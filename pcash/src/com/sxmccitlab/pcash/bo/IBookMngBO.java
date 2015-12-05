package com.sxmccitlab.pcash.bo;

import java.util.List;

import com.sxmccitlab.common.pagehandle.PaginationVO;
public interface IBookMngBO {
	
	
 //public List detailLedger(String unitCode,String voucherDatestart,String voucherDateend,String accountCode,final int pageNow, final int pageSize);
	
	public PaginationVO detailLedger(String unitCode, String voucherDatestart,String voucherDateend, String accountCode,int startIndex, int maxResult);
	public List detailLedgerExport(String unitCode, String voucherDatestart,String voucherDateend, String accountCode);
	
	public List HJsum(String unitCode, String voucherDatestart,String voucherDateend, String accountCode);
    public List LJsum(String unitCode, String voucherDatestart,String voucherDateend, String accountCode);

    public PaginationVO dailyLedger(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult);
    public List dailyLedgerExport(String unitCode, String voucherDatestart, String accountCode);
	public List HJdailyLedgersum(String unitCode, String voucherDatestart, String accountCode);
    public List LJdailyLedgersum(String unitCode, String voucherDatestart, String accountCode);

    public PaginationVO generalLedger(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult);
    public List generalLedgerExport(String unitCode, String voucherDatestart, String accountCode);
	public List HJgeneralLedgersum(String unitCode, String voucherDatestart, String accountCode);
    public List LJgeneralLedgersum(String unitCode, String voucherDatestart, String accountCode);



}
