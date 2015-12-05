<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page import="com.opensymphony.xwork2.util.*"%>
<%@ page import="com.sxmccitlab.pcash.po.Staff"%>
<%@ page contentType="application/vnd.ms-excel"%>
<%   
    String filename = new String(("分公司损益类报表").getBytes("GBK"),"ISO-8859-1");    
    response.addHeader("Content-Disposition", "filename=" + filename + ".xls");   
%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>损益类科目汇总表</title>
	</head>
	
	<body>
		<table width="1314" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
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
										损益类科目汇总表-分公司
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
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url1"
								action="findSales_Department.action">
								<s:param name="regioncode">01</s:param>
							</s:url> <s:a href="%{url1}">
								太原分公司	
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url2"
								action="findSales_Department.action">
								<s:param name="regioncode">02</s:param>
							</s:url> <s:a href="%{url2}">
								大同分公司	
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url3"
								action="findSales_Department.action">
								<s:param name="regioncode">03</s:param>
							</s:url> <s:a href="%{url3}">
									阳泉分公司
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url4"
								action="findSales_Department.action">
								<s:param name="regioncode">04</s:param>
							</s:url> <s:a href="%{url4}">
									临汾分公司
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url5"
								action="findSales_Department.action">
								<s:param name="regioncode">05</s:param>
							</s:url> <s:a href="%{url5}">
								朔州分公司	
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url6"
								action="findSales_Department.action">
								<s:param name="regioncode">06</s:param>
							</s:url> <s:a href="%{url6}">
									运城分公司
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url7"
								action="findSales_Department.action">
								<s:param name="regioncode">07</s:param>
							</s:url> <s:a href="%{url7}">
								忻州分公司	
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url8"
								action="findSales_Department.action">
								<s:param name="regioncode">08</s:param>
							</s:url> <s:a href="%{url8}">
									晋城分公司
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url9"
								action="findSales_Department.action">
								<s:param name="regioncode">09</s:param>
							</s:url> <s:a href="%{url9}">
								晋中分公司
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url10"
								action="findSales_Department.action">
								<s:param name="regioncode">10</s:param>
							</s:url> <s:a href="%{url10}">
								吕梁分公司	
								</s:a> </strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong><s:url id="url11"
								action="findSales_Department.action">
								<s:param name="regioncode">11</s:param>
							</s:url> <s:a href="%{url11}">
								长治分公司
								</s:a> </strong>
					</div>
				</td>
			</tr>

			<%
				List lst = (List) ActionContext.getContext().get(
						"monthbranch");
				List lst1 = (List) ActionContext.getContext().get(
						"yearbranch");
				if (lst != null && lst.size() > 0 && lst1 != null
						&& lst1.size() > 0) {
					Iterator iter = lst.iterator();
					Iterator iter1 = lst1.iterator();
					while (iter.hasNext()) {
						Object[] objs = (Object[]) iter.next();
						Object[] objs1 = (Object[]) iter1.next();
			%>
			<tr>
				<td align='left' bgcolor='#FFFFFF'>
					<div align='center'>
						<%
							out.println(objs[0]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					<div align="center">
						<%
							out.println(objs[1]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[2] + "/" + objs1[2]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[3] + "/" + objs1[3]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[4] + "/" + objs1[4]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[5] + "/" + objs1[5]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[6] + "/" + objs1[6]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[7] + "/" + objs1[7]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[8] + "/" + objs1[8]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[9] + "/" + objs1[9]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[10] + "/" + objs1[10]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[11] + "/" + objs1[11]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[12] + "/" + objs1[12]);
						%>
					</div>
				</td>

			</tr>
			<%
				}
				}

				else if (lst1 != null && lst1.size() > 0) {
					Iterator iter1 = lst1.iterator();
					while (iter1.hasNext()) {
						Object[] objs1 = (Object[]) iter1.next();
			%>
			<tr>
				<td align='left' bgcolor='#FFFFFF'>
					<div align='center'>
						<%
							out.println(objs1[0]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					<div align="center">
						<%
							out.println(objs1[1]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[2]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[3]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[4]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[5]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[6]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[7]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[8]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[9]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[10]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[11]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println("0" + "/" + objs1[12]);
						%>
					</div>
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</body>
</html>
