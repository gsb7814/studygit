package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.pcash.dao.IAccountTypeDAO;
import com.sxmccitlab.pcash.po.AccountType;

/**
 * A data access object (DAO) providing persistence and search support for
 * AccountType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.AccountType
 * @author MyEclipse Persistence Tools
 */

public class AccountTypeDAO extends BaseHibernateDAO implements IAccountTypeDAO {
	private static final Log log = LogFactory.getLog(AccountTypeDAO.class);
	
	public void add(AccountType accountType) {
		
	}
	
	public void delete(AccountType accountType) {
		
	}
	
	public List query(String hql) {
		if (hql == null || "".equals(hql))
			return null;
		return this.findByHql(hql);
	}
	
	public void update(AccountType accountType) {
		
	}
}