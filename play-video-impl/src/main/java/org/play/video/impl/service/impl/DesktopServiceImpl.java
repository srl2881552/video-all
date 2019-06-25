package org.play.video.impl.service.impl;

import java.util.List;

import org.play.video.impl.entity.Desktop;
import org.play.video.impl.mapper.DesktopMapper;
import org.play.video.impl.mybatis.utility.PageBean;
import org.play.video.impl.service.DesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("desktopService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class DesktopServiceImpl implements DesktopService{

	@Autowired
	private DesktopMapper desktopMapper;
	@Override
	public Desktop selectById(String id) {
		// TODO Auto-generated method stub
		return desktopMapper.selectById(id);
	}

	@Override
	public int insert(Desktop entity) {
		// TODO Auto-generated method stub
		return desktopMapper.insert(entity);
	}

	@Override
	public int update(Desktop entity) {
		// TODO Auto-generated method stub
		return desktopMapper.update(entity);
	}

	@Override
	public List<Desktop> selectAll() {
		// TODO Auto-generated method stub
		return desktopMapper.selectAll();
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return desktopMapper.delete(id);
	}

	@Override
	public PageBean<Desktop> selectListPage(PageBean<Desktop> entity) {
		// TODO Auto-generated method stub
		entity.setResult(desktopMapper.selectListPage(entity));
		return entity;
	}

}
