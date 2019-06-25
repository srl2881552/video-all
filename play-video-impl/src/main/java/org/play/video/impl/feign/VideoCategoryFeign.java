package org.play.video.impl.feign;

import java.util.List;

import org.play.video.impl.entity.Video;
import org.play.video.impl.entity.VideoCategory;
import org.play.video.impl.service.VideoCategoryService;
import org.play.video.impl.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoCategoryFeign {

	@Autowired
	private VideoCategoryService videoCategoryService;
	
	@RequestMapping("/videoCategory/save")

	public Integer Save(@RequestBody VideoCategory category){
		int result=videoCategoryService.insert(category);
		return result;
	}
	
	@RequestMapping("/videoCategory/update")

	public Integer update(@RequestBody VideoCategory category){
		int result=videoCategoryService.update(category);
		return result;
	}
	
	@RequestMapping("/videoCategory/delete")

	public Integer delete(@RequestParam String id){
		int result=videoCategoryService.delete(id);
		return result;
	}
	
	@RequestMapping("/videoCategory/getCateById")

	public VideoCategory getCateById(@RequestParam String id){
		VideoCategory result=videoCategoryService.selectById(id);
		return result;
	}
	@RequestMapping("/videoCategory/getVideoAll")
	public List<VideoCategory> getVideoAll(){
		List<VideoCategory> video=videoCategoryService.getVideoAll();
		return video;
	}
	@RequestMapping("/videoCategory/getLiveAll")
	public List<VideoCategory> getLiveAll(){
		List<VideoCategory> video=videoCategoryService.getLiveAll();
		return video;
	}
}
