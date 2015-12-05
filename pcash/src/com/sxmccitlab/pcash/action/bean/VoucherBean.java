package com.sxmccitlab.pcash.action.bean;

import java.util.Date;

public class VoucherBean {

	Date voucherDate;
	String voucherTypeCode;
	String staffName;
	String unitName;
	String voucherTypeName;
	Double debitSum;
	Double creditSum;
	String voucherCode;
	String chargeFlag;

	public VoucherBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoucherBean(Date voucherDate,String voucherTypeCode, String staffName,
			String unitName, String voucherTypeName, Double debitSum,
			Double creditSum, String voucherCode, String chargeFlag) {
		super();
		this.voucherDate=voucherDate;
		this.voucherTypeCode = voucherTypeCode;
		this.staffName = staffName;
		this.unitName = unitName;
		this.voucherTypeName = voucherTypeName;
		this.debitSum = debitSum;
		this.creditSum = creditSum;
		this.voucherCode = voucherCode;
		this.chargeFlag = chargeFlag;
	}

	
	public Date getVoucherDate() {
		return voucherDate;
	}
	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}
	public VoucherBean(String staffName, String unitName,
			String voucherTypeName, Double debitSum, Double creditSum,
			String voucherCode, String chargeFlag) {
		super();
		this.staffName = staffName;
		this.unitName = unitName;
		this.voucherTypeName = voucherTypeName;
		this.debitSum = debitSum;
		this.creditSum = creditSum;
		this.voucherCode = voucherCode;
		this.chargeFlag = chargeFlag;
	}

	public String getVoucherTypeCode() {
		return voucherTypeCode;
	}

	public void setVoucherTypeCode(String voucherTypeCode) {
		this.voucherTypeCode = voucherTypeCode;
	}
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getVoucherTypeName() {
		return voucherTypeName;
	}

	public void setVoucherTypeName(String voucherTypeName) {
		this.voucherTypeName = voucherTypeName;
	}

	public Double getDebitSum() {
		return debitSum;
	}

	public void setDebitSum(Double debitSum) {
		this.debitSum = debitSum;
	}

	public Double getCreditSum() {
		return creditSum;
	}

	public void setCreditSum(Double creditSum) {
		this.creditSum = creditSum;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getChargeFlag() {
		return chargeFlag;
	}

	public void setChargeFlag(String chargeFlag) {
		this.chargeFlag = chargeFlag;
	}

}
