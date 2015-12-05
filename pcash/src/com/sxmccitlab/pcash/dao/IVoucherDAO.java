package com.sxmccitlab.pcash.dao;

import com.sxmccitlab.pcash.po.Voucher;

public interface IVoucherDAO {

	public abstract void save(Voucher transientInstance);

	public abstract void delete(Voucher persistentInstance);

	public abstract Voucher findById(java.lang.String id);

	public abstract Voucher merge(Voucher detachedInstance);

	public abstract void attachDirty(Voucher instance);

	public abstract void attachClean(Voucher instance);

}