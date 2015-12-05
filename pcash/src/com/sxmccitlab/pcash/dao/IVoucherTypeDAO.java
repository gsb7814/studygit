package com.sxmccitlab.pcash.dao;

import java.util.List;


import com.sxmccitlab.pcash.po.VoucherType;

public interface IVoucherTypeDAO {

	public abstract void add(VoucherType transientInstance);

	public abstract void delete(VoucherType persistentInstance);

	//public abstract VoucherType findById(java.lang.String id);
	
	public abstract List query(String hql);
	
	public abstract void update(VoucherType transientInstance);
	
	public abstract List findAll();

}