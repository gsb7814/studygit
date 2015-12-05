<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../images/text.css" rel="stylesheet" type="text/css" />
<script LANGUAGE="JavaScript"> 
<!-- 
function openwin() 
{ window.open ("../Frame/org.html", "newwindow", "height=300, width=300, top=0,left=0,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") 
} 
//--> 
</script> 
<title>凭证反记账查询</title>
</head>

<body>
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
    <td>当前位置： <a href="../index.jsp" target="_top">首页</a> &gt;&gt; 凭证管理 &gt;&gt; 反记账</td>
  </tr>
  <tr>
    <td height="1" colspan="3" bgcolor="#333333"><img src="../images/11Dot.gif" width="1" height="1" /></td>
  </tr>
</table>
<br />
<s:form action="voucherMng_searchUnChargedVoucher.action" namespace="/voucherMng" target="down">
<table width="780" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#999999">
  <tr>
    <td colspan="8" align="left" bgcolor="#E8E8E8"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="37"><div align="center"><img src="../images/icon_arrow_table.gif" width="9" height="9" /></div></td>
        <td width="200" class="Title">反记账</td>
        <td class="TableTitle">&nbsp;</td>
      </tr>
    </table>
    <div align="left"></div></td>
  </tr>
  <tr>
    <td colspan="8" align="left" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><div align="left">　<strong>凭证范围：</strong>						
						<s:select label="凭证范围"
							list="voucherMngBean.unitList" listKey="unitCode"
							listValue="unitName" name="voucherMngBean.unitCode"
							theme="simple"></s:select> 
        
            &nbsp;<strong>当前期间：</strong><s:property value="voucherMngBean.accountingPeriodName"/></div>          
         <s:hidden name="voucherMngBean.accountingPeriod" value="%{voucherMngBean.accountingPeriod}"></s:hidden>
         </td>
        <td width="190"><div align="left">　　</div></td>
        <td width="71" height="25"><div align="center">
            <input name="Submit222" type="submit" class="buttonborder" value="查询" />
        </div></td>
      </tr>
    </table></td>
  </tr>
</table>
</s:form>
	<iframe src="mainFrame.jsp" name="down" width="100%" height="76%"
		frameborder="0" marginwidth="0" marginheight="0"></iframe>
<div align="center"><br />
</div>
</body>
</html>
