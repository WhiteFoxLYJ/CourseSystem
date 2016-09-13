$(document).ready(function(){
	alert("Welcome to the SelectCourse System");
	$("#login_sub").click(function(){
		
		
//		$.ajax({
//			url:"loginAction.action",
//			type:'post',
//			dataType:'json',
//			success:function(data){
//				alert("login success");
//			},
//			error:function(){
//				alert("login faile,Please try again");
//			}
//		});
		
		/*var Id=$("#Id").value;
		var Name=$("#name").value;
		var Password=$("#Password").value;
		var options=$("#type option:selected");
		if(Id==null){
			alert("登录帐号为空，请重新输入");
		}else
		if(Name==null){
			alert("用户名称为空，请重新输入");
		}else
		if(Password==null){
			alert("帐号密码为空，请重新输入");
		}else
		if(options.val()==null){
			alert("用户类型为空，请重新选择");
		}else{
			alert("信息确认");
		}*/
	});
	
	function getID(g){
		alert("sdasda");
		var id=g.id;
		if(id=="type"){
			if($("#"+id+"option:selected").val()==null){
				$("#"+id).after("<span>该项不能为空</span>");
		}else if($("#"+id).value==null){
				$("#"+id).after("<span>该项不能为空</span>");
			}
		}
	}
	
});