package com.sxmccitlab.pcash.action;

public interface IAccountAction {
	/* 设置期初余额 */
	public String setBalance();
	/* 查询会计科目、期初余额 */
	public String getAccountInfo();
	/* 设置会计科目启用标志 */
	public String setAccountFlag();
}
