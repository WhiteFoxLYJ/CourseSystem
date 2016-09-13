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
    
    <title>My JSP 'Success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/CoursePlan.js"></script>
  </head>
  
  <body>
  	课程安排页面<br>CoursePlan.jsp<hr>
  	用户名:<%=ActionContext.getContext().getSession().get("login_name") %>|| 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %>
  	<hr>
  	<!-- <a href="getCTRInfo.action">安排课程</a>||
    <a href="##">删除课程</a>||
    <a href="getAllCourse.action">录入课程</a>||
    <a href="/Room.jsp">录入教室</a>||
    <a href="getAllPlan.action">查看所有课程安排</a><hr> -->
 	<%-- <s:form action="AddCoursePlan.action" method="post" > --%>
  	<h3>安排课程</h3><br>请选择相关的信息
  	<table border="1" style =" display: ;margin:0 auto;height: auto; width: 800px">
  		<tr>
  			<td colspan="1">请选择相关的信息</td>
  		</tr>
  		<tr>
	  		<td>
		  		<s:select list="%{#session.rlist}" id="room_id" label="授课教室" headerKey="" headerValue="" listValue="roomId" listKey="roomId " name="room_id" cssStyle="width:200px"/>
		  		
	  		<!-- </td>
  			<td> -->
		  		<s:select list="%{#session.clist}" id="course_id" label="授课课程" headerKey="" headerValue="" listValue="courseName" listKey="courseId " name="course_id" cssStyle="width:200px"/>
		  		
	  		<!-- </td>
	  		<td> -->
		  		<s:select list="%{#session.tlist}" id="teacher_id" label="授课教师" headerKey="" headerValue="" listValue="teacherName" listKey="teacherId " name="teacher_id" cssStyle="width:200px"/>
		  		
	  		<!-- </td>
	  		<td> -->
		  		<s:select list="%{#session.ctlist}" id="time_id" label="授课时间" headerKey="" headerValue="" listValue="timeDesc" listKey="timeId " name="time_id" cssStyle="width:200px"/>
		  		
	  		</td>
 		</tr>
  		<tr>
  			<td colspan="4">
  				 <%-- <s:submit value="开设课程" id="js_button"/>  --%>
  				<input type="button" id="js_button" value="开设课程">
  			</td>
  		</tr>
  	</table>
 	<%-- </s:form>  --%>
  <div id="info"></div>
  </body>
</html>
