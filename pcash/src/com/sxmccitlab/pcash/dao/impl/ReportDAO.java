package com.sxmccitlab.pcash.dao.impl;

import java.util.List;

import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;
import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.pcash.dao.IReportDAO;

public class ReportDAO extends BaseHibernateDAO implements IReportDAO {

	public List<Object[]> findByBranchmonth(String date, String accountType) {
		List<Object[]> list = null;
		String sql = null;
		sql = "SELECT account_code,account_name,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '01' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '02' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '03' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '04' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '05' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '06' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '07' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '08' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '09' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '10' THEN "
				+ "total ELSE 0 END)  ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '11' THEN "
				+ "total ELSE 0 END) "
				+ "FROM  (SELECT a.account_code,c.account_name,b.unit_code,fdebit-fcredit as total "
				+ "FROM t_voucher_detail a ,t_voucher b,t_account c "
				+ "WHERE a.voucher_code = b.voucher_code and a.account_code = c.account_code "
				+ "and c.account_type_code = '" + accountType
				+ "' and substr(a.voucher_date,1,6) = '" + date
				+ "') group by account_code,account_name ORDER BY account_code";

		try {
			list = findBySQL(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	
	

	public List<Object[]> findByBranchyear(String date, String accountType) {

		List<Object[]> list = null;
		String sql = null;	
		sql = "SELECT account_code,account_name,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '01' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '02' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '03' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '04' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '05' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '06' THEN "
				+ "total ELSE 0 END),"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '07' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '08' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '09' THEN "
				+ "total ELSE 0 END) ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '10' THEN "
				+ "total ELSE 0 END)  ,"
				+ "SUM( CASE WHEN substr(unit_code,1,2) = '11' THEN "
				+ "total ELSE 0 END) "
				+ "FROM  (SELECT a.account_code,c.account_name,b.unit_code,fdebit-fcredit as total "
				+ "FROM t_voucher_detail a ,t_voucher b,t_account c "
				+ "WHERE a.voucher_code = b.voucher_code and a.account_code = c.account_code "
				+ "and c.account_type_code = '" + accountType
				+ "' and substr(a.voucher_date,1,4) = '" + date
				+ "') group by account_code,account_name ORDER BY account_code";

		try {
			list = findBySQL(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	public List<Object[]> findBySales_Departmentmonth(String date,
			String accountType, List unitCode) {
		List<Object[]> list = null;
		String sql = "";
		String sql1 = "";
		int i =0;		
		if (unitCode != null && unitCode.size() > 0 ) {
			for (i =0 ; i<unitCode.size()-1;i++)
			{
				sql1 =sql1+"SUM( CASE WHEN unit_code = '"+(String)unitCode.get(i)+"' THEN "
				+ "total ELSE 0 END),";			
			}
			sql1 =sql1+"SUM( CASE WHEN unit_code = '"+(String)unitCode.get(i)+"' THEN "
			+ "total ELSE 0 END) ";
		}
		
		sql = "SELECT account_code,account_name,"+sql1
				+ "FROM  (SELECT a.account_code,c.account_name,b.unit_code,fdebit-fcredit as total "
				+ "FROM t_voucher_detail a ,t_voucher b,t_account c "
				+ "WHERE a.voucher_code = b.voucher_code and a.account_code = c.account_code "
				+ "and c.account_type_code = '" + accountType
				+ "' and substr(a.voucher_date,1,6) = '" + date
				+ "') group by account_code,account_name ORDER BY account_code";

		try {
			list = findBySQL(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}
	
	public List<Object[]> findBySales_Departmentyear(String date,
			String accountType, List unitCode) {
		List<Object[]> list = null;
		String sql = null;
		String sql1 = "";
		int i =0;
		if (unitCode != null && unitCode.size() > 0 ) {
			for (i =0 ; i<unitCode.size()-1;i++)
			{
				sql1 =sql1+"SUM( CASE WHEN unit_code = '"+(String)unitCode.get(i)+"' THEN "
				+ "total ELSE 0 END),";
			}
			sql1 =sql1+"SUM( CASE WHEN unit_code = '"+(String)unitCode.get(i)+"' THEN "
			+ "total ELSE 0 END) ";
		}
		
		sql = "SELECT account_code,account_name,"+sql1
				+ "FROM  (SELECT a.account_code,c.account_name,b.unit_code,fdebit-fcredit as total "
				+ "FROM t_voucher_detail a ,t_voucher b,t_account c "
				+ "WHERE a.voucher_code = b.voucher_code and a.account_code = c.account_code "
				+ "and c.account_type_code = '" + accountType
				+ "' and substr(a.voucher_date,1,4) = '" + date
				+ "') group by account_code,account_name ORDER BY account_code";

		try {
			list = findBySQL(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}
	
	public List<Object> findSales_Department(String region_code)
	{
		String sql = null;
		sql = "select unit_name from t_unit where substr(unit_code,1,2) = '"+region_code+"' order by unit_code";
		List<Object> list =null;
		
		try {
			list = findBySQL(sql);			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}
	
	public List<Object> findSales_Department_code(String region_code)
	{
		String hql = null;
		hql = "select unitCode from Unit where substr(unitCode,1,2) = '"+region_code+"' order by unitCode";
		List<Object> list =null;
		
		try {
			list = findByHql(hql);			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}
	
	public String findbranchname(String region_code)
	{
		String sql = null;
		sql = "select region_name from s_region where region_code = '"+region_code+"'";
		String  regionname =null;
		List list = null;
		
		try {
			list = findBySQL(sql);
			regionname = (String)list.get(0);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return regionname;
	}
}
