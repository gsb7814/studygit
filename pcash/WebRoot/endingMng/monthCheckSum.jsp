<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sxmccitlab.pcash.action.bean.MonthCheckSumBean" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="../images/text.css" rel="stylesheet" type="text/css" />
		<title>无标题文档</title>

	</head>

	<body>
	 <%  
  MonthCheckSumBean monthCheckSumBean = new MonthCheckSumBean();
  monthCheckSumBean = (MonthCheckSumBean)session.getAttribute("monthCheckBean");
  request.setAttribute("monthCheckSumBean",monthCheckSumBean);
  System.out.println(monthCheckSumBean.getFooter());
  System.out.println("------------------------------------");
   %>
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
					<a href="../index.htm">首页</a> &gt;&gt; 期末处理 &gt;&gt; 月结情况汇总表
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="#333333">
					<img src="../images/11Dot.gif" width="1" height="1" />
				</td>
			</tr>
		</table>
		<br />
		<s:form action="monthCheckAction" namespace="/endingMng" method="post">
		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
			<tr>
				<td colspan="5" align="left" bgcolor="#E8E8E8">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="37">
								<div align="center">
									<img src="../images/icon_arrow_table.gif" width="9" height="9" />
								</div>
							</td>
							<td width="200" class="Title">
								月结状情况汇总表
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
				<td colspan="5" align="left" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<div align="left">
									<strong>组织范围：</strong><select name="unitCode" ><option value="0">全省</option><option value="01">太原</option></select>
								</div>
								<div align="left"></div>
								<div align="left"></div>
							</td>
							<td width="71" height="25">
								<div align="center">
								<input name="Submit222" type="submit" class="buttonborder"
										value="查询" />
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</s:form>
		
		<table>
			<tr>
				<td width="32%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>三级部门</strong>
					</div>
				</td>
				<td width="12%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>结账人</strong>
					</div>
				</td>
				<td width="12%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>结账时间</strong>
					</div>
				</td>
				<td width="12%" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>结账状态</strong>
					</div>
				</td>
			</tr>
            <s:iterator id="record" value="#request.monthCheckSumBean.accountBalanceList" status="u">
  <tr>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="unitName"/></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="staffName"/></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="checkPeriod"/></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center">已结账</td>
  </tr>	
   </s:iterator>
  <tr>
    <td height="25" colspan="7" align="left" bgcolor="#FFFFFF" ><div align="right">
    <div align="right"><%=monthCheckSumBean.getFooter()%>  </div>
    </div>     </td>
  </tr>
		</table>
	</body>
</html>
