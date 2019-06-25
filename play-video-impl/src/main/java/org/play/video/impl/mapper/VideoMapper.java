package org.play.video.impl.mapper;

import java.io.Serializable;
import java.util.List;

import org.play.video.impl.base.BaseMapper;
import org.play.video.impl.entity.Video;

public interface VideoMapper extends BaseMapper<Video, Serializable>{

	List<Video> getByNewsVideo();
}
