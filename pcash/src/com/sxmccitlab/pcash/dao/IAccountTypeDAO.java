package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.pcash.po.AccountType;

public interface IAccountTypeDAO {

	public abstract void add(AccountType transientInstance);

	public abstract void delete(AccountType persistentInstance);

	//public abstract AccountType findById(java.lang.String id);
	
	public abstract List query(String hql);
	
	public abstract void update(AccountType transientInstance);

}