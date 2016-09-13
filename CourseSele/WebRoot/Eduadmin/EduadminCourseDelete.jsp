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
	<script type="text/javascript" src="js/EduadminCourseDelete.js"></script>
	<script type="text/javascript">
		function getName(g) {
//		alert("you click it:"+g.id);
		var i=g.id;
		$("#"+i).click(function(){
			$.getJSON("DeleteCourse?CourseId="+i,function(Addmessage){
				if(Addmessage==0){
					alert("删除课程信息成功!!!");
					location.replace(location.href);
				}else{
					alert("删除课程信息失败!!!");
					location.replace(location.href);
				}
			});
		});
		alert("delete end...");
	}
	</script>
  </head>
  
  <body>
    This is EduadminRoomDelete.jsp<hr>
	用户名:<%=ActionContext.getContext().getSession().get("login_name") %>|| 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %><hr>
	<input type="button" value="刷新信息" id="fr_button"/>
	<div id="info"></div>
        
  </body>
</html>
