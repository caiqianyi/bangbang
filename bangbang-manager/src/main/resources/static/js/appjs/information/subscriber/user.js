
var prefix = "/information/subscriber"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
								nameORphone:$('#nameORphone').val(),
								sex:$("#sex option:selected").val(),
								order: params.order,//排序
								sort:params.sort//排序字段
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																/*{
									field : 'id', 
									title : 'id' 
								},*/
																{
									field : 'heardUrl', 
									title : '头像' 
								},
																{
									field : 'username', 
									title : '用户名' 
								},
								{
									field : 'name', 
									title : '真实姓名' 
								},
																{
									field : 'signName', 
									title : '签名' 
								},
								{
									field : 'nickname', 
									title : '昵称' 
								},
																							
																{
									field : 'phone', 
									title : '手机号' 
								},
								{
									field : 'phoneSystem', 
									title : '手机系统',
									formatter : function(value, row, index) {
										if(value==0)
											return 'Android';
										if(value==1)
											return 'ios';
										if(value==2)
											return '其他';
									}
								},
																{
									field : 'sex', 
									title : '性别',
									formatter : function(value, row, index) {
										if(value==1)
											return '男';
										if(value==2)
											return '女';
									}
								},
								{
									field : 'balance', 
									title : '时光贝' 
								},
																{
									field : 'birthday', 
									title : '出生年月' 
								},
																{
									field : 'loginTime', 
									title : '最后登录时间<img src="/img/sort_both.png">',
									sortable : true
								},
																{
									field : 'usedTime', 
									title : '使用时间' 
								},
																
								{
									field : 'registrationSource', 
									title : '注册来源' 
								},								
																
																{
									field : 'registerTime', 
									title : '注册时间<img src="/img/sort_both.png">',
									sortable : true
								},
																{
									field : 'updateTime', 
									title : '编辑时间' 
								},
																
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										/*var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;*/
										var e='<button type="button" class="btn  btn-xs btn-default" onclick="zhuanfa(\''+row.id+'\')">转发</button>  ';
										var d= '<button type="button" class="btn btn-xs btn-danger" onclick="shoucang (\''+row.id+'\')">收藏</button>  ';
										var f= '<button type="button" class="btn btn-xs btn-success" onclick="xiaofei(\''+row.id+'\')">购买</button>  ';
								        return e+d+f;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}


function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}


function zhuanfa(id){
	var flag=1;
	window.location.href="/information/subcriberlog/"+flag+"/"+id
}

function shoucang(id){
	var flag=2;
	window.location.href="/information/subcriberlog/"+flag+"/"+id
}
function xiaofei(id){
	var flag=0;
	window.location.href="/information/subcriberlog/"+flag+"/"+id
}

function bofangjilu(){
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要查看的用户");
		return;
	}
	if(rows.length>1){
		layer.msg("请选择一个用户查看");
		return;
	}
	var id = rows[0]['id'];
	window.location.href='/information/record/'+id
}

function youhuiquan(){
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要查看的用户");
		return;
	}
	if(rows.length>1){
		layer.msg("请选择一个用户查看");
		return;
	}
	var id = rows[0]['id'];
	window.location.href='/information/sendoutcoupon/'+id
}

function duihuanma(){
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要查看的用户");
		return;
	}
	if(rows.length>1){
		layer.msg("请选择一个用户查看");
		return;
	}
	var id = rows[0]['id'];
	window.location.href='/information/sendoutreedeem/'+id;
}