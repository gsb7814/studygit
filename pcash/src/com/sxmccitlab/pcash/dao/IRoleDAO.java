package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.pcash.po.Region;
import com.sxmccitlab.pcash.po.Role;

public interface IRoleDAO {

	public abstract void add(Role transientInstance);

	public abstract void delete(Role persistentInstance);
	
	public abstract List query(String hql);
	
	public abstract void update(Role transientInstance);

	public abstract Role queryById(java.lang.String id);

}