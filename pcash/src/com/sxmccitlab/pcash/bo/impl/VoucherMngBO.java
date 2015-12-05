package com.sxmccitlab.pcash.bo.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.pcash.action.bean.VoucherBean;
import com.sxmccitlab.pcash.action.bean.VoucherMngBean;
import com.sxmccitlab.pcash.bo.IVoucherMngBO;
import com.sxmccitlab.pcash.dao.IAccountDAO;
import com.sxmccitlab.pcash.dao.IAccountTypeDAO;
import com.sxmccitlab.pcash.dao.IAccountingPeriodDAO;
import com.sxmccitlab.pcash.dao.ISerialDAO;
import com.sxmccitlab.pcash.dao.IToolDAO;
import com.sxmccitlab.pcash.dao.IVoucherDAO;
import com.sxmccitlab.pcash.dao.IVoucherDetailDAO;
import com.sxmccitlab.pcash.dao.IVoucherTypeDAO;
import com.sxmccitlab.pcash.po.Serial;
import com.sxmccitlab.pcash.po.Voucher;
import com.sxmccitlab.pcash.po.VoucherDetail;
import com.sxmccitlab.pcash.po.VoucherDetailId;

public class VoucherMngBO implements IVoucherMngBO {
	IVoucherDAO voucherDAO;

	IVoucherDetailDAO voucherDetailDAO;

	ISerialDAO serialDAO;

	IVoucherTypeDAO voucherTypeDAO;

	IAccountTypeDAO accountTypeDAO;

	IAccountDAO accountDAO;

	IToolDAO toolDAO;
	
	IAccountingPeriodDAO accountingPeriodDAO ;



	public void setAccountingPeriodDAO(IAccountingPeriodDAO accountingPeriodDAO) {
		this.accountingPeriodDAO = accountingPeriodDAO;
	}

	public IVoucherDetailDAO getVoucherDetailDAO() {
		return voucherDetailDAO;
	}

	public void setVoucherDetailDAO(IVoucherDetailDAO voucherDetailDAO) {
		this.voucherDetailDAO = voucherDetailDAO;
	}

	public IVoucherTypeDAO getVoucherTypeDAO() {
		return voucherTypeDAO;
	}

	public void setVoucherTypeDAO(IVoucherTypeDAO voucherTypeDAO) {
		this.voucherTypeDAO = voucherTypeDAO;
	}

	public IAccountTypeDAO getAccountTypeDAO() {
		return accountTypeDAO;
	}

	public void setAccountTypeDAO(IAccountTypeDAO accountTypeDAO) {
		this.accountTypeDAO = accountTypeDAO;
	}

	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public IVoucherDAO getVoucherDAO() {
		return voucherDAO;
	}

	public ISerialDAO getSerialDAO() {
		return serialDAO;
	}

	public IToolDAO getToolDAO() {
		return toolDAO;
	}

	
	public void setToolDAO(IToolDAO toolDAO) {
		this.toolDAO = toolDAO;
	}

	
	public void setVoucherDAO(IVoucherDAO voucherDAO) {
		this.voucherDAO = voucherDAO;
	}

	
	public void setSerialDAO(ISerialDAO serialDAO) {
		this.serialDAO = serialDAO;
	}


	//查询凭证类型和会计科目下拉列表数据
	public VoucherMngBean getInfo(VoucherMngBean voucherMngBean) {

		voucherMngBean=this.getAccountingPeriodInfo(voucherMngBean);
		//查询凭证类型列表
		voucherMngBean.setVoucherType(voucherTypeDAO.findAll());
		//查询会计科目列表
		voucherMngBean.setAccount(accountDAO.findAll());
		voucherMngBean.setUnitList(this.getUnitInfo(voucherMngBean));
		return voucherMngBean;
	}

	//添加凭证数据和凭证明细数据
	public void addVoucherInfo(VoucherMngBean voucherMngBean) {
		System.out.println(voucherMngBean.getVoucherCode()+"rrrrrrrrrrrrr");
		//添加凭证基本信息并且获取凭证号
		voucherMngBean=this.addVoucher(voucherMngBean);
		//voucherMngBean.setVoucherCode("01012010040004");
		System.out.println(voucherMngBean.getVoucherCode()+"uuuuuuuuuuuuuuuuu");
		this.addVoucherDetail(voucherMngBean);
	}
	
	//构造当前凭证号
	private String getVoucherCode(VoucherMngBean voucherMngBean){
		String voucherCode="";
		String unitCode=voucherMngBean.getUnitCode();
		
		String voucherDate=voucherMngBean.getVoucherDate();
		System.out.println(voucherDate+"oooh");
		Serial serial = serialDAO.findById(unitCode);
		System.out.println(serial.getSerialNo()+"oooh");
		serial.setSerialNo(serial.getSerialNo()+1);
		serialDAO.attachDirty(serial);
		String serialNo=serial.getSerialNo().toString();
		voucherCode=unitCode;
		System.out.println(voucherCode+"ddhh");
		voucherCode=voucherCode+voucherDate.substring(0, 4)+voucherDate.substring(5,7);
		System.out.println(voucherDate.substring(0, 4)+"sssssss");
		System.out.println(voucherDate.substring(5,7)+"vvvvvv");
		System.out.println(voucherCode+"vvvvvv");
		for(int i=0;i<4-serialNo.length();i++){
			voucherCode=voucherCode+'0';
		}
		voucherCode=voucherCode+serialNo;
		return voucherCode;
	}
	
	//添加凭证基本信息
	private VoucherMngBean addVoucher(VoucherMngBean voucherMngBean){
		Voucher voucher = new Voucher();
		String voucherCode =this.getVoucherCode(voucherMngBean);
		System.out.println(voucherCode+"hhhhh");
		voucherMngBean.setVoucherCode(voucherCode);
		voucher.setVoucherCode(voucherCode);
		voucher.setVoucherTypeCode(voucherMngBean.getVoucherTypeCode());
		voucher.setCreditSum(voucherMngBean.getCreditSum());
		voucher.setDebitSum(voucherMngBean.getDebitSum());
		voucher.setStaffCode(voucherMngBean.getStaffCode());
		voucher.setUnitCode(voucherMngBean.getUnitCode());
		System.out.println(voucherMngBean.getVoucherDate());
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		try {
			date = sdf.parse(voucherMngBean.getVoucherDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		voucher.setVoucherTime(date);

		voucher.setOpTime(new Date());
//		String strSql = "insert into t_voucher (voucher_type_code,debit_sum,credit_sum,staff_code,unit_code,voucher_code,op_time,id) "
//				+ "values('5',200,200,'0010','1101','20100202-0558',null,null)";

		//toolDAO.updateSQLString(strSql);

		voucherDAO.save(voucher);

		return voucherMngBean;
		
	}
	
	//添加凭证明细信息
	private void addVoucherDetail(VoucherMngBean voucherMngBean){
		int size = voucherMngBean.getVoucherAbstract().size();
		System.out.println(size+"uuuuuuuu");
		String voucherCode =voucherMngBean.getVoucherCode();		
		
		List list = new ArrayList();
		if(size!=1){   
             for(int i=1;i<size;i++){   
            	 VoucherDetail voucherDetail = new VoucherDetail();
            	 System.out.println("ccc"+voucherMngBean.getVoucherAbstract().get(i));
            	 VoucherDetailId voucherDetailId=new VoucherDetailId();
            	 voucherDetailId.setVoucherCode(voucherCode);
            	 System.out.println(voucherCode+"gggggggggggggg");
            	// System.out.println(voucherDetailId.getVoucherCode()+"kkkkkkkkk");
            	 voucherDetailId.setVoucherDetailCode(""+i);
            	 voucherDetail.setId(voucherDetailId);
            	 voucherDetail.setVoucherAbstract((String)voucherMngBean.getVoucherAbstract().get(i));
            	 voucherDetail.setFcredit(Double.parseDouble(voucherMngBean.getFcredit().get(i).toString()));
            	 voucherDetail.setFdebit(Double.parseDouble(voucherMngBean.getFdebit().get(i).toString()));
            	 voucherDetail.setCurrencyDetail((String)voucherMngBean.getCurrencyDetail().get(i));
            	 voucherDetail.setAccountCode((String)voucherMngBean.getAccountCode().get(i));
            	 voucherDetail.setChargeFlag("00");
            	 voucherDetail.setRollbackFlag("00");
            	 voucherDetail.setChargeTime(new Date());
            	 System.out.println(voucherDetailId.getVoucherCode()+"kkkkkkkkk");
            	 System.out.println(voucherDetail.getId().getVoucherCode()+"aaaaaaaaaa");
            	 System.out.println(voucherDetail.getId().getVoucherDetailCode()+"bbbbbbbbbbb");
            	 System.out.println(voucherDetail.getId()+"cccccccc");
            	 System.out.println(voucherDetail.getVoucherAbstract()+"ddddddddddd");
            	 System.out.println(voucherDetail.getFcredit()+"eeeeeeeeeeee");
            	 System.out.println(voucherDetail.getFdebit()+"ffffffffffff");
            	 System.out.println(voucherDetail.getCurrencyDetail()+"gggggggggg");
            	 System.out.println(voucherDetail.getAccountCode()+"hhhhhhhhhhhh");
            	 voucherDetailDAO.save(voucherDetail);	            	 	            	 
             }
		}    
		
	}
	
	//修改凭证信息
	public void updateVoucherInfo(VoucherMngBean voucherMngBean){
		this.updateVoucher(voucherMngBean);
		this.deleteVoucherDetail(voucherMngBean);
		this.addVoucherDetail(voucherMngBean);
	}
	
	//修改凭证基本信息
	private void updateVoucher(VoucherMngBean voucherMngBean){
		String voucherCode = voucherMngBean.getVoucherCode();
		Voucher voucher=voucherDAO.findById(voucherCode);
		voucher.setCreditSum(voucherMngBean.getCreditSum());
		voucher.setDebitSum(voucherMngBean.getDebitSum());
		voucher.setModifyTime(new Date());
		voucherDAO.attachDirty(voucher);
	}
	//删除凭证详细信息
	private void deleteVoucherDetail(VoucherMngBean voucherMngBean){
		String voucherCode = voucherMngBean.getVoucherCode();
//		List list = voucherMngBean.getVoucherCodeList();
//		int size = list.size();
//		String voucherCodeStr = "";
//		if (size != 0) {
//			for (int i = 0; i < size; i++) {
//				if (i == 0) {
//					voucherCodeStr = "'" + (String) list.get(i) + "'";
//				} else {
//					voucherCodeStr = voucherCodeStr + ",'"
//							+ (String) list.get(i) + "'";
//				}
//			}
//		}
		String strSql = "delete from t_voucher_detail  where trim(voucher_code)='"
				+ voucherCode + "'";

		System.out.println(strSql);
		toolDAO.updateSQLString(strSql);
	}
	

	//分页查询凭证数据
	public PaginationSupport queryVoucher(VoucherMngBean voucherMngBean) {
//		List list = new ArrayList();
//		String sqlStr = "select distinct a.debit_sum,a.credit_sum ,c.staff_name,d.unit_name,"
//				+ "e.voucher_type_name,a.voucher_code,b.charge_flag "
//				+ "from t_voucher a,t_voucher_detail b ,t_staff c,t_unit d,s_voucher_type e "
//				+ "where a.voucher_code=b.voucher_code and a.staff_code=c.staff_code   "
//				+ "and a.unit_code=d.unit_code and a.voucher_type_code=e.voucher_type_code  ";
//
//		if (!"0".equals(voucherMngBean.getVoucherTypeCode())
//				&& voucherMngBean.getVoucherTypeCode() != null) {
//			sqlStr = sqlStr + " and a.voucher_type_code='"
//					+ voucherMngBean.getVoucherTypeCode() + "'";
//		}
//		if (!"0".equals(voucherMngBean.getChargeFlag())
//				&& voucherMngBean.getChargeFlag() != null) {
//			sqlStr = sqlStr + " and b.charge_flag in('"
//					+ voucherMngBean.getChargeFlag() + "')";
//		}
//		System.out.println(sqlStr);
//		PaginationSupport paginationSupport = toolDAO.findPageBySql(sqlStr,
//				sqlStr, (voucherMngBean.getPage() - 1)
//						* voucherMngBean.getPageSize(), voucherMngBean
//						.getPageSize());
		
		
		int unitCodeLength = voucherMngBean.getUnitCode().length();
		String strHql="select distinct  new com.sxmccitlab.pcash.action.bean.VoucherBean(c.staffName, d.unitName,"
			+ "e.voucherTypeName, a.debitSum, a.creditSum,a.voucherCode, b.chargeFlag) "
			+ "from Voucher a,VoucherDetail b ,Staff c,Unit d,VoucherType e "
			+ "where a.voucherCode=b.id.voucherCode and a.staffCode=c.staffCode   "
			+ "and a.unitCode=d.unitCode and a.voucherTypeCode=e.voucherTypeCode";
		
		if (!"0".equals(voucherMngBean.getVoucherTypeCode())
				&& voucherMngBean.getVoucherTypeCode() != null) {
			strHql = strHql + " and a.voucherTypeCode='"
					+ voucherMngBean.getVoucherTypeCode() + "'";
		}
		if (!"0".equals(voucherMngBean.getChargeFlag())
				&& voucherMngBean.getChargeFlag() != null) {
			strHql = strHql + " and b.chargeFlag in('"
					+ voucherMngBean.getChargeFlag() + "')";
		}	
		if (!"0".equals(voucherMngBean.getUnitCode())
				&& voucherMngBean.getUnitCode() != null) {
			strHql = strHql + " and substr(a.unitCode,0,"+unitCodeLength+") ='"
					+ voucherMngBean.getUnitCode() + "'";
		}	
		if (!"0".equals(voucherMngBean.getAccountingPeriod())
				&& voucherMngBean.getAccountingPeriod() != null) {
			strHql = strHql + " and to_char(a.voucherTime,'yyyymm') ='"
					+ voucherMngBean.getAccountingPeriod() + "'";
		}	
		if (!"".equals(voucherMngBean.getFromDate())
				&& voucherMngBean.getFromDate() != null&&!"".equals(voucherMngBean.getFromDate())
				&& voucherMngBean.getFromDate() != null) {
			strHql = strHql + " and to_char(a.voucherTime,'yyyy-mm-d') >='"
					+ voucherMngBean.getFromDate() + "'"+ " and to_char(a.voucherTime,'yyyy-mm-d') <='"
					+ voucherMngBean.getToDate() + "'";
		}
		System.out.println(strHql);
		PaginationSupport paginationSupport = toolDAO.findPageByHql(strHql, (voucherMngBean.getPage() - 1)
				* voucherMngBean.getPageSize(), voucherMngBean
				.getPageSize());
		
//		List listResult = paginationSupport.getItems();
//		if (listResult != null) {
//			Iterator it = listResult.iterator();
//			while (it.hasNext()) {
//				Object[] objs = (Object[]) it.next();
//				VoucherBean voucherBean = new VoucherBean();
//				System.out.println(objs[2].getClass());
//				System.out.println(objs[5].getClass());
//				voucherBean.setDebitSum(Double.parseDouble(objs[0].toString()));
//				voucherBean
//						.setCreditSum(Double.parseDouble(objs[1].toString()));
//				voucherBean.setStaffName(objs[2].toString());
//				voucherBean.setUnitName(objs[3].toString());
//				voucherBean.setVoucherTypeName(objs[4].toString());
//				System.out.println(objs[5] + "xxdxxff");
//				voucherBean.setVoucherCode(objs[5].toString());
//				System.out.println(objs[5].toString() + "xxdxxff");
//				// voucherBean.setChargeFlag(objs[6].toString());
//				// System.out.println(objs[6].toString()+"ddxdff");
//				list.add(voucherBean);
//
//			}
//		}
//		System.out.println(list.size() + "ww");
//		paginationSupport.setItems(list);
		return paginationSupport;
	}

	//通过凭证编号查看凭证信息包括凭证数据和凭证明细数据
	public VoucherMngBean queryVoucherInfo(String voucherCode) {
		VoucherMngBean voucherMngBean = new VoucherMngBean();
		voucherMngBean.setVoucherBean(this.queryVoucherById(voucherCode));
		voucherMngBean.setVoucherDetailBeanList(this.queryVoucherDetailById(voucherCode));
		return voucherMngBean;
	}

	//通过凭证编码查询凭证数据
	private VoucherBean queryVoucherById(String voucherCode) {

		String strHql = "select distinct  new com.sxmccitlab.pcash.action.bean.VoucherBean(a.voucherTime,a.voucherTypeCode,c.staffName, d.unitName,"
				+ "e.voucherTypeName, a.debitSum, a.creditSum,a.voucherCode, b.chargeFlag) "
				+ "from Voucher a,VoucherDetail b ,Staff c,Unit d,VoucherType e "
				+ "where a.voucherCode=b.id.voucherCode and a.staffCode=c.staffCode   "
				+ "and a.unitCode=d.unitCode and a.voucherTypeCode=e.voucherTypeCode  and trim(b.id.voucherCode)='"
				+ voucherCode + "'";
		System.out.println(strHql);
		List list=toolDAO.queryHqlStringSearch(strHql);
		
		System.out.println(((VoucherBean)list.get(0)).getVoucherCode()+"ggg");
		
		return (VoucherBean)list.get(0);
		
	}
	
	//通过凭证编码查询凭证明细数据
	private List queryVoucherDetailById(String voucherCode){
		String strHql = "select new com.sxmccitlab.pcash.action.bean.VoucherDetailBean(a.accountCode,a.voucherAbstract, b.accountName,a.fdebit, a.fcredit,a.currencyDetail) " +
				"from VoucherDetail a,Account b " +
				"where a.accountCode=b.accountCode and  trim(a.id.voucherCode)='"
			+ voucherCode + "'";
	System.out.println(strHql);
	return toolDAO.queryHqlStringSearch(strHql);
	}

	//修改凭证明细信息中的凭证状态，凭证记账和凭证反记账调用。
	public int updateVoucherDetail(VoucherMngBean voucherMngBean) {
		List list = voucherMngBean.getVoucherCodeList();
		int size = list.size();
		String voucherCodeStr = "";
		String chargeFlag = voucherMngBean.getChargeFlag();
		if (size != 0) {
			for (int i = 0; i < size; i++) {
				if (i == 0) {
					voucherCodeStr = "'" + (String) list.get(i) + "'";
				} else {
					voucherCodeStr = voucherCodeStr + ",'"
							+ (String) list.get(i) + "'";
				}
			}
		}
		String strSql = "update t_voucher_detail set charge_flag='"
				+ chargeFlag + "' where trim(voucher_code) in("
				+ voucherCodeStr + ")";

		System.out.println(strSql);
		return toolDAO.updateSQLString(strSql);

	}
	
	
	public VoucherMngBean getSearchInfo(VoucherMngBean voucherMngBean){
		voucherMngBean=this.getAccountingPeriodInfo(voucherMngBean);
		voucherMngBean.setUnitList(this.getUnitInfo(voucherMngBean));
		return voucherMngBean;
	}
	
	//获取当前期间信息
	private VoucherMngBean getAccountingPeriodInfo(VoucherMngBean voucherMngBean){
		System.out.println(accountingPeriodDAO);
		System.out.println(voucherMngBean.getUnitCode());
		String accountingPeriod =accountingPeriodDAO.findById(voucherMngBean.getUnitCode()).getAccountingPeriod();
		String accountingPeriodName=accountingPeriod.substring(0, 4)+"年"+accountingPeriod.substring(4, 6)+"月";
		voucherMngBean.setAccountingPeriod(accountingPeriod);
		voucherMngBean.setAccountingPeriodName(accountingPeriodName);
		return voucherMngBean;
	}
	
	//获取当前登录用户所在部门已经其下属部门的部门信息
	private List getUnitInfo(VoucherMngBean voucherMngBean){
		int unitCodeLength =  voucherMngBean.getUnitCode().length();
		String strHql="from Unit where unitCode='"+voucherMngBean.getUnitCode()+"'";
		return toolDAO.queryHqlStringSearch(strHql);
	}
	
	
}
