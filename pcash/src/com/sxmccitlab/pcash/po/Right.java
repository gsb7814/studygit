package com.sxmccitlab.pcash.po;

import java.util.Set;

/**
 * TRight entity. @author MyEclipse Persistence Tools
 */

public class Right implements java.io.Serializable {

	// Fields

	private String rightCode;
	private String rightName;
	//private String menuCode;
	private Set <Role> roles;
	private Menu menu;

	// Constructors

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** default constructor */
	public Right() {
	}

	/** minimal constructor */
	public Right(String rightCode) {
		this.rightCode = rightCode;
	}

	/** full constructor */
	public Right(String rightCode, String rightName) {
		this.rightCode = rightCode;
		this.rightName = rightName;
	}

	// Property accessors

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

}