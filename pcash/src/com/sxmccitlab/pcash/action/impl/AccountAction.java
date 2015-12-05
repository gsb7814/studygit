package com.sxmccitlab.pcash.action.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;

import com.sxmccitlab.pcash.action.IAccountAction;
import com.sxmccitlab.pcash.bo.impl.AccountBO;
import com.sxmccitlab.pcash.bo.impl.AccountTempBean;


public class AccountAction implements IAccountAction {

	private final String SUCCESS = "success";
	private final String FAIL = "fail";
	private final String SETINITBALANCE = "setinitbalance";
	
	/* 营业部名称 */
	private String unitName;
	/* 营业部编号 */
	private  String unitValue;
    private String unitCode;
	private String unitValueHiden;
	/* 会计科目编号 */
	private String accountHiden;
	/* 获取会计科目编号、会计科目名称、期初余额 */
	private AccountBO accountBO;
	private Log log = LogFactory.getLog(getClass());
	/* 设置期初余额 */
	private List<AccountTempBean> accountTempBeanList = new ArrayList();
	private String initialBalance;
	private Double initialBalanceNew;
	/* 设置会计科目启用标志 */
	private List<String> accountFlagList = new ArrayList();
	HttpServletRequest request;
	HttpSession session ;

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getInitialBalance() {
		return initialBalance;
	}

	public List<String> getAccountFlagList() {
		return accountFlagList;
	}

	public void setAccountFlagList(List<String> accountFlagList) {
		this.accountFlagList = accountFlagList;
	}

	public void setInitialBalance(String initialBalance) {
		this.initialBalance = initialBalance;
	}

	public List<AccountTempBean> getAccountTempBeanList() {
		return accountTempBeanList;
	}

	public void setAccountTempBeanList(List<AccountTempBean> accountTempBeanList) {
		this.accountTempBeanList = accountTempBeanList;
	}

	public AccountBO getAccountBO() {
		return accountBO;
	}

	public void setAccountBO(AccountBO accountBO) {
		this.accountBO = accountBO;
	}

	public Double getInitialBalanceNew() {
		return initialBalanceNew;
	}

	public void setInitialBalanceNew(Double initialBalanceNew) {
		this.initialBalanceNew = initialBalanceNew;
	}

	public String getAccountHiden() {
		return accountHiden;
	}

	public void setAccountHiden(String accountHiden) {
		this.accountHiden = accountHiden;
	}

	/* 设置期初余额 */
	public String setBalance() {
		
		try {
			
			if (initialBalance != null) {
				initialBalanceNew = Double.parseDouble(initialBalance);	
				HttpServletRequest request = ServletActionContext.getRequest();
				session = (HttpSession) request.getSession();
				unitValueHiden = (String) session.getAttribute("unitValueHidden");	
				unitCode = unitValueHiden;
				accountBO.setBalance(unitCode, accountHiden, initialBalanceNew);
				session = (HttpSession) request.getSession();
				System.out.println("session"+session);
				unitValueHiden = (String) session.getAttribute("unitValueHidden");	
			    unitCode = unitValueHiden;
			    unitName= accountBO.getUnitValueName(unitCode);
			   // System.out.println("unitName"+unitName);
				accountTempBeanList = accountBO.getAccountInfo(unitCode);
				return SETINITBALANCE;
			} else
				return FAIL;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return FAIL;
		}
	}

	

	
	/* 查询会计科目、期初余额 */
	public String getAccountInfo() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String pageName = (String) request.getParameter("page");
			/*System.out.println("pageName"+pageName);
			System.out.println("Session:"
					+ request.getSession().getAttribute("unitValueHidden"));
			System.out.println("request:"+request.getParameter("unitValue"));	*/
			
			if (!"initBalancePage".equals(pageName)) {
				
				session = (HttpSession) request.getSession();
				session.setAttribute("unitValueHidden", request.getParameter("unitValue"));
				unitValueHiden = (String) session.getAttribute("unitValueHidden");	
			    unitCode = unitValueHiden;
			    unitName= accountBO.getUnitValueName(unitCode);
				for (int i = 0; i < accountTempBeanList.size(); i++)
					accountTempBeanList.remove(i);
				System.out
						.println("beginning find account_code,account_name,initialBalance");

				accountTempBeanList = accountBO.getAccountInfo(unitCode);
				if (accountTempBeanList.size() != 0) {
					return SUCCESS;
				}

				else {
					return FAIL;
				}
			} else {
				session = (HttpSession) request.getSession();
				unitValueHiden = (String) session.getAttribute("unitValueHidden");	
			    unitCode = unitValueHiden;
			    unitName= accountBO.getUnitValueName(unitCode);
				accountTempBeanList = accountBO.getAccountInfo(unitCode);
				return SETINITBALANCE;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return FAIL;
		}

	}

	public String getUnitValueHiden() {
		return unitValueHiden;
	}

	public void setUnitValueHiden(String unitValueHiden) {
		this.unitValueHiden = unitValueHiden;
	}

	public String getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
	}

	/* 设置会计科目启用标志 */
	public String setAccountFlag() {
		try {
			int size = accountFlagList.size();
			String accountFlagStr = "";
			if (size != 0) {
				for (int i = 0; i < size; i++) {
					if (i == 0) {
						accountFlagStr = "'" + (String) accountFlagList.get(i)
								+ "'";
					} else {
						accountFlagStr = accountFlagStr + ",'"
								+ (String) accountFlagList.get(i) + "'";
					}
				}
			}
			System.out.println(accountFlagStr);
			accountBO.setAccountFlag(accountFlagStr);
			this.getAccountInfo();
			return SUCCESS;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return FAIL;
		}
	}

}

