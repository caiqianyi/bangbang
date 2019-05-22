$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	if($('#userIdArray').val()==null){
		layer.msg("请选择用户");
		return;
	}
	
	if($('#userIdArray').val().length>$('#couponSurplus').val().length){
		layer.msg("优惠券数量不足");
		return;
	}
	
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/sendoutcoupon/save",
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
			validity: {required : true}
			
	},
		messages : {
			
			validity : {required : icon + "有效期不能为空"}
		}
	})
}

$("[name='courseId']").change(function(){
	var courseId=$(this).val();
	$.ajax({
		cache : true,
		type : "GET",
		url : "/information/subcriberlog/getSubcriberlogByCourseId",
		data :{courseId:courseId},
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {console.info(data);
			if(data.length>0){
				$('#userIdArray').html('')
				for(var i=0;i<data.length;i++){
					$('#userIdArray').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
				}
				
			}
			 $('#userIdArray').selectpicker('refresh');  
		}
	});
	
	 
});