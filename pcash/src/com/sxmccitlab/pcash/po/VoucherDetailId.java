package com.sxmccitlab.pcash.po;

/**
 * TVoucherDetailId entity. @author MyEclipse Persistence Tools
 */

public class VoucherDetailId implements java.io.Serializable {

	// Fields

	private String voucherCode;
	private String voucherDetailCode;

	// Constructors

	/** default constructor */
	public VoucherDetailId() {
	}

	/** full constructor */
	public VoucherDetailId(String voucherCode, String voucherDetailCode) {
		this.voucherCode = voucherCode;
		this.voucherDetailCode = voucherDetailCode;
	}

	// Property accessors

	public String getVoucherCode() {
		return this.voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getVoucherDetailCode() {
		return this.voucherDetailCode;
	}

	public void setVoucherDetailCode(String voucherDetailCode) {
		this.voucherDetailCode = voucherDetailCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VoucherDetailId))
			return false;
		VoucherDetailId castOther = (VoucherDetailId) other;

		return ((this.getVoucherCode() == castOther.getVoucherCode()) || (this
				.getVoucherCode() != null
				&& castOther.getVoucherCode() != null && this.getVoucherCode()
				.equals(castOther.getVoucherCode())))
				&& ((this.getVoucherDetailCode() == castOther
						.getVoucherDetailCode()) || (this
						.getVoucherDetailCode() != null
						&& castOther.getVoucherDetailCode() != null && this
						.getVoucherDetailCode().equals(
								castOther.getVoucherDetailCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getVoucherCode() == null ? 0 : this.getVoucherCode()
						.hashCode());
		result = 37
				* result
				+ (getVoucherDetailCode() == null ? 0 : this
						.getVoucherDetailCode().hashCode());
		return result;
	}

}