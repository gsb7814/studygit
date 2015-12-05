package com.sxmccitlab.pcash.bo.impl;

import java.util.List;

import com.sxmccitlab.pcash.bo.IBookMngBO;

import com.sxmccitlab.common.pagehandle.PaginationVO;
import com.sxmccitlab.pcash.dao.IVoucherDAO;
import com.sxmccitlab.pcash.dao.IVoucherDetailDAO;

public class BookMngBO implements  IBookMngBO{
	
	



	private IVoucherDetailDAO voucherDetailDAO;

	public IVoucherDetailDAO getVoucherDetailDAO() {
		return voucherDetailDAO;
	}



	public void setVoucherDetailDAO(IVoucherDetailDAO voucherDetailDAO) {
		this.voucherDetailDAO = voucherDetailDAO;
	}


	//public List detailLedger(String unitCode,String voucherDatestart,String voucherDateend,String accountCode) {
	
	//public List detailLedger(String unitCode,String voucherDatestart,String voucherDateend,String accountCode,final int pageNow, final int pageSize) {
	public PaginationVO detailLedger(String unitCode, String voucherDatestart,String voucherDateend, String accountCode,int startIndex, int maxResult) {
	
	// TODO Auto-generated method stub
		//return voucherDetailDAO.searchSum(unitCode, voucherDatestart,voucherDateend, accountCode, pageNow,, pageSize);
		return voucherDetailDAO.searchSum( unitCode, voucherDatestart,voucherDateend, accountCode ,startIndex,  maxResult);
		
	}
	public List detailLedgerExport(String unitCode, String voucherDatestart,String voucherDateend, String accountCode) {
		
		// TODO Auto-generated method stub
			//return voucherDetailDAO.searchSum(unitCode, voucherDatestart,voucherDateend, accountCode, pageNow,, pageSize);
			return voucherDetailDAO.searchExport( unitCode, voucherDatestart,voucherDateend, accountCode );
			
		}
	
	public List HJsum(String unitCode, String voucherDatestart,String voucherDateend, String accountCode){
		return voucherDetailDAO.sumHJ(unitCode, voucherDatestart,voucherDateend, accountCode);
		
		
	}
    public List LJsum(String unitCode, String voucherDatestart,String voucherDateend, String accountCode){
    	return voucherDetailDAO.sumLJ(unitCode, voucherDatestart,voucherDateend, accountCode);
    	
    }
    
	public PaginationVO dailyLedger(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult) {
		
		// TODO Auto-generated method stub
			//return voucherDetailDAO.searchSum(unitCode, voucherDatestart,voucherDateend, accountCode, pageNow,, pageSize);
			return voucherDetailDAO.searchDailyLedgerSum( unitCode, voucherDatestart, accountCode ,startIndex,  maxResult);
			
		}
	
	public List dailyLedgerExport(String unitCode, String voucherDatestart, String accountCode) {
		
		// TODO Auto-generated method stub
			//return voucherDetailDAO.searchSum(unitCode, voucherDatestart,voucherDateend, accountCode, pageNow,, pageSize);
			return voucherDetailDAO.searchDailyLedgerExport( unitCode, voucherDatestart, accountCode);
			
		}
		
		public List HJdailyLedgersum(String unitCode, String voucherDatestart, String accountCode){
			return voucherDetailDAO.sumDailyLedgerHJ(unitCode, voucherDatestart, accountCode);
			
			
		}
	    public List LJdailyLedgersum(String unitCode, String voucherDatestart,String accountCode){
	    	return voucherDetailDAO.sumDailyLedgerLJ(unitCode, voucherDatestart, accountCode);
	    	
	    }
	    
		public PaginationVO generalLedger(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult) {
			
			// TODO Auto-generated method stub
				//return voucherDetailDAO.searchSum(unitCode, voucherDatestart,voucherDateend, accountCode, pageNow,, pageSize);
				return voucherDetailDAO.searchGeneralLedgerSum( unitCode, voucherDatestart, accountCode ,startIndex,  maxResult);
				
			}
		
		public List generalLedgerExport(String unitCode, String voucherDatestart, String accountCode) {
			
			// TODO Auto-generated method stub
				//return voucherDetailDAO.searchSum(unitCode, voucherDatestart,voucherDateend, accountCode, pageNow,, pageSize);
				return voucherDetailDAO.searchGeneralLedgerExport( unitCode, voucherDatestart, accountCode );
				
			}
			
			public List HJgeneralLedgersum(String unitCode, String voucherDatestart, String accountCode){
				return voucherDetailDAO.sumGeneralLedgerHJ(unitCode, voucherDatestart, accountCode);
				
				
			}
		    public List LJgeneralLedgersum(String unitCode, String voucherDatestart,String accountCode){
		    	return voucherDetailDAO.sumGeneralLedgerLJ(unitCode, voucherDatestart, accountCode);
		    	
		    }    
}
