package org.play.video.impl.service.impl;

import java.util.List;

import org.play.video.impl.entity.VideoCategory;
import org.play.video.impl.mapper.VideoCategoryMapper;
import org.play.video.impl.mybatis.utility.PageBean;
import org.play.video.impl.service.VideoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("videoCategoryService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class VideoCategoryServiceImpl implements VideoCategoryService{

	@Autowired
	private VideoCategoryMapper videoCategoryMapper;
	@Override
	public VideoCategory selectById(String id) {
		// TODO Auto-generated method stub
		return videoCategoryMapper.selectById(id);
	}

	@Override
	public int insert(VideoCategory entity) {
		// TODO Auto-generated method stub
		return videoCategoryMapper.insert(entity);
	}

	@Override
	public int update(VideoCategory entity) {
		// TODO Auto-generated method stub
		return videoCategoryMapper.update(entity);
	}

	@Override
	public List<VideoCategory> selectAll() {
		// TODO Auto-generated method stub
		return videoCategoryMapper.selectAll();
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return videoCategoryMapper.delete(id);
	}

	@Override
	public PageBean<VideoCategory> selectListPage(PageBean<VideoCategory> entity) {
		// TODO Auto-generated method stub
		entity.setResult(videoCategoryMapper.selectListPage(entity));
		return entity;
	}

	@Override
	public List<VideoCategory> getLiveAll() {
		// TODO Auto-generated method stub
		return videoCategoryMapper.getLiveAll();
	}

	@Override
	public List<VideoCategory> getVideoAll() {
		// TODO Auto-generated method stub
		return videoCategoryMapper.getVideoAll();
	}

}
