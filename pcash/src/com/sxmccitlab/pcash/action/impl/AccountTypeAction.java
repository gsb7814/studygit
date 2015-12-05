package com.sxmccitlab.pcash.action.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sxmccitlab.pcash.action.IAccountTypeAction;
import com.sxmccitlab.pcash.bo.IAccountTypeBO;
import com.sxmccitlab.pcash.po.AccountType;

public class AccountTypeAction extends ActionSupport implements
		IAccountTypeAction {
	IAccountTypeBO accountTypeBO;
	AccountType accountType;
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public IAccountTypeBO getAccountTypeBO() {
		return accountTypeBO;
	}

	public void setAccountTypeBO(IAccountTypeBO accountTypeBO) {
		this.accountTypeBO = accountTypeBO;
	}

	public String add(AccountType acountType) {
		// TODO Auto-generated method stub
		accountTypeBO.add(accountType);
		
		return "success";
	}

	public String find(AccountType acountType) {
		// TODO Auto-generated method stub
		return null;
	}

	public String update(AccountType acountType) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(AccountType accountType) {
		// TODO Auto-generated method stub

	}

	public List<AccountType> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
