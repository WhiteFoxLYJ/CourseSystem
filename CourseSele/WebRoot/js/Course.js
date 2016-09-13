$(document).ready(function(){
	
	//添加课程
	$("#Edu_AddCourse_but").click(function(){
		alert("显示信息中...请稍等");
		$("#courseInfoTable tr:not(:first)").remove();
		$.getJSON("getCourseInfo",function(data){
			$.each(data,function(i,value){
				$("#courseInfoTable").append(
					"<tr>"+
						"<td>"+
							value.courseId
						+"</td>"
						+
						"<td>"+
							value.courseName
						+"</td>"
						+
						"<td>"+
							value.courseType
						+"</td>"
						+
						"<td>"+
							"<input type='button' value='删除'  id='"+value.courseId+"' onclick='getName(this)'>"
							+
							"<input type='hidden' value='删除' name='"+value.courseName+"'>"
							
						+"</td>"
					+"</tr>"		
				);
			});
			document.getElementById("roomAddTable").style.display="none";
			document.getElementById("roomInfoTable").style.display="";
			alert("已经获取所有的教室的信息");
			
		});

	});
	
	//显示添加新课程的输入框
	$("#Edu_AddRoom_but").click(function(){
		document.getElementById("roomInfoTable").style.display="none";
		document.getElementById("roomAddTable").style.display="";
	});
	
	//添加新的课程，叫数据传输到js，通过下面的方法传输到后台的Action
	$("#Add_NewRoom_Info").click(function(){
		alert("add new room...");
		var roomtype=document.getElementById("room_type").value;
		var roomscale=document.getElementById("room_scale").value;
//		window.location.href="RoomAdd_test.action?room_type="+roomtype+"&&room_scale="+roomscale;
		$.getJSON("RoomAdd_test?room_type="+roomtype+"&&room_scale="+roomscale,function(Addmessage){
			if(Addmessage==0){
				alert("添加成功!!!");
				//添加成功之后刷行当前页面
				location.reload(true);
			}else{
				alert("添加失败!!!");
			}
		});
		alert("添加结束!!!");
	});
	
	
	
	//清空输入框
	$("#Clear_Info_Room").click(function(){
		var roomtype=document.getElementById("room_type");
		var roomscale=document.getElementById("room_scale");
		roomtype.value="";
		roomscale.value="";
	});
});