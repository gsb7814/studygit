<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="../../common/error.jsp"
 import="com.ibm.util.ParamUtils,
         com.ibm.admin.UserManager,
         java.util.Iterator,
         com.ibm.admin.User"%>
<%!String functionNo=null;%>
<%@ include file="../../common/global.jsp" %>
<%
    int groupID=ParamUtils.getIntParameter(request,"groupID",1);
	String selected=ParamUtils.getParameter(request,"selected","");
    boolean multiSelect=ParamUtils.getBooleanParameter(request,"multiSelect",true);
%>
<html>
<head>
<title>选择用户</title>
<link href='<%=request.getContextPath()%>/style/qingy.css' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="JavaScript" type="text/JavaScript">
function clickCancel(){
	var rtv = new Array();
	rtv[0]='Cancel';
	returnValue=rtv;
	window.close();
}
function clickOK(){
	 var selected=document.frames("SysBody").document.form1.selected.value;
    if(selected.lastIndexOf(','))
        selected=selected.substring(0,selected.length-1);

	returnValue=selected.split(",");
    if(returnValue.length==1){
        returnValue[1]="";
    }
	window.close();
}
</script>
</head>
<body>
<form name="form1" method="post" action="">
  <table align="center" width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr valign="top">
      <td width="86%"> <table class="td03" align="center" cellspacing="0" cellpadding="1" bordercolor="#ffffff" bordercolorlight="#2F2D90" bordercolordark="#FFFFFF" width="100%" border="1">
          <tr valign="top">
            <td width="100%" bgcolor="#000080"><b><font color="#FFFFFF" face="宋体">选择用户</font></b></td>
          </tr>
          <tr valign="top">
            <td width="100%" height="100">
<iframe name="SysBody" id="SysBody" frameborder="1" src="user.jsp?groupID=<%=groupID%>&selected=<%=selected%>&multiSelect=<%=multiSelect%>" width="100%" height="200" align="center">
</iframe></td>
          </tr>
        </table></td>
      <td width="14%"> <table align="center">
          <tr bgcolor="#FFFFFF">
            <td><br>
              <input type="button"  onclick="return clickOK();" value=" 确 定 " style="background-color: #e2e2e2; color: #2F2D90; font-size: 9pt; font-family: ??ì?; border: 2 groove #CCCCCC; padding-top: 2; background-position: center 50%"> </td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td width="87%" style="font-size:9pt"><br>
              <p>
                <input type="button" onclick="return clickCancel();" value=" 取 消 " style="background-color: #e2e2e2; color: #2F2D90; font-size: 9pt; font-family: ??ì?; border: 2 groove #CCCCCC; padding-top: 2; background-position: center 50%"> </td>
          </tr>
        </table></td>
    </tr>
  </table>
</form>
</body>
</html>
