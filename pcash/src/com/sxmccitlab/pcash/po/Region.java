package com.sxmccitlab.pcash.po;

/**
 * SRegion entity. @author MyEclipse Persistence Tools
 */

public class Region implements java.io.Serializable {

	// Fields

	private String regionCode;
	private String regionName;
	private Long id;

	// Constructors

	/** default constructor */
	public Region() {
	}

	/** minimal constructor */
	public Region(String regionCode) {
		this.regionCode = regionCode;
	}

	/** full constructor */
	public Region(String regionCode, String regionName, Long id) {
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.id = id;
	}

	// Property accessors

	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}