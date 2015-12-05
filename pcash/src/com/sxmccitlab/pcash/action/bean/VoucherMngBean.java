package com.sxmccitlab.pcash.action.bean;

import java.util.List;

public class VoucherMngBean {
	
	String staffName;
	String staffCode;
	String unitCode;
	String unitName;
	String voucherDate;
	String voucherTypeCode;
	String voucherCode;
	Double debitSum;
	String chargeFlag;
	int page;
	int pageSize;
	String footer;
	Double creditSum;
	String accountingPeriod;
	String accountingPeriodName;
	String fromDate;
	String toDate;
	
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	VoucherBean voucherBean;
	
	List voucherCodeList;
	List voucherAbstract;
	List accountCode;
	List fdebit;
	List fcredit;
	List currencyDetail;
	List voucherType;
	List account;
	List voucher;
	List voucherDetail;
	List voucherDetailBeanList;
	List unitList;
	
	
	public List getVoucherDetailBeanList() {
		return voucherDetailBeanList;
	}
	public void setVoucherDetailBeanList(List voucherDetailBeanList) {
		this.voucherDetailBeanList = voucherDetailBeanList;
	}
	public List getUnitList() {
		return unitList;
	}
	public void setUnitList(List unitList) {
		this.unitList = unitList;
	}
	public String getAccountingPeriod() {
		return accountingPeriod;
	}
	public void setAccountingPeriod(String accountingPeriod) {
		this.accountingPeriod = accountingPeriod;
	}
	public String getAccountingPeriodName() {
		return accountingPeriodName;
	}
	public void setAccountingPeriodName(String accountingPeriodName) {
		this.accountingPeriodName = accountingPeriodName;
	}

	public VoucherBean getVoucherBean() {
		return voucherBean;
	}
	public void setVoucherBean(VoucherBean voucherBean) {
		this.voucherBean = voucherBean;
	}
	public List getVoucherCodeList() {
		return voucherCodeList;
	}
	public void setVoucherCodeList(List voucherCodeList) {
		this.voucherCodeList = voucherCodeList;
	}
	

	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	public String getChargeFlag() {
		return chargeFlag;
	}
	public void setChargeFlag(String chargeFlag) {
		this.chargeFlag = chargeFlag;
	}
	
	public List getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(List accountCode) {
		this.accountCode = accountCode;
	}
	public List getFdebit() {
		return fdebit;
	}
	public void setFdebit(List fdebit) {
		this.fdebit = fdebit;
	}
	public List getFcredit() {
		return fcredit;
	}
	public void setFcredit(List fcredit) {
		this.fcredit = fcredit;
	}
	public List getCurrencyDetail() {
		return currencyDetail;
	}
	public void setCurrencyDetail(List currencyDetail) {
		this.currencyDetail = currencyDetail;
	}
	
	public List getVoucherAbstract() {
		return voucherAbstract;
	}
	public void setVoucherAbstract(List voucherAbstract) {
		this.voucherAbstract = voucherAbstract;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
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
	public String getVoucherTypeCode() {
		return voucherTypeCode;
	}
	public void setVoucherTypeCode(String voucherTypeCode) {
		this.voucherTypeCode = voucherTypeCode;
	}

	public List getAccount() {
		return account;
	}
	public void setAccount(List account) {
		this.account = account;
	}

	
	public List getVoucher() {
		return voucher;
	}
	public void setVoucher(List voucher) {
		this.voucher = voucher;
	}
	public List getVoucherDetail() {
		return voucherDetail;
	}
	public void setVoucherDetail(List voucherDetail) {
		this.voucherDetail = voucherDetail;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getVoucherDate() {
		return voucherDate;
	}
	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
	}
	public List getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(List voucherType) {
		this.voucherType = voucherType;
	}


}
