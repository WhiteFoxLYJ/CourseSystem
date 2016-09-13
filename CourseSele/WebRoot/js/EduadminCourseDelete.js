$(document).ready(function(){
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

	//删除课程的方法
//	function getName(g) {
//		alert("you click it:"+g.id);
//		var i=g.id;
//		$("#"+i).click(function(){
//			$.getJSON("DeleteCourse?CourseId="+i,function(Addmessage){
//				if(Addmessage==0){
//					alert("删除课程信息成功!!!");
//					location.replace(location.href);
//				}else{
//					alert("删除课程信息失败!!!");
//					location.replace(location.href);
//				}
//			});
//		});
//		alert("delete end...");
//	}
});