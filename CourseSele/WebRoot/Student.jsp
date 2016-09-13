<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
	#menu{
	width:200px;
	/* border:1px solid red; */
	}
	
	#menu  ul{
	list-style: none;
	padding: 0px;
	margin: 0px;
	}
	#menu ul li{
	
	border-bottom:1px solid #fff;
	
	}
	#menu ul li a{
	/* 转换为块级元素 */
	display: block;
	background-color:#008792;
	color:#fff;
	padding:5px;
	text-decoration:none;
	}
		#menu ul li a:hover{
	
	background-color:#00a6ac;
	}
	
	
	</style>

  
  
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">   
<script type="text/javascript" src="easyui/jquery.min.js"></script>   
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>  



  
  <script type="text/javascript">
  $(function(){
  

  
/*  $("#tt").tabs({    
    border:false,    
    onSelect:function(title){    
        alert(title+' is selected');    
    }    
});   */ 


$("a[title]").click(function(){

var text=$(this).text();
var href=$(this).attr("title");

if($("#tt").tabs("exists",text)){
	$("#tt").tabs("select",text);
}else{
	$("#tt").tabs("add",{
		title:text,
		closable:true,
		content:'<iframe src="'+href+'" frameborder="0" width="100%" height="100%"/>'
		
	});
	}

	


});
  });
  
  </script>
	
  </head>
 <body class="easyui-layout">   

    <div data-options="region:'north',title:'校园信息门户网站',split:true" style="height:100px;">
    	欢迎使用校园信息门户网站 !<br>
		用户名:<%=ActionContext.getContext().getSession().get("login_name") %><br>
		用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %>
    </div>   
     
    <div data-options="region:'west',title:'用户操作',split:true" style="width:200px;">
    
    <div id="menu" class="easyui-accordion" data-options="fit:true">
    
    		<!--  <div title="学生信息">
    			<ul>
    				<li><a href="#" title="Student.jsp">个人信息</a></li>
    			</ul>
    		</div> --> 
    		<div title="排课信息">
    			<ul>
    				<li><a href="#" title="Student/StudentCourseTable.jsp">个人课表</a></li>
    			</ul>
    		</div>
    		<div title="选课">
    			<ul>
    				<li><a href="#" title="Student/StudentCourseSelect.jsp">选择课程</a></li>
    				<!-- <li><a href="#" title="StudentFunction.jsp">选择课程</a></li> -->
    				<li><a href="#" title="Student/StudentCourseDelete.jsp">退选课程</a></li>
    				<!-- <li><a href="#" title="Student/StudentCourseAllShow.jsp">选课信息查询</a></li> -->
    			</ul>
    		</div>
    </div>
    </div>   
    <div data-options="region:'center',title:'操作页面'" style="padding:1px;background:#fff;">
    
		 <div id="tt" class="easyui-tabs"  data-options="fit:true">   
		    <div title="系统信息页面" style="padding:20px;">   
		        		欢迎使用校园信息门户网站 !<br>
		        		用户名:<%=ActionContext.getContext().getSession().get("login_name") %><br>
						用户帐号:<%=ActionContext.getContext().getSession().get("login_id") %>
		    </div>   
		 </div>  
    </div>   
</body>  


	
 

</html>
