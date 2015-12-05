<%@ page contentType="text/html; charset=GBK" language="java"%>
 <%@ page errorPage="../common/error.jsp"%>
<%!String functionNo="1002";%>
<%@ include file="../common/global.jsp" %>
<%! // Global vars
    static final int[] RANGES = {15, 30, 50, 100};
%>
<% 	
    String contextPath = request.getContextPath();

    Role currentRole=RoleManager.getRoleByID(loginedUser.getRoleID());
	
	int cityID =0;//(int)GroupManager.getL2Group(loginedUser.getGroupID()).getId();
	//System.out.println("roles.jsp:User Info: GROUPID:"+loginedUser.getGroupID()+" CityID:"+cityID);
	int rootFunID =1;// FunctionManager.getMinFunID(cityID);
	
	long roleID=ParamUtils.getLongParameter(request,"roleid",1);
	System.out.println("roles.jsp:User Info: roleid=:"+roleID);

	long selectFunctionID=ParamUtils.getIntParameter(request,"selectFunctionID",rootFunID);
	long selectNonFunctionID=ParamUtils.getIntParameter(request,"selectNonFunctionID",rootFunID);
	if(selectNonFunctionID==1) selectNonFunctionID=1;
	
    int start = ParamUtils.getIntParameter(request,"start", 0);
    if(start<0) start=0;
	int range = ParamUtils.getIntParameter(request,"range", 15);

    UserManager userManager =UserManager.getInstance();
    int userCount=userManager.getRoleUserCountNoDel(roleID);
    
	Role selectedRole =RoleManager.getRoleByID(roleID);

	Role role=null;
	Function function=null;
	boolean removeFunction=request.getParameter("removeFunction")!=null;
	boolean addFunction=request.getParameter("addFunction")!=null;
	if(removeFunction){
		long[] functionSelect =ParamUtils.getLongParameters(request,"functionRemoveSelect",0);
        if(functionSelect.length>0){
            //selectedRole.setFunction(RoleFunctionManager.removeSelectedFunction(selectedRole,functionSelect));
            //RoleManager.updateRole(selectedRole);
           System.out.print("Removing mennu from had lists");
            RoleFunctionManager.removeSelectedFunction(
            			selectedRole.getId(),
            			functionSelect,
            			loginedUser.getId(),
            			loginedUser.getName(),
            			GroupManager.getL2Group(loginedUser.getGroupID()).getId(),
            			GroupManager.getL2Group(loginedUser.getGroupID()).getName(),
            			request,
            			cityID);
        }
       
	}
	else if(addFunction){
		long[] functionSelect = ParamUtils.getLongParameters(request,"functionAddSelect",0);
        if(functionSelect.length>0){
            //selectedRole.setFunction(RoleFunctionManager.addSelectedFunction(currentRole,selectedRole.getFunction(),functionSelect));
            //RoleManager.updateRole(selectedRole);
            System.out.print("Start... add mennu");
            RoleFunctionManager.addSelectedFunction(currentRole.getId(),
            										roleID,
            										functionSelect,
            										loginedUser.getId(),
            										loginedUser.getName(),
            										GroupManager.getL2Group(loginedUser.getGroupID()).getId(),
            										GroupManager.getL2Group(loginedUser.getGroupID()).getName(),
            										request,cityID);
            System.out.print("End... add mennu");
        }
        
	}
	
%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=gb2312">
<title>权限管理</title>
<link href="../style/css.css" rel="stylesheet" type="text/css">
<LINK href="<%=contextPath %>/rmbs/css/main.css" type="text/css" rel="stylesheet"> 
<link href="<%=contextPath %>/rmbs/css/form.css" type="text/css" rel="stylesheet">
<script language="JavaScript">
	
	
	<%
	if(removeFunction||addFunction){
	

	%>
	window.location.href="roles.jsp?roleid=<%=roleID%>";
	<%}%>
	function selectAll()
	{		
		for (var i=0;i<thisForm.elements.length;i++)
		{
			var e = thisForm.elements[i];
			if(e.name == "roleID")				
				e.checked = thisForm.allID.checked;						
		}
	}
	function editSubmit()
	{
		var number = 0;
		for (var i=0;i<thisForm.elements.length;i++)
		{
			var e = thisForm.elements[i];						
			if(e.name == "roleID")				
			{			
				if(e.checked)
					number = number + 1;
			}							
		}
		if(number == 0)
		{
			alert("请选择要修改的权限");
			return false;
		}
		if(number > 1)
		{
			alert("一次只能修改一个权限！");
			return false;
		}		
		thisForm.action = "editRole.jsp";
		thisForm.submit();
	}
	
	function deleteSubmit()
	{
		var number = 0;
		for (var i=0;i<thisForm.elements.length;i++)
		{
			var e = thisForm.elements[i];						
			if(e.name == "roleID")				
			{			
				if(e.checked)
					number = number + 1;
			}							
		}
		if(number == 0)
		{
			alert("请选择要删除的权限");
			return false;
		}		
		thisForm.action = "removeRole.jsp";
		thisForm.submit();
	}
	
	function toexcel() {
	   var  url = "<%=contextPath%>/userListtoExcel.do?function=roleToExcel";
       form1.action=url;
       form1.submit();
    }
    function toLogexcel() 
{
    var  url = "<%=contextPath%>/rmbs/toExcel.do?reporttype=O";
    form1.action=url;
    form1.submit();
}
</script>

<style type="text/css">
<!--
.style31 {font-family: Arial, Helvetica, sans-serif}
.style12 {font-size: 14px;
	font-weight: bold;
	color: #000000;
}
-->
</style>
</head>
<body topmargin="0" leftmargin="0">
<form name="form1" method="post" action="" >
</form>

  <form action="roles.jsp" name="thisForm" method="post">   
  <input type="hidden" name="roleid" value="<%=roleID%>">
  
  <table cellpadding="0" cellspacing="0" border="0" width="100%" valign='top' height='100%' >
  <tbody>
    <tr height="19" >
            
      <td  style="width:140px;" align='left'>
     
      
      &nbsp;<img alt="" src="<%=contextPath%>/images/role.png">&nbsp;<b><font size="2">角色列表 </font>   
        
      </td>
 
      <td width="85%" > 
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
                
            <td height="20" align="center">&nbsp;<img src="<%=contextPath%>/image/icon/icon_liulan.gif"> <b><font size="2"> ( <%=RoleManager.getRoleByID(roleID)%> )菜单列表</font></b> 
            </td>
              </tr>
            </table>   
      </td>
      </tr>
      <tr>
      <td colspan=2>
      <input name="search" align="right" type="button" class="Whitetext" onclick="toexcel();" value="导出Excel" /> </b>
      <input name="search" align="right" type="button" class="Whitetext" onclick="toLogexcel();" value="导出账户及账户权限变更Excel" /> </b>
     </td>
     <td>
     
      </td>
      </tr>
          <tr bgcolor="#ffffff"> 
      <td  valign="top" height='100%'> 
      <div style="overflow-Y:auto;overflow-X:auto;width:230px; height:100%;border:1px solid B8CBF6;">
        <%
          //权限列表
		  Iterator iter=RoleManager.getAllRole();
		  if(iter.hasNext()){
			  role=(Role) iter.next();
		  %>
            
        <%
        	//权限列表
			out.println(JspMethod.showRoleTree( currentRole, iter,1, roleID));
		  }
		 %>
		 </div>
      </td>
            <td width="85%" valign="top" bgcolor="#ffffff" valign='top' >
            <div style="overflow-Y:auto;overflow-X:auto;width:100%;height:100%;border:1px solid B8CBF6;">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" height='100%'>
          <tr> 
            <td width="100%" valign='top'>
             <table cellpadding="0" cellspacing="0" border="0" width="100%" valign='top' height='100%'>
             
                <tr bgcolor="#ffffff" valign="top" height='100%'> 
                  <td > 
                   
                    <%
                    	//显示菜单已经功能
						//iter=FunctionManager.getRootToChildPath(selectFunctionID);
		            	System.out.print("开始显示已有功能列表... ");
                    	System.out.println("--rootfunID:"+rootFunID+" selectFunctionID:"+selectFunctionID);
						iter=FunctionManager.getRootToChildPath(rootFunID,selectFunctionID);
						if(iter.hasNext()){
	                    	System.out.println("--hasNext() is true");
							function=(Function) iter.next();
						%>
                    <table cellpadding="0" cellspacing="0" border="0" width="202">
                      <tr> 
                        <td width="1%"><img src="../images/indexleft_03.gif" border="0"></td>
                        <td width="99%"> <a href="roles.jsp?roleid=<%=roleID%>&selectFunctionID=<%=function.getId() %>"> 
                          <font size="-1"> <%=function.getName() %>(已授权功能) </font> </a> 
                        </td>
                      </tr>
                    </table>
                    <div style="overflow-Y:auto;overflow-X:auto;width:100%;height:97%;border:1px solid B8CBF6;">
                    <%
						 // if(!selectedRole.getId().equals("0000"))
                    		System.out.print("显示已有功能列表... ");		                
							out.println(JspMethod.showFunctionTree( loginedUser,function, iter,1,selectFunctionID,selectedRole,true));
						}else
	                    	System.out.println("--hasNext() is false");
						%>
						</div>
                  </td>
                <td width="2%" align="center" nowrap bgcolor="#FFFFFF"> 
                    <INPUT NAME="addFunction" TYPE="submit" VALUE="&lt;&lt;" > 
                    <br> <INPUT NAME="removeFunction" TYPE="submit" VALUE="&gt;&gt;"> 
                  </td>
                  <td> 
                   
                    <%
						//iter=FunctionManager.getRootToChildPath(selectNonFunctionID);
                    	System.out.print("\n开始显示未有功能列表... RootID:"+rootFunID+" SelectedFunID:"+selectNonFunctionID);
						iter=FunctionManager.getRootToChildPath(rootFunID,selectNonFunctionID);
						if(iter.hasNext()){
							System.out.print("\n进入未有功能列表... ");
							function=(Function) iter.next();
						%>
                    <table cellpadding="0" cellspacing="0" border="0" width="200" height='20px'>
                      <tr> 
                        <td width="1%"><img src="../images/indexleft_03.gif" border="0"></td>
                        <td width="99%"><a href="roles.jsp?roleid=<%=roleID%>&selectNonFunctionID=<%=function.getId() %>"> 
                          <font size="-1"> <%=function.getName() %>(未授权功能) </font> </a>
                        </td>
                      </tr>
                    </table>
                    <div style="overflow-Y:auto;overflow-X:auto;width:100%;height:97%;border:1px solid B8CBF6;">
                    <%
						  //	if(!selectedRole.getId().equals("0000"))
                    		System.out.print("\n显示未有功能列表... ,Fun:"+function+"\n");
							out.println(JspMethod.showFunctionTree(loginedUser,function, iter,1,selectNonFunctionID, selectedRole,false));
						}
						%>
						</div>
                  </td>
                </tr>
              </table>
              
              </td>
              
          </tr>
        </table>
        </div>    </td>
          </tr>
          </tbody>

    </table>
    
  </form>

<%@ include file="../common/footer.jsp" %>