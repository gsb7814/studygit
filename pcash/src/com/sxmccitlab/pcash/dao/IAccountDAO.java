package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.pcash.po.Account;

public interface IAccountDAO {

	public abstract void save(Account transientInstance);

	public abstract void delete(Account persistentInstance);

	public abstract Account findById(java.lang.String id);

	public abstract List findAll();

	public abstract Account merge(Account detachedInstance);

	public abstract void attachDirty(Account instance);

	public abstract void attachClean(Account instance);

}