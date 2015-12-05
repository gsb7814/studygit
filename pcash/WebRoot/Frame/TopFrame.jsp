<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<title>topframe</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #CCCCCC;
}
td {
	font-size: 12px;
	color: #FFFFFF;
}
a:link {
	font-size: 14px;
	font-weight: bold;
	color: #FFFFFF;
	text-decoration: none;
}
a:visited {
	font-size: 14px;
	font-weight: bold;
	color: #FFFFFF;
	text-decoration: none;
}
a:hover {
	font-size: 14px;
	font-weight: bold;
	color: #CCCCCC;
	text-decoration: underline;
}
.RightBg {
	background-image: url(images/TopRight.jpg);
	background-repeat: no-repeat;
	background-position: right top;
}
.Title {
	font-size: 14px;
	color: #FFFFFF;
}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/TopBg.jpg">
  <tr>
    <td width="300" valign="bottom" background="images/TopLeft.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="10">&nbsp;</td>
        <td width="21" valign="top"><img src="images/UserInfo.gif" width="10" height="15" /></td>
        <td height="6" valign="bottom" class="Title">工号：<s:property value="#session.staff.staffCode"/> &nbsp;姓名：<s:property value="#session.staff.staffName"/> </td>
      </tr>
      <tr>
        <td height="8" colspan="3"></td>
        </tr>
      
    </table></td>
    <td height="92" valign="bottom" background="images/TopRight.jpg" class="RightBg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>
        <div align="right">
        <s:url var="url" action="logout" namespace="/"> 
        </s:url> 
        <s:a href="%{url}" target="_top">退出系统</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
        </div></td>
      </tr>
      <tr>
        <td height="8"></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
