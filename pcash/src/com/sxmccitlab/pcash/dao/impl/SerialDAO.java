package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.dao.ISerialDAO;
import com.sxmccitlab.pcash.po.Serial;

/**
 * A data access object (DAO) providing persistence and search support for
 * Serial entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.Serial
 * @author MyEclipse Persistence Tools
 */

public class SerialDAO extends HibernateDaoSupport implements ISerialDAO {
	private static final Log log = LogFactory.getLog(SerialDAO.class);
	// property constants
	public static final String SERIAL_NO = "serialNo";
	public static final String ID = "id";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.ISerialDAO#save(com.sxmccitlab.pcash.po.Serial)
	 */
	public void save(Serial transientInstance) {
		log.debug("saving Serial instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.ISerialDAO#delete(com.sxmccitlab.pcash.po.Serial)
	 */
	public void delete(Serial persistentInstance) {
		log.debug("deleting Serial instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.ISerialDAO#findById(java.lang.String)
	 */
	public Serial findById(java.lang.String id) {
		log.debug("getting Serial instance with id: " + id);
		try {
			Serial instance = (Serial) getHibernateTemplate().get(
					"com.sxmccitlab.pcash.po.Serial", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Serial instance) {
		log.debug("finding Serial instance by example");
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
		log.debug("finding Serial instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Seriall as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySerialNo(Object serialNo) {
		return findByProperty(SERIAL_NO, serialNo);
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findAll() {
		log.debug("finding all Serial instances");
		try {
			String queryString = "from Serial";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.ISerialDAO#merge(com.sxmccitlab.pcash.po.Serial)
	 */
	public Serial merge(Serial detachedInstance) {
		log.debug("merging Serial instance");
		try {
			Serial result = (Serial) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.ISerialDAO#attachDirty(com.sxmccitlab.pcash.po.Serial)
	 */
	public void attachDirty(Serial instance) {
		log.debug("attaching dirty Serial instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.ISerialDAO#attachClean(com.sxmccitlab.pcash.po.Serial)
	 */
	public void attachClean(Serial instance) {
		log.debug("attaching clean Serial instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ISerialDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ISerialDAO) ctx.getBean("SerialDAO");
	}
}