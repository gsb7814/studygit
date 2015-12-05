<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>



<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>填制凭证</title>
	<link href="../images/text.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="../javascript/voucher.js"></script>
	<script type="text/javascript">
var $ = function (id) {
	return "string" == typeof id ? document.getElementById(id) : id;
};

function addEventHandler(oTarget, sEventType, fnHandler) {
	if (oTarget.addEventListener) {
		oTarget.addEventListener(sEventType, fnHandler, false);
	} else if (oTarget.attachEvent) {
		oTarget.attachEvent("on" + sEventType, fnHandler);
	} else {
		oTarget["on" + sEventType] = fnHandler;
	}
};

var Class = {
  create: function() {
	return function() {
	  this.initialize.apply(this, arguments);
	}
  }
}

var Extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
	return destination;
}

var DateSelector = Class.create();
DateSelector.prototype = {
  initialize: function(oYear, oMonth, oDay, options) {
	this.SelYear = $(oYear);//年选择对象
	this.SelMonth = $(oMonth);//月选择对象
	this.SelDay = $(oDay);//日选择对象
	
	this.SetOptions(options);
	
	var dt = new Date(), iMonth = parseInt(this.options.Month), iDay = parseInt(this.options.Day), iMinYear = parseInt(this.options.MinYear), iMaxYear = parseInt

(this.options.MaxYear);
	
	this.Year = parseInt(this.options.Year) || dt.getFullYear();
	this.Month = 1 <= iMonth && iMonth <= 12 ? iMonth : dt.getMonth() + 1;
	this.Day = iDay > 0 ? iDay : dt.getDate();
	this.MinYear = iMinYear && iMinYear < this.Year ? iMinYear : this.Year;
	this.MaxYear = iMaxYear && iMaxYear > this.Year ? iMaxYear : this.Year;
	this.onChange = this.options.onChange;
	
	//年设置
	this.SetSelect(this.SelYear, this.MinYear, this.MaxYear - this.MinYear + 1, this.Year - this.MinYear);
	//月设置
	this.SetSelect(this.SelMonth, 1, 12, this.Month - 1);
	//日设置
	this.SetDay();
	
	var oThis = this;
	//日期改变事件
	addEventHandler(this.SelYear, "change", function(){
		oThis.Year = oThis.SelYear.value; oThis.SetDay(); oThis.onChange();
	});
	addEventHandler(this.SelMonth, "change", function(){
		oThis.Month = oThis.SelMonth.value; oThis.SetDay(); oThis.onChange();
	});
	addEventHandler(this.SelDay, "change", function(){ oThis.Day = oThis.SelDay.value; oThis.onChange(); });
  },
  //设置默认属性
  SetOptions: function(options) {
	this.options = {//默认值
		Year:		0,//年
		Month:		0,//月
		Day:		0,//日
		MinYear:	0,//最小年份
		MaxYear:	0,//最大年份
		onChange:	function(){}//日期改变时执行
	};
	Extend(this.options, options || {});
  },
  //日设置
  SetDay: function() {
	//取得月份天数
	var daysInMonth = new Date(this.Year, this.Month, 0).getDate();
	if (this.Day > daysInMonth) { this.Day = daysInMonth; };
	this.SetSelect(this.SelDay, 1, daysInMonth, this.Day - 1);
  },
  //select设置
  SetSelect: function(oSelect, iStart, iLength, iIndex) {
	//添加option
	oSelect.options.length = iLength;
	for (var i = 0; i < iLength; i++) { oSelect.options[i].text = oSelect.options[i].value = iStart + i; }
	//设置选中项
	oSelect.selectedIndex = iIndex;
  }
};
</script>
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
				<a href="../index.jsp" target="_top">首页</a> &gt;&gt; 凭证管理
				&gt;&gt; 填制凭证
			</td>
		</tr>
		 <tr>
    <td height="1" colspan="3" bgcolor="#333333"><img src="../images/11Dot.gif" width="1" height="1" /></td>
  </tr>
	</table>

	
	<s:form action="voucherMng_addVoucher.action" namespace="/voucherMng">
		<table width="950" border="0" align="center" cellpadding="0"
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
								填制凭证
							</td>
							<td class="TableTitle">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<table width="950" border="0" align="center" cellpadding="0"
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
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						凭证类型：
					</div>
				</td>
				<td width="30%" align="left" bgcolor="#FFFFFF">
					&nbsp;
					<span class="TableTitle"> <s:select label="凭证类型"
							list="voucherMngBean.voucherType" listKey="voucherTypeCode"
							listValue="voucherTypeName" name="voucherMngBean.voucherTypeCode"
							theme="simple"></s:select> </span>

				</td>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						制证人：
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
					<s:textfield name="voucherMngBean.staffName"
						value="%{voucherMngBean.staffName}" readonly="true"></s:textfield>
				</td>
			</tr>
			<tr>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						凭证日期：
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;					
					<s:textfield name="voucherMngBean.voucherDate"></s:textfield>
					<s:property value="voucherMngBean.accountingPeriodName"/>

<select id="idYear"></select> 
<select id="idMonth"></select> 
<select id="idDay"></select> 

<script>
var ds = new DateSelector("idYear", "idMonth", "idDay", {
	MaxYear: new Date().getFullYear(),
	onChange: function(){ $("idShow").innerHTML = this.Year + "/" + this.Month + "/" + this.Day; }
});

ds.onChange();
</script>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					<div align="right">
						制证人所在部门：
					</div>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
					<s:textfield name="voucherMngBean.unitName"
						value="%{voucherMngBean.unitName}" readonly="true"></s:textfield>
				</td>
			</tr>
		</table>
		<table width="950" border="0" align="center" cellpadding="0"
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
				<td width="150" align="left" bgcolor="#FFFFFF">
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
			<s:div id="first">
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
					&nbsp;
					<s:textfield name="voucherMngBean.debitSum"
						id="voucherMngBean.debitSum" readonly="true">
					</s:textfield>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
					<s:textfield name="voucherMngBean.creditSum"
						id="voucherMngBean.creditSum" readonly="true">
					</s:textfield>
				</td>
				<td align="left" bgcolor="#FFFFFF">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="25" colspan="6" align="left" bgcolor="#FFFFFF">
					<div align="right">
						<input type="button" onclick="addVoucherDetail();"
							class="buttonborder" value="新增一行" />
						<input type="button" onclick="delVoucherDetail();"
							class="buttonborder" value="删除一行" />

						<input name="Submit2222" type="submit" value="保存凭证"
							class="buttonborder" />
						<input name="Submit2222" type="button" class="buttonborder"
							value="凭证记账"
							onclick="location.href='voucherMng_showChargeVoucher.action'" />
						&nbsp;
					</div>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>