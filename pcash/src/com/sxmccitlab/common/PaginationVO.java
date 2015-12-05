/**
 * 
 */
package com.sxmccitlab.common;

import java.util.List;

/**
 * @author Bob Guo
 *
 */
public class PaginationVO {
    private int currentPage;
    private int pageSize=10;
    private int totalResult;
    private int totalPage;
    private List resultList;
    private int firstResult;
	/**
	 * @return the firstResult
	 */
	public int getFirstResult() {
		return firstResult;
	}
	/**
	 * @param firstResult the firstResult to set
	 */
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the resultList
	 */
	public List getResultList() {
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the totalResult
	 */
	public int getTotalResult() {
		return totalResult;
	}
	/**
	 * @param totalResult the totalResult to set
	 */
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
}
