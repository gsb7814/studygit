package com.sxmccitlab.pcash.bo.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sxmccitlab.pcash.dao.impl.AccountBalanceDAO;
import com.sxmccitlab.pcash.dao.impl.AccountDAO;

public class AccountBalanceMonthBO {
	private AccountBalanceDAO accountBalanceDAO;
	private String checkPeriod;
	private Date checkTime;
	private String staffName;
	


	/*	查询会计期间、状态、结账人、结账时间 */
	public List getMonthCheckInfo(String unitCode) {
		try{
       //已经结账
		String sqlFlagTrue="select t_account_balance.check_period,t_account_balance.check_time,t_staff.staff_name from t_account_balance,t_staff,t_unit where t_staff.staff_code=t_account_balance.staff_code and  t_account_balance.unit_code='"+unitCode+"'group by(t_account_balance.check_period,t_account_balance.check_time,t_staff.staff_name)";
        //未结账
		String sqlFlagFalse="select accounting_period from t_accounting_period where unit_code='"+unitCode+"'";
        List <MonthCheckTempBean>monthCheckTempList=new ArrayList();
	    List resultListFlagTrue=new ArrayList();
	    List resultListFlagFalse=new ArrayList();	
		resultListFlagTrue=accountBalanceDAO.querySQLStringSearch(sqlFlagTrue);
		if (resultListFlagTrue != null) {
			Iterator it = resultListFlagTrue.iterator();
			while (it.hasNext()) {
				 Object[] objs = (Object[]) it.next();
				 checkPeriod = objs[0].toString();
				 checkTime=(Date) objs[1];
				 staffName =objs[2].toString();
			     MonthCheckTempBean monthCheckTempBean  = new MonthCheckTempBean();
			     monthCheckTempBean.setCheckPeriod(checkPeriod);			     
			     monthCheckTempBean.setCheckTime(checkTime);
			     monthCheckTempBean.setFlag("已结");
			     monthCheckTempBean.setStaffName(staffName);
				 monthCheckTempList.add(monthCheckTempBean);
			}
			
			resultListFlagFalse=accountBalanceDAO.querySQLStringSearch(sqlFlagFalse);
			if (resultListFlagFalse != null) {
				Iterator it2 = resultListFlagFalse.iterator();
                Date checkTimeTemp = null;
    			while (it2.hasNext()) {
					 Object object = (Object) it2.next();
					 checkPeriod = object .toString();
				     MonthCheckTempBean monthCheckTempBean  = new MonthCheckTempBean();
				     monthCheckTempBean.setCheckPeriod(checkPeriod);			     
				     monthCheckTempBean.setCheckTime(checkTimeTemp);
				     monthCheckTempBean.setFlag("未结");
				     monthCheckTempBean.setStaffName("---");
					 monthCheckTempList.add(monthCheckTempBean);
				}
			
			
			}
			
		}
    	return monthCheckTempList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/*进行月结*/
	public boolean  setMonthCheck(String sytemTime,String unitCode,String staffCode){
      
		/*判断是否完全记账*/
		String sqlCharge1="select * from t_voucher  where charge_time is null and unit_Code='"+unitCode+"'";
		String sqlCharge2="select * from t_voucher where charge_time<uncharge_time and unit_Code='"+unitCode+"'";
		List listCharge1=accountBalanceDAO.querySQLStringSearch(sqlCharge1);
		List listCharge2=accountBalanceDAO.querySQLStringSearch(sqlCharge2);
		//System.out.println("SIZE:"+listCharge1.size());
		//System.out.println("SIZE:"+listCharge2.size());
		
		if((listCharge1.size()==0)&&(listCharge2.size()==0))
		{	
			/*获取上一个会计期间*/
		String sql1="select ACCOUNTING_PERIOD from t_accounting_period where unit_code='"+unitCode+"'";
		List list=accountBalanceDAO.querySQLStringSearch(sql1);
		String oldDate=list.get(0).toString();
		String date=list.get(0).toString();
		//System.out.println("date"+oldDate);
		String month=oldDate.substring(oldDate.length()-2);
		String year=oldDate.substring(0,4);
		if (month.equals("01")) {
			month = "12";			
			oldDate = (String.valueOf(Integer.parseInt(year) -1)) + month;
		} else {
			month=String.valueOf(Integer.parseInt(month)- 1);
			if (month.length()<2)
				month="0"+month;
			oldDate = year + month;

		}
		System.out.println("old"+oldDate);
		/* 插入记录到t_account_balance表*/
		String sql2="delete  t_account_balance where check_period='"+date+"'";
	    String sql3="insert into t_account_balance(id,account_code,unit_code,check_period,debit_sum,credit_sum,initial_balance) select  seq_account_balance.nextval,d.account_code,b.unit_code, b.ACCOUNTING_PERIOD,d.fdebit,d.fcredit,a.endting_balance from t_account_balance a ,t_accounting_period b ,t_voucher  c ,t_voucher_detail d where a.unit_code=b.unit_code and a.account_code =d.account_code and c.voucher_code =d.voucher_code and c.unit_code =b.unit_code and b.unit_code='"+unitCode+"' and check_period='"+oldDate+"'";
		String sql4="update t_account_balance  set endting_balance =(initial_balance-debit_sum+credit_sum) where check_period='"+date+"' and unit_code='"+unitCode+"'";
		String sql5="update t_account_balance  set check_time =(to_date('"+sytemTime+"','yyyy_mm_dd')) where check_period='"+date+"' and unit_code='"+unitCode+"'";
		String sql6="update t_account_balance  set staff_code='"+staffCode+"'where check_period='"+date+"' and unit_code='"+unitCode+"'";
		accountBalanceDAO.updateSQLString(sql2);
	    accountBalanceDAO.updateSQLString(sql3);
		accountBalanceDAO.updateSQLString(sql4);
		accountBalanceDAO.updateSQLString(sql5);
		accountBalanceDAO.updateSQLString(sql6);
		/*获取下一个会计期间*/
		String newDate=list.get(0).toString();
		month=newDate.substring(newDate.length()-2);
		year=newDate.substring(0,4);
		if (month.equals("12")) {
			month = "01";
			newDate = (String.valueOf(Integer.parseInt(year) +1)) + month;
		} else {
			month=String.valueOf(Integer.parseInt(month) + 1);
			if (month.length()<2)
				month="0"+month;
			newDate = year + month;

		}
	   // System.out.println("new"+newDate);
	    String sql7="update t_accounting_period  set ACCOUNTING_PERIOD='"+newDate+"'where unit_code='"+unitCode+"'";
		accountBalanceDAO.updateSQLString(sql7);
		return true;
		}
		else 
			return false;
	}
	
	public AccountBalanceDAO getAccountBalanceDAO() {
		return accountBalanceDAO;
	}

	public void setAccountBalanceDAO(AccountBalanceDAO accountBalanceDAO) {
		this.accountBalanceDAO = accountBalanceDAO;
	}
	public String getCheckPeriod() {
		return checkPeriod;
	}

	public void setCheckPeriod(String checkPeriod) {
		this.checkPeriod = checkPeriod;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
}
