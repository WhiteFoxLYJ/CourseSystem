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
    
    <title>My JSP 'StudentFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
  	td {
  		text-align:center
  	}
    tr{    background:#FFF;    }              
  	tr:nth-child(2n){         background:#F9F0F0; } 
 	tr{         background-color: expression((this.sectionRowIndex % 2 == 0) ? "#FFF" : "#F0F0F0" );}

	</style>
	
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/StudentCourseDelete.js"></script>
	<script type="text/javascript">
	function getName(bu) {
		var i=bu.id;
		alert("you click button:"+i); 
		$.getJSON("StuDeleteCour?selectId="+i,function(Addmessage){
			if(Addmessage=="0"){
				alert("退课成功!!!"); 
				location.replace(location.href);
			}else{
				alert("退课失败!!!");
				location.replace(location.href);
			}
		});
		alert("add end...");
	}
	</script>

  </head>
  
  <body>
    This is StudnetCourseDelete.jsp. <hr>
   欢迎	<%=ActionContext.getContext().getSession().get("login_name") %>登录<br>
   您的学号为<%=ActionContext.getContext().getSession().get("login_id") %>
    <hr>
      <table id="RemoveSCourseTable" style =" display: ;margin:0 auto;height: auto; width: 800px" border="1">
      	<tr>
      		<td>课程编号</td>
      		<td>课程名称</td>
      		<td>修读类型</td>
      		<td>授课讲师</td>
      		<td>授课教室</td>
      		<td>退课</td>
      	</tr>
      </table>      
  </body>
</html>
