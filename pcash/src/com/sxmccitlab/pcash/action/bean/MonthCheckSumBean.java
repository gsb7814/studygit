package com.sxmccitlab.pcash.action.bean;

import java.util.List;

public class MonthCheckSumBean {
	int page;
	int pageSize;
	String footer;
	List accountBalanceList;
	public List getAccountBalanceList() {
		return accountBalanceList;
	}
	public void setAccountBalanceList(List accountBalanceList) {
		this.accountBalanceList = accountBalanceList;
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
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}

}
