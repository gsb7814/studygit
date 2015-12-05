package com.sxmccitlab.pcash.dao;

import java.util.List;
import com.sxmccitlab.pcash.po.Region;

public interface IRegionDAO {

	public abstract void add(Region transientInstance);

	public abstract void delete(Region persistentInstance);

	//public abstract Region findById(java.lang.String id);
	
	public abstract List query(String hql);
	
	public abstract void update(Region transientInstance);

}