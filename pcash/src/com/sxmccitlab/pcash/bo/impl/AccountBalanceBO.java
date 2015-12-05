package com.sxmccitlab.pcash.bo.impl;

import java.util.*;

import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.pcash.action.bean.VoucherBean;
import com.sxmccitlab.pcash.bo.IAccountBalanceBO;
import com.sxmccitlab.pcash.dao.IToolDAO;
import com.sxmccitlab.pcash.po.Unit;
import com.sxmccitlab.pcash.action.bean.AccountBalanceBean;

public class AccountBalanceBO implements IAccountBalanceBO {
	IToolDAO toolDAO;

	public IToolDAO getToolDAO() {
		return toolDAO;
	}

	public void setToolDAO(IToolDAO toolDAO) {
		this.toolDAO = toolDAO;
	}

	public PaginationSupport queryMonthCheck(Unit unit, int page, int pageSize) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String sqlStr = "select distinct u.unit_name,s.staff_name ,"
				+ "a.check_period "
				+ "from t_account_balance a,t_staff s ,t_unit u "
				+ "where a.unit_code=u.unit_code and a.staff_code=s.staff_code   ";
		sqlStr = sqlStr + " and a.unit_code like '" + unit.getUnitCode() + "%'";
		java.util.Date date = new java.util.Date();
		java.util.Calendar calendar   =   new   GregorianCalendar();   
		  calendar.setTime(date);   
		    
		  System.out.println("YEAR:   "   +   calendar.get(Calendar.YEAR)); 
		String year = String.valueOf( calendar.get(Calendar.YEAR));
		System.out.println(year+"____________________");
		sqlStr = sqlStr + " and a.check_period like '"
				+ year + "%'";

		PaginationSupport paginationSupport = toolDAO.findPageBySql(sqlStr,
				sqlStr, (page - 1)
						* pageSize, pageSize);
		List listResult = paginationSupport.getItems();
		if (listResult != null) {
			Iterator it = listResult.iterator();
			while (it.hasNext()) {
				Object[] objs = (Object[]) it.next();
				AccountBalanceBean accountBalanceBean = new AccountBalanceBean();
				accountBalanceBean.setUnitName(objs[0].toString());
				accountBalanceBean.setStaffName(objs[1].toString());
				accountBalanceBean.setCheckPeriod(objs[2].toString());
				list.add(accountBalanceBean);

			}
		}
		paginationSupport.setItems(list);
		return paginationSupport;
	}
}
