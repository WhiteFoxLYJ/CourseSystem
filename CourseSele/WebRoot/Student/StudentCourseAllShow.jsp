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
	<script type="text/javascript" src="js/StudentCourseTable.js"></script>
	<script type="text/javascript">
	
	</script>

  </head>
  
  <body>
    This is StudentCourseAllShow.jsp. <hr>
   欢迎	<%=ActionContext.getContext().getSession().get("login_name") %>登录<br>
   您的学号为<%=ActionContext.getContext().getSession().get("login_id") %>
    <hr>
      
      <table id="ShowStudentCourseTable" style =" display: ;margin:0 auto;height: auto; width: 800px" border="1" >
      	<tr>
      		<td colspan="6">
      			<%=ActionContext.getContext().getSession().get("login_name") %> 的
      			课程表
      		</td>
      	</tr>
      	<tr>
      		<td></td>
      		<td>星期一</td>
      		<td>星期二</td>
      		<td>星期三</td>
      		<td>星期四</td>
      		<td>星期五</td>
      	</tr>
      	 <tr>
      		<td id>上午第一节<br>(8:00~9:00)</td>
      		<td id="t_1"></td>
      		<td id="t_9"></td>
      		<td id="t_17"></td>
      		<td id="t_25"></td>
      		<td id="t_33"></td>
      	</tr>
      	<tr>
      		<td id>上午第二节<br>(9:00~10:00)</td>
      		<td id="t_2"></td>
      		<td id="t_10"></td>
      		<td id="t_18"></td>
      		<td id="t_26"></td>
      		<td id="t_34"></td>
      	</tr>
      	<tr>
      		<td id>上午第三节<br>(10:00~11:00)</td>
      		<td id="t_3"></td>
      		<td id="t_11"></td>
      		<td id="t_19"></td>
      		<td id="t_27"></td>
      		<td id="t_35"></td>
      	</tr>
      	<tr>
      		<td id>上午第四节<br>(11:00~12:00)</td>
      		<td id="t_4"></td>
      		<td id="t_12"></td>
      		<td id="t_20"></td>
      		<td id="t_28"></td>
      		<td id="t_36"></td>
      	</tr>
      	<tr>
      		<td id>下午第一节<br>(14:00~15:00)</td>
      		<td id="t_5"></td>
      		<td id="t_13"></td>
      		<td id="t_21"></td>
      		<td id="t_29"></td>
      		<td id="t_37"></td>
      	</tr>
      	<tr>
      		<td id>下午第二节<br>(15:00~16:00)</td>
      		<td id="t_6"></td>
      		<td id="t_14"></td>
      		<td id="t_22"></td>
      		<td id="t_30"></td>
      		<td id="t_38"></td>
      	</tr>
      	<tr>
      		<td id>下午第三节<br>(16:00~17:00)</td>
      		<td id="t_7"></td>
      		<td id="t_15"></td>
      		<td id="t_23"></td>
      		<td id="t_31"></td>
      		<td id="t_39"></td>
      	</tr>
      	<tr>
      		<td id>下午第四节<br>(17:00~18:00)</td>
      		<td id="t_8"></td>
      		<td id="t_16"></td>
      		<td id="t_24"></td>
      		<td id="t_32"></td>
      		<td id="t_40"></td>
      	</tr>
      </table>
      
  </body>
</html>
