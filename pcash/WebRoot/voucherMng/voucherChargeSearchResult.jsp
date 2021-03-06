<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.sxmccitlab.pcash.action.bean.VoucherMngBean"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="../images/text.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="../javascript/voucher.js"></script>
	<title>凭证反记账查询结果</title>
</head>

<body>

	<%
		VoucherMngBean bean1 = new VoucherMngBean();
		bean1 = (VoucherMngBean) request.getAttribute("voucherMngBean");
	%>
	<s:form action="voucherMng_chargeVoucher.action"
		namespace="/voucherMng" target="infoFrame">
		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">

			<tr>
				<td width="80" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>凭证类型</strong>
					</div>
				</td>
				<td width="100" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>凭证编号</strong>
					</div>
				</td>
				<td width="80" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>借方合计</strong>
					</div>
				</td>
				<td width="80" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>贷方合计</strong>
					</div>
				</td>
				<td width="80" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>制证人</strong>
					</div>
				</td>
				<td width="182" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>所在部门</strong>
					</div>
				</td>
				<td width="60" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>状态</strong>
					</div>
				</td>
				<td width="54" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<strong>操作</strong>
					</div>
				</td>
				<td width="54" align="left" bgcolor="#FAFAFA">
					<div align="center">
						<input type="checkbox" name="selectAllcheckbox" value="全选/不选"
							onClick="javascript:selectAll(this,'voucherMngBean.voucherCodeList')" />
					</div>
				</td>
			</tr>
			<s:iterator id="record" value="voucherMngBean.voucher" status="u">
				<tr>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:property value="voucherTypeName" />
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">

						<div align="center">
							<a
								href="../voucherMng/voucherMng_searchVoucherInfo.action?voucherCode=<s:property
									value="voucherCode" />"
								target="_blank"> <s:property value="voucherCode" /> </a>
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:property value="debitSum" />
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:property value="creditSum" />
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:property value="staffName" />
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:property value="unitName" />
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">							
							<s:if test="chargeFlag==00">未记账</s:if>
					  	<s:elseif test="chargeFlag==01">已记账</s:elseif >
					  	<s:elseif test="chargeFlag==10">反记账</s:elseif >
					  	<s:else>状态错误</s:else>
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<a
								href="../voucherMng/voucherMng_showModifyVoucher.action?voucherCode=<s:property
									value="voucherCode" />"
								target="infoFrame"> 修改 </a>
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<input type="checkbox" name="voucherMngBean.voucherCodeList"
								value="<s:property value="voucherCode"/>" />
						</div>
					</td>
				</tr>

			</s:iterator>
			<tr>
				<td height="25" colspan="9" align="left" bgcolor="#FFFFFF">
					<div align="right">
						<div align="right"><%=bean1.getFooter()%>
						</div>
					</div>
				</td>
			</tr>

			<tr>
				<td height="25" colspan="9" align="left" bgcolor="#FFFFFF">
					<div align="right">
						<input name="Submit" type="submit" class="buttonborder" value="记账" />
						&nbsp;
					</div>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
