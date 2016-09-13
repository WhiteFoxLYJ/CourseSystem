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
	<script type="text/javascript" src="js/EduadminPlanC.js"></script>
  </head>
  
  <body>
  	课程安排页面<br>EduadminPlanC.jsp<hr>
  	用户名:<%=ActionContext.getContext().getSession().get("login_name") %>|| 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %>
  	<hr>
 	<s:form action="AddCoursePlan.action" method="post" >
  	<h3>安排课程</h3>
  	<table border="1"  style =" display: ;margin:0 auto;height: auto; width: 800px">
  		<tr>
	  		<td>
		  		<s:select list="%{#session.rlist}" label="授课教室" headerKey="" headerValue="请选择" listValue="roomId" listKey="roomId " name="room_id">
		  		</s:select>
	  		</td>
  			<td>
		  		<s:select list="%{#session.clist}" label="授课课程" headerKey="" headerValue="请选择" listValue="courseName" listKey="courseId " name="course_id">
		  		</s:select>
	  		</td>
	  		<td>
		  		<s:select list="%{#session.tlist}" label="授课教师" headerKey="" headerValue="请选择" listValue="teacherName" listKey="teacherId " name="teacher_id">
		  		</s:select>
	  		</td>
	  		<td>
		  		<s:select list="%{#session.ctlist}" label="授课时间" headerKey="" headerValue="请选择" listValue="timeDesc" listKey="timeId " name="time_id">
		  		</s:select>
	  		</td>
	  		<td>
		  		<s:select list="%{#session.timelist}" label="开课学期" headerKey="" headerValue="请选择" listValue="timeName" listKey="opentimeId" name="openTime_id">
		  		</s:select>
	  		</td>
 		</tr>
  		<tr>
  			<td colspan="4">
  				<s:submit value="开设课程"/>
  			</td>
  		</tr>
  	</table>
  </s:form>
  
  <!-- <table id="AddPlanTable">
  	<tr>
  		<td>课程名称</td>
  		<td>教师名称</td>
  		<td>授课教室</td>
  		<td>授课时间</td>
  		<td></td>
  	</tr>
  	<tr>
  		<td>
  			
  		</td>
  		<td>
  			
  		</td>
  		<td>
  			
  		</td>
  		<td>
  			
  		</td>
  		<td>
  			<input type="button" value="添加新的课程安排" id="AddNewPlan">
  		</td>
  	</tr>
  </table> -->
  
  </body>
</html>
