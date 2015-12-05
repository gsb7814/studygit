<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<import="com.sxmccitlab.pcash.action.impl.*"></import>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>设置期初余额</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="../images/text.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" type="text/css" href="css/dtree.css">

  </head>
  
  <body>
    
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#DDECFF">
			<tr>
				<td height="3" colspan="3" bgcolor="#FFCC00"></td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="#ffffff"></td>
			</tr>
			<tr>
				<td width="12" height="24">
					&nbsp;
				</td>
				<td width="25">
					<img src="../images/PositionDot.gif" width="13" height="13" />
				</td>
				<td>
					当前位置：
					<a href="../SlideIndex.htm">首页</a> &gt;&gt; 期初处理 &gt;&gt; 帐套初始化
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="#333333">
					<img src="../images/11Dot.gif" width="1" height="1" />
				</td>
			</tr>
		</table>
		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
			<tr>
				<td colspan="4" align="left" bgcolor="#E8E8E8">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="37">
								<div align="center">
									<img src="../images/icon_arrow_table.gif" width="9" height="9" />
								</div>
							</td>
							<td width="200" class="Title">
								帐套初始化
							</td>
							<td class="TableTitle">
								&nbsp;
							</td>
						</tr>
					</table>
					<div align="left"></div>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="left" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<div align="left">
									<strong>帐套初始化部门：</strong><s:property value="unitName" />


									<strong>年度：</strong>2010年
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="20%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>会计科目编号</strong>
					</div>
					<div align="center"></div>
				</td>
				<td width="40%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>会计科目名称</strong>
					</div>
				</td>
				<td width="20%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>年初余额</strong>
					</div>
				</td>
				<td width="20%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>确认</strong>
					</div>
				</td>
				
			</tr>	
					
			<s:iterator id="accountTempBeanList" value="accountTempBeanList">
				<tr>
					<td width="10%" align="left" bgcolor="#FAFAFA">
						<div align="center">
							<s:property value="account_code" />
						</div>
					</td>
					<td width="40%" align="left" bgcolor="#FAFAFA">
						<div align="center">
							<s:property value="account_name" />
						</div>
					</td>
					<td width="20%" align="left" bgcolor="#FAFAFA">
						<div align="center">
						<s:form action="accountAction_setBalance?page=initBalancePage" 
					    	namespace="/beginningMng" >
						  <s:textarea  
                            name="initialBalance" 
                            />
                            <s:hidden name="accountHiden" value="%{account_code}"/> 

						</div>
					</td>
					<td width="20%" align="left" bgcolor="#FAFAFA">
						<div align="center">
							
							<s:submit value="确定"></s:submit>
			                </s:form>
						</div>
					</td>
				</tr>
			</s:iterator>	
		</table>

  </body>
</html>
