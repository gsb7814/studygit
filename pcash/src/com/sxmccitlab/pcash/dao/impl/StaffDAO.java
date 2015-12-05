package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.pcash.dao.IStaffDAO;
import com.sxmccitlab.pcash.po.Staff;

/**
 * A data access object (DAO) providing persistence and search support for
 * Staff entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.Staff
 * @author MyEclipse Persistence Tools
 */

public class StaffDAO extends BaseHibernateDAO implements IStaffDAO {
	private static final Log log = LogFactory.getLog(StaffDAO.class);
	// property constants
	public static final String STAFF_NAME = "staffName";
	public static final String TELEPHONE = "telephone";
	public static final String EMAIL = "email";
//	public static final String ROLE_CODE = "roleCode";
//	public static final String UNIT_CODE = "unitCode";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(Staff transientInstance) {
		log.debug("saving Staff instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Staff persistentInstance) {
		log.debug("deleting Staff instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Staff findById(java.lang.String id) {
		log.debug("getting Staff instance with id: " + id);
		try {
			Staff instance = (Staff) getHibernateTemplate().get(
					"com.sxmccitlab.pcash.po.Staff", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Staff> findByExample(Staff instance) {
		log.debug("finding Staff instance by example");
		try {
			List <Staff> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List <Staff> findByProperty(String propertyName, Object value) {
		log.debug("finding Staff instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Staff as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List <Staff> findByStaffName(Object staffName) {
		return findByProperty(STAFF_NAME, staffName);
	}

	public List <Staff> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List <Staff> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

//	public List <Staff> findByRoleCode(Object roleCode) {
//		return findByProperty(ROLE_CODE, roleCode);
//	}
//
//	public List <Staff> findByUnitCode(Object unitCode) {
//		return findByProperty(UNIT_CODE, unitCode);
//	}

	public List <Staff> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List <Staff> findAll() {
		log.debug("finding all Staff instances");
		try {
			String queryString = "from Staff";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public static StaffDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StaffDAO) ctx.getBean("staffDAO");
	}
}