/**
 * 
 */
package com.sxmccitlab.pcash.bo;

import java.util.List;

import com.sxmccitlab.pcash.po.Staff;

/**
 * @author Bob Guo
 *
 */
public interface IStaffBO {
	public Staff login(Staff staff);
	public void add(Staff staff);
	public boolean delete(Staff staff);
	public boolean update(Staff staff);
	public List query (String hql);
}
