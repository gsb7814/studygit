<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ page import="com.ibm.admin.*;" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<%
	User user=(User)session.getAttribute("user");
    String contextPath = request.getContextPath();
	String currPage=request.getParameter("currPage");
	String pageSize=request.getParameter("pageSize");
	String goPage=request.getParameter("goPage");
	if(currPage==null||"".equals(currPage)){
		currPage="1";
	}
	if(pageSize==null||"".equals(pageSize)){
		pageSize="20";
	}
	if(goPage==null){
		goPage="0";
	}
	
	String userName=request.getParameter("userName");
	String roleName=request.getParameter("roleName");
	if(null==userName){
		userName="";
	}
    if(null==roleName){
		roleName="";
	}


%>

<meta http-equiv="Content-Type" content="text/html; charset=GBK">
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

 
<link href="<%=contextPath %>/rmbs/css/tab.css" type="text/css" rel="stylesheet">
<LINK href="<%=contextPath %>/rmbs/css/dishui1.css" type="text/css" rel="stylesheet">
<LINK href="<%=contextPath %>/rmbs/css/main.css" type="text/css" rel="stylesheet"> 
<link href="<%=contextPath %>/rmbs/css/form.css" type="text/css" rel="stylesheet">
<script language="javascript">
	//初始化页面
	function initView(){
	    var oDom = oPublicFunction.getDom('<%=contextPath%>/userRole.do?method=listAllUserRole&roleName=<%=roleName%>&userName=<%=userName%>&pageSize=<%=pageSize%>&currPage=<%=currPage%>');
		sysCtrl.initViewPage(oDom);
		//clsDynamicSelect$init("", "<%=contextPath%>/paperclaim.do?method=listPaperclaimReceiveCom");
 	    //clsDynamicSelect$codeToName(new Array('groupName_s'),null);
	}
	
	function toexcel() {
	var  url = "<%=contextPath%>/userListtoExcel.do?function=userRoleToExcel";
    form1.action=url;
    form1.submit();
    }
	
	
	function clsDynamicSelect$onSelectLostFocus2()  {
	  if (clsDynamicSelect$completeDiv==null)  return;
	  if( (clsDynamicSelect$completeDiv.offsetLeft - document.body.scrollLeft) < event.x &&
      event.x < ( clsDynamicSelect$completeDiv.offsetLeft + clsDynamicSelect$completeDiv.offsetWidth - document.body.scrollLeft) &&
      (clsDynamicSelect$completeDiv.offsetTop - document.body.scrollTop)< event.y &&
      event.y < ( clsDynamicSelect$completeDiv.offsetTop + clsDynamicSelect$completeDiv.offsetHeight- document.body.scrollTop ) )
      {}else{
        clsDynamicSelect$clearNames();
        if (clsDynamicSelect$inputField.getAttribute("realvalue")=="") {
			clsDynamicSelect$inputField.setAttribute("value","");	 
		}
    }
    }
    
	function searchMe()
	{
	 
	 var userName=document.getElementById('userName').value;
	 	
	 var roleName=document.getElementById('roleName').value;

	//加query=true 避免重复写日志指在点击查询的时候写
	var oDom = oPublicFunction.getDom('<%=contextPath%>/userRole.do?method=listAllUserRole&query=true&roleName='+roleName+'&userName='+userName+'&pageSize=<%=pageSize%>&currPage=<%=currPage%>');
		
	 sysCtrl.initViewPage(oDom);
		
	   
	
	}
	
	function cancel()
	{
		window.close();
	
	}
	function goToPage(obj)
	{

   var nextPage=<%=currPage%>;
   if('UP'==obj)
     nextPage--;
   if('DOWN'==obj)
     nextPage++;
   if('START'==obj)
     nextPage=1;
   if('END'==obj)
    nextPage=document.getElementById("totalPages").value;
   
   
   if('GO'==obj){
   	 nextPage=document.getElementById("goPage").value;
   }
   
   var totalPages = document.getElementById("totalPages").value;
   
   var currPage=document.getElementById('currPage').value;
   
   var pageSize=document.getElementById('pageSize').value;
   var goPage=document.getElementById('goPage').value;
   
   if(parseInt(nextPage)>parseInt(totalPages)){
      currPage = totalPages;
      nextPage = totalPages;
   }

   if(parseInt(currPage)>parseInt(totalPages)){
      currPage = totalPages;
      nextPage = totalPages;
   }
   
	    var url="userRole.jsp?roleName=<%=roleName%>&userName=<%=userName%>&currPage="+nextPage+"&pageSize="+pageSize;
	    //alert(url);
		window.location.href=url;
	    //hidden_button(insertordelete);
	}
	
	function chooseUser(){
	   var users=window.showModalDialog('popup/selectUsersByGID.jsp','userWin');
	   alert(users);
	}
	function roleMng(){
	   var url='roleList.jsp';
	   window.location.href=url;
	}
	function createRole(){
	   window.location.href="roleCreate.jsp";
	}
	function update() {
		var tableCtrl = sysCtrl.getCtrl("userRoleList");
		var rowIndex=tableCtrl.getCurRowIndex();
		var roleId = tableCtrl.getRowData(rowIndex).get("roleId");
		window.location.href = "role2Users.jsp?roleId="+roleId;
	}
	function editMe(){
		var tableCtrl = sysCtrl.getCtrl("userRoleList");
		var rowIndex=tableCtrl.getCurRowIndex();
		var roleId = tableCtrl.getRowData(rowIndex).get("roleId");
		var url="roleEdit.jsp?roleId="+roleId;
	    window.location.href=url;
	}
	function deleteMe(){
		var tableCtrl = sysCtrl.getCtrl("userRoleList");
		var rowIndex=tableCtrl.getCurRowIndex();
		var roleId = tableCtrl.getRowData(rowIndex).get("roleId");
		var roleName = tableCtrl.getRowData(rowIndex).get("roleName");
		var oDom=oPublicFunction.getDom("<%=contextPath%>/userRole.do?method=deleteRole&deleteIds="+roleId+"&roleName="+roleName);
		window.location.reload();
	}
</script>
</head>
<body onLoad="initView()">

<form name="form1" method="post" action="<%=contextPath%>/userRole.do?method=listAllUserRole" >

<table cellSpacing=1 cellPadding=1 width="100%" border=1>

<tr><td>选择角色：</td><td>
<!-- input type="text" name="roleName_s" id="roleName_s" title="角色" size="20" /-->
<input type="text" name="roleName" id="roleName" title="角色" size="20" />
</td>
<!-- <td>人员名称：</td><td>
<!--input type="text" name="userName_s" id="userName_s" title="人员">
<input type="text" name="userName" id="userName" title="人员"/>
 -->
</td>
<td><input type="button" class="Whitetext" value="查询" name="sb" id="sb" onclick="searchMe();"/>&nbsp;&nbsp;
<input type="button" class="Whitetext" value="新增" name="sb2" id="sb2" onclick="createRole();"/></td></tr>
<input name="search" align="right" type="button" class="Whitetext" onclick="toexcel();" value="导出Excel" />
</table>


  
  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=1  name="userRoleList" type="tblresult" align="center">
    <TR class="popupmenu_option" >
       
        <td valign="middle" align=center width=20%><span>角色名称</span></td>
		
		<td valign="middle" align=center><span>角色备注</span></td>
		<td valign="middle" width=12%><div align='center'>操  作</div></td>
    </TR>
    <TR class=trbg0 name="item">
        <TD align="center">
         <input type="hidden" name="id" id="id">
          <input type="hidden" name="roleId" id="roleId">
        <label class="must" id="roleName" name="roleName" /></TD>
        <TD align="center"><label class="must" id="userName" name="userName" /></TD>
		<TD align="center"><a href='#' onclick="editMe();"/>编辑</a><!-- |<a href='#' onclick="update();"/>人员</a> --> |<a href='#' onclick="deleteMe();"/>删除</a></TD>
    </TR>
     <tr name="fenyeCtrl" isShow="false" itemNum="1">
        <td class="listValue" align="right" colspan="4">
            <label name="增行" isShow="false"></label>
            <label name="删行" isShow="false"></label>
        </td>
    </tr>
    <tr name="fenyeCtrl" isShow="false" itemNum="1" >
      <td colspan="3">&nbsp;</td>
     
			<jsp:include page="../rmbs/page.jsp" />
    </tr>
    
</TABLE>
</form>
</body>
</html>