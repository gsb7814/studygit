package com.sxmccitlab.pcash.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sxmccitlab.common.PageUtil;
import com.sxmccitlab.common.PagerBean;
import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.pcash.po.Unit;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sxmccitlab.pcash.bo.IAccountBalanceBO;
import com.sxmccitlab.pcash.action.bean.MonthCheckSumBean;
import com.sxmccitlab.pcash.action.bean.VoucherMngBean;

public class MonthCheckSumAction extends ActionSupport {
	private IAccountBalanceBO accountBalanceBO;
	private MonthCheckSumBean monthCheckBean;
	public IAccountBalanceBO getAccountBalanceBO() {
		return accountBalanceBO;
	}

	public MonthCheckSumBean getMonthCheckBean() {
		return monthCheckBean;
	}

	public void setMonthCheckBean(MonthCheckSumBean monthCheckBean) {
		this.monthCheckBean = monthCheckBean;
	}

	public void setAccountBalanceBO(IAccountBalanceBO accountBalanceBO) {
		this.accountBalanceBO = accountBalanceBO;
	}
	
	public String queryMonthCheck(){
		HttpServletRequest request =   ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String unitCode = request.getParameter("unitCode");
		Unit unit =new Unit();
		if(null != unitCode )
		{
			unit.setUnitCode(unitCode);
		}
		else
		{
			unit.setUnitCode("01");
		}
		monthCheckBean=(MonthCheckSumBean)session.getAttribute("monthCheckBean");
		if(monthCheckBean==null){
			monthCheckBean=new MonthCheckSumBean();
		}
		int monthCheckPage = 1;
		try {
			String pg = request.getParameter("page");
			if(pg==null || pg.trim().equals("")){
				if(session.getAttribute("page")!=null){
					monthCheckPage = (Integer)session.getAttribute("page");
				}
				
			}else{
				monthCheckPage = Integer.parseInt(pg);
				session.setAttribute("monthCheckPage", monthCheckPage);
			}
		} catch (Exception e) {
			monthCheckPage = 1;
		}
		monthCheckBean.setPage(monthCheckPage);
		monthCheckBean.setPageSize(3);
		PaginationSupport paginationSupport=accountBalanceBO.queryMonthCheck(unit, monthCheckPage, 8);
		PagerBean pagerBean=new PagerBean();
		pagerBean.makePagerList(paginationSupport);
		List accountBalanceList = paginationSupport.getItems();
		PageUtil pageUtil= new PageUtil();
		pageUtil.setCurPage(pagerBean.getCurrentPager());
		pageUtil.setRowsCount(pagerBean.getTotalRecords());
		pageUtil.setTotalPage(pagerBean.getTotalPagers());
		String footer=pageUtil.getFooter(request, "",monthCheckPage, String.valueOf(8));
		monthCheckBean.setFooter(footer);
		monthCheckBean.setAccountBalanceList(accountBalanceList);
		session.setAttribute("monthCheckBean", monthCheckBean);
		return "showMonthCheck";
	}

}
