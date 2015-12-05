package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.po.Menu;

/**
 * A data access object (DAO) providing persistence and search support for Menu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.Menu
 * @author MyEclipse Persistence Tools
 */

public class MenuDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MenuDAO.class);
	// property constants
	public static final String MENU_NAME = "menuName";
	public static final String MENU_PATH = "menuPath";
	public static final String ID = "id";

	protected void initDao() {
		// do nothing
	}

	public void save(Menu transientInstance) {
		log.debug("saving Menu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Menu persistentInstance) {
		log.debug("deleting Menu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Menu findById(java.lang.String id) {
		log.debug("getting Menu instance with id: " + id);
		try {
			Menu instance = (Menu) getHibernateTemplate().get(
					"com.sxmccitlab.pcash.po.Menu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Menu instance) {
		log.debug("finding Menu instance by example");
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
		log.debug("finding Menu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Menu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMenuName(Object menuName) {
		return findByProperty(MENU_NAME, menuName);
	}

	public List findByMenuPath(Object menuPath) {
		return findByProperty(MENU_PATH, menuPath);
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from Menu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Menu merge(Menu detachedInstance) {
		log.debug("merging Menu instance");
		try {
			Menu result = (Menu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Menu instance) {
		log.debug("attaching dirty Menu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Menu instance) {
		log.debug("attaching clean Menu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MenuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MenuDAO) ctx.getBean("MenuDAO");
	}
}