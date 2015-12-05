package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.po.RoleRight;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleRight entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.RoleRight
 * @author MyEclipse Persistence Tools
 */

public class RoleRightDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RoleRightDAO.class);
	// property constants
	public static final String RIGHT_CODE = "rightCode";
	public static final String ID = "id";

	protected void initDao() {
		// do nothing
	}

	public void save(RoleRight transientInstance) {
		log.debug("saving RoleRight instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleRight persistentInstance) {
		log.debug("deleting RoleRight instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleRight findById(java.lang.String id) {
		log.debug("getting RoleRight instance with id: " + id);
		try {
			RoleRight instance = (RoleRight) getHibernateTemplate().get(
					"com.sxmccitlab.pcash.po.RoleRight", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleRight instance) {
		log.debug("finding RoleRight instance by example");
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
		log.debug("finding RoleRight instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleRight as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRightCode(Object rightCode) {
		return findByProperty(RIGHT_CODE, rightCode);
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findAll() {
		log.debug("finding all RoleRight instances");
		try {
			String queryString = "from RoleRight";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleRight merge(RoleRight detachedInstance) {
		log.debug("merging RoleRight instance");
		try {
			RoleRight result = (RoleRight) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleRight instance) {
		log.debug("attaching dirty RoleRight instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleRight instance) {
		log.debug("attaching clean RoleRight instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleRightDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoleRightDAO) ctx.getBean("RoleRightDAO");
	}
}