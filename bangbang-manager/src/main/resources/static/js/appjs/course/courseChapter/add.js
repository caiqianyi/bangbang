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
		interval();
		save();
	}
});

//每100ms获取一次图片上传进度
var intervalId;
function interval(){
    intervalId = window.setInterval(showPercent, 100);
}

//获取图片进度数据
function showPercent(){
	var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/courseChapter/percent",
		data : formData, // $('#signupForm').serialize(),// 你的formid
		async : false,
	    processData:false,
		contentType:false,
		success : function(data) {
			//console.log(data);
			var end = 0;
            var per = 0;
            end = data.end;
            per = data.percent + "%";
            console.log(per);
            console.log("end:" + end);
            $("#percent").val(data.percent);//图片上传进度
            $("#per").html(per);
            if (per == '100%'){ //图片上传结束标识
                stopInterval();
                //图片上传完成session重置
            	clearPercent();
        	}

		},
		error : function(request) {
			stopInterval();
			clearPercent();
			parent.layer.alert("文件太大");
		}
	});
}

//清除进度数据
function clearPercent(){
	$.ajax({
	        type : "POST",
	        contentType : false,
	        async : false,
	        cache : false,
	        url : "/information/courseChapter/percent/reset",
	        dataType : "json",
	        success : function(data) {
	        console.log("ddd:"+data);
	        }
	    });
}

//清除时间
function stopInterval(){
  window.clearInterval(intervalId);
}
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
		async : true,
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