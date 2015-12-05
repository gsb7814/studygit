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
 * ͨ��DAO��
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
	 * ��ȡָ����sequenceֵ
	 * @param sequenceName ָ����sequence����
	 * @return sequenceֵ
	 * @throws DBException ���ݿ���ʴ���ʱ�׳�
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
	 * ����POJO����
	 */
	public void save(Object o) throws DataAccessException {
		getHibernateTemplate().save(o);
		
	}
	
	public Object saveObject(Object o) throws DataAccessException {
		return getHibernateTemplate().save(o);
	}
	
	/**
	 * ����POJO����
	 */
	public void create(Object o) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(o);
		//getHibernateTemplate().save(o);
	}

	/**
	 * ɾ��POJO����
	 */
	public void delete(Object o) throws DataAccessException {
		getHibernateTemplate().delete(o);
	}
	public void deleteALL(List o) throws DataAccessException {
		getHibernateTemplate().deleteAll(o);
	}
	/**
	 * ��ѯPOJO����
	 */
	public Object retrive(Class clazz,Serializable id) throws DataAccessException{
		return getHibernateTemplate().get(clazz, id);
	}

	/**
	 * ��ѯPOJO����s
	 */
	public List retriveAll(Class clazz) throws DataAccessException {
		return getHibernateTemplate().find("from " + clazz.getName());
	}
	/**
	 * ����������ѯPOJO����s
	 */
	public List retriveByFilter(String filter) throws DataAccessException {
		return getHibernateTemplate().find(filter);
		
	}
	/**
	 * ����POJO����
	 */
	public void update(Object o) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(o);
	}

	/**
	 * ����POJO����s
	 */
	public void updateAll(List objs) throws DataAccessException {
		getHibernateTemplate().saveOrUpdateAll(objs);
	}
	
	/**
	 * ����SQL��ѯ�����
	 * @param resultSQL SQL���
	 * @throws DAOException ���ݿ���ʴ���ʱ�׳�
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
	 *  ���ݷ�ҳԭ���ѯ����
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
 * ��ҳԭ���ѯ����
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
		 q = super.getSession().createQuery(filter);// ִ��SQL
		q.setCacheable(true);
		// ��ʼ������
		q.setFirstResult(startIndex);
		// ����������
		q.setMaxResults(pageSize);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new DBException(ex.getMessage());
		}
		return q.list();
	}
	
	
}
