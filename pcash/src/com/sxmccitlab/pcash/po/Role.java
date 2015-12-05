package com.sxmccitlab.pcash.po;

import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private String roleCode;
	private String roleName;
	//private String rightCode;
	private String comments;
	private Set <Staff> staffs;
	private Set <Right> rights;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleCode) {
		this.roleCode = roleCode;
	}

	/** full constructor */
	public Role(String roleCode, String roleName,
			String comments) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.comments = comments;
	}

	// Property accessors

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Right> getRights() {
		return rights;
	}

	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setStaffs(Set <Staff> staffs) {
		this.staffs = staffs;
	}

	public Set <Staff> getStaffs() {
		return staffs;
	}

}