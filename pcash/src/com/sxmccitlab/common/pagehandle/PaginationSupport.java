package com.sxmccitlab.common.pagehandle;

import java.util.List;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author Bob Guo
 * 
 */
public class PaginationSupport {
	
	public static final int PAGESIZE = 10;
	private int pageSize;
	private List items;
	private int totalCount;
	private int indexes[];
	private int startIndex;
	
	public PaginationSupport(List items, int totalCount) {
		pageSize = 10;
		indexes = new int[1];
		startIndex = 0;
		initPageSize();
		setPageSize(10);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(0);
	}

	public PaginationSupport(List items, int totalCount, int startIndex) {
		pageSize = 10;
		indexes = new int[1];
		this.startIndex = 0;
		initPageSize();
		setPageSize(10);
		initPageSize();
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	public PaginationSupport(List items, int totalCount, int pageSize,
			int startIndex) {
		this.pageSize = 10;
		indexes = new int[1];
		this.startIndex = 0;
		initPageSize();
		setPageSize(pageSize);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	private void initPageSize() {
		String pageSizeStr = null;
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(
					getClass().getResource("/application.properties"));
			pageSizeStr = config.getString("pager.jsp.pagesize");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (pageSizeStr == null || pageSizeStr.equals(""))
			pageSizeStr = "10";
		pageSize = Integer.parseInt(pageSizeStr);
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			int count = totalCount / pageSize;
			if (totalCount % pageSize > 0)
				count++;
			indexes = new int[count];
			for (int i = 0; i < count; i++)
				indexes[i] = pageSize * i;

		} else {
			this.totalCount = 0;
		}
	}

	public int[] getIndexes() {
		return indexes;
	}

	public void setIndexes(int indexes[]) {
		this.indexes = indexes;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		if (totalCount <= 0)
			this.startIndex = 0;
		else if (startIndex >= totalCount)
			this.startIndex = indexes[indexes.length - 1];
		else if (startIndex < 0)
			this.startIndex = 0;
		else
			this.startIndex = indexes[startIndex / pageSize];
	}

	public int getNextIndex() {
		int nextIndex = getStartIndex() + pageSize;
		if (nextIndex >= totalCount)
			return getStartIndex();
		else
			return nextIndex;
	}

	public int getPreviousIndex() {
		int previousIndex = getStartIndex() - pageSize;
		if (previousIndex < 0)
			return 0;
		else
			return previousIndex;
	}

	public int getTotalPages() {
		int totalPages;
		if (getTotalCount() % getPageSize() > 0)
			totalPages = getTotalCount() / getPageSize() + 1;
		else
			totalPages = getTotalCount() / getPageSize() + 1;
		return totalPages;
	}

	public int getCurrentPage() {
		int currentPage = getStartIndex() / getPageSize() + 1;
		return currentPage;
	}

	public int getLastPage() {
		int lastPage = (getTotalPages() - 1) * getPageSize();
		return lastPage;
	}

}
