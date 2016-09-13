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
    
    <title>My JSP 'CourseSelect.jsp' starting page</title>
    
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
    This is CourseSelect.jsp. <hr>
    <a href="CourseSelect.jsp">选课</a>
     <a href="###">查询课程</a>
      <a href="###">退课</a><hr>
      <s:form method="post" action="">
      	<table>
      		<tr>
      			<td>
      				课程代码
      			</td>
      			<td>
      				课程名称
      			</td>
      			<td>
      				课程学分
      			</td>
      			<td>
      				授课教师
      			</td>
      		</tr>
      		<s:iterator var="" value="">
      			<tr>
      				<td>
      					<s:textfield value="" name=""/>
      				</td>
      				<td>
      					<s:textfield value="" name=""/>
      				</td>
      				<td>
      					<s:textfield value="" name=""/>
      				</td>
      				<td>
      					<s:textfield value="" name=""/>
      				</td>
      				<td>
      					<s:form method="post" action="">
      						<s:hidden name="" value=""/>
      						<s:submit value="选课"/>
      					</s:form>
      				</td>
      			</tr>
      		</s:iterator>
      	</table>
      </s:form>
  </body>
</html>
