$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/reedeem/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
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
			reedeemType : {required : true},
			reedeemCount:{required : true,number:true},
			validity:{required : true,number:true}
		},
		messages : {
			reedeemType : {required : icon + "兑换方式不能为空"},
			reedeemCount : {required : icon + "发行数量不能为空",number:icon + "必须是数字"},
			validity : {required : icon + "有效期不能为空",number:icon + "必须是数字"}
		}
	})
}