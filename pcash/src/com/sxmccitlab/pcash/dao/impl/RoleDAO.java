package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.pcash.dao.IRoleDAO;
import com.sxmccitlab.pcash.po.Role;

/**
 * A data access object (DAO) providing persistence and search support for Role
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.Role
 * @author MyEclipse Persistence Tools
 */

public class RoleDAO extends BaseHibernateDAO implements IRoleDAO {
	private static final Log log = LogFactory.getLog(RoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String RIGHT_CODE = "rightCode";
	public static final String COMMENTS = "comments";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IRoleDAO2#save(com.sxmccitlab.pcash.po.Role)
	 */
	public void save(Role transientInstance) {
		log.debug("saving Role instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IRoleDAO2#delete(com.sxmccitlab.pcash.po.Role)
	 */
	public void delete(Role persistentInstance) {
		log.debug("deleting Role instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IRoleDAO2#findById(java.lang.String)
	 */
	public Role findById(java.lang.String id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = (Role) getHibernateTemplate().get(
					"com.sxmccitlab.pcash.po.Role", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Role instance) {
		log.debug("finding Role instance by example");
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
		log.debug("finding Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Role as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByRightCode(Object rightCode) {
		return findByProperty(RIGHT_CODE, rightCode);
	}


	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.dao.impl.IRoleDAO2#findAll()
	 */
	public List findAll() {
		log.debug("finding all Role instances");
		try {
			String queryString = "from Role";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public static IRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IRoleDAO) ctx.getBean("RoleDAO");
	}

	public void add(Role transientInstance) {
		// TODO Auto-generated method stub
		
	}

	public List query(String hql) {
		// TODO Auto-generated method stub
		if (hql == null || "".equals(hql))
			return null;
		return findByHql(hql);
	}

	public Role queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Role transientInstance) {
		// TODO Auto-generated method stub
		
	}
}