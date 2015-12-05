/**
 * 
 */
package com.sxmccitlab.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.pagehandle.PaginationSupport;
import com.sxmccitlab.common.pagehandle.PaginationVO;



/**
 * @author Bob Guo
 *
 */
public class BaseHibernateDAO extends HibernateDaoSupport {
	private Log log= LogFactory.getLog(getClass());
	
	/**
	 * 根据分页原则查询数据
	 * @param hql
	 * @param startIndex 结果集中第一条记录位置
	 * @param maxResult 结果集的记录总条数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PaginationVO findLimitedResultByHql(final String hql, final int startIndex, final int maxResult) {
		PaginationVO page= new PaginationVO();
		List list=(List)super.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List callbackList=session.createQuery(hql).setFirstResult(startIndex).setMaxResults(maxResult).list();
				return callbackList;
			}		
		});
		page.setResultList(list);
		final String countHql="select new map(count(*) as rownumber) "+hql;
		String totalResult=(String)super.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
			   List countList= session.createQuery(countHql).list();
			   Map map=(Map)countList.get(0);
			   
				return map.get("rownumber").toString();
			}});
		page.setTotalResult(Integer.parseInt(totalResult));
		int totalPages=(int)Math.ceil(Double.parseDouble(totalResult)/maxResult);
		page.setTotalPage(totalPages);
		page.setFirstResult(startIndex);
		page.setPageSize(maxResult);
		return page;
	}
	
	/**
	 *  根据分页原则查询数据，分页后可判断当前显示页数。
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex 结果集中第一条记录位置
	 * @param orderList Order对象列表，用于排序
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
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
	
	public void saveOrUpdate(Object obj){
		super.getHibernateTemplate().saveOrUpdate(obj);
	}
	
	@SuppressWarnings("unchecked")
	public Object getById(Class clazz,Serializable id){
		
		return super.getHibernateTemplate().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public Object loadById(Class clazz,Serializable id){
		return super.getHibernateTemplate().load(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public List findByHql(String hql){
		
		return super.getHibernateTemplate().find(hql);
	}

	public void delete(Object obj){
		super.getHibernateTemplate().delete(obj);
	}
	
	@SuppressWarnings("unchecked")
	public Object getByExample(Object obj){
		List list=super.getHibernateTemplate().findByExample(obj);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public List findBySQL(final String sql){
		
		List list=(List)super.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query=session.createSQLQuery(sql);
				List list=query.list();
				return list;
			}
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public PaginationVO findLimitedResultBySql(final String sql, final int firstResult, final int maxResult) {
		PaginationVO page= new PaginationVO();
		List resultList=(List)super.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query=session.createSQLQuery(sql);
				query.setFirstResult(firstResult).setMaxResults(maxResult);

				List list=query.list();
			
				return list;
			}
			
		});
		page.setResultList(resultList);
		final String  countSql="select count(0) as rownumber from ("+sql+") t";
		String  totalRows=(String)super.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List list=session.createSQLQuery(countSql).list();
				//Integer rs=(Integer)list.get(0);
				//2010-4-24 bugged
				Integer rs=Integer.parseInt(list.get(0).toString());
				
				return rs.toString();
			}
			
		});
		page.setTotalResult(Integer.parseInt(totalRows));
		page.setFirstResult(firstResult);
		page.setPageSize(maxResult);
		int totalPages=(int)Math.ceil(Double.parseDouble(totalRows)/maxResult);
		page.setTotalPage(totalPages);
		return page;
	}
}
