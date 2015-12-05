<%@ page language="java" import="java.util.*,com.sxmccitlab.common.pagehandle.PaginationVO,com.opensymphony.xwork2.ActionContext" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <% 
  int totalpage=1;
  int totalresult=1;%>
  
 
  
 
<s:form name="frm" action="generalLedger.action" method="post">  
 
 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#DDECFF">
  <tr>
    <td height="3" colspan="3" bgcolor="#FFCC00"></td>
  </tr>
  <tr>
    <td height="1" colspan="3" bgcolor="#ffffff"></td>
  </tr>
  <tr>
    <td width="12" height="24">&nbsp;</td>
    <td width="25"><img src="../images/PositionDot.gif" width="13" height="13" /></td>
    <td>当前位置： <a href="../index.htm" target="_top">首页</a> &gt;&gt; 帐薄管理 &gt;&gt; 总分类账</td>
  </tr>
  <tr>
    <td height="1" colspan="3" bgcolor="#333333"><img src="../images/11Dot.gif" width="1" height="1" /></td>
  </tr>
</table>
<br />
<table width="780" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#999999">
  <tr>
    <td colspan="7" align="left" bgcolor="#E8E8E8"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="37"><div align="center"><img src="../images/icon_arrow_table.gif" width="9" height="9" /></div></td>
        <td width="200" class="Title">总分类账</td>
        <td class="TableTitle">&nbsp;</td>
      </tr>
    </table>
        <div align="left"></div></td>
  </tr>
  <tr>
 
    <td colspan="7" align="left" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><div align="left">　<strong>凭证范围：</strong><s:select label="营业厅代码" list="#application.GLOBAL_UNITS"
	listKey="unitCode"
	listValue="unitName"
	name="unitCode" theme="simple"
	headerKey="0" headerValue="请选择" value="%{#unitCode.trim()}"></s:select>
                  &nbsp;&nbsp;<strong>会计期间：</strong> <input   type="text"   name="voucherDatestart" value="<s:property value="#session.tvoucherDatestart"/>" >     
                    &nbsp;&nbsp;<strong>会计科目：</strong> 
                    <s:select label="会计科目代码"  name="accountCode"
                             list="#{ '1000':'资产','1001':'库存现金','1001010101':'库存现金-人民币','1001020101':'库存现金-港币', '1001030101':'库存现金-美元', '1002':'银行存款','100201':'银行存款-人民币', '10020110':'银行存款 - 人民币 - 省公司','1002011001':'银行存款 - 人民币 - 省公司-工行收入户9861', '2001':'短期借款','2002':'存入保证金'}"
                             ></s:select>
                    
        </div>
              <div align="left"></div>
          <div align="left"></div></td>
        <td width="71" height="25"><div align="center">
         <s:submit name="submit" value="生成" method="searchGeneralLedger"></s:submit>
        </div></td>
      </tr>
    </table></td>
   
  
  </tr>
    <%
  List hj = (List)ActionContext.getContext().get("sumhjGeneralSum");
   if (hj != null)
  {
  
  Iterator iterhj = hj.iterator();
    
  
  while (iterhj.hasNext()) {
  Object[] objshj = (Object[])iterhj.next();
   
      
 %> 
    <tr>
   
    <td width="250" align="left" bgcolor="#FAFAFA" ><div align="center"><strong>本期发生额</strong></div></td>
    <td width="80" align="left" bgcolor="#FAFAFA"><%=objshj[0] %></td>
    <td width="80" align="left" bgcolor="#FAFAFA"><%=objshj[1] %></td>
    
  </tr>
  
    <%
    }
    }
  List lj = (List)ActionContext.getContext().get("sumljGeneralSum");
   if (lj != null)
  {
  
  Iterator iterlj = lj.iterator();
    
  
  while (iterlj.hasNext()) {
  Object[] objslj = (Object[])iterlj.next();  
    %>
     <tr>
    
    <td align="left" bgcolor="#FAFAFA" ><div align="center"><strong>本年累计</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><%=objslj[0] %></td>
    <td align="left" bgcolor="#FAFAFA"><%=objslj[1] %></td>
   
  </tr>
  <%
  }
  }
   %>
  
  <tr>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>日期</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>借方金额</strong></div></td>
    <td align="left" bgcolor="#FAFAFA"><div align="center"><strong>贷方金额</strong><strong></strong><strong> </strong></div></td>
   
  </tr>
  
    <% 
  PaginationVO lst = (PaginationVO)ActionContext.getContext().get("GeneralLedgerSum");
   if (lst != null)
  {
  
  Iterator iter = lst.getResultList().iterator();
    
  
  while (iter.hasNext()) {
  Object[] objs = (Object[])iter.next();
   
      
 %> 

 
  
 


 <tr>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[0] %></td>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[1] %></td>
    <td align="left" bgcolor="#FFFFFF" ><%=objs[2] %></td>
   
  </tr>

 <% 
 }
 
  
  totalpage=lst.getTotalPage();
  totalresult=lst.getTotalResult();
 %>
 
 <s:url id="url_first" value="generalLedgerfy.action">
         <s:param name="CP" value="0"></s:param>
         
  </s:url>
  
    <s:if test="CP gt 0">
  <s:url id="url_pre" value="dailyLedgerfy.action">
         <s:param name="CP" value="CP-1"></s:param>
         
     </s:url>
</s:if>

<s:set name="tp"><%=totalpage-1%></s:set>

 <s:if test="CP lt #tp">
     <s:url id="url_next" value="generalLedgerfy.action">
         <s:param name="CP" value="CP+1"></s:param>
     </s:url> 
</s:if>

     <s:url id="url_last" value="generalLedgerfy.action">
         <s:param name="CP" ><%=totalpage-1%></s:param>
         
  </s:url>
  
     <s:url id="url_last" value="generalLedgerfy.action">
         <s:param name="CP" ><%=totalpage-1%></s:param>
         
  </s:url>
     
  <tr>
    <td height="25" colspan="7" align="left" bgcolor="#FFFFFF" >共计<%=totalresult%>条记录 每页3条 分为<%=totalpage%>页 <s:property value="CP+1"/>
<s:a href="%{url_first}"> 首页 </s:a> <s:a href="%{url_pre}">上一页</s:a> <s:a href="%{url_next}">下一页</s:a>  <s:a href="%{url_last}">尾页</s:a></td>
  </tr>
  <tr>
    <td height="25" colspan="7" align="left" bgcolor="#FFFFFF" ><div align="right">
      <s:submit name="export" value="导出"   method="exportGeneralLedger"/> 
      </div></td>
  </tr>
 

</table>


 
  
   <% 
  }
   %>
  
  
    </s:form>
  
    
  
  </body>
</html>
