$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/coupon/update",
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
			couponId : {required : true},
			couponBalance:{required:true,number:true},
			couponCount:{required:true,number:true},
			validity:{required:true,number:true}
		},
		messages : {
			couponId : {required : icon + "请输入优惠券编号"},
			couponBalance:{required : icon + "请输入优惠券金额",number:icon + "必须是数字"},
			couponCount:{required : icon + "请输入优惠券发行数量",number:icon + "必须是数字"},
			validity:{required : icon + "请输入有效期天数",number:icon + "必须是数字"}
		}
	})
}