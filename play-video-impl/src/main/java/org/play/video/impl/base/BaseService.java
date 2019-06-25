package org.play.video.impl.base;

import java.io.Serializable;
import java.util.List;

import org.play.video.impl.mybatis.utility.PageBean;




public interface BaseService<T, ID extends Serializable>  {

	/**
	 * 根据主键ID查找实体对象
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	T selectById(String id);
	
	/**
	 * 持久化实体对象
	 * @param entity
	 *            实体对象
	 */
	int insert(T entity);

	/**
	 * 更新实体对象
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	int update(T entity);
		
	/**
	 * 查找实体对象分页
	 * @param entity
	 *            实体对象
	 * @param pageable
	 *            分页信息
	 * @return 实体对象分页
	 */
	List<T> selectAll();
	/**
	 * 查询实体对象数量
	 * @param entity
	 *            实体对象
	 * @return 实体对象数量
	 */
	int delete(String id);	
		
	/**
	 * 查找实体对象分页
	 * @param entity
	 *            实体对象
	 * @param pageable
	 *            分页信息
	 * @return 实体对象分页
	 */
	PageBean<T> selectListPage(PageBean<T> entity);
}
