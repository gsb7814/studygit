package com.sxmccitlab.pcash.po;

/**
 * TRoleRight entity. @author MyEclipse Persistence Tools
 */

public class RoleRight implements java.io.Serializable {

	// Fields

	private String roleCode;
	private String rightCode;
	private Long id;

	// Constructors

	/** default constructor */
	public RoleRight() {
	}

	/** minimal constructor */
	public RoleRight(String roleCode) {
		this.roleCode = roleCode;
	}

	/** full constructor */
	public RoleRight(String roleCode, String rightCode, Long id) {
		this.roleCode = roleCode;
		this.rightCode = rightCode;
		this.id = id;
	}

	// Property accessors

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}