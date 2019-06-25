package org.play.video.impl.service.impl;

import java.util.List;

import org.play.video.impl.entity.Video;
import org.play.video.impl.mapper.VideoMapper;
import org.play.video.impl.mybatis.utility.PageBean;
import org.play.video.impl.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("videoService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	@Override
	public Video selectById(String id) {
		// TODO Auto-generated method stub
		return videoMapper.selectById(id);
	}

	@Override
	public int insert(Video entity) {
		// TODO Auto-generated method stub
		return videoMapper.insert(entity);
	}

	@Override
	public int update(Video entity) {
		// TODO Auto-generated method stub
		return videoMapper.update(entity);
	}

	@Override
	public List<Video> selectAll() {
		// TODO Auto-generated method stub
		return videoMapper.selectAll();
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return videoMapper.delete(id);
	}

	@Override
	public PageBean<Video> selectListPage(PageBean<Video> entity) {
		// TODO Auto-generated method stub
		entity.setResult(videoMapper.selectListPage(entity));
		return entity;
	}

	@Override
	public List<Video> getByNewsVideo() {
		// TODO Auto-generated method stub
		return videoMapper.getByNewsVideo();
	}

}
