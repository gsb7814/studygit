<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page import="com.opensymphony.xwork2.util.*"%>
<%@ page import="com.sxmccitlab.pcash.po.Staff"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>

		<title>�ʲ���ծ���Ŀ���ܱ�</title>
		<link href="../images/text.css" rel="stylesheet" type="text/css" />
		
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
					��ǰλ�ã�
					<a href="../index.htm">��ҳ</a> &gt;&gt; ���񱨱� &gt;&gt; �ʲ���ծ���Ŀ���ܱ�
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="#333333">
					<img src="../images/11Dot.gif" width="1" height="1" />
				</td>
			</tr>
		</table>
		<br />
		<s:form method="post"
			action="/reportMng/findBySales_Department_debt.action">
			<table id="table" width="1314" border="0" align="center"
				cellpadding="0" cellspacing="1" bgcolor="#999999">
				<tr>
					<td height="25" colspan="13" align="left" bgcolor="#E8E8E8">
						<div align="center">
							<table width="400" border="0" align="left" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="37">
										<div align="center">
											<img src="../images/icon_arrow_table.gif" width="9"
												height="9" />
										</div>
									</td>
									<td class="Title">
										<div align="left">
											�ʲ���ծ���Ŀ���ܱ�-<%
											String branch_name = (String) ActionContext.getContext().getSession()
														.get("branch_name_debt");
												out.println(branch_name);
										%>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>

					<td height="40" align="left">
						�·�ѡ��
					</td>
					<td>
						<s:select list="{'2010','2011','2012','2013','2014'}"
							name="year_sales" value="2010" />
						��
					</td>
					<td>
						<s:select
							list="{'01','02','03','04','05','06','07','08','09','10','11','12'}"
							name="month_sales" headerValue="01" />
						��
					</td>
					<td>
						<s:submit name="search"  value="��ѯ"  method="findBySales_Department"/>
					</td>


				</tr>
				<tr>
					<td width="100" align="left" bgcolor="#FAFAFA">
						<div align="center">
							<strong>��Ŀ���</strong>
						</div>
					</td>
					<td width="100" align="left" bgcolor="#FAFAFA">
						<div align="center">
							<strong>��Ŀ����</strong>
						</div>
					</td>
					<%
						List lst2 = (List) ActionContext.getContext().getSession().get(
									"Sales_Department_debt");
							int i = 2;

							if (lst2 != null && lst2.size() > 0) {
								Iterator iter2 = lst2.iterator();
								while (iter2.hasNext()) {
									Object objs2 = (Object) iter2.next();
					%>
					<td  align="left" bgcolor="#FAFAFA">
						<div align="center">
							<strong> <%
 	out.println(objs2);
 %> </strong>
						</div>
					</td>
					<%
						}
							}
					%>
				</tr>
				<%
					List lst = (List) ActionContext.getContext().get(
								"monthsales_debt");					
						if (lst != null && lst.size() > 0 ) {
							Iterator iter = lst.iterator();							
							while (iter.hasNext()) {
								Object[] objs = (Object[]) iter.next();
				%>
				<tr>
					<td width="100" align='left' bgcolor='#FFFFFF'>
						<div align='center'>
							<%
								out.println(objs[0]);
							%>
						</div>
					</td>
					<td width="100" align="left" bgcolor="#FFFFFF">
						<div align="center">
							<%
								out.println(objs[1]);
							%>
						</div>
					</td>
					<%
						while (i <= lst2.size() + 1) {
					%>
					<td align="left" bgcolor="#FAFAFA">
						<div align="center">
							<%
								out.println(objs[i]);
												i++;
							%>
						</div>
					</td>

					<%
						}
					%>


					<%
						}
							} 
								
					%>
			
				<tr>
					<td height="25" colspan="13" align="left" bgcolor="#FFFFFF">
						<div align="center">
							<span class="Title"> <s:submit name="export" value="����"   method="Export_Sales_Department"/> 
							</span><span
								class="Title"> <strong><a
									href="assetsAndDebtRepBranch.jsp">���طֹ�˾��ѯ</a>
							</strong>
							</span>
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
