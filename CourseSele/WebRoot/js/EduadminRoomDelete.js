$(document).ready(function(){

	$("#info").empty();
	$("#info").append("<table id='CoursePlan' style =' display: ;margin:0 auto;height: auto; width: 800px' border='1'><tr><td>教室编号</td><td>教室类型</td><td>可容纳人数</td></tr></table>");
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
					"<td>" +
						"<input type='button' value='删除' id='"+value.roomId+"' onclick='getName(this)'>"
					+"</td>"+
					"</tr>"
					
			);
		});
	});

});