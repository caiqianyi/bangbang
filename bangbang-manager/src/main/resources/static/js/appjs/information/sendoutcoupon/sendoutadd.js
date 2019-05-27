$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var arry=[];
	if($('#userIdArray12').val()==null){
		$("#userIdArray12 option").each(function(){
			arry.push($(this).val());
		});
	}
	else{
		arry=$('#userIdArray12').val();
	}
	if(arry.length==0){
		layer.msg("当前条件下，没有用户");
		return;
	}
	if(arry.length>$("#couponSurplus").val()){
		layer.msg("优惠券的数量不足");
		return;
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/sendoutcoupon/save",
		data : {couponId:$("#couponId").val(),validity:$("#validity").val(),couponGroup:$("#couponGroup").val(),userIdArray:arry},// 你的formid
		traditional: true,
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
$("#userIdArray12").selectpicker({
    noneSelectedText: '请选择用户' //默认显示内容  
 });
$("[name='courseId']").change(function(){
	var courseId=$(this).val();
	var text=$(this).children(":selected").text();
	$.ajax({
		cache : true,
		type : "GET",
		url : "/information/subcriberlog/getSubcriberlogByCourseId",
		data :{courseId:courseId},
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
		$('#userIdArray12').html('')
			if(data.length>0){
				$("#userIdArray12").selectpicker({
	                noneSelectedText: '请选择用户' //默认显示内容  
                 });
				for(var i=0;i<data.length;i++){
					$('#userIdArray12').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
				}
				
			}
			if(data.length==0){
				$("#userIdArray12").selectpicker({
	                noneSelectedText: '没有购买'+text+"课程的用户" //默认显示内容  
                 });
			}
			 $('#userIdArray12').selectpicker('refresh');  
		}
	});
	
	 
});