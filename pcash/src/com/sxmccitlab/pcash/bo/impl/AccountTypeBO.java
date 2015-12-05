package com.sxmccitlab.pcash.bo.impl;

import java.util.List;

import com.sxmccitlab.pcash.bo.IAccountTypeBO;
import com.sxmccitlab.pcash.dao.IAccountTypeDAO;
import com.sxmccitlab.pcash.po.AccountType;

public class AccountTypeBO implements IAccountTypeBO {
	IAccountTypeDAO accountTypeDAO;
	
	public IAccountTypeDAO getAccountTypeDAO() {
		return accountTypeDAO;
	}

	public void setAccountTypeDAO(IAccountTypeDAO accountTypeDAO) {
		this.accountTypeDAO = accountTypeDAO;
	}

	public void add(AccountType accountType) {
		// TODO Auto-generated method stub
		accountTypeDAO.add(accountType);
	}

	public void delete(AccountType accountType) {
		// TODO Auto-generated method stub

	}

	public List<AccountType> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(AccountType accountType) {
		// TODO Auto-generated method stub

	}

}
