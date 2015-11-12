<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="guo" uri="/WEB-INF/mytags.tld" %>
<html>
<head>
<title>
testTag1
</title>
</head>
<body bgcolor="#ffffff">
private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private String url = "jdbc:odbc:petclinicapps";
    private String sql = "select * from employee";<br /><br />
<guo:queryDB driver="sun.jdbc.odbc.JdbcOdbcDriver" url="jdbc:odbc:petclinicapps" sql="select * from employee">
</guo:queryDB>
</body>
</html>
