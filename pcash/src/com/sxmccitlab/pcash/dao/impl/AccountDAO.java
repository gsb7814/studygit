package com.sxmccitlab.pcash.dao.impl;

import java.sql.SQLException;
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

import com.sxmccitlab.pcash.dao.IAccountDAO;
import com.sxmccitlab.pcash.po.Account;

/**
 * A data access object (DAO) providing persistence and search support for
 * Account entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.Account
 * @author MyEclipse Persistence Tools
 */

public class AccountDAO extends HibernateDaoSupport implements IAccountDAO {
	private static final Log log = LogFactory.getLog(AccountDAO.class);
	// property constants
	public static final String ACCOUNT_NAME = "accountName";
	public static final String ACCOUNT_TYPE_CODE = "accountTypeCode";
	public static final String IS_CURRENT_ACCOUNT = "isCurrenAccount";
	public static final String COMMENTS = "comments";
	public static final String ID = "id";

	protected void initDao() {
		// do nothing
	}

	public void save(Account transientInstance) {
		log.debug("saving Account instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Account persistentInstance) {
		log.debug("deleting Account instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Account findById(java.lang.String id) {
		log.debug("getting Account instance with id: " + id);
		try {
			Account instance = (Account) getHibernateTemplate().get(
					"com.sxmccitlab.pcash.po.Account", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Account instance) {
		log.debug("finding Account instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Account instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Account as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccountName(Object accountName) {
		return findByProperty(ACCOUNT_NAME, accountName);
	}

	public List findByAccountTypeCode(Object accountTypeCode) {
		return findByProperty(ACCOUNT_TYPE_CODE, accountTypeCode);
	}

	public List findByIsCurrenAccount(Object isCurrenAccount) {
		return findByProperty(IS_CURRENT_ACCOUNT, isCurrenAccount);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findAll() {
		log.debug("finding all Account instances");
		try {
			String queryString = "from Account";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Account merge(Account detachedInstance) {
		log.debug("merging Account instance");
		try {
			Account result = (Account) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Account instance) {
		log.debug("attaching dirty Account instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Account instance) {
		log.debug("attaching clean Account instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AccountDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AccountDAO) ctx.getBean("AccountDAO");
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