package com.sxmccitlab.pcash.po;

/**
 * TAccount entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private String accountCode;
	private String accountName;
	private String accountTypeCode;
	private String isCurrentAccount;
	private String comments;
	private Long id;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(String accountCode) {
		this.accountCode = accountCode;
	}

	/** full constructor */
	public Account(String accountCode, String accountName,
			String accountTypeCode, String isCurrentAccount, String comments,
			Long id) {
		this.accountCode = accountCode;
		this.accountName = accountName;
		this.accountTypeCode = accountTypeCode;
		this.isCurrentAccount = isCurrentAccount;
		this.comments = comments;
		this.id = id;
	}

	// Property accessors

	public String getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountTypeCode() {
		return this.accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public String getIsCurrentAccount() {
		return this.isCurrentAccount;
	}

	public void setIsCurrentAccount(String isCurrentAccount) {
		this.isCurrentAccount = isCurrentAccount;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}