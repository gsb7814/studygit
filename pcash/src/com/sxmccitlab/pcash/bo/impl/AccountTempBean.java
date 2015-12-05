package com.sxmccitlab.pcash.bo.impl;

public class AccountTempBean {
	private String account_code;
	private String account_name;
	private Double initialBalance;
	
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String accountCode) {
		account_code = accountCode;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String accountName) {
		account_name = accountName;
	}
	public Double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
}
