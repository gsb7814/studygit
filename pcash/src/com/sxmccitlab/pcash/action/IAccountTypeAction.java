package com.sxmccitlab.pcash.action;

import com.sxmccitlab.pcash.po.AccountType;


public interface IAccountTypeAction {
	public String find(AccountType acountType);
	public String add(AccountType acountType);
	public String update(AccountType acountType);
	
}
