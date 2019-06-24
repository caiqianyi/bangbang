$().ready(function() {
	$('.summernote').summernote({
		height : '100px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				sendFile(files);
			}
		}
	});
	$('.summernote1').summernote({
		height : '100px',
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
	$("#chapterNotes").val(content_sn);
	var content_sn = $("#content_sn1").summernote('code');
	$("#url").val(content_sn);
	var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/courseChapter/save",
		data : formData, // $('#signupForm').serialize(),// 你的formid
		async : false,
	    processData:false,
		contentType:false,
		success : function(data) {
			console.log(data);
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		},
		error : function(request) {
			parent.layer.alert("文件太大");
		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			chapterId : {
				required : true
			},
			chapterName : {
				required : true
			},
			url : {
				required : true
			},
		},
		messages : {
			chapterId : {
				required : icon + "请输入一个章节Id"
			},
			chapterName : {
				required : icon + "请输入章节名称"
			},
			url : {
				required : icon + "您还未上传课程"
			}
		}
	})
}