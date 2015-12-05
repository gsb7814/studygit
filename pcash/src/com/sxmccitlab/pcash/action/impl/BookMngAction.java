package com.sxmccitlab.pcash.action.impl;

import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext; 


import com.sxmccitlab.pcash.bo.IBookMngBO;
import com.sxmccitlab.pcash.po.VoucherDetail;
import com.sxmccitlab.common.pagehandle.PaginationVO;

public class BookMngAction   {

	public IBookMngBO bookMngBO;
	
	public String unitCode;
	public String voucherDatestart;
	public String voucherDateend;
	public String  accountCode;

	
	
	
	
	
	public VoucherDetail voucherDetail;
	
	public int startIndex = 1 ; //初始化为1,默认从第一页开始显示
    public int  maxResult =3 ; //每页显示5条记录 并生成get，set方法 
   
    public int CP;

    




public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}



public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
		
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

public IBookMngBO getBookMngBO() {
		return bookMngBO;
	}

	public void setBookMngBO(IBookMngBO bookMngBO) {
		this.bookMngBO = bookMngBO;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getVoucherDatestart() {
		return voucherDatestart;
	}

	public void setVoucherDatestart(String voucherDatestart) {
		this.voucherDatestart = voucherDatestart;
	}

	public String getVoucherDateend() {
		return voucherDateend;
	}

	public void setVoucherDateend(String voucherDateend) {
		this.voucherDateend = voucherDateend;
	}



	

	public VoucherDetail getVoucherDetail() {
		return voucherDetail;
	}

	public void setVoucherDetail(VoucherDetail voucherDetail) {
		this.voucherDetail = voucherDetail;
	}
public String searchfy(){
		
	 PaginationVO voucherSum=null;
	 List sumhjdetail=null;
	 List sumljdetail=null;

		
		if (this.getCP()==0)
		{
			this.setStartIndex(0);
			
		
			
		
			this.setVoucherDateend(ActionContext.getContext().getSession().get("tvoucherDateend").toString());
			this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
			this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
			this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
			
		
		}
		else
		{
			
			
			this.setStartIndex(0);
		startIndex=this.getCP()*this.getMaxResult()+this.getStartIndex();
		this.setVoucherDateend(ActionContext.getContext().getSession().get("tvoucherDateend").toString());
		this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
		this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
		this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
		}
		
	
		
		
		voucherSum=bookMngBO.detailLedger( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode(),startIndex,  maxResult);
		
		
		
		
		ActionContext.getContext().put("voucherSum", voucherSum);
		
		sumhjdetail=bookMngBO.HJsum( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		ActionContext.getContext().put("sumhjdetail", sumhjdetail);
		sumljdetail=bookMngBO.LJsum( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		
		ActionContext.getContext().put("sumljdetail", sumljdetail);
		
		
		return "success";
	}


public String search(){
		
	 PaginationVO voucherSum=null;
	 List sumhjdetail=null;
	 List sumljdetail=null;

	ActionContext.getContext().getSession().put("tvoucherDateend", voucherDateend);
	ActionContext.getContext().getSession().put("tvoucherDatestart", voucherDatestart);
	ActionContext.getContext().getSession().put("tunitCode", unitCode);
	ActionContext.getContext().getSession().put("taccountCode", accountCode);
		
		if (this.getCP()==0)
		{
			this.setStartIndex(0);
			
		
			
			
			
			
		
		}
		else
		{
			
			
			this.setStartIndex(0);
		startIndex=this.getCP()*this.getMaxResult()+this.getStartIndex();
		this.setVoucherDateend(ActionContext.getContext().getSession().get("tvoucherDateend").toString());
		this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
		this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
		this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
		}
		
	
		
		
		voucherSum=bookMngBO.detailLedger( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode(),startIndex,  maxResult);
		
		
		
		
		ActionContext.getContext().put("voucherSum", voucherSum);
		
		sumhjdetail=bookMngBO.HJsum( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		ActionContext.getContext().put("sumhjdetail", sumhjdetail);
		sumljdetail=bookMngBO.LJsum( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		
		ActionContext.getContext().put("sumljdetail", sumljdetail);
		
		
		return "success";
	}



public String searchDailyLedgerfy(){
	
	PaginationVO DailyLedgerSum=null;
	 List sumhjLedgerSum=null;
	 List sumljLedgerSum=null;

	
	if (this.getCP()==0)
	{
		this.setStartIndex(0);
		
	
		
	
		
		this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
		this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
		this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
		
	
	}
	else
	{
		
		
		this.setStartIndex(0);
	startIndex=this.getCP()*this.getMaxResult()+this.getStartIndex();
	
	this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
	this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
	this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
	}
	

	
	
	DailyLedgerSum=bookMngBO.dailyLedger( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode(),startIndex,  maxResult);
	
	
	
	
	ActionContext.getContext().put("DailyLedgerSum", DailyLedgerSum);
	
	sumhjLedgerSum=bookMngBO.HJdailyLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	ActionContext.getContext().put("sumhjLedgerSum", sumhjLedgerSum);
	sumljLedgerSum=bookMngBO.LJdailyLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	
	ActionContext.getContext().put("sumljLedgerSum", sumljLedgerSum);
	
	
	return "success";
}


public String searchDailyLedger(){
	
	PaginationVO DailyLedgerSum=null;
	 List sumhjLedgerSum=null;
	 List sumljLedgerSum=null;

	ActionContext.getContext().getSession().put("tvoucherDatestart", voucherDatestart);
	ActionContext.getContext().getSession().put("tunitCode", unitCode);
	ActionContext.getContext().getSession().put("taccountCode", accountCode);
	
	if (this.getCP()==0)
	{
		this.setStartIndex(0);

			
		
	}
	else
	{
		
		
		this.setStartIndex(0);
	startIndex=this.getCP()*this.getMaxResult()+this.getStartIndex();
	this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
	this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
	this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
	}
	

	
	
   DailyLedgerSum=bookMngBO.dailyLedger( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode(),startIndex,  maxResult);
	
	
	
	
	ActionContext.getContext().put("DailyLedgerSum", DailyLedgerSum);
	
	sumhjLedgerSum=bookMngBO.HJdailyLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	ActionContext.getContext().put("sumhjLedgerSum", sumhjLedgerSum);
	sumljLedgerSum=bookMngBO.LJdailyLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	
	ActionContext.getContext().put("sumljLedgerSum", sumljLedgerSum);
	
	
	return "success";
}

public String searchGeneralLedgerfy(){
	
	
	
	
	 PaginationVO GeneralLedgerSum=null;
	 List sumhjGeneralSum=null;
	 List sumljGeneralSum=null;
	if (this.getCP()==0)
	{
		this.setStartIndex(0);
		
	
		
	
		
		this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
		this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
		this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
		
	
	}
	else
	{
		
		
		this.setStartIndex(0);
	startIndex=this.getCP()*this.getMaxResult()+this.getStartIndex();
	
	this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
	this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
	this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
	}
	

	
	GeneralLedgerSum=bookMngBO.generalLedger( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode(),startIndex,  maxResult);
	
	
	
	
	ActionContext.getContext().put("GeneralLedgerSum", GeneralLedgerSum);
	
	sumhjGeneralSum=bookMngBO.HJgeneralLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	ActionContext.getContext().put("sumhjGeneralSum", sumhjGeneralSum);
	sumljGeneralSum=bookMngBO.LJgeneralLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	
	ActionContext.getContext().put("sumljGeneralSum",sumljGeneralSum);
	
	
	return "success";
}


public String searchGeneralLedger(){
	

 PaginationVO GeneralLedgerSum=null;
	 List sumhjGeneralSum=null;
	 List sumljGeneralSum=null;

	ActionContext.getContext().getSession().put("tvoucherDatestart", voucherDatestart);
	ActionContext.getContext().getSession().put("tunitCode", unitCode);
	ActionContext.getContext().getSession().put("taccountCode", accountCode);
	
	if (this.getCP()==0)
	{
		this.setStartIndex(0);

			
		
	}
	else
	{
		
		
		this.setStartIndex(0);
	startIndex=this.getCP()*this.getMaxResult()+this.getStartIndex();
	this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
	this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
	this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
	}
	

	
	

	
GeneralLedgerSum=bookMngBO.generalLedger( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode(),startIndex,  maxResult);
	
	
	
	
	ActionContext.getContext().put("GeneralLedgerSum", GeneralLedgerSum);
	
	sumhjGeneralSum=bookMngBO.HJgeneralLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	ActionContext.getContext().put("sumhjGeneralSum", sumhjGeneralSum);
	sumljGeneralSum=bookMngBO.LJgeneralLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	
	ActionContext.getContext().put("sumljGeneralSum",sumljGeneralSum);
	
	
	return "success";
}

public String exportGeneralLedger(){
	

	 List GeneralLedgerSum=null;
		 List sumhjGeneralSum=null;
		 List sumljGeneralSum=null;

		this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
		this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
		this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
		
		
	GeneralLedgerSum=bookMngBO.generalLedgerExport( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
		
		
		ActionContext.getContext().put("GeneralLedgerSum", GeneralLedgerSum);
		
		sumhjGeneralSum=bookMngBO.HJgeneralLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
		ActionContext.getContext().put("sumhjGeneralSum", sumhjGeneralSum);
		sumljGeneralSum=bookMngBO.LJgeneralLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
		
		ActionContext.getContext().put("sumljGeneralSum",sumljGeneralSum);
		
		System.out.println("export");
		return "export";
	}
public String exportDailyLedger(){
	
	List DailyLedgerSum=null;
	 List sumhjLedgerSum=null;
	 List sumljLedgerSum=null;

	
	
	this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
	this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
	this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());


	
   DailyLedgerSum=bookMngBO.dailyLedgerExport( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	
	
	
	
	ActionContext.getContext().put("DailyLedgerSum", DailyLedgerSum);
	
	sumhjLedgerSum=bookMngBO.HJdailyLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	ActionContext.getContext().put("sumhjLedgerSum", sumhjLedgerSum);
	sumljLedgerSum=bookMngBO.LJdailyLedgersum( this.getUnitCode(),this.getVoucherDatestart(),this.getAccountCode());
	
	ActionContext.getContext().put("sumljLedgerSum", sumljLedgerSum);
	
	
	return "export";
}

public String exportDetailLedger(){
	
	 List voucherSum=null;
	 List sumhjdetail=null;
	 List sumljdetail=null;

	
		this.setVoucherDateend(ActionContext.getContext().getSession().get("tvoucherDateend").toString());
		this.setVoucherDatestart(ActionContext.getContext().getSession().get("tvoucherDatestart").toString());
		this.setUnitCode(ActionContext.getContext().getSession().get("tunitCode").toString()) ;
		this.setAccountCode(ActionContext.getContext().getSession().get("taccountCode").toString());
		
		
		
		voucherSum=bookMngBO.detailLedgerExport( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		
		
		
		
		ActionContext.getContext().put("voucherSum", voucherSum);
		
		sumhjdetail=bookMngBO.HJsum( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		ActionContext.getContext().put("sumhjdetail", sumhjdetail);
		sumljdetail=bookMngBO.LJsum( this.getUnitCode(),this.getVoucherDatestart(),this.getVoucherDateend(),this.getAccountCode());
		
		ActionContext.getContext().put("sumljdetail", sumljdetail);
		
		
		return "export";
	}


}
