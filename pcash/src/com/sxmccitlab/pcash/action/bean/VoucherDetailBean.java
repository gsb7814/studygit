package com.sxmccitlab.pcash.action.bean;

public class VoucherDetailBean {
	String accountCode;
	
	String voucherAbstract;
	String accountName;
	Double fdebit;
	Double fcredit;
	String currencyDetail;
	
	public VoucherDetailBean(String accountCode,String voucherAbstract, String accountName,
			Double fdebit, Double fcredit,String currencyDetail) {
		super();
		this.accountCode=accountCode;
		this.voucherAbstract = voucherAbstract;
		this.accountName = accountName;
		this.fdebit = fdebit;
		this.fcredit = fcredit;
		this.currencyDetail=currencyDetail;
	}
	
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getCurrencyDetail() {
		return currencyDetail;
	}
	public void setCurrencyDetail(String currencyDetail) {
		this.currencyDetail = currencyDetail;
	}
	
	public String getVoucherAbstract() {
		return voucherAbstract;
	}
	public void setVoucherAbstract(String voucherAbstract) {
		this.voucherAbstract = voucherAbstract;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Double getFdebit() {
		return fdebit;
	}
	public void setFdebit(Double fdebit) {
		this.fdebit = fdebit;
	}
	public Double getFcredit() {
		return fcredit;
	}
	public void setFcredit(Double fcredit) {
		this.fcredit = fcredit;
	}
	
	

}
