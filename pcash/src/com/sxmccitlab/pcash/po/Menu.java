package com.sxmccitlab.pcash.po;

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private String menuCode;
	private String menuName;
	private String menuPath;
	private Long id;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String menuCode) {
		this.menuCode = menuCode;
	}

	/** full constructor */
	public Menu(String menuCode, String menuName, String menuPath, Long id) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuPath = menuPath;
		this.id = id;
	}

	// Property accessors

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPath() {
		return this.menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}