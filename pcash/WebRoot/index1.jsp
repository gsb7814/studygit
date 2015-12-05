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
    <s:form action="userLogin" namespace="/sysMng">
    	用户名:<s:textfield name="userInfo.username"/><br/>
    	密码:<s:password name="userInfo.password"/><br/>
    	<s:submit>登录</s:submit>
    </s:form>
    <s:bean name="msg"></s:bean>
  </body>
</html>
