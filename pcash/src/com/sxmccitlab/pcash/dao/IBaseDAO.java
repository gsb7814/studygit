package com.sxmccitlab.pcash.dao;

import java.io.Serializable;
import java.util.List;

import com.sxmccitlab.common.exception.DBException;

public interface IBaseDAO {
	public Integer genSequence(String seqName) throws DBException;

	/**
	 * 插入POJO对象
	 */
	public void save(Object o);

	
	/**
	 * 删除POJO对象
	 */
	public void delete(Object o);

	public void deleteALL(List o);

	/**
	 * 查询POJO对象
	 */
	public Object retrive(Class clazz, Serializable id);

	/**
	 * 查询POJO对象s
	 */
	public List retriveAll(Class clazz);

	/**
	 * 根据条件查询POJO对象s
	 */
	public List retriveByFilter(String filter);

	/**
	 * 更新POJO对象
	 */
	public void update(Object o);

	/**
	 * 更新POJO对象s
	 */
	public void updateAll(List objs);

	/**
	 * 根据SQL查询结果集行数
	 * @param sql SQL语句
	 * @throws DBException
	 * 数据库访问错误时抛出
	 */
	public int queryCount(String sql) throws DBException;
}
