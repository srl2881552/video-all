package org.play.video.impl.mapper;

import java.io.Serializable;
import java.util.List;

import org.play.video.impl.base.BaseMapper;
import org.play.video.impl.entity.VideoCategory;

public interface VideoCategoryMapper extends BaseMapper<VideoCategory, Serializable>{

	public List<VideoCategory> getLiveAll();
	
	public List<VideoCategory> getVideoAll();
}
