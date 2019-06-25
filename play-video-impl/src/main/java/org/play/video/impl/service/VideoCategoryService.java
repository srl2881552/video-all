package org.play.video.impl.service;

import java.io.Serializable;
import java.util.List;

import org.play.video.impl.base.BaseService;
import org.play.video.impl.entity.VideoCategory;

public interface VideoCategoryService extends BaseService<VideoCategory, Serializable>{

	public List<VideoCategory> getLiveAll();
	
	public List<VideoCategory> getVideoAll();
}
