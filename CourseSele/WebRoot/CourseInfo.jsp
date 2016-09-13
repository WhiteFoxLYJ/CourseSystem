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
  	课程信息<hr>CourseInfo.jsp<hr>
  	<!-- <a href="getCTRInfo.action">安排课程</a>||
    <a href="getAllCourse.action">删除课程</a>||
    <a href="getAllCourse.action">录入课程</a>||
    <a href="getAllRoom.action">录入教室</a> -->
    <hr>
    	<s:form action="CourseAdd.action" method="post">
    		<table>
    			<tr>
	  				<td>
	  					<s:textfield name="CousrseName" label="课程名称"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CourseType" label="课程类型"/><span>必修“1”，选修“2”</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CoursePeriod" label="课程学时"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CourseCredit" label="课程学分"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CousrseDESC" label="课程描述"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td colspan="5">
	  					<s:submit value="登记课程"/>
	  				</td>
	  			</tr>
    		</table>
    	</s:form>
    <hr>
  
  <h3>课程信息</h3>
  	<table border="1">
  	<tr>
  		<td>
	  		<s:form action="getAllCourse.action" method="post">
	  			<s:submit value="刷新信息"/>
	  		</s:form><!-- 修改部分 -->
  		</td>
  		<td colspan="6">
  			<s:form action="getAllCourse.action" method="post">
  				<s:textfield label="课程编号" name="CousrseName"/>
	  			<s:submit value="刷新信息"/>
	  		</s:form><!-- 修改部分 -->
  		</td>
  	</tr>
  		<tr>
  			<td>课程编号</td>
  			<td>课程名称</td>
  			<td>课程类型</td>
  			<td>课程学时</td>
  			<td>课程学分</td>
  			<td>课程描述</td>
  		</tr>
  		<s:iterator value="#request.clist" var="course">
  			<tr>
  				<td><s:property value="#course.courseId"/></td>
  				<td><s:property value="#course.courseName"/></td>
  				<td><s:property value="#course.courseType"/></td>
  				<td><s:property value="#course.coursePeriod"/></td>
  				<td><s:property value="#course.courseCredit"/></td>
  				<td><s:property value="#course.courseDesc"/></td>
  				<td>
  					<s:form action="DeleteCourse.action" method="post">
  						<s:hidden id="#course.courseId" name="CourseId" value="%{#course.courseId}"></s:hidden>
  						<s:submit value="删除" ></s:submit>
  					</s:form>
  				</td>
  			</tr>
  		</s:iterator>
  	</table>
  
  </body>
</html>
