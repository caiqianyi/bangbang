$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {  
	if(parseInt($("#couponBalance").val())>parseInt($("#usecondition").val())){
		layer.msg("优惠券的使用金额不能小于优惠券的面值");
		return;
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/coupon/save",
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
			validity:{required:true,number:true},
			usageScenario:{required:true},
			usecondition:{required:true,number:true}
		},
		messages : {
			couponId : {required : icon + "请输入优惠券编号"},
			couponBalance:{required : icon + "请输入优惠券金额",number:icon + "必须是数字"},
			couponCount:{required : icon + "请输入优惠券发行数量",number:icon + "必须是数字"},
			validity:{required : icon + "请输入有效期天数",number:icon + "必须是数字"},
			usageScenario:{required : icon + "选择使用场景"},
			usecondition:{required:icon + "请输入使用金额",number:icon + "必须是数字"}
		}
	})
}