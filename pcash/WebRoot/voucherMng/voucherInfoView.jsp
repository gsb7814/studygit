<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../images/text.css" rel="stylesheet" type="text/css" />
<title>查看凭证明细</title>
</head>

<body>
<br />
<table width="780" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#999999">
  <tr>
    <td colspan="4" align="left" bgcolor="#E8E8E8"><div align="center" class="Title"><s:property value="voucherMngBean.voucherBean.voucherTypeName" /></div>
      <div align="left"></div></td>
  </tr>
  <tr>
    <td colspan="4" align="left" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="50%" height="25"><div align="center">凭证日期：<s:date name="voucherMngBean.voucherBean.voucherDate" format="yyyy-MM-dd"/></div></td>
        <td width="50%"><div align="center">凭证编号：<s:property value="voucherMngBean.voucherBean.voucherCode" /> </div></td>
        </tr>
    </table></td>
  </tr>
  <tr class="TableTitle">
    <td width="285" align="left" bgcolor="#FAFAFA"><div align="center">摘要</div></td>
    <td width="250" align="left" bgcolor="#FAFAFA"><div align="center">会计科目</div></td>
    <td width="120" align="left" bgcolor="#FAFAFA" ><div align="center">借方金额</div></td>
    <td width="120" align="left" bgcolor="#FAFAFA"><div align="center">贷方金额</div></td>
  </tr>
<s:iterator id="record" value="voucherMngBean.voucherDetailBeanList" status="u">
  <tr>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="voucherAbstract" /></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="accountName" /></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="fdebit" /></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="fcredit" /></div></td>
  </tr>
</s:iterator>
  <tr>
    <td colspan="2" align="left" bgcolor="#FFFFFF" ><div align="center" class="TableTitle">合计</div>      </td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="voucherMngBean.voucherBean.debitSum" /></div></td>
    <td align="left" bgcolor="#FFFFFF" ><div align="center"><s:property value="voucherMngBean.voucherBean.creditSum" /></div></td>
  </tr>
  <tr>
    <td colspan="4" align="left" bgcolor="#FFFFFF" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%" height="25"><div align="center">制证人：<s:property value="voucherMngBean.voucherBean.staffName" /></div></td>
        <td width="33%"><div align="center">凭证部门：<s:property value="voucherMngBean.voucherBean.unitName" /></div></td>
        <td width="33%"><div align="center">凭证状态：<s:if test="voucherMngBean.voucherBean.chargeFlag==00">未记账</s:if>
					  	<s:elseif test="voucherMngBean.voucherBean.chargeFlag==01">已记账</s:elseif >
					  	<s:elseif test="voucherMngBean.voucherBean.chargeFlag==10">反记账</s:elseif >
					  	<s:else>状态错误</s:else></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td colspan="4" align="left" bgcolor="#FFFFFF" ><div align="center">
      <input name="Submit32" type="submit" class="buttonborder" value="打印" />
      <input name="Submit3" type="submit" class="buttonborder" value="关闭" onclick="javascript:window.close()" />
    </div></td>
  </tr>
</table>
<div align="center"><br />
</div>
</body>

