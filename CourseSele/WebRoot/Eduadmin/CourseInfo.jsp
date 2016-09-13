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
	<script type="text/javascript" src="js/CourseInfo.js"></script>


  </head>
  
  <body>
  	课程信息<hr>Eduadmin/CourseInfo.jsp<hr>
    <hr>
    	<s:form action="CourseAdd.action" method="post">
    		<table>
    			<tr>
	  				<td>
	  					<s:textfield name="CousrseName" label="课程名称" id="CousrseName"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CourseType" label="课程类型" id="CourseType"/><span>必修“1”，选修“2”</span>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CoursePeriod" label="课程学时" id="CoursePeriod"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CourseCredit" label="课程学分" id="CourseCredit"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<s:textfield name="CousrseDESC" label="课程描述" id="CousrseDESC"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td colspan="5">
	  					<%-- <s:submit value="登记课程"/> --%>
	  					<input type="button" value="登记课程" id="wr_button"/>
	  					<input type="button" value="清空信息" id="re_button"/>
	  				</td>
	  			</tr>
    		</table>
    	</s:form>
    <hr>
  	<input type="button" value="刷新信息" id="fr_button"/>
  <%-- <h3>课程信息</h3>
  	<table border="1" id="info" style =" display: ;margin:0 auto;height: auto; width: 800px">
  		<tr>
  			<td>课程编号</td>
  			<td>课程类型</td>
  			<td>课程学时</td>
  			<td>课程学分</td>
  			<td>课程描述</td>
  		</tr>
  		<s:iterator value="#request.clist" var="course">
  			<tr>
  				<td><s:property value="#course.courseId"/></td>
  				<td><s:property value="#course.courseType"/></td>
  				<td><s:property value="#course.coursePeriod"/></td>
  				<td><s:property value="#course.courseCredit"/></td>
  				<td><s:property value="#course.courseDesc"/></td>
  				<td>
  					<s:form action="CourseDel.action" method="post">
  						<s:hidden id="#course.courseId" name="course_id" value="%{#course.courseId}"></s:hidden>
  						<s:submit value="删除" ></s:submit>
  					</s:form>
  				</td>
  			</tr>
  		</s:iterator>
  	</table> --%>
  <div id="info"></div>
  </body>
</html>
