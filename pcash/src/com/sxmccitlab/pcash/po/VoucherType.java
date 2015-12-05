package com.sxmccitlab.pcash.po;

/**
 * SVoucherType entity. @author MyEclipse Persistence Tools
 */

public class VoucherType implements java.io.Serializable {

	// Fields

	private String voucherTypeCode;
	private String voucherTypeName;
	private Long id;

	// Constructors

	/** default constructor */
	public VoucherType() {
	}

	/** minimal constructor */
	public VoucherType(String voucherTypeCode) {
		this.voucherTypeCode = voucherTypeCode;
	}

	/** full constructor */
	public VoucherType(String voucherTypeCode, String voucherTypeName, Long id) {
		this.voucherTypeCode = voucherTypeCode;
		this.voucherTypeName = voucherTypeName;
		this.id = id;
	}

	// Property accessors

	public String getVoucherTypeCode() {
		return this.voucherTypeCode;
	}

	public void setVoucherTypeCode(String voucherTypeCode) {
		this.voucherTypeCode = voucherTypeCode;
	}

	public String getVoucherTypeName() {
		return this.voucherTypeName;
	}

	public void setVoucherTypeName(String voucherTypeName) {
		this.voucherTypeName = voucherTypeName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}