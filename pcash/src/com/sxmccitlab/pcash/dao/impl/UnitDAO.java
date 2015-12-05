package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.pcash.dao.IUnitDAO;
import com.sxmccitlab.pcash.po.AccountType;
import com.sxmccitlab.pcash.po.Unit;

/**
 * A data access object (DAO) providing persistence and search support for TUnit
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.Unit
 * @author MyEclipse Persistence Tools
 */

public class UnitDAO extends BaseHibernateDAO implements IUnitDAO {
	private static final Log log = LogFactory.getLog(UnitDAO.class);
	// property constants

	public void add(AccountType transientInstance) {
		// TODO Auto-generated method stub
		
	}

	public void delete(AccountType persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	public List query(String hql) {
		if (hql == null || "".equals(hql))
			return null;
		return this.findByHql(hql);

	}

	public void update(AccountType transientInstance) {
		// TODO Auto-generated method stub
		
	}
	
}