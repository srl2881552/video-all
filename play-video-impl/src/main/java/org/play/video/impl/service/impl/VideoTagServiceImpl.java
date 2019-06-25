package org.play.video.impl.service.impl;

import java.util.List;

import org.play.video.impl.entity.VideoTag;
import org.play.video.impl.mapper.VideoTagMapper;
import org.play.video.impl.mybatis.utility.PageBean;
import org.play.video.impl.service.VideoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("videoTagService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class VideoTagServiceImpl implements VideoTagService{

	@Autowired
	private VideoTagMapper videoTagMapper;
	@Override
	public VideoTag selectById(String id) {
		// TODO Auto-generated method stub
		return videoTagMapper.selectById(id);
	}

	@Override
	public int insert(VideoTag entity) {
		// TODO Auto-generated method stub
		return videoTagMapper.insert(entity);
	}

	@Override
	public int update(VideoTag entity) {
		// TODO Auto-generated method stub
		return videoTagMapper.update(entity);
	}

	@Override
	public List<VideoTag> selectAll() {
		// TODO Auto-generated method stub
		return videoTagMapper.selectAll();
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return videoTagMapper.delete(id);
	}

	@Override
	public PageBean<VideoTag> selectListPage(PageBean<VideoTag> entity) {
		// TODO Auto-generated method stub
		entity.setResult(videoTagMapper.selectListPage(entity));
		return entity;
	}

}
