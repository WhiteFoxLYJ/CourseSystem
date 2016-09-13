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
    
    <title>My JSP 'CoursePlanInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>

  </head>
  
  <body>
  	课程安排页面<br>CoursePlanShow.jsp<hr>
  	用户名:<%=ActionContext.getContext().getSession().get("login_name") %> || 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %>
  	<hr>
  	<!-- <a href="getCTRInfo.action">安排课程</a>||
    <a href="##">删除课程</a>||
    <a href="getAllCourse.action">录入课程</a>||
    <a href="/Room.jsp">录入教室</a> --><hr>
  	<h3>安排课程</h3>
  	<table border="1">
  		<tr>
	  		<td>
	  			课程安排编号
	  		</td>
	  		<td>
	  			课程名称
	  		</td>
	  		<td>
	  			授课时间
	  		</td>
	  		<td>
	  			安排教务编号
	  		</td>
	  		<td>
	  			授课教室
	  		</td>
	  		<td>
	  			讲师
	  		</td>
	  		<td>
	  			
	  		</td>
  		</tr>
  		 <s:iterator value="#session.cplist" var="ct">
  		 <tr>
  			<td>
	  			<s:property value="#ct.ctId"/>
	  		</td>
	  		<td>
	  			<s:property value="#ct.course.courseName"/>
	  		</td>
	  		<td>
	  			<s:property value="#ct.coursetime.timeDesc"/>
	  		</td>
	  		<td>
	  			<s:property value="#ct.eduadmin.id"/>
	  		</td>
	  		<td>
	  			<s:property value="#ct.room.roomId"/>
	  		</td>
	  		<td>
	  			<s:property value="#ct.teacher.teacherName"/>
	  		</td>
	  		<td>
	  			<s:form action="DeletePlan.action" method="post">
	  				<s:hidden value="%{#ct.ctId}" name="ct_id"/>
	  				<%-- <s:hidden value="#ct.course.courseId" name="course_id"/> --%>
	  				<s:submit value="删除"/>
	  			</s:form>
	  		</td>
	  	 </tr>
  		</s:iterator>
  	
  	</table>
  
  </body>
</html>
