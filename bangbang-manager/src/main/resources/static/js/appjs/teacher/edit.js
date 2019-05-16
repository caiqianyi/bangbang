$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/teacher/update",
		data : formData, //$('#signupForm').serialize(),// 你的formid
		async : false,
		processData:false,
		contentType:false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			phone: {
				required : true,
				minlength : 11, 
				isPhone :true
			},
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			},
			phone : {
				required : icon + "手机号不能为空",
				minlength : "手机号码格式不正确", 
				isPhone :"手机号码格式不正确"
			}
		}
	})
	//手机号码验证  
	jQuery.validator.addMethod("isPhone", function(value, element) {  
	 var length = value.length;  
	 var phone = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;  
	 return this.optional(element) || (length == 11 && phone.test(value));  
	}, "请正确填写手机号码"); 
}