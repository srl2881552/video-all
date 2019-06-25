package org.play.video.impl.feign;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.play.video.impl.entity.Desktop;
import org.play.video.impl.entity.Video;
import org.play.video.impl.service.DesktopService;
import org.play.video.impl.tools.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesktopFeign {

	@Autowired
	private DesktopService desktopService;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@RequestMapping("/desktop/selectAll")

	public List<Desktop> selectAll(){
		List<Desktop> result=desktopService.selectAll();
		return result;
	}
	@RequestMapping("/desktop/refresh")
	public void refresh(){
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Map<String, List<Desktop>> map=new LinkedHashMap<String, List<Desktop>>();
				HashOperations<String,String,String> operations=redisTemplate.opsForHash();
				List<Desktop> result=desktopService.selectAll();
				for(Desktop vo:result)
				{
					String num=operations.get("com.song.play.click", vo.getId().toString());
					vo.setChick(num==null?0L:Long.valueOf(num));
					if(map.get(vo.getCateName())!=null)
					{
						if(map.get(vo.getCateName()).size()<20)
						{
							map.get(vo.getCateName()).add(vo);
						}
					}else{
						List<Desktop> list=new ArrayList<Desktop>();
						list.add(vo);
						map.put(vo.getCateName(), list);
					}
				}
				String json=JsonUtil.writeValueAsString(map);
				redisTemplate.opsForValue().set("com.song.play.desktop", json);
			}
		});
		
	}
}
