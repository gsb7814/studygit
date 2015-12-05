package com.sxmccitlab.pcash.po;

/**
 * TSerial entity. @author MyEclipse Persistence Tools
 */

public class Serial implements java.io.Serializable {

	// Fields

	private String unitCode;
	private Integer serialNo;
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	private Long id;

	// Constructors

	/** default constructor */
	public Serial() {
	}

	/** minimal constructor */
	public Serial(String unitCode) {
		this.unitCode = unitCode;
	}



	// Property accessors

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}





	public Integer getSerialNo() {
		return serialNo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}