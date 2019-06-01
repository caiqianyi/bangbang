$().ready(function() {
	$('.summernote').summernote({
		height : '150px',
		lang : 'zh-CN',
		callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
	});
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	
	var content_sn = $("#content_sn").summernote('code');
	$("#appImprint").val(content_sn);
	var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/versionManagement/save",
		data : formData,// 你的formid
		processData:false,
		contentType:false,
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
			name : {
				required : true
			},
			appNum:{
				required : true
			},
			appDownloadLink:{
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			},
			appNum:{
				required : icon + "不允许为空"
			},
			appDownloadLink:{
				required : icon + "不允许为空"
			}
		}
	})
}