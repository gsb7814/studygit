package com.sxmccitlab.pcash.po;

/**
 * SAccountType entity. @author MyEclipse Persistence Tools
 */

public class AccountType implements java.io.Serializable {

	// Fields

	private String accountTypeCode;
	private String accountTypeName;

	// Constructors

	/** default constructor */
	public AccountType() {
	}

	/** minimal constructor */
	public AccountType(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	/** full constructor */
	public AccountType(String accountTypeCode, String accountTypeName) {
		this.accountTypeCode = accountTypeCode;
		this.accountTypeName = accountTypeName;
	}

	// Property accessors

	public String getAccountTypeCode() {
		return this.accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public String getAccountTypeName() {
		return this.accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

}