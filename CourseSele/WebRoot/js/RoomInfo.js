$(document).ready(function(){
	alert("欢迎使用哟~");
	/*alert("33");*/
	$("#re_button").click(function(){
		$("#room_type").value="";
		$("#room_scale").value="";
	});
	$("#fresh_button").click(function(){
		alert("获取教室信息..");
		$("#info").empty();
		$("#info").append("<table id='CoursePlan' style =' display: ;margin:0 auto;height: auto; width: 500px' border='1'><tr><td>教室编号</td><td>教室类型</td><td>可容纳人数</td></tr></table>");
		$.getJSON("getRoomInfo",function(data){
			$.each(data,function(i,value){
				$("#CoursePlan").append(
						"<tr>" +
						
						"<td>" +
							value.roomId
						+"</td>"+
						"<td>" +
							value.roomType
						+"</td>"+
						"<td>" +
							value.roomScale
						+"</td>"+
						
						"</tr>"
						
				);
			});
		});
	});
	$("#wr_button").click(function(){
		alert("点击了按钮了哟");
		alert("开始添加新的教室……");
		var room_type=$("#room_type").val();
		var room_scale=$("#room_scale").val();
		alert(room_type+"----"+room_scale);
		/*var roomId=$("#room_id").value;*/
//		alert("room_id:"+room_id
//				+"//course_id:"+course_id
//				+"//teacher_id:"+teacher_id
//				+"//time_id:"+time_id);
		if(room_type==""){
			alert("教室类型不能为空");
		}
		if(room_scale==""){
			alert("教室可容纳人数不能为空");
		}
		if(room_type!=""&&room_scale!=""){
			$.getJSON("RoomAdd_test?room_type="+room_type+"&Scale="+room_scale,function(data){
				if(data==0){
					alert("添加课程安排成功");
				}else{
					alert("添加课程安排失败");
				}
			});
		}
		$("#info").empty();
		$("#info").append("<table id='CoursePlan' border='1'><tr><td>教室编号</td><td>教室类型</td><td>可容纳人数</td></tr></table>");
		$.getJSON("getRoomInfo",function(data){
			$.each(data,function(i,value){
				$("#CoursePlan").append(
						"<tr>" +
						
						"<td>" +
							value.roomId
						+"</td>"+
						"<td>" +
							value.roomType
						+"</td>"+
						"<td>" +
							value.roomScale
						+"</td>"+
						
						"</tr>"
						
//						"<s:iterator value='#session.acplist' var='ct'><tr><td><s:property value='#ct.ctId'/></td><td><s:property value='#ct.course.courseName'/></td><td><s:property value='#ct.coursetime.timeDesc'/></td><td><s:property value='#ct.eduadmin.id'/></td><td><s:property value='#ct.room.roomId'/></td><td><s:property value='#ct.teacher.teacherName'/></td><td><s:form action='DeletePlan.action' method='post'><s:hidden value='%{#ct.ctId}' name='ct_id'/><s:submit value='删除'/></s:form></td></tr></s:iterator>"
				);
			});
		});
		
	});
});