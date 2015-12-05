package com.sxmccitlab.pcash.po;

/**
 * TVoucherTypeId entity. @author MyEclipse Persistence Tools
 */

public class VoucherTypeId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String voucherTypeCode;
	private String voucherTypeName;

	// Constructors

	/** default constructor */
	public VoucherTypeId() {
	}

	/** full constructor */
	public VoucherTypeId(Integer id, String voucherTypeCode,
			String voucherTypeName) {
		this.id = id;
		this.voucherTypeCode = voucherTypeCode;
		this.voucherTypeName = voucherTypeName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VoucherTypeId))
			return false;
		VoucherTypeId castOther = (VoucherTypeId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getVoucherTypeCode() == castOther
						.getVoucherTypeCode()) || (this.getVoucherTypeCode() != null
						&& castOther.getVoucherTypeCode() != null && this
						.getVoucherTypeCode().equals(
								castOther.getVoucherTypeCode())))
				&& ((this.getVoucherTypeName() == castOther
						.getVoucherTypeName()) || (this.getVoucherTypeName() != null
						&& castOther.getVoucherTypeName() != null && this
						.getVoucherTypeName().equals(
								castOther.getVoucherTypeName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getVoucherTypeCode() == null ? 0 : this.getVoucherTypeCode()
						.hashCode());
		result = 37
				* result
				+ (getVoucherTypeName() == null ? 0 : this.getVoucherTypeName()
						.hashCode());
		return result;
	}

}