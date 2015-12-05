package com.sxmccitlab.pcash.po;

import java.util.Set;

/**
 * TStaff entity. @author MyEclipse Persistence Tools
 */

public class Staff implements java.io.Serializable {

	// Fields

	private String staffCode;
	private String staffName;
	private String telephone;
	private String email;
	private String password;
	
	private Set<Role> roles;
	private Set<Unit>  units;
	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

	// Constructors

	public Set<Unit> getUnits() {
		return units;
	}

	public void setUnits(Set<Unit> units) {
		this.units = units;
	}

	/** default constructor */
	public Staff() {
	}

	/** minimal constructor */
	public Staff(String staffCode) {
		this.staffCode = staffCode;
	}

	/** full constructor */
	public Staff(String staffCode, String staffName, String telephone,
			String email, String password) {
		this.staffCode = staffCode;
		this.staffName = staffName;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	// Property accessors

	public String getStaffCode() {
		return this.staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}