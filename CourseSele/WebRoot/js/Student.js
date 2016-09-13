$(document).ready(function(){
	
	$("#Stu_ShowCourse_but").click(function(){
		alert("正在获取可选课程的信息");
		$("#SelectCourseTable tr:not(:first)").remove();
		document.getElementById("RemoveSCourseTable").style.display="none";
		document.getElementById("ShowCourseTable").style.display="none";
		document.getElementById("ShowStudentCourseTable").style.display="none";
		document.getElementById("SelectCourseTable").style.display="";
		$.getJSON("ShowCPTS",function(data){
			alert("in  getJson");
			$.each(data,function(i,value){
				alert(value.ctId);
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
								/*+
								"<input type='hidden' value='%{#session.student_id}' id='student_id'/>"*/
							+"</td>"
						+"</tr>"
						);

				});
			});
		alert("get end");
		});
	
	$("#Stu_ShowAllCourse_but").click(function(){
		alert("loading...");
		document.getElementById("RemoveSCourseTable").style.display="none";
		document.getElementById("SelectCourseTable").style.display="none";
		document.getElementById("ShowStudentCourseTable").style.display="none";
		document.getElementById("ShowCourseTable").style.display="";
		$("#ShowCourseTable tr:not(:first)").empty("");
		alert("---------");
		$.getJSON("getCoursePlan",function(data){
//			alert("in json");
			$.each(data,function(i,value){
//				alert("----");
				$("#ShowCourseTable").append(
				"<tr>" +
					"<td>" +
						value.ctId
					+"</td>"
					+
					"<td>" +
						value.course.courseName
					+"</td>"
					+
					"<td>" +
						value.course.courseType
					+"</td>"
					+
					"<td>" +
						value.teacher.teacherName
					+"</td>"
					+
					"<td>" +
						value.room.roomId
					+"</td>"
				+"</tr>"
				);
			});
		});
//		alert("??????????");
	});
	
//	展示已选的课程
	$("#Stu_DeleteCourse_but").click(function(){
		alert("show loading...");
		
		document.getElementById("SelectCourseTable").style.display="none";
		document.getElementById("ShowCourseTable").style.display="none";
		document.getElementById("ShowStudentCourseTable").style.display="none";
		document.getElementById("RemoveSCourseTable").style.display="";
		
		$("#RemoveSCourseTable tr:not(:first)").empty("");
		
		$.getJSON("ShowStuSelect",function(data){
			alert("in json");
			$.each(data,function(i,value){
				$("#roomAddTable").append(
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
								"<input type='button' value='退选' id='"+value.selectId+"'/>"
							+"</td>"
						+"</tr>"
				);
			});
		});
		alert("show end...thanks");
		
	});
	
	//展示当前学生的课表
	$("#Stu_CourseTable_but").click(function(){
		alert("获取课表……");
		document.getElementById("SelectCourseTable").style.display="none";
		document.getElementById("ShowCourseTable").style.display="none";
		document.getElementById("RemoveSCourseTable").style.display="none";
		document.getElementById("ShowStudentCourseTable").style.display="";
		$.getJSON("ShowStudentCourse",function(data){
			$.each(data,function(i,value){
				$("#t_"+value.selectCourse.courseTeacher.coursetime.timeNum).html(value.selectCourse.courseTeacher.course.courseName);
			});
		});
		alert("显示完毕");
	});
	
});