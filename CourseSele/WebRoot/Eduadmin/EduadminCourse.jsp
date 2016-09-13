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
    
    <title>My JSP 'EduadminFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
  	#AllCourseTable td {
  		text-align:center
  	}
    #AllCourseTable tr{    background:#FFF;    }              
  	#AllCourseTable tr:nth-child(2n){         background:blue; } 
 	#AllCourseTable tr{         background-color: expression((this.sectionRowIndex % 2 == 0) ? "#FFF" : "#F0F0F0" );}

	</style>
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/EduadminCourse.js"></script>
	<script type="text/javascript">
	function getName(g) {
		alert("you click it:"+g.id);
		var i=g.id;
		$("#"+i).click(function(){
			$.getJSON("DeleteCourse?CouresID="+i,function(Addmessage){
				if(Addmessage==0){
					alert("删除课程信息成功!!!");
					location.replace(location.href);
				}else{
					alert("删除课程信息失败!!!");
					location.replace(location.href);
				}
			});
		});
		alert("delete end...");
	} 
	</script>
  </head>
  
  <body>
  	<h3>课程信息查询界面</h3><hr>
    This is EduadminCourse.jsp<hr>
	用户名:<%=ActionContext.getContext().getSession().get("login_name") %>|| 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %><hr>
   <hr>
   
   <hr>
  	<table border="1"  style =" display: ;margin:0 auto;height: auto; width: 800px">
  		<tr>
  			<td colspan="2" >课程信息信息录入界面</td>
  		</tr>
  		<tr>
  			<td>课程名称</td>
  			<td>
  				<input type="text" name="CousseName" id="CourseName"><span style='color:red' id="SCourseName"></span>
  			</td>
  		</tr>
  		<tr>
  			<td>课程类型</td>
  			<td>
  				<input type="text" name="CousrseType" id="CourseType"><span style='color:red' id="SCourseType"></span>
  			</td>
  		</tr>
  		<tr>
  			<td>课程学时</td>
  			<td>
  				<input type="text" name="CoursePeriod" id="CoursePeriod"><span style='color:red' id="SCoursePeriod"></span>
  			</td>
  		</tr>
  		<tr>
  			<td>课程学分</td>
  			<td>
  				<input type="text" name="CourseCredit" id="CourseCredit"><span style='color:red' id="SCourseCredit"></span>
  			</td>
  		</tr>
  		<tr>
  			<td>课程描述</td>
  			<td>
  				<input type="text" name="CousrseDESC" id="CourseDESC"><span style='color:red' id="SCousrseDESC"></span>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="button" value="添加课程信息" id="AddNewCourseInfo">
  				<input type="button" value="重置信息" id="ResetCourseInfo">
  			</td>
  		</tr>
  	</table>
  	<hr>
    <table id="AllCourseTable" style =" display: ;margin:0 auto;height: auto; width: 800px" border="1">
    	<tr>
    		<td colspan="7" style="background:red">课程信息显示</td>
    	</tr>
    	<tr>
    		<td>课程编号</td>
    		<td>课程名称</td>
    		<td>课程类型</td>
    		<td>课程学时</td>
    		<td>课程学分</td>
    		<td>课程描述</td>
    		<td></td>
    	</tr>
    </table>
  </body>
</html>
