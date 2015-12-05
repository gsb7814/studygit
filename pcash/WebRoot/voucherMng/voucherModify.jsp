<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>无标题文档</title>
	<link href="../images/text.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="../javascript/voucher.js"></script>
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
				<a href="../index.htm" target="_top">首页</a> &gt;&gt; 凭证管理 &gt;&gt;
				凭证记账 - 修改凭证
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="#333333">
				<img src="../images/11Dot.gif" width="1" height="1" />
			</td>
		</tr>
	</table>
	<br />
	
	<s:form action="voucherMng_modifyVoucher.action"
		namespace="/voucherMng">
		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
			<tr bgcolor="#F3F3F3">
				<td align="left" bgcolor="#F3F3F3">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="37">
								<div align="center">
									<img src="../images/icon_arrow_table.gif" width="9" height="9" />
								</div>
							</td>
							<td width="200" class="Title">
								修改凭证
							</td>
							<td class="TableTitle">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
			<tr bgcolor="#F3F3F3">
				<td colspan="4" align="left" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						bgcolor="#FAFAFA">
						<tr>
							<td width="37">
								<div align="center">
									<img src="../images/ArrowDown.gif" width="9" height="5" />
								</div>
							</td>
							<td width="200" class="TableTitle">
								凭证基本信息
							</td>
							<td class="TableTitle">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="20%" align="left" bgcolor="#FFFFFF">
					<div align="right">
						凭证类型：
					</div>
				</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF">
					<span class="TableTitle"> &nbsp; <s:select label="凭证类型"
							list="voucherMngBean.voucherType" listKey="voucherTypeCode"
							listValue="voucherTypeName" name="voucherMngBean.voucherTypeCode"
							theme="simple"
							value="%{voucherMngBean.voucherBean.voucherTypeCode}"></s:select>
					</span>
				</td>
			</tr>
			<tr>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						凭证编号：
					</div>
				</td>
				<td width="30%" align="left" bgcolor="#FFFFFF">
					&nbsp;
					<s:textfield name="voucherMngBean.voucherCode"
						value="%{voucherMngBean.voucherBean.voucherCode}" readonly="true" />
				</td>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						制证人：
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
					<s:property value="voucherMngBean.voucherBean.staffName" />
				</td>
			</tr>
			<tr>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						凭证日期：
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;<s:date name="voucherMngBean.voucherBean.voucherDate" format="yyyy-MM-dd"/>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						制证人所在部门：
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
					<s:property value="voucherMngBean.voucherBean.unitName" />
				</td>
			</tr>
		</table>
		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
			<tr>
				<td colspan="5" align="left" bgcolor="#FFFFFF">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						bgcolor="#FAFAFA">
						<tr>
							<td width="37">
								<div align="center">
									<img src="../images/ArrowDown.gif" width="9" height="5" />
								</div>
							</td>
							<td width="200" class="TableTitle">
								凭证明细信息
							</td>
							<td class="TableTitle">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="25%" align="left" bgcolor="#FFFFFF">
					<div align="center">
						摘要
					</div>
				</td>
				<td width="25%" align="left" bgcolor="#FFFFFF">
					<div align="center">
						会计科目
					</div>
				</td>
				<td width="12%" align="left" bgcolor="#FFFFFF">
					<div align="center">
						借方金额
					</div>
				</td>
				<td width="12%" align="left" bgcolor="#FFFFFF">
					<div align="center">
						贷方金额
					</div>
				</td>
				<td width="26%" align="left" bgcolor="#FFFFFF">
					<div align="center">
						往来帐明细
					</div>
				</td>
			</tr>
		</table>
		<s:div id="hide" cssStyle="display:none">
			<table width="950" border="0" align="center" cellpadding="0"
				cellspacing="1" bgcolor="#999999">
				<tr>
					<td width="25%" align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:textarea name="voucherMngBean.voucherAbstract"></s:textarea>
						</div>
					</td>
					<td width="25%" align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:select label="会计科目" list="voucherMngBean.account"
								listKey="accountCode" listValue="accountName"
								name="voucherMngBean.accountCode" theme="simple"></s:select>
						</div>

					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:textfield name="voucherMngBean.fdebit"
								onblur="computDebitSum()">
							</s:textfield>
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:textfield name="voucherMngBean.fcredit"
								onblur="computCreditSum()">
							</s:textfield>
						</div>
					</td>
					<td align="left" bgcolor="#FFFFFF">
						<div align="center">
							<s:textarea name="voucherMngBean.currencyDetail"></s:textarea>
						</div>
					</td>
				</tr>
			</table>
		</s:div>

		<s:div id="parent">
			<s:iterator id="record" value="voucherMngBean.voucherDetailBeanList"
				status="u">
				<s:div id="first">
					<table width="950" border="0" align="center" cellpadding="0"
						cellspacing="1" bgcolor="#999999">
						<tr>
							<td width="25%" align="left" bgcolor="#FFFFFF">
								<div align="center">
									<s:textarea name="voucherMngBean.voucherAbstract"
										value="%{voucherAbstract}"></s:textarea>
								</div>
							</td>
							<td width="25%" align="left" bgcolor="#FFFFFF">
								<div align="center">
									<s:select label="会计科目" list="voucherMngBean.account"
										listKey="accountCode" listValue="accountName"
										name="voucherMngBean.accountCode" theme="simple"
										value="%{accountCode}"></s:select>
								</div>
							</td>
							<td align="left" bgcolor="#FFFFFF">
								<div align="center">
									<s:textfield name="voucherMngBean.fdebit" value="%{fdebit}"
										onblur="computDebitSum()">
									</s:textfield>
								</div>
							</td>
							<td align="left" bgcolor="#FFFFFF">
								<div align="center">
									<s:textfield name="voucherMngBean.fcredit" value="%{fcredit}"
										onblur="computCreditSum()">
									</s:textfield>
								</div>
							</td>
							<td align="left" bgcolor="#FFFFFF">
								<div align="center">
									<s:textarea name="voucherMngBean.currencyDetail"
										value="%{currencyDetail}"></s:textarea>
								</div>
							</td>
						</tr>
					</table>
				</s:div>
			</s:iterator>

		</s:div>




		<table width="950" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#999999">
			<tr>
				<td width="25%" align="left" bgcolor="#FFFFFF">
					&nbsp;
				</td>
				<td width="25%" colspan="2" align="left" bgcolor="#FFFFFF">
					<div align="center">
						<strong>合 计</strong>
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					<s:textfield name="voucherMngBean.debitSum"
						value="%{voucherMngBean.voucherBean.debitSum}" />

				</td>
				<td align="left" bgcolor="#FFFFFF">

					<s:textfield name="voucherMngBean.creditSum"
						value="%{voucherMngBean.voucherBean.creditSum}" />
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="25" colspan="5" align="left" bgcolor="#FFFFFF">
					<div align="right">
						<input type="button" onclick="addVoucherDetail();"
							class="buttonborder" value="新增一行" />
						<input type="button" onclick="delVoucherDetail();"
							class="buttonborder" value="删除一行" />

						<input name="Submit2222" type="submit" value="修改凭证"
							class="buttonborder" />
						&nbsp;
					</div>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
