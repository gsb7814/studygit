package com.sxmccitlab.common.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.ICommonDAO;
import com.sxmccitlab.common.pagehandle.PaginationSupport;
import com.sxmccitlab.common.exception.DBException;


/**
 * 通用DAO类
 * @author Bob Guo
 *
 */
public class CommonDAO extends HibernateDaoSupport implements ICommonDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return this.jdbcTemplate;
	}
	
	/**
	 * 获取指定的sequence值
	 * @param sequenceName 指定的sequence名称
	 * @return sequence值
	 * @throws DBException 数据库访问错误时抛出
	 */
	public Integer genSequence(String seqName) throws DBException{
		//String sql = "SELECT NEXTVAL FOR "+seqName+" FROM sysibm.syssequences where SEQNAME='"+seqName+"'"; //for db2
		//String sql = "select "+seqName+".nextval from dual"; //for oracle

		String sql = "values nextval for "+seqName;

		try{
			int sequence = jdbcTemplate.queryForInt(sql);
			return new Integer(sequence);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}	
	}

	/**
	 * 插入POJO对象
	 */
	public void save(Object o) throws DataAccessException {
		getHibernateTemplate().save(o);
		
	}
	
	public Object saveObject(Object o) throws DataAccessException {
		return getHibernateTemplate().save(o);
	}
	
	/**
	 * 插入POJO对象
	 */
	public void create(Object o) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(o);
		//getHibernateTemplate().save(o);
	}

	/**
	 * 删除POJO对象
	 */
	public void delete(Object o) throws DataAccessException {
		getHibernateTemplate().delete(o);
	}
	public void deleteALL(List o) throws DataAccessException {
		getHibernateTemplate().deleteAll(o);
	}
	/**
	 * 查询POJO对象
	 */
	public Object retrive(Class clazz,Serializable id) throws DataAccessException{
		return getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 查询POJO对象s
	 */
	public List retriveAll(Class clazz) throws DataAccessException {
		return getHibernateTemplate().find("from " + clazz.getName());
	}
	/**
	 * 根据条件查询POJO对象s
	 */
	public List retriveByFilter(String filter) throws DataAccessException {
		return getHibernateTemplate().find(filter);
		
	}
	/**
	 * 更新POJO对象
	 */
	public void update(Object o) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(o);
	}

	/**
	 * 更新POJO对象s
	 */
	public void updateAll(List objs) throws DataAccessException {
		getHibernateTemplate().saveOrUpdateAll(objs);
	}
	
	/**
	 * 根据SQL查询结果集
	 * @param resultSQL SQL语句
	 * @throws DAOException 数据库访问错误时抛出
	 */
	public int queryCount(String sql)throws DBException{
		try{
			return jdbcTemplate.queryForInt(sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
	}
	
	/**
	 *  根据分页原则查询数据
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex
	 * @param orderList
	 * @return
	 * @throws DAOException
	 */

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria,final int pageSize,
			final int startIndex,final List orderList){
			return (PaginationSupport) getHibernateTemplate().executeWithNativeSession(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {
							Criteria criteria = detachedCriteria
									.getExecutableCriteria(session);
							
							int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
							criteria.setProjection(null);
							if (orderList != null) {
								for(int i=0;i<orderList.size();i++){
									Order order = (Order)orderList.get(i);
									criteria.addOrder(order);
								}
						    }
							
							List items = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();
							PaginationSupport ps = new PaginationSupport(items,
									totalCount, pageSize, startIndex);
							return ps;
						}
					});
	}
    
	public List retriveBySql(String sql) throws DBException{
		try{
			return jdbcTemplate.queryForList(sql);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
	}

	public void executeSql(String sql) throws DBException {
		try{
			jdbcTemplate.execute(sql);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
	}

	public int updateSql(String sql) throws DBException {
		try{
			return jdbcTemplate.update(sql);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
	}
/**
 * 分页原则查询数据
 */
/*	public PaginationSupport findPageByHQL(String countfilter,String filter,final int pageSize,final int startIndex)throws DBException 
	 {
		                    int totalCount=0;
		                    PaginationSupport ps=null;
							try {
									totalCount = this.getMenuCount(countfilter);
								}
								catch (Exception ex){
									ex.printStackTrace();
								}
							 List items=null;
							try {
								items = this.getFullInfo(filter, pageSize, startIndex);
							} catch (Exception e) {
								e.printStackTrace();
							}
							 ps = new PaginationSupport(items,
									totalCount, pageSize, startIndex);
		  return ps;	
	}*/
	
	public Map getMenuTotal(String countfilter) throws Exception {
		Map ret = null;
		try{
		Query q = super.getSession().createQuery(countfilter);
		List result = q.list();
		//ret = Integer.valueOf(result.get(0).toString()).intValue();
		ret = (Map)result.get(0);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
		return ret;
	}
	public List getFullInfo(String filter,final int pageSize, final int startIndex) throws Exception {
		Query q=null;
		try{
		 q = super.getSession().createQuery(filter);// 执行SQL
		q.setCacheable(true);
		// 开始的条数
		q.setFirstResult(startIndex);
		// 结束的条数
		q.setMaxResults(pageSize);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
		return q.list();
	}
	
	
}
