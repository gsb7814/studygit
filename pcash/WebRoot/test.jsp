<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
 
  <body>
      	<s:form action="addAccountTypeAction" namespace="/">
      		会计科目类型编号：<s:textfield name="accountType.accountTypeCode"></s:textfield>
      		会计科目类型名称：<s:textfield name="accountType.accountTypeName"></s:textfield>
      		<s:submit></s:submit>
      	</s:form>
  </body>
</html>
