<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="../../common/error.jsp"
 import="com.ibm.util.ParamUtils,
         com.ibm.admin.UserManager,
         java.util.Iterator,
         com.ibm.admin.User,
         com.ibm.util.StringUtils,
         java.sql.SQLException,
         com.ibm.ApplicationException"%>
<%!
    private static String isSelect(String idString[],long id){
        for(int i=0;i<idString.length;i++)
            if(idString[i].equals(String.valueOf(id)))
                return "checked";
        return "";
    }
%>
<%
    UserManager userManager=UserManager.getInstance();
    int groupID=ParamUtils.getIntParameter(request,"groupID",1);
    String selected=ParamUtils.getParameter(request,"selected","");
    boolean multiSelect=ParamUtils.getBooleanParameter(request,"multiSelect",true);

	String idString[]=StringUtils.split(selected,",");

    Iterator iter=userManager.groupUserNoDel(groupID);

    String inputType=multiSelect ? "checkbox":"Radio";
%>
<html>
<head>
<script language="JavaScript" type="text/JavaScript">
function addMe(id,name){
    var selectedArray=form1.selected.value.split(",");
    var found=-1;
    for(var i=0;i<selectedArray.length-1;i+=2)
        if(selectedArray[i]==id){
            found=i;
            break;
        }

    if(found==-1)
        form1.selected.value+=id+","+name+",";
    else{
        form1.selected.value="";
        for(var j=0;j<selectedArray.length-1;j+=2)
            if(j!=found)
                form1.selected.value+=selectedArray[j]+","+selectedArray[j+1]+",";
    }
}
</script>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<form name="form1" method="post" action="">
  <%if(!iter.hasNext()) out.println("本单位没有用户。");%>
  <%for(int i=0;iter.hasNext();i++){
          User user=(User) iter.next(); %>
  <input type="<%=inputType%>"  id="idCheck" name="idCheck" onClick="addMe(this.value,'<%=user.getName()%>')" value="<%=user.getId()%>" <%=isSelect(idString,user.getId())%>><%=user.getName()%>
  <input type="hidden" id="valueHidden" name="valueHidden" value="<%=user.getName()%>">
  <%=(i>0 && i%2==0) ? "<br>":""%>
  <%}%>
  <input type="<%=inputType%>"  id="idCheck" name="idCheck" value="-1" style="display:none">
  <input type="hidden" id="valueHidden" name="valueHidden" value="" style="display:none">
  <%
      String id_name="";
      for(int i=0;i<idString.length;i++){
          User user=null;
          try {
              user = UserManager.getUser(Long.parseLong(idString[i]));
          } catch (Exception e) {
           //   e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
          }
          if(user!=null) id_name+=idString[i]+","+user.getName()+",";
      }
  %>
  <input type="hidden" id="selected" name="selected" value="<%=id_name%>" style="display:none">
</form>
</body>
</html>
