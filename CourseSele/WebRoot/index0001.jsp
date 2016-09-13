<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
    This is index page. <br>
    Welcome to Course Choice!!!!!
    <hr>
    <s:form action="loginAction.action" method="post">
    	<table>
    		<tr>
    			<s:textfield id="Id" name="Id" label="登录帐号"/>
    		</tr>
    		<tr>
    			<s:textfield id="name" name="name" label="用户名"/>
    		</tr>
    		<tr>
    			<s:textfield id="Password" name="Password" label="密码"/>
    		</tr>
    		<tr>
    			<s:select list="{'学生','教务','教师'}" name="type" label="用户类型" headerKey="" headerValue=""/>
    		</tr>
    		<tr>
    			<s:submit value="登录" id="login_sub"/><s:reset value="重置"/>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
