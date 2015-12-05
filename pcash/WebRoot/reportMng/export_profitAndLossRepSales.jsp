<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page import="com.opensymphony.xwork2.util.*"%>
<%@ page import="com.sxmccitlab.pcash.po.Staff"%>
<%@ page contentType="application/vnd.ms-excel"%>
<%
	String filename = new String(("营业部损益类报表").getBytes("GBK"),
			"ISO-8859-1");
	response.addHeader("Content-Disposition", "filename=" + filename
			+ ".xls");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>

		<title>损益类科目汇总表</title>
		

	</head>

	<body>
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
										<img src="../images/icon_arrow_table.gif" width="9" height="9" />
									</div>
								</td>
								<td class="Title">
									<div align="left">
										损益类科目汇总表-<%
										String branch_name = (String) ActionContext.getContext()
												.getSession().get("branch_name");
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
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>科目编号</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>科目名称</strong>
					</div>
				</td>
				<%
					List lst2 = (List) ActionContext.getContext().getSession().get(
							"Sales_Department");
					int i = 2;

					if (lst2 != null && lst2.size() > 0) {
						Iterator iter2 = lst2.iterator();
						while (iter2.hasNext()) {
							Object objs2 = (Object) iter2.next();
				%>
				<td align="left" bgcolor="#FAFAFA">
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
				List lst = (List) ActionContext.getContext().get("monthsales");
				List lst1 = (List) ActionContext.getContext().get("yearsales");
				if (lst != null && lst.size() > 0 && lst1 != null
						&& lst1.size() > 0) {
					Iterator iter = lst.iterator();
					Iterator iter1 = lst1.iterator();
					while (iter.hasNext() && iter1.hasNext()) {
						Object[] objs = (Object[]) iter.next();
						Object[] objs1 = (Object[]) iter1.next();
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
							out.println(objs[i] + "/" + objs1[i]);
										i++;
						%>
					</div>
				</td>

				<%
					}
				%>


				<%
					}
					} else if (lst1 != null && lst1.size() > 0) {
						Iterator iter1 = lst1.iterator();
						while (iter1.hasNext()) {
							Object[] objs1 = (Object[]) iter1.next();
				%>

				<tr>
					<td width="100" align='left' bgcolor='#FFFFFF'>
						<div align='center'>
							<%
								out.println(objs1[0]);
							%>
						</div>
					</td>
					<td width="100" align="left" bgcolor="#FFFFFF">
						<div align="center">
							<%
								out.println(objs1[1]);
							%>
						</div>
					</td>
					<%
						while (i <= lst2.size() + 1) {
					%>
					<td align="left" bgcolor="#FAFAFA">
						<div align="center">
							<%
								out.println("0" + "/" + objs1[i]);
											i++;
							%>
						</div>
					</td>
					<%
						}
					%>
				</tr>
				<%
					}
					}
				%>
			
		</table>
	</body>
</html>
