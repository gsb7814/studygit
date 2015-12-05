package com.sxmccitlab.common;

public class PcashConstants {
	//会计科目类型列表
	public static String GLOBAL_ACCOUNT_TYPES = "GLOBAL_ACCOUNT_TYPES";
	
	//会计科目列表
	public static String GLOBAL_ACCOUNTS = "GLOBAL_ACCOUNTS";
	
	//记账凭证类型列表
	public static String GLOBAL_VOUCHER_TYPES = "GLOBAL_VOUCHER_TYPES";
	
	//营业部及分公司组织机构列表
	public static String GLOBAL_UNITS = "GLOBAL_UNITS";
	
	//分公司代码列表
	public static String GLOBAL_REGIONS = "GLOBAL_REGIONS";
	
	//角色列表
	public static String GLOBAL_ROLES = "GLOBAL_ROLES";
		
	public final static String INIT_VOUCHER_TYPES_HQL = "from VoucherType";
	public final static String INIT_ACCOUNT_TYPES_HQL = "from AccountType";
	public final static String INIT_UNITS_HQL = "from Unit";
	public final static String INIT_REGIONS_HQL = "from Region";
	public final static String INIT_ROLES_HQL = "from Role";
	
	//凭证状态00：未记账状态
	public final static String VOUCHER_CHARGE_FLAG_NOTCHARGED = "00";
	//凭证状态01：已记账状态
	public final static String VOUCHER_CHARGE_FLAG_CHARGED = "01";
	//凭证状态10：反记账状态
	public final static String VOUCHER_CHARGE_FLAG_UNCHARGED = "10";
	
}
