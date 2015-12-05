package com.sxmccitlab.pcash.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.dao.IAccountBalanceDAO;
import com.sxmccitlab.pcash.po.AccountBalance;

/**
 * A data access object (DAO) providing persistence and search support for
 * AccountBalance entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.AccountBalance
 * @author MyEclipse Persistence Tools
 */

public class AccountBalanceDAO extends HibernateDaoSupport implements IAccountBalanceDAO{
	private static final Log log = LogFactory.getLog(AccountBalanceDAO.class);
	// property constants
	
	public static IAccountBalanceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IAccountBalanceDAO) ctx.getBean("accountBalanceDAO");
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountBalanceDAO#add(com.sxmccitlab.pcash.po.AccountBalance)
	 */
	public void add(AccountBalance transientInstance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountBalanceDAO#delete(com.sxmccitlab.pcash.po.AccountBalance)
	 */
	public void delete(AccountBalance persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountBalanceDAO#findAll()
	 */
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountBalanceDAO#query(java.lang.String)
	 */
	public List query(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountBalanceDAO#update(com.sxmccitlab.pcash.po.AccountBalance)
	 */
	public void update(AccountBalance transientInstance) {
		// TODO Auto-generated method stub
		
	}
	
	//÷¥––SQL≤È—Ø”Ôæ‰
	public List querySQLStringSearch(final String strSql) {
		// TODO Auto-generated method stub
		//System.out.println("initialBalance");
		List resultList = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						//System.out.println("initialBalance");
						SQLQuery query = session.createSQLQuery(strSql);
						
						return query.list();
					}
				});
		return resultList;
	}
	//÷¥––SQL≤Â»Î∫Õ…æ≥˝”Ôæ‰
	public int updateSQLString(final String strSql) {
		int i = 0;
		System.out.println(i+"edde");
		i = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
		
					throws HibernateException, SQLException {
				
				// TODO Auto-generated method stub
				Query query = session.createSQLQuery(strSql);
				//System.out.println("ss"+query);
				int i = query.executeUpdate();
				//System.out.println(i+"ee");
				return i;
			}
		});
		return i;
	}
}