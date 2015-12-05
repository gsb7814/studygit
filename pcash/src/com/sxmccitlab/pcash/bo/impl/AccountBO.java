package com.sxmccitlab.pcash.bo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.bo.IAccountBO;
import com.sxmccitlab.pcash.dao.IAccountDAO;
import com.sxmccitlab.pcash.dao.impl.AccountDAO;
import com.sxmccitlab.pcash.po.Account;
import com.sxmccitlab.pcash.po.AccountBalance;


public class AccountBO  implements IAccountBO{
	private AccountDAO accountDAO;
	//查询会计科目，期初余额
	private String accountCode;
	private String accountName;
	private Double initialBalance;	
	private Log log= LogFactory.getLog(getClass());
	
	
	public Double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public AccountDAO getAccountDAO() {
		return accountDAO; 
	}
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

/*	查询会计科目、会计编码、期初余额 */
	public List getAccountInfo(String unitCode) {
		try{
	    String sql = "select  t_account.account_code,t_account.account_name,t_account_balance.initial_balance from  t_ledger,t_ledger_detail,t_account,t_account_balance,t_ledger_unit where t_ledger_detail.flag='Y' and  t_ledger_detail.account_code=t_account_balance.account_code and  t_ledger_detail.account_code=t_account.account_code and  t_ledger.ledger_code=t_ledger_detail.ledger_code and  t_ledger.ledger_code=t_ledger_unit.LEDGER_CODE and t_account_balance.unit_code=t_ledger_unit.unit_code and  t_ledger_unit.unit_code='"+unitCode+"'";
	    List <AccountTempBean>accountTempBeanList=new ArrayList();
	    List resultList=new ArrayList();	
	   
		resultList=accountDAO.querySQLStringSearch(sql);
		
		if (resultList != null) {
			Iterator it = resultList.iterator();
			while (it.hasNext()) {
				Object[] objs = (Object[]) it.next();
				accountCode = objs[0].toString();
				accountName=objs[1].toString();
				 initialBalance = ((BigDecimal)objs[2]).doubleValue();
				AccountTempBean accountTempBean = new AccountTempBean();
				accountTempBean.setAccount_code(accountCode);				
				accountTempBean.setInitialBalance(initialBalance);
				accountTempBean.setAccount_name(accountName);
				accountTempBeanList.add(accountTempBean);
		
			}
		}
		//System.out.println("bo"+accountTempBeanList);
    	return accountTempBeanList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
/*	插入期初余额*/
	public void setBalance(String unitCode,String accountCode,Double initialBalance)
	{
		 String sql = "update  t_account_balance set initial_balance='"+initialBalance+"' where  account_code='"+accountCode+"' and unit_code='"+unitCode+"'";
	     log.info(sql);
	     accountDAO.updateSQLString(sql);   
	}

/*设置会计科目启用标志*/
	public void setAccountFlag(String accountFlagStr)
	{try{
		String FlagNO="N";
		String FlagYES="Y";
		String strSql="update t_ledger_detail set flag='"+FlagNO+"' where trim(account_code) not in("+accountFlagStr+")";
		String strSql2="update t_ledger_detail set flag='"+FlagYES+"' where trim(account_code) in("+accountFlagStr+")";
		accountDAO.updateSQLString(strSql);   
		accountDAO.updateSQLString(strSql2); 

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	
	}
	}
/*	获取选择营业部名称*/
	public String getUnitValueName(String unitValue)
	{
		try{
		String strSql="select unit_name from t_unit  where unit_code='"+unitValue+"'";
		
		String unitName=(String) accountDAO.querySQLStringSearch(strSql).get(0);
		return unitName;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
