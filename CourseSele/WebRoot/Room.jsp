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

  </head>
  
  <body>
  	教室信息录入<hr>
  	<a href="getCTRInfo.action">安排课程</a>||
    <a href="getAllCourse.action">删除课程</a>||
    <a href="getAllCourse.action">录入课程</a>||
    <a href="getAllRoom.action">录入教室</a><br>
  <s:form action="RoomAdd.action" method="post">
  <h3>教室信息录入界面</h3>
  	<table>
  		<tr>
  			<s:textfield name="room_type" label="教室类型"/>
  		</tr>
  		<tr>
  			<s:textfield name="room_scale" label="可容纳人数"/>
  		</tr>
  		<tr>
  			<s:submit value="录入信息"/><s:reset value="重置信息" />
  		</tr>
  	</table>
  </s:form>
  </body>
</html>
