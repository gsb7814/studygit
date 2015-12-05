package com.sxmccitlab.common;

import java.util.ArrayList;
import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxmccitlab.common.PaginationSupport;


public class PagerBean {
	Log log = LogFactory.getLog(this.getClass());
	//-----------------分页使用----------------
	private Integer pagesize = 20;             //每页记录数
	private Integer totalPagers;               //总页数
	private Integer currentPager;              //当前页
	private Integer totalRecords;              //总记录数
	private Integer pagerNo;                   //下拉框返回的页码
	private List pagerList ;                   //下拉的页码列表
	private String sessionPagerListName ;      //页码存在session里面的属性名称
    
	public PagerBean()
	{}
	//子类需要重载此构造函数来设置每页显示的行数和保存在session中页码的属性名
	public PagerBean(String sessionPagerListName,Integer pagesize){
		setSessionPagerListName(sessionPagerListName);
		setPagesize(pagesize);
	}
	
	//由子类去实现翻页
	//public abstract String go();
	
	
	//把页码存放到session中
	public List getPagerList() {
		/*if (null == pagerList) {
			pagerList = new ArrayList();
			List list = (List) Tool.getSessionAttribute(getSessionPagerListName());
			if (null != list) {
				pagerList = list;
			}
		}*/

		return pagerList;
	}

	public void setPagerList(List pagerList) {
		this.pagerList = pagerList;
	}
	
	//生成页码
	public void makePagerList(PaginationSupport ps) {
		/*
		 * log.debug("getTotalCount() = " + ps.getTotalCount());
		 * log.debug("getStartIndex() = " + ps.getStartIndex());
		 * log.debug("getTotalPagers() = " +
		 * (ps.getStartIndex()/ps.getPageSize()+1));
		 * log.debug("ps.getIndexes().length = " + ps.getIndexes().length);
		 */
		// 设置分页信息
		setTotalRecords(ps.getTotalCount());
		setCurrentPager((ps.getStartIndex() / ps.getPageSize() + 1));
		setTotalPagers(ps.getIndexes().length);
		List<String> list = new ArrayList<String>();
		// 得到分页索引的数组
		for (int i = 0; i < ps.getIndexes().length; i++) {
			// log.debug("分页索引:" + ps.getIndexes()[i]);
			String name = Integer.valueOf(i + 1).toString();
			//String id = Integer.valueOf(ps.getIndexes()[i]).toString();
			//list.add(new SelectItem(id, name));
			list.add(name);
		}
		log.debug("得到分页索引的数组的值： " + list.size());
		setPagerList(list);

		//Tool.setSessionAttribute(getSessionPagerListName(), list);
	}
	
	public String getSessionPagerListName() {
		return sessionPagerListName;
	}
	
	public void setSessionPagerListName(String sessionPagerListName) {
		this.sessionPagerListName = sessionPagerListName;
	}
	
	public Integer getTotalPagers() {
		return totalPagers;
	}

	public void setTotalPagers(Integer totalPagers) {
		this.totalPagers = totalPagers;
	}

	public Integer getCurrentPager() {
		return currentPager;
	}

	public void setCurrentPager(Integer currentPager) {
		this.currentPager = currentPager;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getPagerNo() {
		return pagerNo;
	}

	public void setPagerNo(Integer pagerNo) {
		this.pagerNo = pagerNo;
	}
	
	public Integer getPagesize() {
		return pagesize;
	}
	
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
}
