package com.sxmccitlab.pcash.dao;

import com.sxmccitlab.pcash.po.Serial;

public interface ISerialDAO {

	public abstract void save(Serial transientInstance);

	public abstract void delete(Serial persistentInstance);

	public abstract Serial findById(java.lang.String id);

	public abstract Serial merge(Serial detachedInstance);

	public abstract void attachDirty(Serial instance);

	public abstract void attachClean(Serial instance);

}