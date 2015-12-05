package com.sxmccitlab.pcash.po;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TVoucherDetail entity. @author MyEclipse Persistence Tools
 */

public class VoucherDetail implements java.io.Serializable {

	// Fields

	private VoucherDetailId id;
	private String voucherDate;
	private String voucherAbstract;
	private String accountCode;
	private Double fdebit;
	private Double fcredit;
	private String chargeFlag;
	private Date chargeTime;
	private String rollbackFlag;
	private Date rollbackTime;
	private Long id_1;
	private String currencyDetail;

	// Constructors

	/** default constructor */
	public VoucherDetail() {
	}

	/** minimal constructor */
	public VoucherDetail(VoucherDetailId id) {
		this.id = id;
	}

	/** full constructor */
	public VoucherDetail(VoucherDetailId id, String voucherDate,
			String voucherAbstract, String accountCode, Double fdebit,
			Double fcredit, String chargeFlag, Timestamp chargeTime,
			String rollbackFlag, Timestamp rollbackTime, Long id_1,
			String currencyDetail) {
		this.id = id;
		this.voucherDate = voucherDate;
		this.voucherAbstract = voucherAbstract;
		this.accountCode = accountCode;
		this.fdebit = fdebit;
		this.fcredit = fcredit;
		this.chargeFlag = chargeFlag;
		this.chargeTime = chargeTime;
		this.rollbackFlag = rollbackFlag;
		this.rollbackTime = rollbackTime;
		this.id_1 = id_1;
		this.currencyDetail = currencyDetail;
	}

	// Property accessors

	public VoucherDetailId getId() {
		return this.id;
	}

	public void setId(VoucherDetailId id) {
		this.id = id;
	}

	public String getVoucherDate() {
		return this.voucherDate;
	}

	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
	}

	public String getVoucherAbstract() {
		return this.voucherAbstract;
	}

	public void setVoucherAbstract(String voucherAbstract) {
		this.voucherAbstract = voucherAbstract;
	}

	public String getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Double getFdebit() {
		return this.fdebit;
	}

	public void setFdebit(Double fdebit) {
		this.fdebit = fdebit;
	}

	public Double getFcredit() {
		return this.fcredit;
	}

	public void setFcredit(Double fcredit) {
		this.fcredit = fcredit;
	}

	public String getChargeFlag() {
		return this.chargeFlag;
	}

	public void setChargeFlag(String chargeFlag) {
		this.chargeFlag = chargeFlag;
	}



	public String getRollbackFlag() {
		return this.rollbackFlag;
	}

	public void setRollbackFlag(String rollbackFlag) {
		this.rollbackFlag = rollbackFlag;
	}

	

	public Date getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}

	public Date getRollbackTime() {
		return rollbackTime;
	}

	public void setRollbackTime(Date rollbackTime) {
		this.rollbackTime = rollbackTime;
	}

	public Long getId_1() {
		return this.id_1;
	}

	public void setId_1(Long id_1) {
		this.id_1 = id_1;
	}

	public String getCurrencyDetail() {
		return this.currencyDetail;
	}

	public void setCurrencyDetail(String currencyDetail) {
		this.currencyDetail = currencyDetail;
	}

}