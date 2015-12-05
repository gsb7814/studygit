package com.sxmccitlab.common.pagehandle;

import java.util.List;

/**
 * @author Bob Guo
 * 
 */
public class Result {

	private Page page;
	private List content;
	
	public Result() {
	}

	public Result(Page page, List content) {
		this.page = page;
		this.content = content;
	}

	public List getContent() {
		return content;
	}

	public Page getPage() {
		return page;
	}

	public void setContent(List content) {
		this.content = content;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
