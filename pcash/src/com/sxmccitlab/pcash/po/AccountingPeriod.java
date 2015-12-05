package com.sxmccitlab.pcash.po;

/**
 * TAccountingPeriod entity. @author MyEclipse Persistence Tools
 */

public class AccountingPeriod implements java.io.Serializable {

	// Fields

	private String unitCode;
	private Long id;
	private String accountingPeriod;
	private String comments;

	// Constructors

	/** default constructor */
	public AccountingPeriod() {
	}

	/** minimal constructor */
	public AccountingPeriod(String unitCode) {
		this.unitCode = unitCode;
	}

	/** full constructor */
	public AccountingPeriod(String unitCode, Long id, String accountingPeriod,
			String comments) {
		this.unitCode = unitCode;
		this.id = id;
		this.accountingPeriod = accountingPeriod;
		this.comments = comments;
	}

	// Property accessors

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountingPeriod() {
		return this.accountingPeriod;
	}

	public void setAccountingPeriod(String accountingPeriod) {
		this.accountingPeriod = accountingPeriod;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}