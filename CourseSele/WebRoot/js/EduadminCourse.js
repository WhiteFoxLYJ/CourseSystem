$(document).ready(function(){
	//加载页面的时候直接显示所有的已经添加到数据库的课程信息
//	$("#CousrseName").after("<span style='color:red'>*课程类型：必修填“1”，选修填“2”</span>");
//	$("#CousrseType").after("<span style='color:red'>*</span>");
//	$("#CourseCredit").after("<span style='color:red'>*</span>");
//	$("#CoursePeriod").after("<span style='color:red'>*</span>");
	$("#SCourseName").html("*");
	$("#SCourseType").html("*课程类型：必修填“1”，选修填“2”");
	$("#SCourseCredit").html("*");
	$("#SCoursePeriod").html("*");
	$("#AllCourseTable tr:not(:first)").remove();
	alert("加载课程信息");
	$.getJSON("GetAllCourse",function(data){
		$.each(data,function(i,value){

			$("#AllCourseTable").append(
			"<tr>" +
				"<td>" +
					value.courseId
				+"</td>"
				+
				"<td>" +
					value.courseName
				+"</td>"
				+
				"<td>" +
					value.courseType
				+"</td>"
				+
				"<td>" +
					value.courseCredit
				+"</td>"
				+
				"<td>" +
					value.coursePeriod
				+"</td>"
				+
				"<td>" +
					value.courseDesc
				+"</td>"
				+
				"<td>" +
					"<input type='button' value='删除' id='"+value.courseId+"' onclick='getName(this)'>"
				+"</td>"
			+"</tr>"
			);
		});
	});

	//添加新的课程到数据库中
	$("#AddNewCourseInfo").click(function(){
		alert("开始添加课程信息...");
		var courseName=document.getElementById("CourseName").value;
		var courseType=document.getElementById("CourseType").value;
		var courseCredit=document.getElementById("CourseCredit").value;
		var coursePeriod=document.getElementById("CoursePeriod").value;
		var courseDesc=document.getElementById("CourseDESC").value;
		alert(courseName+"--"+courseType+"--"+courseCredit+"--"+courseDesc+"--"+coursePeriod+"--"+coursePeriod);
		if(courseName==""){
			$("#SCourseName").html("课程名称不能为空");
		}else{
			$("#SCourseName").html("√");
//			$("#SCourseName").style.color = "green";
		}
		if(courseType==""){
			$("#SCourseType").html("课程类型不能为空");
		}else{
			$("#SCourseType").html("√");
//			$("#SCourseType").style.color = "green";
		}
		if(courseCredit==""){
			$("#SCourseCredit").html("课程学时不能为空");
		}else{
			$("#SCourseCredit").html("√");
//			$("#SCourseCredit").style.color = "green";
		}
		if(coursePeriod==""){
			$("#SCoursePeriod").html("课程学分不能为空");
		}else{
			$("#SCoursePeriod").html("√");
//			$("#SCoursePeriod").style.color = "green";
		}
		alert(courseName+"--"+courseType+"--"+courseCredit+"--"+courseDesc+"--"+coursePeriod);
		if($("#CourseName").val()==""||$("#CourseType").val()==""||$("#CoursePeriod").val()==""||$("#CourseCredit").val()==""){
			alert("带*输入框为空，请检查不为空再提交");
		}else{
			alert("开始提交");
			$.getJSON("AddNewCourse?CourseName="+courseName
					+"&CourseTypeC="+courseType
					+"&CourseCredit="+courseCredit
					+"&CoursePeriodC="+coursePeriod
					+"&CourseDESC="+courseDesc
					,function(Addmessage){
				if(Addmessage==0){
					alert("添加新的课程信息成功!!!");
					//添加成功之后刷行当前页面
					location.replace(location.href);
				}else{
					location.replace(location.href);
				}
			});
		}
		alert("添加课程信息功能结束");
		$("#ResetCourseInfo").click(function(){
			document.getElementById("CourseName").value="";
			document.getElementById("CourseType").value="";
			document.getElementById("CoursePeriod").value="";
			document.getElementById("CourseCredit").value="";
			document.getElementById("CourseDESC").value="";
		});
		$.getJSON("GetAllCourse",function(data){
//			alert("进入GetAllCourse.Action 并且返回了吗？？");
			$.each(data,function(i,value){

				$("#AllCourseTable").append(
				"<tr>" +
					"<td>" +
						value.courseId
					+"</td>"
					+
					"<td>" +
						value.courseName
					+"</td>"
					+
					"<td>" +
						value.courseType
					+"</td>"
					+
					"<td>" +
						value.courseCredit
					+"</td>"
					+
					"<td>" +
						value.coursePeriod
					+"</td>"
					+
					"<td>" +
						value.courseDesc
					+"</td>"
					+
					"<td>" +
						"<input type='button' value='删除' id='"+value.courseId+"' onclick='getName(this)'>"
					+"</td>"
				+"</tr>"
				);
			});
		});
	});
	
	//清空课程输入框的内容
	$("#ResetCourseInfo").click(function(){
		document.getElementById("CourseName").value="";
		document.getElementById("CourseType").value="";
		document.getElementById("CoursePeriod").value="";
		document.getElementById("CourseCredit").value="";
		document.getElementById("CourseDESC").value="";
	});
	
	
	//删除课程的方法
//	function getName(g) {
//		alert("you click it:"+g.id);
//		var i=g.id;
//		$("#"+i).click(function(){
//			$.getJSON("DeleteCourse?CourseId="+i,function(Addmessage){
//				if(Addmessage==0){
//					alert("删除课程信息成功!!!");
//					
//				}else{
//					alert("删除课程信息失败!!!");
//				}
//			});
//		});
//		alert("delete end...");
//	}
});