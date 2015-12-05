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
		pageSize="10";
	}
	if(goPage==null){
		goPage="0";
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
 <script language="javascript" src="<%=contextPath %>/js/xmlHttp.js"></script>
<link href="<%=contextPath %>/rmbs/css/tab.css" type="text/css" rel="stylesheet">
<LINK href="<%=contextPath %>/rmbs/css/dishui1.css" type="text/css" rel="stylesheet">
<LINK href="<%=contextPath %>/rmbs/css/main.css" type="text/css" rel="stylesheet"> 
<link href="<%=contextPath %>/rmbs/css/form.css" type="text/css" rel="stylesheet">
<script language="javascript">
	//初始化页面
	
	function initView(){
	 
	  
	
	  var oDom = oPublicFunction.getDom('<%=contextPath%>/userRole.do?method=listAllRole');
		
		sysCtrl.initViewPage(oDom);
		
	}
	



	function cancel()
	{
		window.close();
	
	}
	function goToPage(obj)
	{
	  
	   var nextPage=<%=currPage%>;
	   if('UP'==obj)nextPage--;
	   if('DOWN'==obj)nextPage++;
	   if('START'==obj)nextPage=1;
	   if('END'==obj)nextPage=document.getElementById("totalPages").value;
	   if('GO'==obj){
	   	nextPage=document.getElementById("goPage").value;
	   }
	   
	   var currPage=document.getElementById('currPage').value;
	   var pageSize=document.getElementById('pageSize').value;
	   var goPage=document.getElementById('goPage').value;
	   var url="position.jsp";
	//	alert(url);
		window.location.href=url;
	//   hidden_button(insertordelete);
	}
	
	function chooseUser(){
	
		var users=window.showModalDialog('popup/selectUsersByGID.jsp','userWin');
		if(users!=undefined){
		document.getElementById("selectedUsers").value=users;
		}
	}
	function addUsersToPostions(){
	   
		var users=document.getElementById("selectedUsers").value;
		if(users==""){
			alert("请选择人员");
		}
	    var selectedNode=oDocAssistant.oDomDoc.selectNodes("//Doc[@isSel='1']");
        var tempNode;
		var selectedIds;
		if(selectedNode.length<1){
		    alert("请选择岗位");
			return ;
		}
		for(var i =0;i<selectedNode.length;i++)
		{
			tempNode=selectedNode[i];
			
			var name=tempNode.selectSingleNode("DocFields/Field[@Name='posId']").text;
			
			if( i==0 )
				selectedIds = name;
			else
				selectedIds = selectedIds+','+name;
		}
		
	   var oDom=oPublicFunction.getDom("<%=contextPath%>/userPosition.do?method=addUserPosition&users="+users+"&pos="+selectedIds);
		var returnState = oDom.selectSingleNode("root").getAttribute("state");
		var customer_message = oDom.selectSingleNode("root").getAttribute("customer_message");
		var developer_message = oDom.selectSingleNode("root").getAttribute("developer_message");   
		
		if( returnState=='success')
		{
			window.location.reload(); 
		}else{
			alert('错误：'+customer_message);
		}
	}
	function addUsers(){
		var tableCtrl = sysCtrl.getCtrl("roleList");
		 var rowIndex=tableCtrl.getCurRowIndex();
	
		var roleid = tableCtrl.getRowData(rowIndex).get("roleid");
	   var url="role2Users.jsp?roleId="+roleid;
	   window.location.href=url;
	}
	function editMe(){
	  	var tableCtrl = sysCtrl.getCtrl("roleList");
		 var rowIndex=tableCtrl.getCurRowIndex();
	
         var roleid = tableCtrl.getRowData(rowIndex).get("roleid");
	 	var url="roleEdit.jsp?roleId="+roleid;
	    window.location.href=url;
	}
	function createMe(){
		window.location.href="roleCreate.jsp";
	}
	function deleteMe(){
		var selectedNode=oDocAssistant.oDomDoc.selectNodes("//Doc[@isSel='1']");
		var tempNode;
		var deleteIds;
		
		for(var i =0;i<selectedNode.length;i++)
		{
			tempNode=selectedNode[i];
			
			var name=tempNode.selectSingleNode("DocFields/Field[@Name='roleid']").text;
			
			if( i==0 )
				deleteIds = name;
			else
				deleteIds = deleteIds+','+name;
		}

		
		if(deleteIds==undefined){
			alert("请选择要删除的数据");
			return false;
		}
		
	if(confirm('是否删除所选择的角色?')){
		 var xmlHttp=createXMLHttpRequest();
	     xmlHttp.open("GET", "<%=contextPath%>/userRole.do?method=deleteRole&deleteIds="+deleteIds, false);
    xmlHttp.send();
	 var returnStr=xmlHttp.statusText;
	 if('OK'==returnStr){
	    //window.location.href='roleList.jsp';
	    window.location.href='<%=contextPath%>/admin/userRole.jsp';
	 	ajax_done();
	 }	
	 else{
	 	alert('删除角色出错');
	 }	  
		}else{
		  return false;
		} 
		
	}
function go2Main(){
		window.location.href="userRole.jsp";
	}
</script>
</head>
<body onLoad="initView()">
 <input type="button" class="White" name="back" value="返回" onclick="go2Main();" />
  <input type="button" class="White" name="back" value="新增" onclick="createMe();" />
   <input type="button" class="White" name="back" value="删除" onclick="deleteMe();" />
<form name="form1" method="post" action="" >

  
  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=1  name="roleList" type="tblresult" align="center">
   	
    <TR class="popupmenu_option" align="center">
         <TD width="10%" class="popupmenu_option"><input type="checkbox" onClick="ISelect()">选择</TD>
		<td valign="middle" align=center><span>名称</span></td>
        <td valign="middle" align=center><span>操作</span></td>
    </TR>
    <TR class=trbg0 name="item">
    
        <td>
        <input type="checkbox" id="choose" name="choose">
      
      </td>
      
        <TD align="center">
         <input type="hidden" name="roleid" id="roleid">
        <label class="must" id="name" name="name" />
      

        </TD>
       <TD align="center">
       <div>
         <input type="button" class="White" value='编辑' name='addUser' onclick='editMe();'/>
       <input type="button" class="White" value='人员' name='addUser' onclick='addUsers();'/>
</div>
      

        </TD>
		
    </TR>
     <tr name="fenyeCtrl" isShow="false" itemNum="1">
        <td class="listValue" align="right" colspan="4">
            <label name="增行" isShow="false"></label>
            <label name="删行" isShow="false"></label>
			
        </td>
    </tr>
  
    
</TABLE>
</form>
</body>
</html>