$(document).ready(function(){
	alert("学生已选课程显示 loading...");
	$("#RemoveSCourseTable tr:not(:first)").remove();
	$.getJSON("ShowStuSelect",function(data){
//		alert("in json");
		$.each(data,function(i,value){
			$("#RemoveSCourseTable").append(
					"<tr>" 
						+"<td>"+
							value.selectId
						+"</td>"
						+"<td>"+
							value.courseTeacher.course.courseName
						+"</td>"
						+"<td>"+
							value.courseTeacher.course.courseType
						+"</td>"
						+"<td>"+
							value.courseTeacher.teacher.teacherName
						+"</td>"
						+"<td>"+
							value.courseTeacher.room.roomId
						+"</td>"
						+"<td>"+
							"<input type='button' value='退选' id='"+value.selectId+"' onclick='getName(this)'/>"
						+"</td>"
					+"</tr>"
			);
		});
	});
	alert("显示信息结束");
});