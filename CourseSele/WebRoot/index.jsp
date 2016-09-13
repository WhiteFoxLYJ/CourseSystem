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
    
    <title>校园信息门户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/xgxt_login.css" />
  </head>
  
  <body>
   <div id="header">
	<div class="header_title">
		<span class="title_con">校园信息门户系统</span>
	</div>
</div>
<form action="loginAction.action" method="post">
<div id="content">
	<center>
		<div class="con">
		<div class="con_title">
			<span class="con_title_sp">欢迎登录学工系统</span>
		</div>
		<div class="con_panel">
			<div class="con_input">
				<%-- <s:textfield id="Id" name="Id" label="登录帐号" /> --%>
				<span>登录帐号：</span><input type="text" placeholder="登录帐号" id="Id" name="Id" onblur="getID(this)"/>
			</div>
			<div class="con_input">
				<%-- <s:textfield id="name" name="name" label="用户名称"/> --%>
				<span>用户名称：</span><input type="text" placeholder="用户名称" id="name" name="name" onblur="getID(this)"/>
			</div>
			<div class="con_input">
				<%-- <s:textfield id="Password" name="Password" label="登录密码"/> --%>
				<span>登录密码：</span><input type="password" placeholder="登录密码" name="Password" id="Password" onblur="getID(this)"/>
			</div>
			<div class="con_select">
				<%-- <s:select list="{'学生','教务','教师'}" name="type" label="用户类型" headerKey="" headerValue=""/> --%>
				<span>用户类型：</span>
				<select name="type" id="type" onblur="getID(this)" style="height: 22px; width: 155px; ">
					<option selected="selected" value="">请选择</option>
  					<option value ="学生">学生</option>
  					<option value ="教务">教务</option>
 	 				<option value="教师">教师</option>
				</select>
			</div>
			<%-- <div class="con_select">
				<s:submit value="登录" id="login_sub"/> --%><%-- <s:reset value="重置"/>
			</div> --%>	
			<input type="submit" value="登    录" class="submit-btn"/>
		</div>
	</div>
	</center>
</div>
</form>
<div style="text-align:center;">
</div>
  </body>
</html>
