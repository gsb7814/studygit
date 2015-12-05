<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<SCRIPT type="text/javascript">

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

<SCRIPT language="JavaScript" type="text/JavaScript">
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
    
  <s:iterator value="#session.menus" id="subMenus" status="idx">
	<s:iterator value="#subMenus" id="subMenu" status="st">	
		<s:if test="#st.first">     
  <TR>
    <TD onClick="expandcontent('sc<s:property value="#idx.getIndex()"/>')" width=170 height=20>
      <TABLE height=20 cellSpacing=0 cellPadding=0 width="100%" align="center" border="0">
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
width="9" /><s:property value="menuName"/></td>
                    </tr>
                  </tbody>
                </table></TD>
              </TR></TBODY></TABLE></TD></TR>
              </TBODY>
              </TABLE>
       </TD>
  </TR>
 
  <!-- xxxxxxxx二级菜单开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->    
  
  <TR>
  
  
    <TD class="switchcontent" id="sc<s:property value='#idx.getIndex()'/>">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    	
   
    	<s:property value="menuName"/>
    </s:if>
			
			<tr>
        		<td class="leftmenu_three_out">&nbsp;&nbsp;&nbsp;<img src="images/icon_arrow_leftmenu_2.gif" width="9" height="9" /> <a href="<s:property value="menuPath"/>" target="infoFrame"><s:property value="menuName"/></a></td>
      		</tr>
     	 </table>
    
  	<s:if test="#st.first">     	       
    </TD>
  </TR>
  </s:if>
  	</s:iterator> 
  </s:iterator>
   <!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->     
  
	</TBODY>
</TABLE>
  
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
