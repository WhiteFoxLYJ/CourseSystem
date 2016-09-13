<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EduadminFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/EduadminRoom.js"></script>
	<script type="text/javascript">
		/* function getName(g) {
		alert("you click it:"+g.id);
		var i=g.id;
		$("#"+i).click(function(){
			 alert("you click it111:"+i); 
			$.getJSON("RoomDelete_test?room_id="+i,function(Addmessage){
				if(Addmessage==0){
					alert("add successful!!!");
					
				}else{
					alert("add error!!!");
				}
			});
		});
		alert("delete end...");
	} */
	</script>
  </head>
  
  <body>
    This is EduadminRoom.jsp<hr>
	用户名:<%=ActionContext.getContext().getSession().get("login_name") %>|| 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %><hr>
   <hr>
        
        <div id="roomAdd">
        	<table id="roomAddTable"  style =" display: ;margin:0 auto;height: auto; width: 800px" border="1">
        		<tr>
        			<td>教室类型</td>
        			<td>
        				<input type="text" id="room_type" name="room_type">
        			</td>
        		</tr>
        		<tr>
        			<td>可容纳人数</td>
        			<td>
        				<input type="text" id="room_scale" name="room_scale" 
        					 onkeyup="value=value.replace(/[^\d]/g,'')"
        				>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2">
        				<input type="button" value="添加新教室" id="Add_NewRoom_Info">
        				<input type="button" value="清空输入的信息" id="Clear_Info_Room">
        			</td>
        		</tr>
        	</table>
        </div>
        <hr>
        <div id="roomInfo">
        	<table id="roomInfoTable" style =" display:;margin:0 auto;height: auto; width: 800px" border="1">
        		<tr>
        			<td>教室编号</td>
        			<td>教室类型</td>
        			<td>可容纳人数</td>
        			<td></td>
        		</tr>
        	</table>
        </div>
  </body>
</html>
