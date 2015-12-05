<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page import="com.opensymphony.xwork2.util.*"%>
<%@ page import="com.sxmccitlab.pcash.po.Staff"%>
<%@ page contentType="application/vnd.ms-excel"%>
<%   
    String filename = new String(("分公司资产负债类报表").getBytes("GBK"),"ISO-8859-1");    
    response.addHeader("Content-Disposition", "filename=" + filename + ".xls");   
%>   

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>资产负债类科目汇总表</title>
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
										资产负债类科目汇总表-分公司
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
						<strong>太原分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>大同分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>阳泉分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>临汾分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>朔州分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>运城分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>忻州分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>晋城分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>晋中分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>吕梁分公司</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>长治分公司</strong>
					</div>
				</td>
			</tr>

			<%
				List lst = (List) ActionContext.getContext().get(
						"monthbranch_debt");			
				if (lst != null && lst.size() > 0) {
					Iterator iter = lst.iterator();
					while (iter.hasNext()) {
						Object[] objs = (Object[]) iter.next();
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
							out.println(objs[2]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[3]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[4]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[5]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[6]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[7]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[8]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[9]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[10]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[11]);
						%>
					</div>
				</td>
				<td align="left" bgcolor="#FAFAFA">
					<div align="center">
						<%
							out.println(objs[12]);
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
