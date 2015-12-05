package com.sxmccitlab.pcash.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.pcash.dao.IVoucherTypeDAO;
import com.sxmccitlab.pcash.po.VoucherType;

/**
 * A data access object (DAO) providing persistence and search support for
 * VoucherType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.VoucherType
 * @author MyEclipse Persistence Tools
 */

public class VoucherTypeDAO extends BaseHibernateDAO implements IVoucherTypeDAO {
	private static final Log log = LogFactory.getLog(VoucherTypeDAO.class);
	// property constants
	public void add(VoucherType voucherType) {
		
	}
	
	public void delete(VoucherType voucherType) {
		
	}
	
	public List query(String hql) {
		if (hql == null || "".equals(hql))
			return null;
		return this.findByHql(hql);
	}
	
	public void update(VoucherType voucherType) {
		
	}
	
	public List findAll() {
		return this.findByHql("from VoucherType");
	}
}