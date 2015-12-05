<%@ page language="java" import="java.util.*,com.sxmccitlab.common.pagehandle.PaginationVO,com.opensymphony.xwork2.ActionContext" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="application/vnd.ms-excel"%>
<%   
    String filename = new String(("现金/银行存款日记账").getBytes("GBK"),"ISO-8859-1");    
    response.addHeader("Content-Disposition", "filename=" + filename + ".xls");   
%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <% 
  int totalpage=1;
  int totalresult=1;%>
  
 
  
 
  
 
 

<table width="780" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#999999">
  <tr>
  
     <td><%=ActionContext.getContext().getSession().get("tvoucherDatestart").toString()%></td>
     <td></td>
     <td></td>
     <td></td>
     <td></td>
     <td></td>
     <td></td>
  </tr>
  
  <tr>
    <td colspan="7" align="left" bgcolor="#E8E8E8"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="37"><div align="center"><img src="../images/icon_arrow_table.gif" width="9" height="9" /></div></td>
        <td width="200" class="Title">现金/银行存款日记账</td>
        <td class="TableTitle">&nbsp;</td>
        <td> </td>
         <td> </td>
          <td> </td>
         <td> </td>
      </tr>
    </table>
        <div align="left"></div></td>
  </tr>

    <%
  List hj = (List)ActionContext.getContext().get("sumhjLedgerSum");
   if (hj != null)
  {
  
  Iterator iterhj = hj.iterator();
    
  
  while (iterhj.hasNext()) {
  Object[] objshj = (Object[])iterhj.next();
   
      
 %> 
    <tr>
    <td width="100" align="left" bgcolor="#FAFAFA"><div align="center"></div></td>
    <td width="100" align="left" bgcolor="#FAFAFA">&nbsp;</td>
    <td width="250" align="left" bgcolor="#FAFAFA" ><div align="center"><strong>本月合计</strong></div></td>
    <td width="80" align="left" bgcolor="#FAFAFA"><%=objshj[0] %></td>
    <td width="80" align="left" bgcolor="#FAFAFA"><%=objshj[1] %></td>
    <td width="80" align="left" bgcolor="#FAFAFA">&nbsp;</td>
    <td width="80" align="left" bgcolor="#FAFAFA">&nbsp;</td>
  </tr>
  
    <%
    }
    }
  List lj = (List)ActionContext.getContext().get("sumljLedgerSum");
   if (lj != null)
  {
  
  Iterator iterlj = lj.iterator();
    
  
  while (iterlj.hasNext()) {
  Object[] objslj = (Object[])iterlj.next();  
    %>
     <tr>
    <td align="left" bgcolor="#FAFAFA">&nbsp;</td>
    <td align="left" bgcolor="#FAFAFA">&nbsp;</td>
    <td align="left" bgcolor="#FAFAFA" ><div align="center"><strong>本年累计</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><%=objslj[0] %></td>
    <td align="left" bgcolor="#FAFAFA"><%=objslj[1] %></td>
    <td align="left" bgcolor="#FAFAFA">&nbsp;</td>
    <td align="left" bgcolor="#FAFAFA">&nbsp;</td>
  </tr>
  <%
  }
  }
   %>
  
  <tr>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>日期</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>凭证号</strong></div></td>
    <td align="left" bgcolor="#FAFAFA" ><div align="center"><strong>摘要</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>借方金额</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>贷方金额</strong><strong></strong><strong> </strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>余额方向</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>余额</strong></div></td>
  </tr>
  
    <% 
  List lst = (List)ActionContext.getContext().get("DailyLedgerSum");
   if (lst != null)
  {
  
  Iterator iter = lst.iterator();
    
  
  while (iter.hasNext()) {
  Object[] objs = (Object[])iter.next();
   
      
 %> 

 
  
 


 <tr>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[0] %></td>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[1] %></td>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[2] %></td>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[3] %></td>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[4] %></td>
    <td align="left" bgcolor="#FFFFFF" ></td>
    <td align="left" bgcolor="#FFFFFF" ></td>
  </tr>

 <% 
 }
 
 %>
 
 
</table>


 
  
   <% 
  }
   %>
  
  
   
  
    
  
  </body>
</html>
