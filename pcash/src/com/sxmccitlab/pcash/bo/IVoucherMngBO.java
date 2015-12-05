package com.sxmccitlab.pcash.bo;

import java.util.List;

import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.pcash.action.bean.VoucherMngBean;
import com.sxmccitlab.pcash.dao.IAccountTypeDAO;

import com.sxmccitlab.pcash.dao.ISerialDAO;
import com.sxmccitlab.pcash.dao.IAccountDAO;
import com.sxmccitlab.pcash.dao.IVoucherDetailDAO;
import com.sxmccitlab.pcash.dao.IToolDAO;
import com.sxmccitlab.pcash.dao.IVoucherDAO;
import com.sxmccitlab.pcash.dao.IVoucherTypeDAO;


public interface IVoucherMngBO {

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#settVoucherDetailDAO(com.sxmccitlab.pcash.dao.ITVoucherDetailDAO)
	 */
	public abstract void setVoucherDetailDAO(
			IVoucherDetailDAO voucherDetailDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#setsAccountTypeDAO(com.sxmccitlab.pcash.dao.ISAccountTypeDAO)
	 */
	public abstract void setAccountTypeDAO(IAccountTypeDAO sccountTypeDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IPzMagBO#setsVoucherTypeDAO(com.sxmccitlab.pcash.dao.impl.SVoucherTypeDAO)
	 */
	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#setsVoucherTypeDAO(com.sxmccitlab.pcash.dao.impl.SVoucherTypeDAO)
	 */
	public abstract void setVoucherTypeDAO(IVoucherTypeDAO voucherTypeDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#settAccountDAO(com.sxmccitlab.pcash.dao.ITAccountDAO)
	 */
	public abstract void setAccountDAO(IAccountDAO accountDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IPzMagBO#setToolDAO(com.sxmccitlab.pcash.dao.IToolDAO)
	 */
	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#setToolDAO(com.sxmccitlab.pcash.dao.IToolDAO)
	 */
	public abstract void setToolDAO(IToolDAO toolDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IPzMagBO#setVoucherDAO(com.sxmccitlab.pcash.dao.IVoucherDAO)
	 */
	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#setVoucherDAO(com.sxmccitlab.pcash.dao.IVoucherDAO)
	 */
	public abstract void setVoucherDAO(IVoucherDAO voucherDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IPzMagBO#setSerialDAO(com.sxmccitlab.pcash.dao.ISerialDAO)
	 */
	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#setSerialDAO(com.sxmccitlab.pcash.dao.ISerialDAO)
	 */
	public abstract void setSerialDAO(ISerialDAO serialDAO);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#getInfo()
	 */
	public abstract VoucherMngBean getInfo(VoucherMngBean voucherMngBean);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#addVoucher(com.sxmccitlab.pcash.action.impl.VoucherMngBean)
	 */
	public abstract void addVoucherInfo(VoucherMngBean voucherMngBean);

	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.bo.impl.IVoucherMngBO#queryVoucher()
	 */
	public abstract PaginationSupport queryVoucher(VoucherMngBean voucherMngBean);
	
    //public abstract List queryVoucherDetail(VoucherMngBean voucherMngBean);
    
	public abstract int updateVoucherDetail(VoucherMngBean voucherMngBean);
	
	//public abstract List queryVoucherById(String voucherCode);
	//public List queryVoucherDetailById(String voucherCode);
	public abstract VoucherMngBean queryVoucherInfo(String voucherCode);
	
	public abstract void updateVoucherInfo(VoucherMngBean voucherMngBean);
	
	public abstract VoucherMngBean getSearchInfo(VoucherMngBean voucherMngBean);

}