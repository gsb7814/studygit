<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.admin.*"%>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%
	User user=(User)session.getAttribute("user");
		String contextPath = request.getContextPath();
		String roleId=request.getParameter("roleId");

 %>
<html>
<head>
<title>增加职位</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../style/style.css" rel="stylesheet" type="text/css">
<link href="../style/css.css" rel="stylesheet" type="text/css">
<LINK href="<%=contextPath %>/rmbs/css/main.css" type="text/css" rel="stylesheet"> 
<link href="<%=contextPath %>/rmbs/css/form.css" type="text/css" rel="stylesheet">
<style type="text/css">
<!--
.style1 {font-size: 12px}
.style4 {
	font-size: 14px;
	font-weight: bold;
	font-family: Tahoma, Verdana;
}
.style5 {color: #FFFFFF}
-->
</style>
<script language="Javascript" src="<%=contextPath%>/rmbs/js/hashMap.js"></script>
<script language="Javascript" src="<%=contextPath %>/rmbs/js/docassistant.js"></script>
<script language="Javascript" src="<%=contextPath %>/rmbs/js/serviceInterface.js"></script>
<script language="Javascript" src="<%=contextPath %>/rmbs/js/docassistant_else.js"></script>
<script language="Javascript" src="<%=contextPath %>/rmbs/js/partrefresh_public.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/public.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/clsDynamicSelect.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/Validator.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/calendar.js"></script>
<script language="Javascript" src="<%=contextPath %>/rmbs/js/tabmanager.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/returnmsg.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/CheckForms.js"></script>
<script language="javascript" src="<%=contextPath %>/rmbs/js/ajaxForm.js"></script>
<script language="javascript">
function createXMLHttpRequest() {
    var xmlHttp;
　 if (window.ActiveXObject) {
　　 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
　　}
　　else if (window.XMLHttpRequest) {
　　　xmlHttp = new XMLHttpRequest();
　　}
   return xmlHttp;
  
} 
    function	initView(){
      
   	 var oDom = oPublicFunction.getDom('<%=contextPath%>/userRole.do?method=getRoleById&roleId=<%=roleId%>');
		
		sysCtrl.initViewPage(oDom);
   }
   function createMe(){
  	   if(thisForm.roleName.value == "")
		{
			alert("角色名称不能为空！");
			return false;
		}
       ajax_loading("保存中……");
	   oDocAssistant.oDocCtrlRoot.commit();
      var domStr=oDocAssistant.oDomDoc.xml;
 
      var xmlHttp=createXMLHttpRequest();
      xmlHttp.open("POST", "<%=contextPath%>/userRole.do", false);
	  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
	 xmlHttp.send("method=saveOrUpdateRole&xmlStr="+encodeURIComponent(domStr));
	 var returnStr=xmlHttp.statusText;
	 if('OK'==returnStr){
	   // window.location.href='roleList.jsp';
	   window.location.href='<%=contextPath%>/admin/userRole.jsp';
	 	ajax_done();
	 }	
	 else{
	 	alert('添加角色出错');
	 }
   }
     function go2Main(){
		window.location.href="userRole.jsp";
	}
</script>
</head>


<body topmargin="0" leftmargin="0" onLoad="initView()"> 
<br> 
<table border="0" width="95%" cellspacing="0" cellpadding="0" align=center> 
  <tr> 
    <td height="41" COLSPAN=4 background="../images/dbwd_12.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="style5">&nbsp;<span class="style4">创建岗位</span></span></TD> 
  </tr> 
</table> 
<form name="thisForm" method="post" action="createPosition.jsp" onSubmit="return check()"> 
  <table border="0" width="90%" cellspacing="0" cellpadding="0" align=center> 
    <tr> 
      <td height="22" valign=top background="../images/line_bg.gif" colspan="2" nowrap class="tdbulef" > &nbsp;&nbsp;创建新角色，红星（<font color="#FF0000">*</font>）是必填。 </td> 
    </tr> 
    <tr> 
      <td width="22%" height="22" nowrap  valign=top background="../images/line_bg.gif"> <div align="right" class="style1"><font color="red">*</font>角色名称：</div></td> 
      <td width="78%" height="22" nowrap  valign=top background="../images/line_bg.gif"> <div align="left" class="style1"> 
           <input name="id" type="hidden" id="id"> 
          <input name="roleName" type="text" id="roleName"> 
        </div></td> 
    </tr> 
	
 
    <tr> 
      <td height="22" nowrap  valign=top background="../images/line_bg.gif"><div align="right"><font size="2">备&nbsp;&nbsp;&nbsp;&nbsp;注：</font></div></td> 
      <td height="22" nowrap  valign=top background="../images/line_bg.gif"><div align="left"><font size="2"> 
          <textarea name="roleNote" cols="35" rows="5" id="roleNote"></textarea> 
          </font></div></td> 
    </tr> 
    <tr> 
      <td height="45" colspan="2" bgcolor="#ffffff"><div align="right"><font size="2"></font></div> 
        <input type="button" name="Submit" value=" 修改 " class="White" onclick="createMe();"> 
&nbsp;&nbsp; 
     
        <input type="button" name="Submit3" value=" 返回 " class="White" onClick="javascript:go2Main()"> 
</td> 
    </tr> 
  </table> 

</form> 
</body>
</html>
