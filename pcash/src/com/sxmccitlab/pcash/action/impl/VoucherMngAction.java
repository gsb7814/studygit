package com.sxmccitlab.pcash.action.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.sxmccitlab.common.PageUtil;
import com.sxmccitlab.common.PagerBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.pcash.action.bean.VoucherMngBean;
import com.sxmccitlab.pcash.bo.IVoucherMngBO;
import com.sxmccitlab.pcash.po.Staff;
import com.sxmccitlab.pcash.po.Unit;



public class VoucherMngAction  extends ActionSupport {

	private static final int pageSize = 3;
	
	IVoucherMngBO voucherMngBO;
	
	private VoucherMngBean  voucherMngBean;
	
	public VoucherMngBean getVoucherMngBean() {
		return voucherMngBean;
	}

	public void setVoucherMngBean(VoucherMngBean voucherMngBean) {
		this.voucherMngBean = voucherMngBean;
	}

	public void setVoucherMngBO(IVoucherMngBO voucherMngBO) {
		this.voucherMngBO = voucherMngBO;
	}

	public void validate() {
		// TODO Auto-generated method stub
	/*
		this.clearActionErrors();
		this.clearFieldErrors();
		super.validate();
		if ( "".equals(staff.getStaffCode()) ) {
						
			this.addFieldError("msg.staffCode", "±ØÐëÊäÈë¹¤ºÅ£¡");
		}
		
		if ( "".equals(staff.getPassword()) ) {
			
			this.addFieldError("msg.password", "±ØÐëÊäÈëÃÜÂë£¡");
		}
		
		if ( ! staff.getStaffCode().matches("41[0-9]{6}") ) {
			this.addFieldError("msg.staffCode", "ÊäÈëµÄStaffCode¸ñÊ½²»ÕýÈ·£¡");
		}
		*/
	}
	//显示凭证填制页面
	public String showAddVoucher(){
		try{
			
			//HttpServletRequest request =   ServletActionContext.getRequest();
			//HttpSession session = request.getSession();
			//sMap tempMap = (Map) ActionContext.getContext().getSession();
			Staff staff = (Staff)ActionContext.getContext().getSession().get("staff");
			Unit unit = (Unit)staff.getUnits().toArray()[0];
			
			VoucherMngBean voucherMngBeanTemp =new VoucherMngBean();
			voucherMngBeanTemp.setUnitCode(unit.getUnitCode());
			System.out.println(unit.getUnitCode()+"999999999");
			voucherMngBean=voucherMngBO.getInfo(voucherMngBeanTemp);
			System.out.println(voucherMngBean.getAccountingPeriodName()+"999999999");
			voucherMngBean.setStaffName(staff.getStaffName());
			voucherMngBean.setUnitName(unit.getUnitName());
			//voucherMngBean.setCurrentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			System.out.println("eee"+voucherMngBO.getInfo(voucherMngBean).getAccount());
			System.out.println("zzz"+voucherMngBean.getStaffName());
			System.out.println(voucherMngBO.getInfo(voucherMngBean).getAccount().size());
			return "showAddVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//填制凭证
	public String addVoucher(){		
		try{
			
			System.out.println(voucherMngBean.getVoucherTypeCode());
			Staff staff = (Staff)ActionContext.getContext().getSession().get("staff");
			Unit unit = (Unit)staff.getUnits().toArray()[0];
			
			voucherMngBean.setStaffCode(staff.getStaffCode());
			voucherMngBean.setUnitCode(unit.getUnitCode());
			voucherMngBO.addVoucherInfo(voucherMngBean);
			System.out.println("888888888");
			return "addVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//显示凭证查询页面
	public String showSearchVoucher(){
		try{
			Staff staff = (Staff)ActionContext.getContext().getSession().get("staff");
			Unit unit = (Unit)staff.getUnits().toArray()[0];
			System.out.println(unit.getUnitCode());
			System.out.println(voucherMngBean);
			VoucherMngBean voucherMngBeanTemp =new VoucherMngBean();
			voucherMngBeanTemp.setUnitCode(unit.getUnitCode());
			System.out.println(voucherMngBeanTemp);
			voucherMngBean=voucherMngBO.getInfo(voucherMngBeanTemp);
			System.out.println("111111111");
			return "showSearchVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//凭证查询，显示凭证查询结果
	public String searchVoucher(){
		try{			
			
			HttpServletRequest request =   ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if(voucherMngBean==null){
				voucherMngBean=(VoucherMngBean)session.getAttribute("voucherMngBean");
			}
			
			System.out.println(voucherMngBean);
			System.out.println("zzzzzzzz"+voucherMngBean.getVoucherTypeCode());
			System.out.println(voucherMngBean.getChargeFlag());
			int page = 1;
			try {
				String pg = request.getParameter("page");
				if(pg==null || pg.trim().equals("")){
					if(session.getAttribute("page")!=null){
						page = (Integer)session.getAttribute("page");
					}
					
				}else{
					page = Integer.parseInt(pg);
					session.setAttribute("page", page);
				}
			} catch (Exception e) {
				page = 1;
			}
			System.out.println(page+"ccccc");
			voucherMngBean.setPage(page);
			voucherMngBean.setPageSize(pageSize);
			PaginationSupport paginationSupport=voucherMngBO.queryVoucher(voucherMngBean);
			PagerBean pagerBean=new PagerBean();
			pagerBean.makePagerList(paginationSupport);
			List voucherBean = paginationSupport.getItems();
			PageUtil pageUtil= new PageUtil();
			pageUtil.setCurPage(pagerBean.getCurrentPager());
			pageUtil.setRowsCount(pagerBean.getTotalRecords());
			pageUtil.setTotalPage(pagerBean.getTotalPagers());
			
			String footer=pageUtil.getFooter(request, "",page, String.valueOf(pageSize));
			
			System.out.println(voucherBean.size());
			voucherMngBean.setFooter(footer);
			voucherMngBean.setVoucher(voucherBean);
			session.setAttribute("voucherMngBean", voucherMngBean);
			System.out.println("111111111");
			return "searchVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//查询凭证信息
	public String searchVoucherInfo(){
		try{
			
			HttpServletRequest request =   ServletActionContext.getRequest();
			String voucherCode = request.getParameter("voucherCode");
			System.out.println("voucherCode:"+voucherCode);
			voucherMngBean=voucherMngBO.queryVoucherInfo(voucherCode);
			return "searchVoucherInfo";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			return ERROR;
		}		
	}
	
	//查询凭证信息，显示修改凭证页面
	public String showModifyVoucher(){
		try{
			HttpServletRequest request =   ServletActionContext.getRequest();
			String voucherCode = request.getParameter("voucherCode");
			System.out.println("voucherCode:"+voucherCode);
			voucherMngBean=voucherMngBO.queryVoucherInfo(voucherCode);
			VoucherMngBean voucherMngBean1=voucherMngBO.getInfo(voucherMngBean);
			voucherMngBean.setAccount(voucherMngBean1.getAccount());
			voucherMngBean.setVoucherType(voucherMngBean1.getVoucherType());
			return "showModifyVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//修改凭证信息
	public String modifyVoucher(){
		try{
			System.out.println(voucherMngBean.getVoucherCode()+"ppp");
			voucherMngBO.updateVoucherInfo(voucherMngBean);
			return "modifyVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	//显示凭证记账查询页面
	public String showChargeVoucher(){
		try{
			Staff staff = (Staff)ActionContext.getContext().getSession().get("staff");
			Unit unit = (Unit)staff.getUnits().toArray()[0];
			System.out.println(unit.getUnitCode());
			System.out.println(voucherMngBean);
			VoucherMngBean voucherMngBeanTemp =new VoucherMngBean();
			voucherMngBeanTemp.setUnitCode(unit.getUnitCode());
			System.out.println(voucherMngBeanTemp);
			voucherMngBean=voucherMngBO.getSearchInfo(voucherMngBeanTemp);
			System.out.println(voucherMngBean.getAccountingPeriodName());
			System.out.println(voucherMngBean.getAccountingPeriod());
			System.out.println("11111aaa");
			return "showChargeVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//凭证查询，显示凭证记账查询结果页面
	public String searchChargeVoucher(){
		try{
			HttpServletRequest request =   ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if(voucherMngBean==null){
				voucherMngBean=(VoucherMngBean)session.getAttribute("voucherMngBean");
			}
			
			System.out.println(voucherMngBean);
			System.out.println("zzzzzzzz"+voucherMngBean.getVoucherTypeCode());
			System.out.println(voucherMngBean.getChargeFlag());
			int page = 1;
			try {
				String pg = request.getParameter("page");
				if(pg==null || pg.trim().equals("")){
					if(session.getAttribute("page")!=null){
						page = (Integer)session.getAttribute("page");
					}
					
				}else{
					page = Integer.parseInt(pg);
					session.setAttribute("page", page);
				}
			} catch (Exception e) {
				page = 1;
			}
			System.out.println(page+"ccccc");
			voucherMngBean.setPage(page);
			voucherMngBean.setPageSize(pageSize);
			voucherMngBean.setChargeFlag("00','10");
			PaginationSupport paginationSupport=voucherMngBO.queryVoucher(voucherMngBean);
			PagerBean pagerBean=new PagerBean();
			pagerBean.makePagerList(paginationSupport);
			List voucherBean = paginationSupport.getItems();
			PageUtil pageUtil= new PageUtil();
			pageUtil.setCurPage(pagerBean.getCurrentPager());
			pageUtil.setRowsCount(pagerBean.getTotalRecords());
			pageUtil.setTotalPage(pagerBean.getTotalPagers());
			
			String footer=pageUtil.getFooter(request, "",page, String.valueOf(pageSize));
			
			System.out.println(voucherBean.size());
			voucherMngBean.setFooter(footer);
			voucherMngBean.setVoucher(voucherBean);
			session.setAttribute("voucherMngBean", voucherMngBean);
			System.out.println("jjjjjj");
			System.out.println("11111www");
			return "searchChargeVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//凭证记账
	public String chargeVoucher(){
		try{
			voucherMngBean.setChargeFlag("01");
			System.out.println("hhh"+voucherMngBean.getVoucherCodeList().size());
			voucherMngBO.updateVoucherDetail(voucherMngBean);
			addActionMessage("凭证记账成功");
			return "chargeVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			return ERROR;
		}		
	}
	//显示凭证反记账查询页面
	public String showUnChargedVoucher(){
		try{
			Staff staff = (Staff)ActionContext.getContext().getSession().get("staff");
			Unit unit = (Unit)staff.getUnits().toArray()[0];
			System.out.println(unit.getUnitCode());
			System.out.println(voucherMngBean);
			VoucherMngBean voucherMngBeanTemp =new VoucherMngBean();
			voucherMngBeanTemp.setUnitCode(unit.getUnitCode());
			System.out.println(voucherMngBeanTemp);
			voucherMngBean=voucherMngBO.getSearchInfo(voucherMngBeanTemp);
			return "showUnChargedVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//凭证查询，显示凭证反记账查询结果页面
	public String searchUnChargedVoucher(){
		try{
			HttpServletRequest request =   ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if(voucherMngBean==null){
				voucherMngBean=(VoucherMngBean)session.getAttribute("voucherMngBean");
			}
			
			System.out.println(voucherMngBean);
			System.out.println("zzzzzzzz"+voucherMngBean.getVoucherTypeCode());
			System.out.println(voucherMngBean.getChargeFlag());
			int page = 1;
			try {
				String pg = request.getParameter("page");
				if(pg==null || pg.trim().equals("")){
					if(session.getAttribute("page")!=null){
						page = (Integer)session.getAttribute("page");
					}
					
				}else{
					page = Integer.parseInt(pg);
					session.setAttribute("page", page);
				}
			} catch (Exception e) {
				page = 1;
			}
			System.out.println(page+"ccccc");
			voucherMngBean.setPage(page);
			voucherMngBean.setPageSize(pageSize);
			voucherMngBean.setChargeFlag("01");
			PaginationSupport paginationSupport=voucherMngBO.queryVoucher(voucherMngBean);
			PagerBean pagerBean=new PagerBean();
			pagerBean.makePagerList(paginationSupport);
			List voucherBean = paginationSupport.getItems();
			PageUtil pageUtil= new PageUtil();
			pageUtil.setCurPage(pagerBean.getCurrentPager());
			pageUtil.setRowsCount(pagerBean.getTotalRecords());
			pageUtil.setTotalPage(pagerBean.getTotalPagers());
			
			String footer=pageUtil.getFooter(request, "",page, String.valueOf(pageSize));
			
			System.out.println(voucherBean.size());
			voucherMngBean.setFooter(footer);
			voucherMngBean.setVoucher(voucherBean);
			session.setAttribute("voucherMngBean", voucherMngBean);
			System.out.println("jjjjjj");
			return "searchUnChargedVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	//凭证反记账
	public String unChargedVoucher(){
		try{
			//VgopSysOperator user=Cantants.getCurUser();
			//List list = pzMagBO.getCombusiListInfo(pageVO);
			//pageVO.setPageShowList(list);
			//pageVO.setFuncTypeMap((Map)Cantants.getDataLibrary().get("19"));
			//Cantants.saveSysLog(0, "list","×éºÏÒµÎñ²éÑ¯",  3, "0");
			//voucherMngBO.addVoucher(voucherMngBean);
			voucherMngBean.setChargeFlag("10");
			System.out.println("hhh"+voucherMngBean.getVoucherCodeList().size());
			voucherMngBO.updateVoucherDetail(voucherMngBean);
			addActionMessage("凭证反记账成功");
			return "unChargedVoucher";
		}catch(Exception e){
			//pageVO.setReturnMsg("ÒµÎñ×éºÏÐÅÏ¢²éÑ¯´íÎó......");
			//Cantants.errorDeal("×éºÏÒµÎñ²éÑ¯´íÎó",e, pageVO, "×éºÏÒµÎñ²éÑ¯list", 3);
			e.printStackTrace();
			return ERROR;
		}		
	}
	
}
