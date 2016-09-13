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

	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/Student.js"></script>
	<script type="text/javascript">
	function getName(bu) {
		var i=bu.id;
		alert("you click button:"+i); 
		$.getJSON("StuSelectCourseT?coursetId="+i,function(Addmessage){
			if(Addmessage==0){
				alert("选课成功!!!");
			}else{
				alert("选课失败!!!");
			}
		});
		alert("add end...");
	}
	</script>

  </head>
  
  <body>
    This is StudnetFunction.jsp. <hr>
   欢迎	<%=ActionContext.getContext().getSession().get("login_name") %>登录<br>
   您的学号为<%=ActionContext.getContext().getSession().get("login_id") %>
    <hr>
    <input type="button" value="展示已选课程信息" id="Stu_ShowCourse_but">
    <input type="button" value="查询课程" id="Stu_ShowAllCourse_but">
    <input type="button" value="展示所有课程信息" id="Stu_DeleteCourse_but">
    <input type="button" value="显示个人课程表" id="Stu_CourseTable_but">
    ||<a href="getAllPlan.action">展示所有的课程</a>
      <hr>
      <table id="SelectCourseTable" style =" display: none;" border="1">
      	<tr>
      		<td>课程编号</td>
      		<td>课程名称</td>
      		<td>修读类型</td>
      		<td>授课讲师</td>
      		<td>授课教师</td>
      		<td>选课</td>
      	</tr>
      </table>
      
      <table id="RemoveSCourseTable" style =" display: none;" border="1">
      	<tr>
      		<td>课程编号</td>
      		<td>课程名称</td>
      		<td>修读类型</td>
      		<td>授课讲师</td>
      		<td>授课教室</td>
      		<td>退课</td>
      	</tr>
      </table>
      
       <table id="ShowCourseTable" style =" display: none;" border="1" >
      	<tr>
      		<td>课程编号</td>
      		<td>课程名称</td>
      		<td>修读类型</td>
      		<td>授课讲师</td>
      		<td>授课教室</td>
      		<td>信息显示页面</td>
      	</tr>
      	 
      </table>
      
      <table id="ShowStudentCourseTable" style =" display: none;" border="1" >
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
      		<td id>上午第一节(8:00~9:00)</td>
      		<td id="t_1"></td>
      		<td id="t_9"></td>
      		<td id="t_17"></td>
      		<td id="t_25"></td>
      		<td id="t_33"></td>
      	</tr>
      	<tr>
      		<td id>上午第二节(9:00~10:00)</td>
      		<td id="t_2"></td>
      		<td id="t_10"></td>
      		<td id="t_18"></td>
      		<td id="t_26"></td>
      		<td id="t_34"></td>
      	</tr>
      	<tr>
      		<td id>上午第三节(10:00~11:00)</td>
      		<td id="t_3"></td>
      		<td id="t_11"></td>
      		<td id="t_19"></td>
      		<td id="t_27"></td>
      		<td id="t_35"></td>
      	</tr>
      	<tr>
      		<td id>上午第四节(11:00~12:00)</td>
      		<td id="t_4"></td>
      		<td id="t_12"></td>
      		<td id="t_20"></td>
      		<td id="t_28"></td>
      		<td id="t_36"></td>
      	</tr>
      	<tr>
      		<td id>下午第一节(14:00~15:00)</td>
      		<td id="t_5"></td>
      		<td id="t_13"></td>
      		<td id="t_21"></td>
      		<td id="t_29"></td>
      		<td id="t_37"></td>
      	</tr>
      	<tr>
      		<td id>下午第二节(15:00~16:00)</td>
      		<td id="t_6"></td>
      		<td id="t_14"></td>
      		<td id="t_22"></td>
      		<td id="t_30"></td>
      		<td id="t_38"></td>
      	</tr>
      	<tr>
      		<td id>下午第三节(16:00~17:00)</td>
      		<td id="t_7"></td>
      		<td id="t_15"></td>
      		<td id="t_23"></td>
      		<td id="t_31"></td>
      		<td id="t_39"></td>
      	</tr>
      	<tr>
      		<td id>下午第四节(17:00~18:00)</td>
      		<td id="t_8"></td>
      		<td id="t_16"></td>
      		<td id="t_24"></td>
      		<td id="t_32"></td>
      		<td id="t_40"></td>
      	</tr>
      </table>
      
  </body>
</html>
