<%@ page contentType="text/html; charset=GBK" language="java" errorPage="../common/error.jsp"%>
<%!String functionNo="1004";%>
<%@ include file="../common/global.jsp" %>
<%

    Role currentRole=RoleManager.getRoleByID(loginedUser.getRoleID());
	long curentroleid=0;
	if(currentRole !=null){
		curentroleid=currentRole.getId();
	}
    long roleId=ParamUtils.getLongParameter(request,"roleId",curentroleid);  //角色
    int start = ParamUtils.getIntParameter(request,"start",0);  //开始记录
    if(start<0) start=0;
    int end = start+20;
	int count=UserRoleManager.getRoleUsers(roleId).size();  //角色下用户的数量
    String title ="角色管理";
    Role role = null;
    UserRole userRole = null;
    long deleteRoleId = loginedUser.getRoleID();
    boolean del=request.getParameter("del") != null;
    if (del)  //删除
    {
    	long deleteUserId = ParamUtils.getLongParameter(request,"deleteUserId",0);
    	deleteRoleId = ParamUtils.getLongParameter(request,"deleteRoleId",0);
    	UserRoleManager.deleteUserRole(deleteUserId,deleteRoleId);
    }
    String result = ParamUtils.getParameter(request,"result","");  //返回的操作结果
    String userNames = "";
    //为空表示全部用户增加成功,没有提示.不为空,则把插入不成功的用户取出
    if (!result.equals(""))
    {
    	String[] users = StringUtils.split(result,";");
    	for(int i=0;i<users.length;i++)
    	{
    	   userNames += UserManager.getUser(Long.parseLong(users[i])).getName();
    	   userNames +=";";
    	}    	
    }
%>
<html>
<head>
<title><%=title%></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../style/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style1 {
	color: #666666;
	font-weight: bold;
}
.style2 {color: #666666}
body,td,th {
	font-family: 新宋体, 宋体, Arial, Courier;
}
.float {
	border: 1px solid #EFEFEF; 
	background-color: #EFEFEF; 
	layer-background-color: #EFEFEF; 
	display:none;
	float:inherit;
	position:absolute; 
	left:60%;
}
-->
</style>
<script language="JavaScript">	
function create(){
	thisForm.action = "createUserRole.jsp";
	thisForm.submit();
}
function del(){
	thisForm.del.value = "true";
	thisForm.action = "usersRoles.jsp?roleId=<%=deleteRoleId%>";
	thisForm.submit();
	}
function setValue(userId,roleId){
  thisForm.deleteUserId.value = userId;
  thisForm.deleteRoleId.value = roleId;
}
function changePage(start,end){
		thisForm.start.value = start;
		thisForm.end.value = end;
		thisForm.submit();
}
</script>
</head>
<BODY> 
<%@ include file="../common/title.jsp" %> 

<form action="" method="post" name="thisForm"> 
  <table cellpadding="0" cellspacing="0" border="0" width="90%"> 
    <tr> 
      <td valign="top"> <table cellpadding="0" cellspacing="0" border="0" width="100%"> 
	  <tr> 
            <td width="20%" bgcolor="#DEE3F7"> <table cellpadding="3" cellspacing="0" border="0" width="100%"> 
                <tr> 
                  <td> <b> <font size="2"> 角色列表 </font> </b></td> 
                </tr> 
              </table></td> 
            <td width="80%" bgcolor="#DEE3F7"> <table cellpadding="3" cellspacing="0" border="0" width="100%"> 
                <tr> 
                  <td> <font size="2"> <b> <%if (!result.equals("")){%><font color="#FF0000"><%=userNames%>用户角色已经拥有或为用户默认角色,请检查.</font><%}%></b> </font> </td> 
                </tr> 
              </table></td> 
          </tr>
          <tr bgcolor="#ffffff"> 
          <td width="140" valign="top" bgcolor="F7F9FF"> 
        <%
		  Iterator iter=RoleManager.getParentToChildPath(curentroleid,roleId);
		  if(iter.hasNext()){
			  role=(Role) iter.next();
		  %>
        <table cellpadding="2" cellspacing="0" border="0" width="100%">
                <tr nowrap>
                  <td width="1%"><img src="../images/indexleft_03.gif" border="0"></td>
                  <%  if (roleId==role.getId()) { %>
                  <td width="99%" nowrap>
                    <%  } else { %>
                  <td width="99%" nowrap>
                    <%  } %>
                    <font size="-1" face="arial"> <b><a href="usersRoles.jsp?roleId=<%= role.getId() %>"><%=role.getName() %></a></b>
                    </font> </td>
                </tr>
              </table>
            
        <%
			out.println(JspMethod.showUserRoleTree( role, iter,1, roleId));
		  }
		 %>
      </td>
            <td valign="top" width="700"> <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tr> 
                  <td width="1%"> <img src="../images/blank.gif" width="20" height="8" border="0"> </td> 
                  <td  width="99%"> <table cellpadding="0" cellspacing="0" border="0" width="100%"> 
                      <tr> 
                        <td> <table cellpadding="0" cellspacing="1" border="0" width="100%"> 
                            <tr> 
                              <td width="30%" nowrap height="20" background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">姓名</font></strong></td>
                              <td width="30%" nowrap height="20" background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">单位名称</font></strong></td>
                              <td width="40%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">用户角色</font></strong>&nbsp;</td> 
                             </tr> 
                             <%
                             
                         iter=UserRoleManager.getRoleUsers(roleId,start,end);
							while(iter.hasNext()){
								userRole=(UserRole) iter.next();
							%>
							<tr> 
							  
                              <td width="30%" nowrap height="20" background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">
                                 <input name="id" type="radio" id="id" onclick="javascript:setValue('<%=userRole.getUserId()%>','<%=userRole.getRoleId()%>');"> 
							     <%=UserManager.getUser(userRole.getUserId()).getName()%></font></strong>
							  </td>
							  <td width="30%" nowrap height="20" background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">
                                 <%
                                  		long groupId = UserManager.getUser(userRole.getUserId()).getGroupID();
                                  		Group group = GroupManager.getGroupByID(groupId);
                                  		String grpname="";
                                  		String pname="";
                                  		if(group!=null){
                                  				grpname=group.getName();
                                  				Group pgroup=GroupManager.getParentById(group);
                                  				
                                  				if(pgroup!=null) 
                                  					pname=pgroup.getName();
                                  				
                                  				if(!"".equals(pname)){
                                  					pname= pname+"/"+grpname;                                  			
                                  				}else
                                  					pname= grpname;
                                  		}
                                  		
                                 %><%=pname  %></font></strong>
							  </td>
                              <td width="40%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0"><%=RoleManager.getRole(userRole.getRoleId()).getName()%></font></strong>&nbsp;</td> 
                             </tr> 
                            <%}%>
                            <tr> 
                              <td height="35" colspan="7" style="font-size:12px "> 
                                <input type="button" value="增加" class="stedit" onclick="javascript:create()">&nbsp;
                               
                                <input type="submit" value="删除" name="del" class="stedit" onclick="javascript:del()">&nbsp;
                              <%if(count>20){	//翻页操作
									int lastPage = ((count/(20))*20);
							  %> 
                                <%if(start > 0){ %> 
                                <a href="javascript:changePage(0,20);">首页</a> 
                                <a href="javascript:changePage(<%=start-20%>,<%=start%>);">上一页</a> 
                                <%}%> 
                                <%if(start+20 < count){%> 
                                <a href="javascript:changePage(<%=start+20%>,<%=start+40%>);">下一页</a> 
                                <%}%> 
                                <%if(start+20<count){%> 
                                <a href="javascript:changePage(<%=lastPage%>,<%=lastPage+20%>);">末页</a> 
                                <%}%> 
                                (共<%if (count%20==0) out.println(count/20);else out.println(count/20+1);%>页，当前第<%=start/20 + 1%>页)
                                <%}%>
                                
                             </td> 
                            </tr>
                    </table></td> 
                </tr> 
              </table></td> 
          </tr> 
         
        </table> 
        <br></td> 
    </tr> 
  </table> 
  </td> 
  </tr> 
  </table> 
  <input type="hidden" name="deleteUserId" value=""> 
  <input type="hidden" name="deleteRoleId" value=""> 
  <input type="hidden" name="start" value="<%=start%>">
  <input type="hidden" name="end" value="<%=end%>">
</form> 
<%@ include file="../common/footer.jsp" %>
