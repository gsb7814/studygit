<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<SCRIPT type=text/javascript>

/***********************************************
* Contractible Headers script- ?Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use. Last updated Oct 21st, 2003.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

var enablepersist="on" //Enable saving state of content structure using session cookies? (on/off)
var collapseprevious="yes" //Collapse previously open content when opening present? (yes/no)

if (document.getElementById){
document.write('<style type="text/css">')
document.write('.switchcontent{display:none;}')
document.write('</style>')
}

function getElementbyClass(classname){
ccollect=new Array()
var inc=0
var alltags=document.all? document.all : document.getElementsByTagName("*")
for (i=0; i<alltags.length; i++){
if (alltags[i].className==classname)
ccollect[inc++]=alltags[i]
}
}

function contractcontent(omit){
var inc=0
while (ccollect[inc]){
if (ccollect[inc].id!=omit)
ccollect[inc].style.display="none"
inc++
}
}

function expandcontent(cid){
if (typeof ccollect!="undefined"){
if (collapseprevious=="yes")
contractcontent(cid)
document.getElementById(cid).style.display=(document.getElementById(cid).style.display!="block")? "block" : "none"
}
}

function revivecontent(){
contractcontent("omitnothing")
selectedItem=getselectedItem()
selectedComponents=selectedItem.split("|")
for (i=0; i<selectedComponents.length-1; i++)
document.getElementById(selectedComponents[i]).style.display="block"
}

function get_cookie(Name) { 
var search = Name + "="
var returnvalue = "";
if (document.cookie.length > 0) {
offset = document.cookie.indexOf(search)
if (offset != -1) { 
offset += search.length
end = document.cookie.indexOf(";", offset);
if (end == -1) end = document.cookie.length;
returnvalue=unescape(document.cookie.substring(offset, end))
}
}
return returnvalue;
}

function getselectedItem(){
if (get_cookie(window.location.pathname) != ""){
selectedItem=get_cookie(window.location.pathname)
return selectedItem
}
else
return ""
}

function saveswitchstate(){
var inc=0, selectedItem=""
while (ccollect[inc]){
if (ccollect[inc].style.display=="block")
selectedItem+=ccollect[inc].id+"|"
inc++
}

document.cookie=window.location.pathname+"="+selectedItem
}

function do_onload(){
getElementbyClass("switchcontent")
if (enablepersist=="on" && typeof ccollect!="undefined")
revivecontent()
}


if (window.addEventListener)
window.addEventListener("load", do_onload, false)
else if (window.attachEvent)
window.attachEvent("onload", do_onload)
else if (document.getElementById)
window.onload=do_onload

if (enablepersist=="on" && document.getElementById)
window.onunload=saveswitchstate

</SCRIPT>

<SCRIPT language=JavaScript type=text/JavaScript>
<!--
var oldElem = null;
function mOvrLeftMenu(src){
	if(src!=oldElem){
	 src.className = 'leftmenu_over';
	}
}

function mClickLeftMenu(src,url){
	if(oldElem&&src!=oldElem)
	  oldElem.className = 'leftmenu_out';
	  oldElem = src;
	  parent.document.Main.location.href = url;
}

function mOutLeftMenu(src){
	if(src!=oldElem){
	  src.className = 'leftmenu_out';
	}
}
//-->
</SCRIPT>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #ddecff;
	background-image: url(images/BgLine.gif);
}
.leftmenu_out {
	BORDER-LEFT: #0d69b2 6px solid; PADDING-LEFT: 5px; BACKGROUND: #1687CB; WIDTH: 170px; CURSOR: hand; COLOR: #ffffff; HEIGHT: 23px
}
.leftmenu_over {
	BORDER-LEFT: #ffc000 6px solid; PADDING-LEFT: 5px; BACKGROUND: #0d69b2; WIDTH: 170px; CURSOR: hand; COLOR: #ffffff; HEIGHT: 23px
}
.leftmenu_three_out {
	PADDING-LEFT: 5px; WIDTH: 170px; BACKGROUND: #ddecff; CURSOR: hand; HEIGHT: 22px
}
td {
	font-size: 12px;
}


a:link {
	color: #333333;
	text-decoration: none;
}
a:visited {
	color: #333333;
	text-decoration: none;
}
a:hover {
	color: #999999;
	text-decoration: underline;
}
.LeftTitle {
	font-size: 14px;
	font-weight: bold;
	color: #FFFFFF;
}
</STYLE>

</head>

<body>
<table width="170" border="0" cellpadding="0" cellspacing="0" bgcolor="#0d69b2">
  <tr>
    <td width="5" height="29" bgcolor="#333333"></td>
    <td width="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
    <td class="LeftTitle">&nbsp;&nbsp;系统菜单</td>
    <td width="40"><div align="center"><img src="images/ArrowDown.gif" width="9" height="5" /></div></td>
  </tr>
  <tr>
    <td colspan="4" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
  </tr>
</table>
<TABLE cellSpacing=0 cellPadding=0 width=170 border=0>
  <TBODY>
  <TR>
    <TD onClick="expandcontent('sc1')" width=170 height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 width=170 border=0>
              <TBODY>
              <TR>
                <TD width="170"><table cellspacing="0" cellpadding="0" width="170" align="center" border="0">
                  <tbody>
                    <tr>
                      <td width="170" class="leftmenu_out" onmouseover="mOvrLeftMenu(this)" 
    onmouseout="mOutLeftMenu(this)"><img height="9" hspace="6" 
      src="images/icon_arrow_leftmenu.gif" 
width="9" />凭证管理</td>
                    </tr>
                  </tbody>
                </table></TD>
              </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD class=switchcontent id=sc1><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../voucherMng/voucherAdd.html" target="infoFrame">填制凭证</a></td>
      </tr>
	        <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../voucherMng/voucherCharge.html" target="infoFrame" class="cd1">凭证记账</a></td>
      </tr>
	        <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td height="24" class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../voucherMng/voucherUncharge.html" target="infoFrame" class="cd1">反记账</a><a href="../pz_mag/pz_search.html" target="infoFrame"></a></td>
      </tr>
	        <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
	        <tr>
        <td height="24" class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../voucherMng/voucherSearch.html" target="infoFrame">查询凭证</a></td>
      </tr>
	        <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      

      
    </table>      </TD>
  </TR>
  <TR>
    <TD onClick="expandcontent('sc2')" height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD><table cellspacing="0" cellpadding="0" width="170" align="center" border="0">
            <tbody>
              <tr>
                <td class="leftmenu_out" onmouseover="mOvrLeftMenu(this)" 
    onmouseout="mOutLeftMenu(this)"><img height="9" hspace="6" src="images/icon_arrow_leftmenu.gif" 
width="9" />期初处理</td>
              </tr>
            </tbody>
          </table></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD class=switchcontent id=sc2><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../beginningMng/voucherInit.html" target="infoFrame">期初凭证补录</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../beginningMng/ledgerInit.html" target="infoFrame" class="cd1">账套初始化</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      
      
      
    </table></TD>
  </TR>
  <TR>
    <TD onClick="expandcontent('sc3')" height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD><table cellspacing="0" cellpadding="0" width="170" align="center" border="0">
            <tbody>
              <tr>
                <td class="leftmenu_out" onmouseover="mOvrLeftMenu(this)" 
    onmouseout="mOutLeftMenu(this)"><img height="9" hspace="6" src="images/icon_arrow_leftmenu.gif" 
width="9" />期末处理</td>
              </tr>
            </tbody>
          </table></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD class=switchcontent id=sc3><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../endingMng/monthCheck.html" target="infoFrame">月结账</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../endingMng/monthCheckSum.html" target="infoFrame">月结账情况汇总表</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
	        <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../endingMng/yearCheck.html" target="infoFrame" class="cd1">年结/转账</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
	        <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../endingMng/yearCheckSum.html" target="infoFrame" class="cd1">年结情况汇总表</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      
    </table></TD>
  </TR>
  <TR>
    <TD onClick="expandcontent('sc4')" height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD><table cellspacing="0" cellpadding="0" width="170" align="center" border="0">
            <tbody>
              <tr>
                <td class="leftmenu_out" onmouseover="mOvrLeftMenu(this)" 
    onmouseout="mOutLeftMenu(this)"><img height="9" hspace="6" src="images/icon_arrow_leftmenu.gif" 
width="9" />帐薄管理</td>
              </tr>
            </tbody>
          </table></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD class=switchcontent id=sc4><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../bookMng/dailyLedger.html" target="infoFrame">现金/银行存款日记账</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../bookMng/detailLedger.html" target="infoFrame" class="cd1">明分类细账</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../bookMng/generalledger.html" target="infoFrame">总分类账</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      
    </table></TD>
  </TR>
  <TR>
    <TD onClick="expandcontent('sc5')" height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD><table cellspacing="0" cellpadding="0" width="170" align="center" border="0">
            <tbody>
              <tr>
                <td class="leftmenu_out" onmouseover="mOvrLeftMenu(this)" 
    onmouseout="mOutLeftMenu(this)"><img height="9" hspace="6" src="images/icon_arrow_leftmenu.gif" 
width="9" />财务报表</td>
              </tr>
            </tbody>
          </table></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD class=switchcontent id=sc5><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../reportMng/profitAndLossRepBranch.html" target="infoFrame">损益类科目汇总表</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="../reportMng/assetsAndDebtRepBranch.html" target="infoFrame">资产负债类科目汇总表</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      

    </table></TD>
  </TR>
  <TR>
    <TD onClick="expandcontent('sc6')" height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD><table cellspacing="0" cellpadding="0" width="170" align="center" border="0">
            <tbody>
              <tr>
                <td class="leftmenu_out" onmouseover="mOvrLeftMenu(this)" 
    onmouseout="mOutLeftMenu(this)"><img height="9" hspace="6" src="images/icon_arrow_leftmenu.gif" 
width="9" />系统管理</td>
              </tr>
            </tbody>
          </table></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD class=switchcontent id=sc6><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="#">系统参数设置</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="#" class="cd1">角色管理</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="#">用户权限管理</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="#">操作日志</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
      <tr>
        <td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="#">系统数据备份</a></td>
      </tr>
      <tr>
        <td height="1" bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
      </tr>
    </table></TD>
  </TR>
</TBODY></TABLE>
  
<table width="170" border="0" cellpadding="0" cellspacing="0" bgcolor="#0d69b2">
  <tr>
    <td width="4" height="16">&nbsp;</td>
  </tr>
  <tr>
    <td bgcolor="#FFFFFF"><img src="images/11Dot.gif" width="1" height="1" /></td>
  </tr>
</table>
</body>
</html>
