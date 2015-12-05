package com.sxmccitlab.pcash.action.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.sxmccitlab.pcash.bo.impl.AccountBO;
import com.sxmccitlab.pcash.bo.impl.AccountBalanceMonthBO;
import com.sxmccitlab.pcash.bo.impl.AccountTempBean;
import com.sxmccitlab.pcash.bo.impl.MonthCheckTempBean;
import com.sxmccitlab.pcash.po.Staff;
import com.sxmccitlab.pcash.po.Unit;

public class AccountBalanceMonthAction {

	private final String initMonthCheckReturn = "initMonthCheckReturn";
	/* ��ȡSession */
	Map session = ActionContext.getContext().getSession();
	Staff staff = (Staff) session.get("staff");
	private String unitNameMonth;
	private AccountBalanceMonthBO accountBalanceMonthBO=new AccountBalanceMonthBO() ;
	/*��ȡ�½���Ϣ*/
	private List<MonthCheckTempBean> monthCheckTempBeanList = new ArrayList();
	private String flag;
	private boolean checkFlag=true;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<MonthCheckTempBean> getMonthCheckTempBeanList() {
		return monthCheckTempBeanList;
	}

	public void setMonthCheckTempBeanList(
			List<MonthCheckTempBean> monthCheckTempBeanList) {
		this.monthCheckTempBeanList = monthCheckTempBeanList;
	}

	/* �½��ʼ������ȡ��¼����Ӫҵ�� */
	public String initMonthCheck() {
		String staffCode = staff.getStaffCode();
		Unit unit = (Unit) staff.getUnits().toArray()[0];
		unitNameMonth = unit.getUnitName();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("unitNameMonth", unitNameMonth);
		//System.out.println("unitcode"+unit.getUnitCode());
		monthCheckTempBeanList =accountBalanceMonthBO.getMonthCheckInfo(unit.getUnitCode());
/*	    System.out.println(monthCheckTempBeanList.size());
		System.out.println(monthCheckTempBeanList.get(0).getCheckPeriod());
		System.out.println(monthCheckTempBeanList.get(0).getFlag());
		System.out.println(monthCheckTempBeanList.get(0).getStaffName());
		System.out.println(monthCheckTempBeanList.get(0).getCheckTime());*/
		return initMonthCheckReturn;
	}
	/*�����½�*/
	public String setMonthCheck() throws ParseException {
         
			/* ��ȡϵͳʱ�� */
			Calendar ctime = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
			Date date = ctime.getTime();
			String sDate = formatter.format(date);
		
			/* ��ȡӪҵ����� */
			String staffCode = staff.getStaffCode();
			Unit unit = (Unit) staff.getUnits().toArray()[0];			
			checkFlag= accountBalanceMonthBO.setMonthCheck(sDate, unit.getUnitCode(),staffCode);
			System.out.println(checkFlag);
		    HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("message", " <script laguage='JavaScript'> alert('���Ѿ������������ԣ�');</script>");

			this.initMonthCheck();
		return initMonthCheckReturn;
	}
	
	


	public boolean isCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(boolean checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getUnitNameMonth() {
		return unitNameMonth;
	}
	public void setUnitNameMonth(String unitNameMonth) {
		this.unitNameMonth = unitNameMonth;
	}
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public AccountBalanceMonthBO getAccountBalanceMonthBO() {
		return accountBalanceMonthBO;
	}
	public void setAccountBalanceMonthBO(AccountBalanceMonthBO accountBalanceMonthBO) {
		this.accountBalanceMonthBO = accountBalanceMonthBO;
	}
}
