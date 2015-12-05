package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.pcash.po.AccountingPeriod;

public interface IAccountingPeriodDAO {

	public abstract void save(AccountingPeriod transientInstance);

	public abstract void delete(AccountingPeriod persistentInstance);

	public abstract AccountingPeriod findById(java.lang.String id);

	public abstract List findAll();

	public abstract AccountingPeriod merge(AccountingPeriod detachedInstance);

	public abstract void attachDirty(AccountingPeriod instance);

	public abstract void attachClean(AccountingPeriod instance);

}