<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>用户登陆</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body> 
    <s:form action="login" namespace="/">
    	工号:<s:textfield name="staff.staffCode"/>
    	
    	<br/>
    	密码:<s:password name="staff.password"/>
    	<font color="red"><s:fielderror key="msg.password" /></font>
    	<s:actionerror/>
    	<br/>
    	${message}
    	<s:submit>登录</s:submit>
    </s:form>
  </body>
</html>
