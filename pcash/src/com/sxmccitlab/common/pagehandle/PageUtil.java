package com.sxmccitlab.common.pagehandle;


/**
 * @author Bob Guo
 *
 */
public class PageUtil {

	public PageUtil() {
	}

	public static Page createPage(Page page, int totalRecords) {
		return createPage(page.getEveryPage(), page.getCurrentPage(),
				totalRecords);
	}

	public static Page createPage(int everyPage, int currentPage,
			int totalRecords) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		int totalPage = getTotalPage(everyPage, totalRecords);
		boolean hasNextPage = hasNextPage(currentPage, totalPage);
		boolean hasPrePage = hasPrePage(currentPage);
		return new Page(hasPrePage, hasNextPage, everyPage, totalPage,
				currentPage, beginIndex);
	}

	private static int getEveryPage(int everyPage) {
		return everyPage != 0 ? everyPage : 10;
	}

	private static int getCurrentPage(int currentPage) {
		return currentPage != 0 ? currentPage : 1;
	}

	private static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	private static int getTotalPage(int everyPage, int totalRecords) {
		int totalPage = 0;
		if (totalRecords % everyPage == 0)
			totalPage = totalRecords / everyPage;
		else
			totalPage = totalRecords / everyPage + 1;
		return totalPage;
	}

	private static boolean hasPrePage(int currentPage) {
		return currentPage != 1;
	}

	private static boolean hasNextPage(int currentPage, int totalPage) {
		return currentPage != totalPage && totalPage != 0;
	}
}
