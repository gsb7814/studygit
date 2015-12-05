package com.sxmccitlab.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.sxmccitlab.common.exception.DBException;
import com.sxmccitlab.common.pagehandle.PaginationSupport;

/**
 * 通用IDAO接口
 * 
 * @author Bob Guo
 * 
 */
public interface ICommonDAO {

	public Integer genSequence(String seqName) throws DBException;

	/**
	 * 插入POJO对象
	 */
	public void save(Object o);

	public Object saveObject(Object o);

	/**
	 * 插入POJO对象
	 */
	public void create(Object o);

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
	 * 根据SQL查询结果集
	 * 
	 * @param resultSQL
	 *            SQL语句
	 * @throws DBException
	 * 
	 *             数据库访问错误时抛出
	 */
	public int queryCount(String sql) throws DBException;

	/**
	 * 根据分页原则查询数据
	 * 
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex
	 * @param orderList
	 * @return
	 * @throws DAOException
	 */

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int pageSize,
			final int startIndex, final List orderList);

	public List retriveBySql(String sql) throws DBException;

	public void executeSql(String sql) throws DBException;

	public int updateSql(String sql) throws DBException;

	public Map getMenuTotal(String countfilter) throws Exception;

	public List getFullInfo(String filter, final int pageSize,
			final int startIndex) throws Exception;

}
