<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>error</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="style/user.css">

</head>

<body>
  <%
			if (session.getAttribute("Message") != null) {
			out.print(session.getAttribute("Message"));
			session.removeAttribute("Message");
		}
	%>
</body>
</html>