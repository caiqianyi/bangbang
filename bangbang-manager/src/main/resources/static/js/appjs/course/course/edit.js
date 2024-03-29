$().ready(function() {
	$('.summernote').summernote({
		height : '80px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				sendFile(files);
			}
		}
	});
	$('#content_sn').summernote('code', $("#courseNotes").val());
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
	$('#content_sn2').summernote('code', $("#questionsNotes2").val());
	$('.summernote3').summernote({
		height : '80px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				sendFile(files);
			}
		}
	});
	$('#content_sn3').summernote('code', $("#questionsNotes3").val());
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	var mnn1 =$('.form-group1').css('display');
	var mnn2 =$('.form-group2').css('display');
	var mnn3 =$('.form-group3').css('display');
	var content_sn = $("#content_sn").summernote('code');
	$("#courseNotes").val(content_sn);
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
		url : "/information/course/update",
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
        }else{
    		return true;
    	}
        return true;

    }, "请说明课程价格");
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			money : {
				isMoney : true
			},
			teacher : {
				required : true
			},
		},
		messages : {
			name : {
				required : icon + "请输入课程名称"
			},
			money : {
				isMoney : icon + "请说明课程价格"
			},
			teacher : {
				required : icon + "请选择老师"
			},
		}
	})
}