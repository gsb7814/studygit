package com.sxmccitlab.common;

public class PcashConstants {
	//��ƿ�Ŀ�����б�
	public static String GLOBAL_ACCOUNT_TYPES = "GLOBAL_ACCOUNT_TYPES";
	
	//��ƿ�Ŀ�б�
	public static String GLOBAL_ACCOUNTS = "GLOBAL_ACCOUNTS";
	
	//����ƾ֤�����б�
	public static String GLOBAL_VOUCHER_TYPES = "GLOBAL_VOUCHER_TYPES";
	
	//Ӫҵ�����ֹ�˾��֯�����б�
	public static String GLOBAL_UNITS = "GLOBAL_UNITS";
	
	//�ֹ�˾�����б�
	public static String GLOBAL_REGIONS = "GLOBAL_REGIONS";
	
	//��ɫ�б�
	public static String GLOBAL_ROLES = "GLOBAL_ROLES";
		
	public final static String INIT_VOUCHER_TYPES_HQL = "from VoucherType";
	public final static String INIT_ACCOUNT_TYPES_HQL = "from AccountType";
	public final static String INIT_UNITS_HQL = "from Unit";
	public final static String INIT_REGIONS_HQL = "from Region";
	public final static String INIT_ROLES_HQL = "from Role";
	
	//ƾ֤״̬00��δ����״̬
	public final static String VOUCHER_CHARGE_FLAG_NOTCHARGED = "00";
	//ƾ֤״̬01���Ѽ���״̬
	public final static String VOUCHER_CHARGE_FLAG_CHARGED = "01";
	//ƾ֤״̬10��������״̬
	public final static String VOUCHER_CHARGE_FLAG_UNCHARGED = "10";
	
}
