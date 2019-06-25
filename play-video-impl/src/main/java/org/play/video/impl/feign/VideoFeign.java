package org.play.video.impl.feign;

import java.util.List;

import org.play.video.impl.entity.Video;
import org.play.video.impl.mybatis.utility.PageBean;
import org.play.video.impl.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoFeign {

	@Autowired
	private VideoService videoService;
	@RequestMapping("/video/save")

	public Integer Save(@RequestBody Video video){
		int result=videoService.insert(video);
		return result;
	}
	
	@RequestMapping("/video/update")

	public Integer update(@RequestBody Video video){
		int result=videoService.update(video);
		return result;
	}
	
	@RequestMapping("/video/delete")

	public Integer delete(@RequestParam String id){
		int result=videoService.delete(id);
		return result;
	}
	@RequestMapping("/video/getVideoById")

	public Video getVideoById(@RequestParam String id){
		Video video=videoService.selectById(id);
		return video;
	}
	
	@RequestMapping("/video/getVideoAll")
	public List<Video> getVideoById(){
		List<Video> videos=videoService.selectAll();
		return videos;
	}
	@RequestMapping("/video/getByNewsVideo")
	public List<Video> getByNewsVideo(){
		List<Video> videos=videoService.getByNewsVideo();
		return videos;
	}
	
	@RequestMapping("/video/selectListPage")
	public PageBean<Video> selectListPage(@RequestParam Integer pageNo,@RequestParam Integer pageSize){
		
		PageBean<Video> pageBean=new PageBean<Video>();
		pageBean.setPage(pageNo);
		pageBean.setPageSize(pageSize);
		Video video=new Video();
		pageBean.setParameter(video);
		pageBean=videoService.selectListPage(pageBean);
		return pageBean;
	}
}
