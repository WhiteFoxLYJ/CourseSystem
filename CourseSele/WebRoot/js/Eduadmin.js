$(document).ready(function(){
	alert("Welcome to the Eduadmin System");
	
	//显示所有在数据库中的教室的信息
	$("#Edu_ShowCourse_but").click(function(){
		alert("显示信息中...请稍等");
		$("#roomInfoTable tr:not(:first)").remove();
		$.getJSON("getRoomInfo",function(data){
			$.each(data,function(i,value){
				$("#roomInfoTable").append(
					"<tr>"+
						"<td>"+
							value.roomId
						+"</td>"
						+
						"<td>"+
							value.roomType
						+"</td>"
						+
						"<td>"+
							value.roomScale
						+"</td>"
						+
						"<td>"+
							"<input type='button' value='删除'  id='"+value.roomId+"' onclick='getName(this)'>"
							+
							"<input type='hidden' value='删除' name='"+value.roomName+"'>"
							
						+"</td>"
					+"</tr>"		
				);
			});
			document.getElementById("roomAddTable").style.display="none";
			document.getElementById("roomInfoTable").style.display="";
			alert("get room show");
		});

	});
	
	//显示添加新教室的输入框
	$("#Edu_AddRoom_but").click(function(){
		document.getElementById("roomInfoTable").style.display="none";
		document.getElementById("roomAddTable").style.display="";
	});
	
	//添加新的教室，叫数据传输到js，通过下面的方法传输到后台的Action
	$("#Add_NewRoom_Info").click(function(){
		alert("add new room...");
		var roomtype=document.getElementById("room_type").value;
		var roomscale=document.getElementById("room_scale").value;
//		window.location.href="RoomAdd_test.action?room_type="+roomtype+"&&room_scale="+roomscale;
		$.getJSON("RoomAdd_test?room_type="+roomtype+"&&room_scale="+roomscale,function(Addmessage){
			if(Addmessage==0){
				alert("add successful!!!");
			}else{
				alert("add error!!!");
			}
		});
		alert("add end!!!");
	});
	
	
	
	//清空输入框
	$("#Clear_Info_Room").click(function(){
		var roomtype=document.getElementById("room_type");
		var roomscale=document.getElementById("room_scale");
		roomtype.value="";
		roomscale.value="";
	});
	
	
	
});