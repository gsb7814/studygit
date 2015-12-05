package com.sxmccitlab.pcash.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.ast.QueryTranslatorImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.common.StringUtils;
import com.sxmccitlab.pcash.dao.IToolDAO;

public class ToolDAO extends HibernateDaoSupport implements IToolDAO {

	Log log = LogFactory.getLog(this.getClass());

	public int updateObject(final String sql) {
		int i = 0;
		i = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createSQLQuery(sql);
				int i = query.executeUpdate();
				return i;
			}
		});
		return i;
		/*
		 * 
		 * Session session = null; HibernateTemplate h =
		 * this.getHibernateTemplate();SessionFactory s = h.getSessionFactory();
		 * //this.getHibernateTemplate().getSessionFactory(). try { session =
		 * this.getHibernateTemplate().getSessionFactory().openSession();
		 * 
		 * Query query = session.createSQLQuery(sql);
		 * log.debug("qq"+session.hashCode()); log.debug("ww"+session); i =
		 * query.executeUpdate(); //session.flush();
		 * log.debug("updateCircuitAcctItem的i的值:" + i); } catch
		 * (HibernateException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally{
		 * 
		 * open 的session 还是要关闭的。
		 * 
		 * if(session!=null){ session.close(); } }
		 */

	}

	public int updateObject1(final String sql) {
		int i = 0;
		i = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createSQLQuery(sql);
				int i = query.executeUpdate();
				return i;
			}
		});
		return i;

		/*
		 * Session session = null; int i=0;
		 * 
		 * session =
		 * this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		 * Query query = session.createSQLQuery(sql);
		 * log.debug("qq"+session.hashCode()); log.debug("ww"+session); i =
		 * query.executeUpdate(); log.debug("updateCircuitAcctItem的i的值:" + i);
		 * //session.close();
		 * 
		 * return i;
		 */
	}

	public void saveObject(Object object) {
		this.getHibernateTemplate().save(object);
	}

	public Object getObjectFromKey(Long l, Object o) throws DataAccessException {
		return (Object) getHibernateTemplate().get(o.getClass(), l);
	}

	public void deleteObject(Object object) {
		this.getHibernateTemplate().delete(object);
	}

	// 执行HQL的update操作
	public void updateObject(Object object) {
		this.getHibernateTemplate().update(object);
	}

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int startIndex,
			final int pageSize) {
		return this
				.findHiPageByCriteria(detachedCriteria, startIndex, pageSize);
	}

	private PaginationSupport findHiPageByCriteria(
			final DetachedCriteria detachedCriteria, final int startIndex,
			final int pageSize) {
		return (PaginationSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);

						int totalCount = ((Integer) criteria.setProjection(
								Projections.rowCount()).uniqueResult())
								.intValue();

						criteria.setProjection(null);

						List items = criteria.setFirstResult(startIndex)
								.setMaxResults(pageSize).list();
						PaginationSupport ps = new PaginationSupport(items,
								totalCount, pageSize, startIndex);
						return ps;
					}
				}, true);
	}

	// 执行hql分页查询数据add by zwt
	public PaginationSupport findPageByHql(final String hql,
			final int startIndex, final int pageSize) {
		return (PaginationSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(hql);
						query.setFirstResult(startIndex);
						query.setMaxResults(pageSize);
						List list = query.list();
						log.debug("_________" + list.size() + "ss" + startIndex
								+ "ss" + pageSize);
						int totalCount = getTotalCount(session, hql);
						PaginationSupport ps = new PaginationSupport(list,
								totalCount, pageSize, startIndex);
						return ps;
					}
				}, true);
	}

	// 执行sql分页查询数据
	public PaginationSupport findPageBySql(final String sql0, final String sql,
			final int startIndex, final int pageSize) {
		return (PaginationSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						System.out.println("xxx" + sql);
						Query query = session.createSQLQuery(sql);//
						query.setFirstResult(startIndex);
						System.out.println(startIndex);
						System.out.println(pageSize + "ssssssssss");
						query.setMaxResults(pageSize);
						System.out.println("xxx" + query);
						List list = query.list();//
						System.out.println("eeeeeeeeee" + list.size());
						log.debug("_________" + list.size() + "ss" + startIndex
								+ "ss" + pageSize);
						int totalCount = getTotalCountBySql(session, sql0);
						PaginationSupport ps = new PaginationSupport(list,
								totalCount, pageSize, startIndex);
						return ps;
					}
				}, true);
	}

	/**
	 * 取得查询的记录总数(分页显示用)
	 * 
	 * @param session
	 *            Hibernate的Session对象
	 * @param hql
	 *            查询语句
	 * @return int 查询的记录总数
	 * @throws DataAccessException
	 *             处理失败时抛出该异常
	 */
	/*
	 private int getTotalCount(Session session,String hql){
	 Long amount = new Long(0);
	 String lowwerHql = hql.toLowerCase();
	 int sqlFrom = hql.indexOf("from");
	 int sqlOrderby = lowwerHql.indexOf("order by");
	 String countStr = "";
	 // 因为此方法只取得查询的结果总数，所以将查询语句中可能存在的排序语句去掉来提高查询效率
	 if(sqlOrderby > 0) {
	 countStr = "select count(*) " + hql.substring(sqlFrom,sqlOrderby);
	 } else {
	 countStr = "select count(*) " + hql.substring(sqlFrom);
	 }
	 Query qry = null;
	 qry = session.createQuery(countStr);
	 List countList = qry.list();
	 if(countList!=null && countList.size()>0){
	 amount = (Long)countList.get(0);
	 }
	 
	 return amount.intValue();
	 }
	 */
	 
	 
	private int getTotalCount(Session session, String hql) {
		Long amount = new Long(0);

		QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hql, hql,
				Collections.EMPTY_MAP, (SessionFactoryImplementor) this
						.getSessionFactory());
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		String tempSQL = queryTranslator.getSQLString();
		String lowwerSql = tempSQL.toLowerCase();
	
		int sqlOrderby = lowwerSql.indexOf("order by");
		String countStr = "";
		// 因为此方法只取得查询的结果总数，所以将查询语句中可能存在的排序语句去掉来提高查询效率
		if (sqlOrderby > 0) {
			countStr = "select count(*) from ("
					+ tempSQL.substring(0, sqlOrderby) + ")";
		} else {
			countStr = "select count(*) from (" + tempSQL + ")";
		}
		Query qry = null;
		qry = session.createSQLQuery(countStr);
		List countList = qry.list();
		if (countList != null && countList.size() > 0) {
			amount = Long.parseLong(countList.get(0).toString());
		}
		// log.error("记录总数："+amount);
		/*
		 * finally{ session.clear(); }
		 */
		return amount.intValue();
	}

	private int getTotalCountBySql(Session session, String sql) {
		Long amount = new Long(0);
		String lowwerSql = sql.toLowerCase();
		// int sqlFrom = lowwerHql.indexOf(" from ");
		int sqlOrderby = lowwerSql.indexOf("order by");
		String countStr = "";
		// 因为此方法只取得查询的结果总数，所以将查询语句中可能存在的排序语句去掉来提高查询效率
		if (sqlOrderby > 0) {
			countStr = "select count(*) from (" + sql.substring(0, sqlOrderby)
					+ ")";
		} else {
			countStr = "select count(*) from (" + sql + ")";
		}
		Query qry = null;
		qry = session.createSQLQuery(countStr);
		List countList = qry.list();
		if (countList != null && countList.size() > 0) {
			amount = Long.parseLong(countList.get(0).toString());
		}
		// log.error("记录总数："+amount);
		/*
		 * finally{ session.clear(); }
		 */
		return amount.intValue();
	}

	/**
	 * private int getTotalCountBySql(Session session,String sql){ Long amount =
	 * new Long(0); String lowwerHql = sql.toLowerCase(); int sqlFrom =
	 * lowwerHql.indexOf(" from "); int sqlOrderby =
	 * lowwerHql.indexOf("order by"); String countStr = ""; //
	 * 因为此方法只取得查询的结果总数，所以将查询语句中可能存在的排序语句去掉来提高查询效率 if(sqlOrderby > 0) { countStr
	 * = "select count(*) " + sql.substring(sqlFrom,sqlOrderby); } else {
	 * countStr = "select count(*) " + sql.substring(sqlFrom); } Query qry =
	 * null; qry = session.createSQLQuery(countStr); List countList =
	 * qry.list(); if(countList!=null && countList.size()>0){ amount =
	 * Long.parseLong(countList.get(0).toString()); }
	 * //log.error("记录总数："+amount); finally{ session.clear(); } return
	 * amount.intValue(); }
	 **/
	public String getStr(final String sql) {
		String n = (String) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						SQLQuery query = session.createSQLQuery(sql);
						List children = query.list();
						return (String) children.iterator().next();
					}
				});
		return n;
	}

	// 获取系统时间
	public Date getCurrentSystemDate() {
		Object currentSystemDate = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws SQLException, HibernateException {
						SQLQuery query = session
								.createSQLQuery("select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') a from dual");
						List children = query.list();
						return children.iterator().next();
					}
				});
		log.debug("tooldao的值：" + currentSystemDate.toString());
		return StringUtils.toDate(currentSystemDate.toString(),
				"yyyy-MM-dd HH:mm:ss");
	}

	// 调用存储过程
	public List callProc(final String proName, final List inArgs,
			final List outArgs) {
		log.debug("yyyy-MM-dd HH:mm:ss");
		List i = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Connection connection = session.connection();
				log.debug("2yyyy-MM-dd HH:mm:ss");
				String sql = "{ call " + proName + " ";
				String temp = "";
				if (inArgs != null) {
					for (int k = 0; k < inArgs.size(); k++) {
						temp += "?,";
					}
				}
				if (outArgs != null) {
					for (int k = 0; k < outArgs.size(); k++) {
						temp += "?,";
					}
				}
				if (!temp.equals("")) {
					sql += "(" + temp.substring(0, temp.length() - 1) + ")";
				}
				sql += " }";
				log.debug(sql);
				CallableStatement proc = null;
				ArrayList<Object> outList = new ArrayList<Object>();
				// proc.setString(1, dyingBard.getName());
				// proc.setInt(2, age);
				try {
					int j = 1;
					proc = connection.prepareCall(sql);
					if (inArgs != null) {
						Iterator it2 = inArgs.iterator();

						while (it2.hasNext()) {
							Object ob = it2.next();
							log.debug("" + j + ob.getClass() + ob.toString());
							if (ob.getClass().equals(String.class)) {
								log.debug(String.class);
								proc.setString(j, (String) ob);
							} else if (ob.getClass().equals(Long.class)) {
								log.debug(Long.class);
								proc.setLong(j, (Long) ob);
							} else if (ob.getClass().equals(Integer.class)) {
								log.debug(Integer.class);
								proc.setInt(j, (Integer) ob);
							} else if (ob.getClass().equals(Double.class)) {
								log.debug(Double.class);
								proc.setDouble(j, (Double) ob);
							}
							j++;
						}
					}
					int k = j;
					if (outArgs != null) {
						Iterator it2 = outArgs.iterator();

						while (it2.hasNext()) {
							Object ob = it2.next();

							log.debug("" + j + ob.getClass() + ob.toString());
							if (ob.getClass().equals(String.class)) {
								log.debug(String.class);
								proc.registerOutParameter(j,
										java.sql.Types.VARCHAR);
							} else if (ob.getClass().equals(Long.class)) {
								log.debug(Long.class);
								proc.registerOutParameter(j,
										java.sql.Types.NUMERIC);
							} else if (ob.getClass().equals(Integer.class)) {
								log.debug(Integer.class);
								proc.registerOutParameter(j,
										java.sql.Types.NUMERIC);
							} else if (ob.getClass().equals(Double.class)) {
								log.debug(Double.class);
								proc.registerOutParameter(j,
										java.sql.Types.NUMERIC);
							}
							j++;
						}
					}
					j = k;
					proc.execute();
					if (outArgs != null) {
						Iterator it2 = outArgs.iterator();

						while (it2.hasNext()) {
							Object ob = it2.next();

							log.debug("" + j + ob.getClass() + ob.toString());
							if (ob.getClass().equals(String.class)) {
								log.debug(String.class);
								outList.add(proc.getString(j));
							} else if (ob.getClass().equals(Long.class)) {
								log.debug(Long.class);
								outList.add(proc.getLong(j));
							} else if (ob.getClass().equals(Integer.class)) {
								log.debug(Integer.class);
								outList.add(proc.getInt(j));
							} else if (ob.getClass().equals(Double.class)) {
								log.debug(Double.class);
								outList.add(proc.getDouble(j));
							}
							j++;
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (proc != null)
							proc.close();
						if (connection != null)
							connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return outList;
			}
		});
		return i;
	}

	// 执行HQL查询语句
	public List queryHqlStringSearch(String strHql) {
		log.debug("QueryString Search IJfBssOrg instances");
		try {
			return getHibernateTemplate().find(strHql);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	// 执行SQL查询语句
	public List querySQLStringSearch(final String strSql) {
		// TODO Auto-generated method stub
		List resultList = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						SQLQuery query = session.createSQLQuery(strSql);
						return query.list();
					}
				});
		return resultList;
	}

	// 执行SQL插入和删除语句
	public int updateSQLString(final String strSql) {
		int i = 0;
		System.out.println(i + "edde");
		i = (Integer) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)

			throws HibernateException, SQLException {

				// TODO Auto-generated method stub
				Query query = session.createSQLQuery(strSql);
				System.out.println("ss" + query);
				int i = query.executeUpdate();
				System.out.println(i + "ee");
				return i;
			}
		});
		return i;
	}
}
