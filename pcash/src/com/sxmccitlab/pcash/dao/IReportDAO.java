package com.sxmccitlab.pcash.dao;

import java.util.List;

public interface IReportDAO {
	public List<Object[]> findByBranchmonth (String date, String account_type);
	public List<Object[]> findByBranchyear (String date, String account_type);
	public List<Object> findSales_Department(String region_code);
	public List<Object[]> findBySales_Departmentmonth(String date, String account_type,List unit_code);
	public List<Object[]> findBySales_Departmentyear(String date, String account_type,List unit_code);
	public String findbranchname(String region_code);
	public List<Object> findSales_Department_code(String region_code);

}
