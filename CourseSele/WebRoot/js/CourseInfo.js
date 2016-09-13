$(document).ready(function(){
	alert("欢迎使用课程信息录入功能哟~");
	$("#re_button").click(function(){
		$("#CousrseName").value="";
		$("#CourseType").value="";
		$("#CoursePeriod").value="";
		$("#CourseCredit").value="";
		$("#CousrseDESC").value="";
	});
	$("#fr_button").click(function(){
		$("#info").empty();
		$("#info").empty();
		$("#info").append("<table id='Courseinfo' border='1'><tr><td>课程编号</td><td>课程类型</td><td>课程学时</td><td>课程学分</td><td>课程描述</td></tr></table>");
		$.getJSON("GetAllCourse",function(data){
			$.each(data,function(i,value){
				$("#Courseinfo").append(
						"<tr>" +
							"<td>" +
								value.courseId
							+"</td>"+
							"<td>" +
								value.courseName
							+"</td>"+
							"<td>" +
								value.courseType
							+"</td>"+
							"<td>" +
								value.coursePeriod
							+"</td>"+
							"<td>" +
								value.courseCredit
							+"</td>"+
							"<td>" +
								value.courseDesc
							+"</td>"+
						"</tr>"
				);
			});
		});
	});
	$("#wr_button").click(function(){
		alert("点击了按钮了哟");
		alert("开始添加新的课程……");
		var CousrseName=$("#CousrseName").val();
		var CourseType=$("#CourseType").val();
		var CoursePeriod=$("#CoursePeriod").val();
		var CourseCredit=$("#CourseCredit").val();
		var CousrseDESC=$("#CousrseDESC").val();
		alert(CousrseName+"---"+CourseType+"---"+CoursePeriod+"---CourseCredit"+"---"+CourseCredit+"---"+CousrseDESC);

		if(CousrseName==""){
			alert("CousrseName不能为空");
		}
		if(CourseType==""){
			alert("CourseType不能为空");
		}
		if(CoursePeriod==""){
			alert("CoursePeriod不能为空");
		}
		if(CourseCredit==""){
			alert("CourseCredit不能为空");
		}
		if(CousrseDESC==""){
			alert("CousrseDESC不能为空");
		}
		if(CousrseName!=""&&CourseType!=""&&CoursePeriod!=""&&CourseCredit!=""&&CousrseDESC!=""){
			alert("录入的信息都不为空");
			$.getJSON("AddNewCourse?CousrseName="+CousrseName+"&CourseTypeC="+CourseType+"&CousrseDESC="+CousrseDESC+"&CourseCredit="+CourseCredit+"&CoursePeriodC="+CoursePeriod,function(data){
				if(data=="0"){
					alert("添加课程成功");
				}else{
					alert("添加课程失败");
				}
			});
		}
		$("#info").empty();
		$("#info").append("<table id='Courseinfo' border='1'><tr><td>课程编号</td><td>课程类型</td><td>课程学时</td><td>课程学分</td><td>课程描述</td></tr></table>");
		$.getJSON("GetAllCourse",function(data){
			alert("json");
			$.each(data,function(i,value){
				$("#Courseinfo").append(
						"<tr>" +
							"<td>" +
								value.courseId
							+"</td>"+
							"<td>" +
								value.courseType
							+"</td>"+
							"<td>" +
								value.coursePeriod
							+"</td>"+
							"<td>" +
								value.courseCredit
							+"</td>"+
							"<td>" +
								value.courseDesc
							+"</td>"+
						"</tr>"
				);
			});
		});
		alert("click end");
	});
});