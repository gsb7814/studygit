package com.sxmccitlab.pcash.po;

import java.util.Set;

/**
 * TUnit entity. @author MyEclipse Persistence Tools
 */

public class Unit implements java.io.Serializable {

	// Fields

	private String unitCode;
	private String unitName;
	private String comments;
	private String regionCode;
	private String districtCode;
	
	private Set <Staff> Staffs;

	// Constructors

	public Set<Staff> getStaffs() {
		return Staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		Staffs = staffs;
	}

	/** default constructor */
	public Unit() {
	}

	/** minimal constructor */
	public Unit(String unitCode) {
		this.unitCode = unitCode;
	}

	/** full constructor */
	public Unit(String unitCode, String unitName, String comments,
			String regionCode, String districtCode) {
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.comments = comments;
		this.regionCode = regionCode;
		this.districtCode = districtCode;
	}

	// Property accessors

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}