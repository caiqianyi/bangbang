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
	$('.summernote1').summernote({
		height : '80px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				sendFile(files);
			}
		}
	});
	$('#content_sn1').summernote('code', $("#questionsNotes1").val());
	$('.summernote2').summernote({
		height : '80px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				sendFile(files);
			}
		}
	});
	$('.summernote3').summernote({
		height : '80px',
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
	$("#courseNotes").val(content_sn);
	var mnn1 =$('.form-group1').css('display');
	var mnn2 =$('.form-group2').css('display');
	var mnn3 =$('.form-group3').css('display');
	var content_sn = $("#content_sn1").summernote('code');
	if(mnn1 == 'none'){
		$("#questionsNotes1").val('');
		$("#questionsMoney1").val('0');
	}else{
		$("#questionsNotes1").val(content_sn);
	}
	var content_sn = $("#content_sn2").summernote('code');
	if(mnn2 == 'none'){
		$("#questionsNotes2").val('');
		$("#questionsMoney2").val('0');
	}else{
		$("#questionsNotes2").val(content_sn);
	}
	var content_sn = $("#content_sn3").summernote('code');
	if(mnn3 == 'none'){
		$("#questionsNotes3").val('');
		$("#questionsMoney3").val('0');
	}else{
		$("#questionsNotes3").val(content_sn);
	}
	var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/course/save",
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
	jQuery.validator.addMethod("isMoney", function(value, element) {
		var radioTrue = $("input[name='moneyType']:checked").val();
        if(radioTrue==0) {
        	var money = $("input[name='money']").val();
        	if(money == null || money == ""){
        		return false;
        	}
        }
        return true;

    }, "请说明课程价格");
	
	$("#signupForm").validate({
		ignore: "",
		rules : {
			courseId : {
				required : true
			},
			courseName : {
				required : true
			},
			name : {
				required : true
			},
			money : {
				isMoney : true
			},
			teachers : {
				required : true
			},
		},
		messages : {
			courseId : {
				required : icon + "请输入一个课程编号"
			},
			courseName : {
				required : icon + "请选择课程分类"
			},
			name : {
				required : icon + "请输入课程名称"
			},
			money : {
				isMoney : icon + "请说明课程价格"
			},
			teachers : {
				required : icon + "请选择老师"
			},
		}
	})

}