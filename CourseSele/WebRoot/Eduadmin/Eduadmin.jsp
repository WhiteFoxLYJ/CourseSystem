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
		content:'<iframe id="if1" src="'+href+'.jsp" frameborder="0" width="100%" height="100%" />'
		
	});
	}

	


});
  });
  
  </script>
	
  </head>
 <body class="easyui-layout">   

    <div data-options="region:'north',title:'选课系统模块',split:true" style="height:100px;"></div>   
     
    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
    
    <div id="menu" class="easyui-accordion" data-options="fit:true">
    
    		 <div title="教室信息">
    			<ul>
    				<li><a href="#" title="EduadminRoom">教室信息查询</a></li>
    				<li><a href="#" title="EduadminRoom">教室信息录入</a></li>
    			</ul>
    		</div> 
    		<div title="课程信息">
    			<ul>
    				<li><a href="#" title="EduadminCourse">课程信息查询</a></li>
    				<li><a href="#" title="EduadminCourse">课程信息录入</a></li>
    			</ul>
    		</div>
    		<div title="课程安排">
    			<ul>
    				<li><a href="#" title="EduadminFunction.jsp">安排课程</a></li>
    				<li><a href="#" title="EduadminFunction.jsp">查询课程安排</a></li>
    			</ul>
    		</div>
    </div>
    </div>   
    <div data-options="region:'center',title:'操作页面'" style="padding:1px;background:#fff;">
    
		 <div id="tt" class="easyui-tabs"  data-options="fit:true">   
		    <div title="系统缺省页面" style="padding:20px;">   
		        		欢迎使用校园信息门户网站！ 
		    </div>   
		 </div>  
    </div>   
</body>  


	
 

</html>
