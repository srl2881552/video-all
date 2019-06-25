package org.play.video.impl.service;

import java.io.Serializable;
import java.util.List;

import org.play.video.impl.base.BaseService;
import org.play.video.impl.entity.Video;

public interface VideoService extends BaseService<Video, Serializable>{

	public List<Video> getByNewsVideo();
}
