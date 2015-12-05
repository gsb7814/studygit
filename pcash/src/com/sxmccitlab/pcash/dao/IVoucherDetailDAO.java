package com.sxmccitlab.pcash.dao;

import java.util.List;

import com.sxmccitlab.common.pagehandle.PaginationVO;
import com.sxmccitlab.pcash.po.VoucherDetail;

public interface IVoucherDetailDAO {
	
	public void save(VoucherDetail transientInstance) ;
	public void update(VoucherDetail transientInstance) ;

	public void delete(Long id);

	public VoucherDetail findById(Long id);
     public List findAll() ;
     
   //  public List searchSum(String unitCode,String voucherDatestart,String voucherDateend,String accountCode,final int pageNow, final int pageSize);

   public PaginationVO searchSum(String unitCode, String voucherDatestart,String voucherDateend, String accountCode,int startIndex, int maxResult);
   public List searchExport(String unitCode, String voucherDatestart,String voucherDateend, String accountCode);
   
	public List sumHJ(String unitCode, String voucherDatestart,String voucherDateend, String accountCode);
    public List sumLJ(String unitCode, String voucherDatestart,String voucherDateend, String accountCode);

    
    public PaginationVO searchDailyLedgerSum(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult);
    public List searchDailyLedgerExport(String unitCode, String voucherDatestart, String accountCode);
    
	public List sumDailyLedgerHJ(String unitCode, String voucherDatestart, String accountCode);
    public List sumDailyLedgerLJ(String unitCode, String voucherDatestart, String accountCode);

    
    public PaginationVO searchGeneralLedgerSum(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult);
    public List searchGeneralLedgerExport(String unitCode, String voucherDatestart, String accountCode);
    
	public List sumGeneralLedgerHJ(String unitCode, String voucherDatestart, String accountCode);
    public List sumGeneralLedgerLJ(String unitCode, String voucherDatestart, String accountCode);

}
