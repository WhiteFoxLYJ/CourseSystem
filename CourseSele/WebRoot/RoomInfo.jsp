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
	<style type="text/css">
  	#info td {
  		text-align:center
  	}
    #info tr{    background:#FFF;    }              
  	#info tr:nth-child(2n){         background:green; } 
 	#info tr{         background-color: expression((this.sectionRowIndex % 2 == 0) ? "#FFF" : "#F0F0F0" );}

	</style>
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="js/RoomInfo.js"></script>
  </head>
  
  <body>
  	教室信息<hr>RoomInfo.jsp<hr>
  	<!-- <a href="getCTRInfo.action">安排课程</a>||
    <a href="getAllCourse.action">删除课程</a>||
    <a href="getAllCourse.action">录入课程</a>||
    <a href="getAllRoom.action">录入教室</a><br> -->
  
  <h3>教室信息</h3>
  <s:form action="RoomAdd.action" method="post">
  <h3>教室信息录入界面</h3>
  	<table border="1" style =" display: ;margin:0 auto;height: auto; width: 500px">
  		<tr>
  			<s:textfield name="room_type" id="room_type" label="教室类型"/>
  		</tr>
  		<tr>
  			<s:textfield name="room_scale" id="room_scale" label="可容纳人数"/>
  		</tr>
  		<tr>
  			<%-- <s:submit value="录入信息"/><s:reset value="重置信息" /> --%>
  			<td>
  				<input type="button" id="wr_button" value="录入信息">
  				<input type="button" id="re_button" value="重置信息">
  			</td>
  		</tr>
  	</table>
  </s:form>
  <%-- <s:form action="getAllRoom.action" method="post">
  	<s:submit value="刷新信息"/>
  </s:form> --%>
  <input type="button" value="刷行信息" id="fresh_button"/>
  <br>
  	<%-- <table border="1" id="info" style =" display: ;margin:0 auto;height: auto; width: 800px">
  		<tr>
  			<td>教室编号</td>
  			<td>教室类型</td>
  			<td>可容纳人数</td>
  		</tr>
  		<s:iterator value="%{#request.frlist}" var="room">
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
  		</s:iterator>
  	</table> --%>
		<div id="info"></div>
  </body>
</html>
