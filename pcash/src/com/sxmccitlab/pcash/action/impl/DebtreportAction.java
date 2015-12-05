package com.sxmccitlab.pcash.action.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.sxmccitlab.pcash.action.IReportAction;
import com.sxmccitlab.pcash.bo.IReportBO;
import com.sxmccitlab.pcash.bo.impl.ReportBO;

public class DebtreportAction implements IReportAction {

	IReportBO reportBO;

	

	public IReportBO getReportBO() {
		return reportBO;
	}

	public void setReportBO(IReportBO reportBO) {
		this.reportBO = reportBO;
	}

	String year; // 分公司查询界面返回的年份
	String month; // 分公司查询界面返回的月份
	String regioncode; // 分公司查询界面请求中的分公司代码
	String year_sales; // 营业部查询界面返回的年份
	String month_sales; // 营业部查询界面返回的月份
	String branch_code; // 营业部界面查询界面返回的分公司代码

	public String getYear_sales() {
		return year_sales;
	}

	public void setYear_sales(String yearSales) {
		year_sales = yearSales;
	}

	public String getMonth_sales() {
		return month_sales;
	}

	public void setMonth_sales(String monthSales) {
		month_sales = monthSales;
	}

	public String getRegioncode() {
		return regioncode;
	}

	public void setRegioncode(String regioncode) {
		this.regioncode = regioncode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	// findbyBranch()分公司查询
	public String findbyBranch() {
		List<Object[]> list = null;
		String accountType = "05";
		if (year != null && month != null && accountType != null) {

			list = reportBO.findByBranchmonth(year + month, accountType);
			ActionContext.getContext().put("monthbranch_debt", list);
			System.out.println("branchlistsize:"+list.size());
			return "success";
		} else {
			return "success";
		}
	}

	// findSales_Department()从分公司跳转到对应的营业部
	public String findSales_Department() {
		List<Object> list_sales = null;
		List<Object> list_salecode = null;
		if (regioncode != null) {
			String region_name = reportBO.findbranchname(regioncode);
			ActionContext.getContext().getSession().put("branch_name_debt",
					region_name);
			list_sales = reportBO.findSales_Department(regioncode);
			ActionContext.getContext().getSession().put("Sales_Department_debt",
					list_sales);
			list_salecode = reportBO.findSales_Department_code(regioncode);
			ActionContext.getContext().getSession().put(
					"Sales_Department_code_debt", list_salecode);
			return "success";
		} else {
			return "fail";
		}

	}

	// findBySales_Department()营业部查询
	public String findBySales_Department() {
		List<Object[]> list = null;
		List<Object> list_sales = null;
		String accountType = "05";
		if (year_sales != null && month_sales != null && accountType != null) {

			list_sales = (List<Object>) ActionContext.getContext().getSession()
					.get("Sales_Department_code_debt");
			list = reportBO.findBySales_Departmentmonth(year_sales
					+ month_sales, accountType, list_sales);
			ActionContext.getContext().put("monthsales_debt", list);
			return "success";
		} else {
			return "success";
		}
	}

	public String Export_Sales_Department() {
		List<Object[]> list = null;
		List<Object> list_sales = null;
		String accountType = "05";
		list_sales = (List<Object>) ActionContext.getContext().getSession()
				.get("Sales_Department_code_debt");
		list = reportBO.findBySales_Departmentmonth(year_sales + month_sales,
				accountType, list_sales);
		ActionContext.getContext().put("monthsales_debt", list);		
		return "export";
	}

	public String Export_Branch() {
		List<Object[]> list = null;
		String accountType = "05";
		list = reportBO.findByBranchmonth(year + month, accountType);
		ActionContext.getContext().put("monthbranch_debt", list);	
		return "export";
	}

}
