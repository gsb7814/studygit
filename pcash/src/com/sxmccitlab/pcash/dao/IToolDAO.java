package com.sxmccitlab.pcash.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.sxmccitlab.common.PaginationSupport;



public interface IToolDAO {
	
	/**
	 * 根据一个sql语句修改一个对象 
	 * @param sql
	 * @return int
	 */
	public int updateObject(String sql);
	
	/**
	 * 保存一个对象
	 * @param object
	 */
	public void saveObject(Object object);
	
	/**
	 * 根据主键L查找O
	 * @param l 主键参数为Long
	 * @param object
	 * @return
	 * @throws DataAccessException
	 */
	public Object getObjectFromKey(Long l,Object o) throws DataAccessException;  

	/**
	 * 删除一个对象
	 * @param object
	 */
	public void deleteObject(Object object);
	
	/**
	 * 修改一个对象
	 * @param object
	 */
	public void updateObject(Object object);
	public int updateObject1(String sql);
	
	/* 分页查询函数
	 * @param detachedCriteria 查询条件
	 * @param pageSize         每页的记录数
	 * @param startIndex       开始索引
	 * @return 分页对象PaginationSupport
	 */
	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int startIndex, final int pageSize) ;
	public PaginationSupport findPageByHql(final String hql, final int startIndex, final int pageSize);
	
	/**
	 * 根据sql语句取得第一个字段值
	 * @param sql
	 * @return
	 */
	public String getStr(final String sql);
	
	/**
	 * 得到系统当前时间
	 * @return
	 */
	public Date getCurrentSystemDate();	
	
	public List callProc(final String proName,final List inArgs,final List outArgs);
	//执行HQL查询语句
	public List queryHqlStringSearch(String strHql);
//	执行SQL查询语句
	public List querySQLStringSearch(final String strSql);
//	执行SQL查询和删除语句
	public int updateSQLString(final String strSql);
	
	public PaginationSupport findPageBySql(final String sql0,final String sql, final int startIndex, final int pageSize);

}
