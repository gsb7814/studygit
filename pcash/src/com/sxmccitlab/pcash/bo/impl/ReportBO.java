package com.sxmccitlab.pcash.bo.impl;

import java.util.List;

import com.sxmccitlab.pcash.bo.IReportBO;
import com.sxmccitlab.pcash.dao.impl.ReportDAO;
import com.sxmccitlab.pcash.dao.impl.UnitDAO;


public class ReportBO  implements IReportBO {

	ReportDAO reportDAO;
	UnitDAO unitDAO;
	public ReportDAO getReportDAO() {
		return reportDAO;
	}

	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}
	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}
	public List<Object[]> findByBranchmonth(String date, String accountType) {
		
		List<Object[]> list = reportDAO.findByBranchmonth(date, accountType);

		return list;
	}

	

	public List<Object[]> findByBranchyear(String date, String accountType) {

		

		List<Object[]> list = reportDAO.findByBranchyear(date, accountType);

		return list;
	}
	
	public List<Object[]> findBySales_Departmentmonth(String date,
			String accountType, List unitCode) {
		List<Object[]> list = reportDAO.findBySales_Departmentmonth(date, accountType, unitCode);
		return list;
	}

	public List<Object[]> findBySales_Departmentyear(String date, String accountType,
			List unitCode) {
		
		List<Object[]> list = reportDAO.findBySales_Departmentyear(date, accountType, unitCode);
		return list;
	}
	
	public List<Object> findSales_Department(String region_code)
	{
		List<Object> list = reportDAO.findSales_Department(region_code);

		return list;
	}
	
	public String findbranchname(String region_code)
	{
		String region_name =reportDAO.findbranchname(region_code);
		return region_name;
	}
	public List<Object> findSales_Department_code(String region_code)
	{
		List<Object> unit_code =reportDAO.findSales_Department_code(region_code);
		return unit_code;
	}


}
