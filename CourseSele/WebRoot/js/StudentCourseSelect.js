$(document).ready(function(){

	alert("正在获取可选课程的信息...");
//	alert("login...");
	$("#SelectCourseTable tr:not(:first)").remove();
	document.getElementById("SelectCourseTable").style.display="";
	//从ShowCPTS.action中获取当前用户的可选课信息
	$.getJSON("ShowCPTS",function(data){
		$.each(data,function(i,value){
					$("#SelectCourseTable").append(
					"<tr>"+
						"<td>" +
							value.ctId
						+"</td>"
						+"<td>" +
							value.course.courseName
						+"</td>"
						+"<td>" +
							value.course.courseType
						+"</td>"
						+"<td>" +
							value.teacher.teacherName
						+"</td>"
						+"<td>" +
							value.room.roomId
						+"</td>"
						+"<td>" +
							"<input type='button' value='选课' onclick='getName(this)' id='"+value.ctId+"'/>"
						+"</td>"
					+"</tr>"
					);

			});
		});
//	alert("get end");
});