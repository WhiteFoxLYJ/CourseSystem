$(document).ready(function(){
	
	//页面加载的时候显示所有的教室的信息
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
	});
		
	
	
	//添加新的教室，叫数据传输到js，通过下面的方法传输到后台的Action
	$("#Add_NewRoom_Info").click(function(){
//		alert("add new room...");
		var roomtype=document.getElementById("room_type").value;
		var roomscale=document.getElementById("room_scale").value;
//		window.location.href="RoomAdd_test.action?room_type="+roomtype+"&&room_scale="+roomscale;
		$.getJSON("RoomAdd_test?room_type="+roomtype+"&&room_scale="+roomscale,function(Addmessage){
			if(Addmessage==0){
				alert("添加教室成功!!!");
			}else{
				alert("添加教室失败!!!");
			}
		});
//		alert("add end!!!");
	});
	
	//清空教室录入输入框
	$("#Clear_Info_Room").click(function(){
		var roomtype=document.getElementById("room_type");
		var roomscale=document.getElementById("room_scale");
		roomtype.value="";
		roomscale.value="";
	});
	
	//删除教室信息
	function getName(g) {
		alert("you click it:"+g.id);
		var i=g.id;
		$("#"+i).click(function(){
			/* alert("you click it111:"+i); */
			$.getJSON("RoomDelete_test?room_id="+i,function(Addmessage){
				if(Addmessage==0){
					alert("教室信息删除成功!!!");
					
				}else{
					alert("教室信息删除失败!!!");
				}
			});
		});
		alert("delete end...");
	}
});