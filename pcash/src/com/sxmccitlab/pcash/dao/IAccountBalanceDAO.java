package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.pcash.po.AccountBalance;

public interface IAccountBalanceDAO {

	public abstract void add(AccountBalance transientInstance);

	public abstract void delete(AccountBalance persistentInstance);

	public abstract List findAll();

	public abstract List query(String hql);

	public abstract void update(AccountBalance transientInstance);

}