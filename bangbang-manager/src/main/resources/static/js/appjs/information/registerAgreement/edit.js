$().ready(function() {
	$('.summernote').summernote({
		height : '500px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				sendFile(files);
			}
		}
	});
	$('#content_sn').summernote('code', $("#content").val());
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/registerAgreement/update",
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
				//var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				//parent.layer.close(index);

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
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}