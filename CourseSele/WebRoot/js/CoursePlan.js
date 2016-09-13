$(document).ready(function(){
	alert("欢迎使用课程安排功能哟~");
	$("#js_button").click(function(){
		alert("点击了按钮了哟");
		alert("开始添加新的课程安排……");
		var room_id=$("#room_id option:selected").val();
		var course_id=$("#course_id option:selected").val();
		var teacher_id=$("#teacher_id option:selected").val();
		var time_id=$("#time_id option:selected").val();
		/*var roomId=$("#room_id").value;*/
//		alert("room_id:"+room_id
//				+"//course_id:"+course_id
//				+"//teacher_id:"+teacher_id
//				+"//time_id:"+time_id);
		if(room_id==""){
			alert("教室不能为空");
		}
		if(course_id==""){
			alert("课程不能为空");
		}
		if(teacher_id==""){
			alert("教师不能为空");
		}
		if(time_id==""){
			alert("授课时间不能为空");
		}
		if(room_id!=""&&course_id!=""&&teacher_id!=""&&time_id!=""){
			$.getJSON("SetNewPlan?courseId="+course_id+"&roomId="+room_id+"&teacherId="+teacher_id+"&timeId="+time_id,function(data){
				if(data==0){
					alert("添加课程安排失败");
				}else{
					alert("添加课程安排成功");
				}
			});
		}
		$("#info").empty();
		$("#info").append("<table id='CoursePlan' border='1'><tr><td>排课编号</td><td>课程名称</td><td>授课时间 </td><td>授课教室</td><td>讲师</td><td></td></tr></table>");
		$.getJSON("getCoursePlan",function(data){
//			alert("json");
			$.each(data,function(i,value){
				$("#CoursePlan").append(
						"<tr>" +
						
						"<td>" +
							value.ctId
						+"</td>"+
						"<td>" +
							value.course.courseName
						+"</td>"+
						"<td>" +
							value.coursetime.timeDesc
						+"</td>"+
						"<td>" +
							value.room.roomId
						+"</td>"+
						"<td>" +
							value.teacher.teacherName
						+"</td>"+
						
						"</tr>"
						
//						"<s:iterator value='#session.acplist' var='ct'><tr><td><s:property value='#ct.ctId'/></td><td><s:property value='#ct.course.courseName'/></td><td><s:property value='#ct.coursetime.timeDesc'/></td><td><s:property value='#ct.eduadmin.id'/></td><td><s:property value='#ct.room.roomId'/></td><td><s:property value='#ct.teacher.teacherName'/></td><td><s:form action='DeletePlan.action' method='post'><s:hidden value='%{#ct.ctId}' name='ct_id'/><s:submit value='删除'/></s:form></td></tr></s:iterator>"
				);
			});
		});
		
	});
});