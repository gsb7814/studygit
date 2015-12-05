package com.sxmccitlab.pcash.po;

import java.sql.Timestamp;

/**
 * TAccountBalance entity. @author MyEclipse Persistence Tools
 */

public class AccountBalance implements java.io.Serializable {

	// Fields

	private String accountCode;
	private Timestamp checkPeriod;
	private Double initialBalance;
	private Double endtingBalance;
	private String comments;
	private String checkTypeCode;
	private Double debitSum;
	private Double creditSum;
	private String unitCode;
	private String staffCode;
	private Long id;

	// Constructors

	/** default constructor */
	public AccountBalance() {
	}

	/** minimal constructor */
	public AccountBalance(String accountCode) {
		this.accountCode = accountCode;
	}


	/** full constructor */
	public AccountBalance(String accountCode, Timestamp checkPeriod,
			Double initialBalance, Double endtingBalance, String comments,
			String checkTypeCode, Double debitSum, Double creditSum,
			String unitCode, Long id, String staffCode) {
		this.accountCode = accountCode;
		this.checkPeriod = checkPeriod;
		this.initialBalance = initialBalance;
		this.endtingBalance = endtingBalance;
		this.comments = comments;
		this.checkTypeCode = checkTypeCode;
		this.debitSum = debitSum;
		this.creditSum = creditSum;
		this.unitCode = unitCode;
		this.staffCode = staffCode;
		this.id = id;
	}

	// Property accessors

	public Timestamp getCheckPeriod() {
		return checkPeriod;
	}

	public void setCheckPeriod(Timestamp checkPeriod) {
		this.checkPeriod = checkPeriod;
	}

	public String getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Double getInitialBalance() {
		return this.initialBalance;
	}

	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public Double getEndtingBalance() {
		return this.endtingBalance;
	}

	public void setEndtingBalance(Double endtingBalance) {
		this.endtingBalance = endtingBalance;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCheckTypeCode() {
		return this.checkTypeCode;
	}

	public void setCheckTypeCode(String checkTypeCode) {
		this.checkTypeCode = checkTypeCode;
	}

	public Double getDebitSum() {
		return this.debitSum;
	}

	public void setDebitSum(Double debitSum) {
		this.debitSum = debitSum;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Double getCreditSum() {
		return this.creditSum;
	}

	public void setCreditSum(Double creditSum) {
		this.creditSum = creditSum;
	}


	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}