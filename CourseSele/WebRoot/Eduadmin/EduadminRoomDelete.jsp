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
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/EduadminRoomDelete.js"></script>
	<script type="text/javascript">
		function getName(g) {
		alert("you click it:"+g.id);
		var i=g.id;
		$("#"+i).click(function(){
			/* alert("you click it111:"+i); */
			$.getJSON("RoomDelete_test?room_id="+i,function(Addmessage){
				if(Addmessage==0){
					alert("教室删除成功!!!");
					location.replace(location.href);
				}else{
					alert("教室删除失败!!!");
					location.replace(location.href);
				}
			});
		});
		alert("delete end...");
	}
	</script>
  </head>
  
  <body>
    This is EduadminRoomDelete.jsp<hr>
	用户名:<%=ActionContext.getContext().getSession().get("login_name") %>|| 用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %><hr>
   <!--  <a href="getCTRInfo.action">安排课程</a>||
    <a href="getAllCourse.action">删除课程</a>||
    <a href="getAllCourse.action">录入课程</a>||
    <a href="getAllRoom.action">录入教室</a>
    <input type="button" value="录入教室" id="Edu_AddRoom_but">
      <input type="button" value="录入课程" id="Edu_AddCourse_but">
       <input type="button" value="安排课程" id="Edu_PLanCourse_but">
        <input type="button" value="展示所有教室信息" id="Edu_ShowCourse_but">
        <div id="roomInfo">
        	<table id="roomInfoTable" style =" display: none;margin:0 auto;" border="1">
        		<tr>
        			<td>教室编号</td>
        			<td>教室类型</td>
        			<td>可容纳人数</td>
        			<td></td>
        		</tr>
        	</table>
        </div>
        
        <div id="roomAdd">
        	<table id="roomAddTable" style =" display: none;margin:0 auto;" border="1">
        		<tr>
        			<td>教室类型</td>
        			<td>
        				<input type="text" id="room_type" name="room_type">
        			</td>
        		</tr>
        		<tr>
        			<td>可容纳人数</td>
        			<td>
        				<input type="text" id="room_scale" name="room_scale" 
        					 onkeyup="value=value.replace(/[^\d]/g,'')"
        				>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2">
        				<input type="button" value="添加新教室" id="Add_NewRoom_Info">
        				<input type="button" value="清空输入的信息" id="Clear_Info_Room">
        			</td>
        		</tr>
        	</table>
        </div> -->
        <input type="button" value="刷行信息" id="fresh_button"/>
  <br>
  	<table border="1" id="info" style =" display: ;margin:0 auto;height: auto; width: 800px">
  		<tr>
  			<td>教室编号</td>
  			<td>教室类型</td>
  			<td>可容纳人数</td>
  			<td></td>
  		</tr>
  		<%-- <s:iterator value="%{#request.frlist}" var="room">
  			<tr>
  			
  				<td><s:property value="#room.roomId" /></td>
  				<td><s:property value="#room.roomType "/></td>
  				<td><s:property value="#room.roomScale"/></td>
  				<td>
	  				<s:form action="RoomDelete.action" method="post">
	  					<s:hidden  name="room_id">
	  						<s:property value="#room.roomId"/>
	  					</s:hidden>
	  					<s:hidden name="room_id" value="%{#room.roomId}"/>
	  					<s:submit value="删除" />
	  				</s:form>
  				</td>
  			
  			</tr>
  		</s:iterator> --%>
  	</table>
  </body>
</html>
