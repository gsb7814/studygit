package com.sxmccitlab.pcash.po;

import java.sql.Timestamp;
import java.util.Date;


/**
 * TVoucher entity. @author MyEclipse Persistence Tools
 */

public class Voucher  implements java.io.Serializable {


    // Fields    

     private String voucherCode;
     private String voucherTypeCode;
     private Double debitSum;
     private Double creditSum;
     private String staffCode;
     private String unitCode;
     private Date opTime;
     private Long id;
     private Date voucherTime;
     private Date chargeTime;
     private Date modifyTime;
     private Date unchargeTime;


    // Constructors

    /** default constructor */
    public Voucher() {
    }

	/** minimal constructor */
    public Voucher(String voucherCode) {
        this.voucherCode = voucherCode;
    }
    
    /** full constructor */
    public Voucher(String voucherCode, String voucherTypeCode, Double debitSum, Double creditSum, String staffCode, String unitCode, Timestamp opTime, Long id, Timestamp voucherTime, Timestamp chargeTime, Timestamp modifyTime, Timestamp unchargeTime) {
        this.voucherCode = voucherCode;
        this.voucherTypeCode = voucherTypeCode;
        this.debitSum = debitSum;
        this.creditSum = creditSum;
        this.staffCode = staffCode;
        this.unitCode = unitCode;
        this.opTime = opTime;
        this.id = id;
        this.voucherTime = voucherTime;
        this.chargeTime = chargeTime;
        this.modifyTime = modifyTime;
        this.unchargeTime = unchargeTime;
    }

   
    // Property accessors

    public String getVoucherCode() {
        return this.voucherCode;
    }
    
    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherTypeCode() {
        return this.voucherTypeCode;
    }
    
    public void setVoucherTypeCode(String voucherTypeCode) {
        this.voucherTypeCode = voucherTypeCode;
    }

    public Double getDebitSum() {
        return this.debitSum;
    }
    
    public void setDebitSum(Double debitSum) {
        this.debitSum = debitSum;
    }

    public Double getCreditSum() {
        return this.creditSum;
    }
    
    public void setCreditSum(Double creditSum) {
        this.creditSum = creditSum;
    }

    public String getStaffCode() {
        return this.staffCode;
    }
    
    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getUnitCode() {
        return this.unitCode;
    }
    
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

  
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

	public Date getOpTime() {
		return opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public Date getVoucherTime() {
		return voucherTime;
	}

	public void setVoucherTime(Date voucherTime) {
		this.voucherTime = voucherTime;
	}

	public Date getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getUnchargeTime() {
		return unchargeTime;
	}

	public void setUnchargeTime(Date unchargeTime) {
		this.unchargeTime = unchargeTime;
	}

}