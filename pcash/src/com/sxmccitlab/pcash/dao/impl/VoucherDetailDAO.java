package com.sxmccitlab.pcash.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.sxmccitlab.common.BaseHibernateDAO;
import com.sxmccitlab.common.pagehandle.PaginationVO;


import com.sxmccitlab.pcash.dao.IVoucherDetailDAO;
import com.sxmccitlab.pcash.po.VoucherDetail;
import com.sxmccitlab.pcash.po.Voucher;

/**
 * A data access object (DAO) providing persistence and search support for
 * VoucherDetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.sxmccitlab.pcash.po.VoucherDetail
 * @author MyEclipse Persistence Tools
 */

public class VoucherDetailDAO extends BaseHibernateDAO implements
		IVoucherDetailDAO {
	private static final Log log = LogFactory.getLog(VoucherDetailDAO.class);
	// property constants
	
	public static final String VOUCHER_DATE = "voucherDate";
	public static final String VOUCHER_ABSTRACT = "voucherAbstract";
	public static final String ACCOUNT_CODE = "accountCode";
	public static final String FDEBIT = "fdebit";
	public static final String FCREDIT = "fcredit";
	public static final String CHARGE_FLAG = "chargeFlag";
	public static final String ROLLBACK_FLAG = "rollbackFlag";
	public static final String ID = "id";
	public static final String PKID = "pkid";
	
	protected void initDao() {
		// do nothing
	}

	public void save(VoucherDetail e) {

		getHibernateTemplate().save(e);

	}
	
	public void delete(Long id) {

		VoucherDetail e = (VoucherDetail) getHibernateTemplate().get(
				VoucherDetail.class, id);
		getHibernateTemplate().delete(e);
	}

	public VoucherDetail findById(Long id) {

		return (VoucherDetail) getHibernateTemplate().get(VoucherDetail.class,
				id);
	}

	public List findAll() {

		return getHibernateTemplate().find("from VoucherDetail");
	}

	public void update(VoucherDetail e) {

		getHibernateTemplate().update(e);

	}

//	public List searchSum(String unitCode, String voucherDatestart,
//			String voucherDateend,	String accountCode,final int pageNow, final int pageSize) {
	
	public List sumHJ(String unitCode, String voucherDatestart,String voucherDateend, String accountCode){
		
		return super.findBySQL("select coalesce(sum(lj.d),0),coalesce(sum(lj.e),0) from (Select cast(p.voucher_date as varchar2(8)) a ,cast(q.voucher_code as varchar2(14)) b, p.voucher_abstract c,sum(p.fcredit) d,sum(p.fdebit) e from t_voucher_detail  p ,t_voucher q "
    			+"where p.voucher_code=q.voucher_code  and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') between to_date(substr('"
    			+ voucherDatestart +"',1,6),'yyyymm') and  to_date(substr('"
    			+ voucherDateend +"',1,6),'yyyymm') and p.account_code ='"
    			+ accountCode + "'group by p.voucher_date,q.voucher_code, p.voucher_abstract ) lj");
		
	}
    public List sumLJ(String unitCode, String voucherDatestart,String voucherDateend, String accountCode){
    	
    	return super.findBySQL("select coalesce(sum(lj.d),0),coalesce(sum(lj.e),0) from (Select cast(p.voucher_date as varchar2(8)) a ,cast(q.voucher_code as varchar2(14)) b, p.voucher_abstract c,sum(p.fcredit) d,sum(p.fdebit) e from t_voucher_detail  p ,t_voucher q "
    			+"where p.voucher_code=q.voucher_code  and  q.unit_Code='" 
    			+unitCode+"' and substr(p.voucher_date,1,4) = substr('"
    			+ voucherDatestart +"',1,4)  and p.account_code ='"
    			+ accountCode + "'group by p.voucher_date,q.voucher_code, p.voucher_abstract ) lj");
		
	}
	public PaginationVO searchSum(String unitCode, String voucherDatestart,String voucherDateend, String accountCode,int startIndex, int maxResult) {
		
		
		PaginationVO pv = this.findLimitedResultBySql("Select cast(p.voucher_date as varchar2(8)),cast(q.voucher_code as varchar2(14)), p.voucher_abstract,sum(p.fcredit),sum(p.fdebit) from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') between to_date(substr('"
    			+ voucherDatestart +"',1,6),'yyyymm') and to_date(substr('"
    			+ voucherDateend +"',1,6),'yyyymm') and p.account_code ='"
    			+ accountCode + "' group by p.voucher_date,q.voucher_code, p.voucher_abstract order by q.voucher_code",
						startIndex, maxResult);
		return pv;



			//List list = (List) getHibernateTemplate().execute(
			 //           new HibernateCallback() {
			  //              int size=pageNow*pageSize-pageSize;
			    //    public Object doInHibernate(Session session)
			     //           throws HibernateException {
			      //      Query q =session.createQuery(" Select p.voucherDate,q.voucherCode, p.voucherAbstract,sum(p.fcredit),sum(p.fdebit) from VoucherDetail as p  join  p.vouchers as q "
			       // 					+ " group by p.voucherDate,q.voucherCode, p.voucherAbstract");
			      //       q.setFirstResult(size);
			       //      q.setMaxResults(pageSize);
			       //      List cats = q.list();
			       //     return cats;
			      //  }
			   // });//内部类，返回一个List
			   //  return list;
			   // 
		} 

	public List searchExport(String unitCode, String voucherDatestart,String voucherDateend, String accountCode) {
		
		
		List pv= super.findBySQL("Select cast(p.voucher_date as varchar2(8)),cast(q.voucher_code as varchar2(14)), p.voucher_abstract,sum(p.fcredit),sum(p.fdebit) from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') between to_date(substr('"
    			+ voucherDatestart +"',1,6),'yyyymm') and to_date(substr('"
    			+ voucherDateend +"',1,6),'yyyymm') and p.account_code ='"
    			+ accountCode + "' group by p.voucher_date,q.voucher_code, p.voucher_abstract order by q.voucher_code");
		return pv;



			//List list = (List) getHibernateTemplate().execute(
			 //           new HibernateCallback() {
			  //              int size=pageNow*pageSize-pageSize;
			    //    public Object doInHibernate(Session session)
			     //           throws HibernateException {
			      //      Query q =session.createQuery(" Select p.voucherDate,q.voucherCode, p.voucherAbstract,sum(p.fcredit),sum(p.fdebit) from VoucherDetail as p  join  p.vouchers as q "
			       // 					+ " group by p.voucherDate,q.voucherCode, p.voucherAbstract");
			      //       q.setFirstResult(size);
			       //      q.setMaxResults(pageSize);
			       //      List cats = q.list();
			       //     return cats;
			      //  }
			   // });//内部类，返回一个List
			   //  return list;
			   // 
		} 
public List sumDailyLedgerHJ(String unitCode, String voucherDatestart, String accountCode){
		
		return super.findBySQL("select  coalesce(sum(lj.d),0),coalesce(sum(lj.e),0) from (Select cast(p.voucher_date as varchar2(8)) a ,cast(q.voucher_code as varchar2(14)) b, p.voucher_abstract c,sum(p.fcredit) d,sum(p.fdebit) e from t_voucher_detail  p ,t_voucher q "
    			+"where p.voucher_code=q.voucher_code  and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd')= to_date(substr('"
    			+ voucherDatestart +"',1,6),'yyyymm') "
    			+" and p.account_code ='"
    			+ accountCode + "' group by p.voucher_date,q.voucher_code, p.voucher_abstract ) lj");
		
	}
    public List sumDailyLedgerLJ(String unitCode, String voucherDatestart, String accountCode){
    	
    	return super.findBySQL("select  coalesce(sum(lj.d),0),coalesce(sum(lj.e),0) from (Select cast(p.voucher_date as varchar2(8)) a ,cast(q.voucher_code as varchar2(14)) b, p.voucher_abstract c,sum(p.fcredit) d,sum(p.fdebit) e from t_voucher_detail  p ,t_voucher q "
    			+"where p.voucher_code=q.voucher_code  and  q.unit_Code='" 
    			+unitCode+"' and substr(p.voucher_date,1,4) = substr('"
    			+ voucherDatestart +"',1,4)  and p.account_code ='"
    			+ accountCode + "' group by p.voucher_date,q.voucher_code, p.voucher_abstract ) lj");
		
	}
	public PaginationVO searchDailyLedgerSum(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult) {
		
		
		PaginationVO pv = this.findLimitedResultBySql("Select cast(p.voucher_date as varchar2(8)),cast(q.voucher_code as varchar2(14)), p.voucher_abstract,sum(p.fcredit),sum(p.fdebit) from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') = to_date('"
    			+ voucherDatestart +"','yyyymmdd') "
    			+" and p.account_code ='"
    			+ accountCode + "' group by p.voucher_date,q.voucher_code, p.voucher_abstract order by q.voucher_code",
						startIndex, maxResult);
		return pv;



		} 
	
	public List searchDailyLedgerExport(String unitCode, String voucherDatestart, String accountCode) {
		
		
		List dl = super.findBySQL("Select cast(p.voucher_date as varchar2(8)),cast(q.voucher_code as varchar2(14)), p.voucher_abstract,sum(p.fcredit),sum(p.fdebit) from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') = to_date('"
    			+ voucherDatestart +"','yyyymmdd') "
    			+" and p.account_code ='"
    			+ accountCode + "' group by p.voucher_date,q.voucher_code, p.voucher_abstract order by q.voucher_code");
		return dl;



		} 

public List sumGeneralLedgerHJ(String unitCode, String voucherDatestart, String accountCode){
		
		return super.findBySQL("select  coalesce(sum(lj.d),0),coalesce(sum(lj.e),0) from (Select cast(substr(p.voucher_date,1,6) as varchar2(6)),sum(p.fcredit) d ,sum(p.fdebit) e from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') = to_date( to_char(extract(year from sysdate))||case when  extract(month from sysdate)< 10 then '0'||to_char(extract(month from sysdate)) else  to_char(extract(month from sysdate)) end ,'yyyymm') "
    			+" and p.account_code ='"
    			+ accountCode + "' group by cast(substr(p.voucher_date,1,6) as varchar2(6)) ) lj");
		
	}
    public List sumGeneralLedgerLJ(String unitCode, String voucherDatestart, String accountCode){
    	
    	return super.findBySQL("select  coalesce(sum(lj.d),0),coalesce(sum(lj.e),0) from (Select cast(substr(p.voucher_date,1,4) as varchar2(4)),sum(p.fcredit) d ,sum(p.fdebit) e from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and substr(p.voucher_date,1,4) = '"
    			+ voucherDatestart +"' "
    			+" and p.account_code ='"
    			+ accountCode + "' group by cast(substr(p.voucher_date,1,4) as varchar2(4)) ) lj");
		
	}
	public PaginationVO searchGeneralLedgerSum(String unitCode, String voucherDatestart, String accountCode,int startIndex, int maxResult) {
		
		
		PaginationVO pv = this.findLimitedResultBySql("Select cast(substr(p.voucher_date,1,6) as varchar2(6)),sum(p.fcredit),sum(p.fdebit) from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') = to_date('"
    			+ voucherDatestart +"','yyyy') "
    			+" and p.account_code ='"
    			+ accountCode + "' group by cast(substr(p.voucher_date,1,6) as varchar2(6)) ",
						startIndex, maxResult);
		return pv;



			//List list = (List) getHibernateTemplate().execute(
			 //           new HibernateCallback() {
			  //              int size=pageNow*pageSize-pageSize;
			    //    public Object doInHibernate(Session session)
			     //           throws HibernateException {
			      //      Query q =session.createQuery(" Select p.voucherDate,q.voucherCode, p.voucherAbstract,sum(p.fcredit),sum(p.fdebit) from VoucherDetail as p  join  p.vouchers as q "
			       // 					+ " group by p.voucherDate,q.voucherCode, p.voucherAbstract");
			      //       q.setFirstResult(size);
			       //      q.setMaxResults(pageSize);
			       //      List cats = q.list();
			       //     return cats;
			      //  }
			   // });//内部类，返回一个List
			   //  return list;
			   // 
		} 
	
public List searchGeneralLedgerExport(String unitCode, String voucherDatestart, String accountCode) {
		
		
		List gl =super.findBySQL("Select cast(substr(p.voucher_date,1,6) as varchar2(6)),sum(p.fcredit),sum(p.fdebit) from t_voucher_detail  p ,t_voucher q "
				   +" where p.voucher_code=q.voucher_code and  q.unit_code='" 
    			+unitCode+"' and to_date(p.voucher_date,'yyyymmdd') = to_date('"
    			+ voucherDatestart +"','yyyy') "
    			+" and p.account_code ='"
    			+ accountCode + "' group by cast(substr(p.voucher_date,1,6) as varchar2(6)) ");
		return gl;

		} 

}