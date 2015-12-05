<%@ page language="java" import="java.util.*,com.opensymphony.xwork2.ActionContext" pageEncoding="utf-8"%>
<import="com.sxmccitlab.pcash.action.impl.*"></import>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
   
    <title>月结账</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<body>
		<script language="javascript">
	function checkform() {
	if(confirm('确定要进行结账吗?')){return true;}return false;

	}
</script>

		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#DDECFF">
  <tr>
    <td height="3" colspan="3" bgcolor="#FFCC00"></td>
  </tr>
  <tr>
    <td height="1" colspan="3" bgcolor="#ffffff"></td>
  </tr>
  <tr>
    <td width="12" height="24">&nbsp;</td>
    <td width="25"><img src="../images/PositionDot.gif" width="13" height="13" /></td>
    <td>当前位置： <a href="../index.htm">首页</a> &gt;&gt; 期末处理 &gt;&gt; 月结</td>
  </tr>
  <tr>
    <td height="1" colspan="3" bgcolor="#333333"><img src="../images/11Dot.gif" width="1" height="1" /></td>
  </tr>
</table>
<br />
<table width="780" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#999999">
  <tr>
    <td colspan="5" align="left" bgcolor="#E8E8E8"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="37"><div align="center"><img src="../images/icon_arrow_table.gif" width="9" height="9" /></div></td>
        <td width="200" class="Title">月结账</td>
        <td class="TableTitle">&nbsp;</td>
      </tr>
    </table>
        <div align="left"></div></td>
  </tr>
  <tr>
    <td colspan="5" align="left" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>
								<div align="left">
									<strong>结账部门：
									<%
									String unitNameMonth = request.getAttribute("unitNameMonth").toString();
									out.println(unitNameMonth);
									%>
									
								</div>
								<div align="left"></div>
          <div align="left"></div></td>
        <td width="71" height="25">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td width="22%" align="left" bgcolor="#FAFAFA"><div align="center"><strong>会计期间</strong>
    </div>
    <div align="center"></div></td>
    <td width="22%" align="left" bgcolor="#FAFAFA"><div align="center"><strong>状态</strong></div></td>
    <td width="22%" align="left" bgcolor="#FAFAFA" ><div align="center"><strong>结账人</strong></div></td>
    <td width="22%" align="left" bgcolor="#FAFAFA"><div align="center"><strong>结账时间</strong></div></td>
    <td width="12%" align="left" bgcolor="#FAFAFA"><div align="center"><strong>操作</strong></div></td>
  </tr>
			<s:form action="accountBalanceMonthAction_setMonthCheck" onsubmit="javascript:return checkform()" namespace="/endingMng">
				<s:iterator id="monthCheckTempBeanList" value="monthCheckTempBeanList">
					<tr>
						<td align="left" bgcolor="#FFFFFF">
							<div align="center">
								<s:property value="checkPeriod" />
							</div>
						</td>
						<td align="left" bgcolor="#FFFFFF">
							<div align="center">
								<s:property value="flag" />
							</div>
						</td>
						<td align="left" bgcolor="#FFFFFF">
							<div align="center">
								<s:property value="staffName" />
							</div>
						</td>
						<td align="left" bgcolor="#FFFFFF">
							<div align="center">
								<s:property value="checkTime" />
							</div>
						</td>
						<td align="left" bgcolor="#FFFFFF">
							<div align="center">
                          
                            <s:hidden name="checkFlag" value="%{checkFlag}"/> 
                             <%
                            String checkFlag=request.getAttribute("checkFlag").toString();
                            //out.print(checkFlag);
                            %>  
                            <s:set name="checkFlag" value="%{checkFlag}"/>   
                            <s:set name="flag" value="%{flag}"/>                         
                            <s:if test="#flag == '已结'"><input name="button" type="button"  value="月结" disabled/>	
                            </s:if>
                            <s:else><s:submit value="月结" ></s:submit>        
                            </s:else>
							</div>
						</td>
					</tr>

				</s:iterator>
			</s:form>
		</table>
</body>
</html>

