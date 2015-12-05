package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.dao.IAccountingPeriodDAO;
import com.sxmccitlab.pcash.po.AccountingPeriod;

/**
 * A data access object (DAO) providing persistence and search support for
 * AccountingPeriod entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.AccountingPeriod
 * @author MyEclipse Persistence Tools
 */

public class AccountingPeriodDAO extends HibernateDaoSupport implements IAccountingPeriodDAO {
	private static final Log log = LogFactory
			.getLog(AccountingPeriodDAO.class);
	// property constants
	public static final String ID = "id";
	public static final String ACCOUNTING_PERIOD = "accountingPeriod";
	public static final String COMMENTS = "comments";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#save(com.sxmccitlab.pcash.po.AccountingPeriod)
	 */
	public void save(AccountingPeriod transientInstance) {
		log.debug("saving AccountingPeriod instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#delete(com.sxmccitlab.pcash.po.AccountingPeriod)
	 */
	public void delete(AccountingPeriod persistentInstance) {
		log.debug("deleting AccountingPeriod instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#findById(java.lang.String)
	 */
	public AccountingPeriod findById(java.lang.String id) {
		log.debug("getting AccountingPeriod instance with id: " + id);
		try {
			AccountingPeriod instance = (AccountingPeriod) getHibernateTemplate()
					.get("com.sxmccitlab.pcash.po.AccountingPeriod", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AccountingPeriod instance) {
		log.debug("finding AccountingPeriod instance by example");
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
		log.debug("finding AccountingPeriod instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AccountingPeriod as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findByAccountingPeriod(Object accountingPeriod) {
		return findByProperty(ACCOUNTING_PERIOD, accountingPeriod);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all AccountingPeriod instances");
		try {
			String queryString = "from AccountingPeriod";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#merge(com.sxmccitlab.pcash.po.AccountingPeriod)
	 */
	public AccountingPeriod merge(AccountingPeriod detachedInstance) {
		log.debug("merging AccountingPeriod instance");
		try {
			AccountingPeriod result = (AccountingPeriod) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#attachDirty(com.sxmccitlab.pcash.po.AccountingPeriod)
	 */
	public void attachDirty(AccountingPeriod instance) {
		log.debug("attaching dirty AccountingPeriod instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IAccountingPeriodDAO#attachClean(com.sxmccitlab.pcash.po.AccountingPeriod)
	 */
	public void attachClean(AccountingPeriod instance) {
		log.debug("attaching clean AccountingPeriod instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IAccountingPeriodDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IAccountingPeriodDAO) ctx.getBean("AccountingPeriodDAO");
	}
}