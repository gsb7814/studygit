package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.pcash.po.Staff;



public interface IStaffDAO {
	public void save(Staff transientInstance);
	
	public void delete(Staff persistentInstance);
	
	public Staff findById(String id);

	public List<Staff> findByExample(Staff instance);

	public List<Staff> findByProperty(String propertyName, Object value);
	
	public List<Staff> findAll();
}
