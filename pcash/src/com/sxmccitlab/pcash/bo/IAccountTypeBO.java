package com.sxmccitlab.pcash.bo;

import java.util.List;

import com.sxmccitlab.pcash.po.AccountType;

public interface IAccountTypeBO {
	public void add(AccountType accountType);
	public void update(AccountType accountType);
	public void delete(AccountType accountType);
	public List<AccountType> findById(String id);
}
