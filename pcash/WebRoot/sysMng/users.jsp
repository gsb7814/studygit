<%@ page language="java"  contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%!String functionNo="1004";%>
<%@ page import="com.ibm.org.service.OrgServiceImpl" %>
<%@ include file="../common/global.jsp" %>
<%! // Global vars
    static final int[] RANGES = {15, 30, 50, 100};
%>

<%
	request.setCharacterEncoding("gbk");
  //  PositionManager.getInstance(); 
  	UserManager userManager=UserManager.getInstance();
	//long rootGroupID=loginedUser.getAdminGroupScope();
	Group rootgroup=GroupManager.getL2Group(loginedUser.getGroupID());
	//默认rootGroupID是1
	long rootGroupID =1;
	if(rootgroup!=null)
		rootGroupID=rootgroup.getId();
	
	
    if(rootGroupID==0){
         response.sendRedirect("../admin/Unauthorization.htm");
         return;
    }
    long groupID=ParamUtils.getLongParameter(request,"groupID",rootGroupID);
    //int layer=GroupManager.getLayer(groupID);
	Group group=null;

	int start = ParamUtils.getIntParameter(request,"start", 0);
    if(start<0) start=0;
	int range = ParamUtils.getIntParameter(request,"range", 15);


	String queryKey=ParamUtils.getParameter(request,"queryKey","");
    int userCount=userManager.getGroupRecurUserCountNoDelFromDB(groupID,queryKey);

    //调整orderId
    boolean up = ParamUtils.getBooleanParameter(request,"up");
    boolean down = ParamUtils.getBooleanParameter(request,"down");
    String strSwapOperate = ParamUtils.getParameter(request, "swapOperate" ,"");
	int mIndex = ParamUtils.getIntParameter(request,"mIndex",-1);//更改用户Order不用
    int subUserID=ParamUtils.getIntParameter(request,"subUserID",0);
    int subGroupID=ParamUtils.getIntParameter(request,"subGroupID",0);
    if(subUserID>0){
    	User userObj = UserManager.getUser(subUserID);
    	if (!"".equals(strSwapOperate)) {
			userManager.swapOrder(userObj, strSwapOperate);
		}
    } else if(subGroupID>0){
        if (mIndex != -1) {
            Group groupObj = GroupManager.getGroup(subGroupID);
            //if(groupObj==null) System.out.println("groupObj is null");
            if (up && groupObj!=null) {
                GroupManager.swapOrder(groupObj, (mIndex-1));
                logger.info((up ? "Up group ":"Down group")+groupObj.getName()+" order. "+
                   loginedUser.getUserName()+" from "+request.getRemoteAddr() + ".");
            } else if(down && groupObj!=null){
                GroupManager.swapOrder(groupObj, (mIndex+1));
            }
        }
    }

     // Title of this page and breadcrumbs
    String title ="用户管理";
    String[][] breadcrumbs = {
        {"首页", "../bpms/main.jsp"},
		{"系统管理", "info.jsp"},
		{"用户管理", "users.jsp"}
    };
%>
<html>
<head>
<title><%=title%></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
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
	var isMyself = false;

	function getNum(){
		var num = 0;
		for (var i=0; i<thisForm.elements.length; i++)
		{
			var e = thisForm.elements[i];	
			if(e.name == "id" && e.checked){			
					num = num + 1;
			}							
		}
		return num;
	}

	function create(){
		thisForm.action = "createUser.jsp";
		thisForm.submit();
	}

	function test(){
		alert(isMyself);
	}

	function edit(){
		var num = getNum();
		if(num == 0){
			alert("请选择要修改的用户");
			return;
		}else{
			if(isMyself)
				thisForm.action = "editMyself.jsp";
			else
				thisForm.action = "editUser.jsp";
			thisForm.submit();
		}
	}

	function del(){
		var num = getNum();
		if(num == 0){
			alert("请选择要删除的用户");
			return;
		}else if(isMyself){
			alert("您不能删除自己，请重新选择");
			return;
		}else{ 
			thisForm.action = "removeUser.jsp";
			thisForm.submit();	
		}
	}

	function changePage(start){
		thisForm.start.value = start;
		thisForm.submit();
	}

	function setMyself(object){
		if(object.checked){
			isMyself = true;
		}else{
			isMyself = false;
		} 
	}
	function show(object,tt){	   
		var tleft = tt.offsetLeft;    //TT控件的定位点宽
		while (tt = tt.offsetParent){tleft+=tt.offsetLeft;} 
		object.style.left=tleft+20;
		object.style.display='block';
	}
	function hide(object,tt){ 
		object.style.display='none';
	}
	function swap(operate,strUserId,strGroupId,strStart,strRange) {
		if (operate=="up") {
			thisForm.swapOperate.value = "up";
		} else if (operate=="down") {
			thisForm.swapOperate.value = "down";
		}
		thisForm.action = "users.jsp?subUserID="+strUserId+"&groupID="+strGroupId+"&start="+strStart+"&range="+strRange;
		thisForm.submit();
	}
	
	function addUsers(){
		var tmpUrl="uploadDomino.jsp";
		var width=800;
		var height=window.screen.availHeight/2.5;
		var left=(window.screen.availWidth-width)/2;
		var top=(window.screen.availHeight-height)/2;
		var sFeatures="width="+width+"px,height="+height+"px,resizable=yes/no,left="+left+"px,top="+top+"px";
		tmpUrl+="?"+Math.random();
		window.open(tmpUrl,'_blank',sFeatures,'');
		
	}
</script>
</head>
<BODY> 
<%@ include file="../common/title.jsp" %>
<form name="form1" action="" method="post"> 
  <table width="200" border="0" cellpadding="3" cellspacing="1"> 
    <tr> 
      <td nowrap width="99%"><p><font size="-1"> <b>单位选择： (<%=GroupManager.getGroupByID(groupID)%>)</b> </font> </td> 
      <td nowrap><font size="-1">&nbsp;&nbsp;&nbsp;&nbsp;姓名/关键字：
          <input name="queryKey" type="text" id="queryKey" size="20" value=<%=queryKey==null?"":queryKey%>> 
      </font></td> 
      <td nowrap><font size="-1"> 
        <input name="query" type="submit" value=" 查 询 "> 
        </font></td> 
    </tr> 
  </table> 
</form>


<form action="" method="post" name="thisForm"> 
  <table cellpadding="0" cellspacing="0" border="0" width="90%"> 
    <tr> 
      <td valign="top">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
	  			<tr> 
            		<td width="20%" bgcolor="#DEE3F7">
            			<table cellpadding="3" cellspacing="0" border="0" width="100%"> 
                			<tr> 
                  				<td> <b> <font size="2"> 单位列表 </font> </b> </td> 
                			</tr> 
              			</table>
              		</td> 
            		<td width="80%" bgcolor="#DEE3F7">
            			<table cellpadding="3" cellspacing="0" border="0" width="100%"> 
                			<tr> 
                  				<td> <font size="-2" face="verdana"> <b>&nbsp;</b> </font> </td> 
                			</tr> 
              			</table>
              		</td> 
          		</tr>
          		<tr bgcolor="#ffffff"> 
            		<td valign="top" width="200" background="../images/deploy_two_16.gif">
						<table width="100%" border=0 height="100%" cellspacing="0" cellpadding="0" > 
                			<tr> 
                  				<td valign=top> <font size="2"> 
				                    <%
				                    	Iterator iter=GroupManager.getParentToChildByID(rootGroupID,groupID);
										if(iter.hasNext()){
											group=(Group) iter.next();%> 
                   	 				<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
                      					<tr> 
                        					<td width="1%"><img src="../images/bullet_sm.gif" width="12" height="5" border="0"></td> 
                        					<%if (groupID==group.getId()) { %> 
                        						<td width="99%" bgcolor="#eeeeee"> 
											<%} else { %> 
                        					<td width="99%">
											<%}%> 
                          						<b><a href="../admin/users.jsp?groupID=<%= group.getId() %>"><%=group.getName()%></a></b></td> 
                      					</tr> 
                    				</table> 
				                    <%
										String tableStr=JspMethod.showGroupTree(group, iter,1, groupID,request.getRequestURI());
										if(tableStr!=null && !tableStr.equals("null")){
											out.print(tableStr);
										}
									}
									%> 
                    				</font>
                    			</td> 
                			</tr> 
              			</table>
              		</td>
              		
            		<td valign="top" width="700"> 
            			<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
			                <%
								//if(UserManager.hasAuthorization(loginedUser,"100101"))
								//{
							%> 
                		<tr> 
                  		<td colspan="2">	
                  			<table cellpadding="8" cellspacing="0" border="0"> 
		                      <tr> 
		                        <td nowrap> <span class="style1">&nbsp;&nbsp;<%=GroupManager.getGroupByID(groupID)%>用户</span> </td> 
		                        <td nowrap> <span class="style2"><font size="-1"> 用户数：<%=userCount%> </font><font size="-1" face="arial"> 
		                          <% if(userCount>range){%> 
		                          (</font><font size="-1">每页显示<%=range%>个</font><font size="-1" face="arial">)</font> 
		                          <%}%> 
		                          </span>
		                        </td> 
		                        <td width="99%">　</td> 
		                        <td nowrap align="right"> <% if(userCount>range){%> 
		                          <span class="style2"><font size="-1"> 每页显示用户数: </font></span> 
		                          	<select size="1" name="oRange" id="oRange" onChange="location.href='users.jsp?groupID=<%=groupID%>&start=<%= start %>&range='+this.options[this.selectedIndex].value;"> 
		                            <%  for (int i=0; i<RANGES.length; i++) {
		                            		String selected = "";
				                            if (RANGES[i] == range) {
				                                selected = " selected";
				                            }
				                             %>
		                            		<option value="<%= RANGES[i] %>"<%= selected %>><%= RANGES[i] %> 
		                            		<%  } %> 
                          			</select> 
                          			<%  } %>
                          		</td> 
                      		</tr> 
                    	</table>
                    </td> 
                </tr>
                
                <tr> 
                  <td width="1%"> <img src="../images/blank.gif" width="20" height="8" border="0"> </td> 
                  <td  width="99%">
					<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
                      <tr> 
                        <td> 
                        	<table cellpadding="0" cellspacing="1" border="0" width="100%"> 
	                            <tr> 
	                              <td width="40%" nowrap height="20" background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">姓名</font></strong></td>	                           
	                              <td width="20%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">菜单权限</font></strong>&nbsp;</td>
	                              <td align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">单位</font></strong>&nbsp;</td>
	                              <td width="1%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">岗位编号</font></strong>&nbsp;</td>
	                              <td width="10%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">岗位</font></strong>&nbsp;</td> 
	                              <td width="1%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">序号</font></strong>&nbsp;</td> 
	                              <td width="1%" align="center" nowrap background="../images/line_bg.gif">&nbsp;<strong><font color="#0045D0">排序</font></strong>&nbsp;</td>
	                            </tr> 
                            	<%
			                        List userlist=userManager.groupRecurUserNoDelFromDB(groupID,start,(range+start),queryKey);
									User user=null;
			                        mIndex=0;
			                        int order = 0;
			                        String bgcolor = "";
			                        int dispalyCount=0;
									for(int k=0;k<userlist.size();k++)
									{
			                            bgcolor = order%2==1?"#F7F9FF":"";
										order++;
										user=(User)userlist.get(k);
			                            User lastOrderUser=userManager.getPreviousOrderIDUserNoDel(user);
			                            User nextOrderUser=userManager.getNextOrderIDUserNoDel(user);
			                            /*
										int tempRoleID = (int)user.getRoleID();
										UserNode userNode = UserNodeManager.getInstance().getUserNode((int)user.getId());
										*/

                            	%>
                            	<tr bgcolor="<%=bgcolor%>">
                            		<td>
                            			<%if(loginedUser.getId()!=user.getId()){%> 
                                			<input name="id" type="radio" id="id" value="<%=user.getId()%>"> 
 											<a href="editUser.jsp?id=<%=user.getId()%>" title="编辑用户"><%=user.getName()%></a> 
                                		<% } else { %> 
                                			<input type="radio" name="id" value="0" onclick="javascript:setMyself(this);"> 
											<a href="editMyself.jsp" title="编辑用户"><%=user.getName()%></a> 
                              			<% } %>
									</td>
									
                              		
                              		<td align="center" nowrap>
                              			<a title="点击查看菜单" onMouseOut="javascript:this.style.cursor='point'" onMouseOver="javascript:this.style.cursor='hand'" 
							  				onClick="javascript:window.open('viewUserMenu.jsp?userId=<%=user.getId()%>','_blank','height=680 width=300,left=500 top=50,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no')">
											<font color="#003399">
											<%
											  try{
											  	out.println(RoleManager.getRole(user.getRoleID()));
											  }catch(Exception ex){System.out.println(ex.toString());}
							  				%>
							  				</font>
							  			</a>&nbsp;&nbsp;
							  		</td> 
                              		<td align="center" nowrap> <%=GroupManager.getGroupByID(user.getGroupID())%>&nbsp;&nbsp;&nbsp;</td>
                              		<td align="center" nowrap> <%= user.getorg_position()%></td>
                              		<td nowrap> <%if(PositionManager.getPositionByID(user.getPosId())==null) out.print("&nbsp;");else out.print(PositionManager.getPositionByID(user.getPosId()));%></td> 
                              		<td align=center nowrap><%=user.getOrderId()%></td>
                              		<td >
                              			<%if(user.getGroupID()==groupID){%>
	                              			<table cellpadding="0" cellspacing="0" border="0">
	                                			<tr> 
	                                    			<td> <%  if (lastOrderUser !=null) { %> 
	                                    					<INPUT type="image" src="../images/arrow_up.gif" onclick="swap('up','<%=user.getId()%>','<%=user.getGroupID()%>','<%=start%>','<%=range%>');">
	                                      				<%  } else { %> 
	                                      					<img src="../images/blank.gif" width="13" height="9" border="0" vspace="2" hspace="2"> 
	                                      				<%  } %>
	                                      			</td> 
	                                    			<td> <%  if (nextOrderUser !=null) { %> 
					                                    	<INPUT type="image" src="../images/arrow_down.gif" onclick="swap('down','<%=user.getId()%>','<%=user.getGroupID()%>','<%=start%>','<%=range%>');">
					                                      <%  } else { %> 
					                                      	<img src="../images/blank.gif" width="13" height="9" border="0" vspace="2" hspace="2"> 
					                                      <%  } %>
					                                </td> 
	                                  			</tr> 
	                              			</table>
	                              		<%  } %>
	                              	</td> 
                            	</tr>
                            	
                            <%
                            	mIndex++;
                        		}
							%>
							
                            <tr> 
                               <td colspan="8" valign="top" height="20" background="../images/line_bg.gif" >&nbsp;</td>
                            </tr>
                            
                            <tr> 
                              	<td colspan="8" style="font-size:12px "> 
	                                <input type="button" value="增加" class="stedit" onclick="javascript:create()">&nbsp;
	                                <input type="button" value="修改" class="stedit" onclick="javascript:edit()"> 
	                                <input type="button"  class="stedit" onclick="javascript:window.location.href='batchEditUser.jsp?groupID=<%=groupID%>'" value="批量修改">&nbsp; 
	                                <input type="button" value="删除" class="stedit" onclick="javascript:del()">&nbsp;	
	                                <input type="button" value="批量添加用户" class="stedit" onclick="javascript:addUsers()">&nbsp;	
	                                <%if(userCount>range){	//翻页操作
										int lastPage = ((userCount/(range))*range);
									%> 
	                                <%if(start > 0){ %> 
	                                <a href="javascript:changePage(0);">首页</a> <a href="javascript:changePage(<%=start-range%>);">上<%=range%>个用户</a> 
	                                <%}%> 
	                                <%if(start+range < userCount){%> 
	                                <a href="javascript:changePage(<%=start+range%>);">下<%=range%>个用户</a> 
	                                <%}%> 
	                                <%if(start+range<userCount){%> 
	                                <a href="javascript:changePage(<%=lastPage%>);">末页</a> 
	                                <%}%> 
	                                (共<%=userCount/range%>页，当前第<%=start/range + 1%>页)
	                                <%}%>
								</td> 
                            </tr>
                            
							<tr>
							  <td colspan="8"><br>备注：只有用户所属的科室是当前选择的科室，才可调整用户的顺序。</td>
							</tr>
						</table>
					</td> 
                   </tr>
                  </table>
               </td> 
          	</tr> 
          						<% 
          						
								//} %> 
        </table> 
        <br>
        </td> 
    </tr> 
  </table> 

  <input type="hidden" name="groupID" value="<%=groupID%>"> 
  <input type="hidden" name="start" value=""> 
  <input type="hidden" name="range" value="<%=range%>">
  <INPUT type="hidden" name="swapOperate" value="">


<%@ include file="../common/footer.jsp" %>
