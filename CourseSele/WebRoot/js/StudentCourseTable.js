$(document).ready(function(){
	
	//展示当前学生的课表
	
		alert("获取课表中……");
		
//		document.getElementById("SelectCourseTable").style.display="none";
//		document.getElementById("ShowCourseTable").style.display="none";
//		document.getElementById("RemoveSCourseTable").style.display="none";
//		document.getElementById("ShowStudentCourseTable").style.display="";
		$.getJSON("ShowStudentCourse",function(data){
			$.each(data,function(i,value){
				$("#t_"+value.selectCourse.courseTeacher.coursetime.timeNum).html(value.selectCourse.courseTeacher.course.courseName);
				
			});
		});
		alert("显示完毕");

	
});