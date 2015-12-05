package com.sxmccitlab.common;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

	private int curPage;  //当前页
	private int totalPage; //总页
	private int rowsCount; //总记录数
	
	public String getFooter(HttpServletRequest request,String action,String pageSize){//pageCount 每页几条
		int cur=1;
		if(request.getParameter("page")!=null){
			try{
				cur = Integer.parseInt(request.getParameter("page")) ;
			}catch(Exception e ){
				cur=1;
			}
		}
		this.setCurPage(cur);
		if(this.getCurPage()<1){
			this.setCurPage(1);
		}else if(this.getCurPage()>this.getTotalPage()){
			this.setCurPage(this.getTotalPage());
		}	
		StringBuffer foot=new StringBuffer();
		foot.append("<table id='footertable'><tr id='footerrow'><td><div ><div align='right'><span class='zw-zx-1'>页次：<b>");
		foot.append(this.getCurPage()).append("/").append(this.getTotalPage()).append("</b>&nbsp;每页<b>").append(pageSize);
		foot.append("</b>&nbsp;总数<b>").append(this.getRowsCount()).append("</b>&nbsp;&nbsp;&nbsp;&nbsp;");
		if(this.getCurPage()<=1){
			foot.append("<a disabled='disabled' >").append("首页").append("</a>&nbsp;&nbsp;");
			foot.append("<a disabled='disabled' >").append("上一页").append("</a>&nbsp;&nbsp;");
		}else{
			foot.append("<a href='"+request.getRequestURL()+"?action="+action+"&page=1' >").append("首页").append("</a>&nbsp;&nbsp;");
			foot.append("<a href='"+request.getRequestURL()+"?action="+action+"&page=").append(this.getCurPage()-1).append("' >").append("上一页").append("</a>&nbsp;&nbsp;");
		}
		if(this.getTotalPage()<=this.getCurPage()){
			foot.append("<a disabled='disabled' >").append("下一页").append("</a>&nbsp;&nbsp;");
			foot.append("<a disabled='disabled' >").append("尾页").append("</a>&nbsp;&nbsp;&nbsp;&nbsp;转到:");
		}else{
			foot.append("<a href='"+request.getRequestURL()+"?action="+action+"&page=").append(this.getCurPage()+1).append("' >").append("下一页").append("</a>&nbsp;&nbsp;");
			foot.append("<a href='"+request.getRequestURL()+"?action="+action+"&page=").append(this.getTotalPage()).append("' >").append("尾页").append("</a>&nbsp;&nbsp;&nbsp;&nbsp;转到：");
		}
		foot.append("<select onchange='self.location.href=this.options[this.selectedIndex].value'"+" name='selectPage'  class='footselect' id='footselectid'>");
		String selected="";
		for(int i=1;i<=this.getTotalPage();i++){
			if( i == getCurPage() ){
                selected = " selected ";
			}else{
				selected = "";
			}
			foot.append( "      <option value='").append(request.getRequestURL()).append("?action="+action+"&page=").append(i).append("' ").append(selected).append(">第 ").append(i).append(" 页</option>  \n");
		}
		foot.append("</select></span></div></div></td></tr></table>");
		return foot.toString();
	}
	// add by zwt 
	public String getFooter(HttpServletRequest request,String action,int curPage,String pageSize){//pageCount 每页几条
		int cur=curPage;
		/*if(request.getParameter("page")!=null){
			try{
				cur = Integer.parseInt(request.getParameter("page")) ;
			}catch(Exception e ){
				cur=1;
			}
		}*/
		this.setCurPage(cur);
		if(this.getCurPage()<1){
			this.setCurPage(1);
		}else if(this.getCurPage()>this.getTotalPage()){
			this.setCurPage(this.getTotalPage());
		}	
		StringBuffer foot=new StringBuffer();
		foot.append("<table id='footertable'><tr id='footerrow'><td><div ><div align='right'><span class='zw-zx-1'>页次：<b>");
		foot.append(this.getCurPage()).append("/").append(this.getTotalPage()).append("</b>&nbsp;每页<b>").append(pageSize);
		foot.append("</b>&nbsp;总数<b>").append(this.getRowsCount()).append("</b>&nbsp;&nbsp;&nbsp;&nbsp;");
		if(this.getCurPage()<=1){
			foot.append("<a disabled='disabled' >").append("首页").append("</a>&nbsp;&nbsp;");
			foot.append("<a disabled='disabled' >").append("上一页").append("</a>&nbsp;&nbsp;");
		}else{
			foot.append("<a href='"+request.getRequestURL()+"?page=1' >").append("首页").append("</a>&nbsp;&nbsp;");
			foot.append("<a href='"+request.getRequestURL()+"?page=").append(this.getCurPage()-1).append("' >").append("上一页").append("</a>&nbsp;&nbsp;");
		}
		if(this.getTotalPage()<=this.getCurPage()){
			foot.append("<a disabled='disabled' >").append("下一页").append("</a>&nbsp;&nbsp;");
			foot.append("<a disabled='disabled' >").append("尾页").append("</a>&nbsp;&nbsp;&nbsp;&nbsp;转到:");
		}else{
			foot.append("<a href='"+request.getRequestURL()+"?page=").append(this.getCurPage()+1).append("' >").append("下一页").append("</a>&nbsp;&nbsp;");
			foot.append("<a href='"+request.getRequestURL()+"?page=").append(this.getTotalPage()).append("' >").append("尾页").append("</a>&nbsp;&nbsp;&nbsp;&nbsp;转到：");
		}
		foot.append("<select onchange='self.location.href=this.options[this.selectedIndex].value'"+" name='selectPage'  class='footselect' id='footselectid'>");
		String selected="";
		for(int i=1;i<=this.getTotalPage();i++){
			if( i == getCurPage() ){
                selected = " selected ";
			}else{
				selected = "";
			}
			foot.append( "      <option value='").append(request.getRequestURL()).append("?page=").append(i).append("' ").append(selected).append(">第 ").append(i).append(" 页</option>  \n");
		}
		foot.append("</select></span></div></div></td></tr></table>");
		return foot.toString();
	}
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
	
}
