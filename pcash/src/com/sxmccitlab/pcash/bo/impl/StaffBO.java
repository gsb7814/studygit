/**
 * 
 */
package com.sxmccitlab.pcash.bo.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import com.sxmccitlab.pcash.bo.IStaffBO;
import com.sxmccitlab.pcash.dao.IStaffDAO;
import com.sxmccitlab.pcash.po.Menu;
import com.sxmccitlab.pcash.po.Right;
import com.sxmccitlab.pcash.po.Role;
import com.sxmccitlab.pcash.po.Staff;

/**
 * @author Bob Guo
 *
 */
public class StaffBO implements IStaffBO {
	
	IStaffDAO staffDAO;
	
	public IStaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setStaffDAO(IStaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.IStaffBO#delete(com.sxmccitlab.pcash.po.Staff)
	 */
	public boolean delete(Staff staff) {
		return false;
	}
	
	
	public Staff login(Staff staff) {
		Staff staff2 = staffDAO.findById(staff.getStaffCode());
		System.out.println("staff:"+staff.getPassword());
		System.out.println("staff2:"+staff2.getPassword());
		
		
		
		if ( staff2 != null && staff2.getPassword().trim().equals(staff.getPassword().trim()) ) {
			return staff2;
		}
		return null;
	}
	

		
	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.IStaffBO#register(com.sxmccitlab.pcash.po.Staff)
	 */
	public void add(Staff staff) {
		staffDAO.save(staff);
	}

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.IStaffBO#update(com.sxmccitlab.pcash.po.Staff)
	 */
	public boolean update(Staff staff) {
		return false;
	}

	public List query(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

}
