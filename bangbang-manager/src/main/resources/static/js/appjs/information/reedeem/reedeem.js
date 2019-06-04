
var prefix = "/information/reedeem"
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
								createTime:$("#createTime").val(),
								ifUsed:$("[name='ifUsed'] option:selected").val(),
								reedeemType:$("[name='reedeemType'] option:selected").val(),
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
																{
									field : 'id', 
									title : 'id' 
								},
																{
									field : 'reedeemCode', 
									title : '兑换码' 
								},
								{
									field : 'reedeemName', 
									title : '兑换码名称' 
								},
								
								{
									field:'reedeemType',
									title:'兑换类型',
									formatter : function(value, row, index) {
										if(value==0)
											return '兑换课程   <font color="green">' +row.courseName+'</font>';
										if(value==1)
											return '兑换余额   <font color="green">面值' +row.reedeemBalance+'元</font>';
										if(value==2)
											return '兑换优惠券  <font color="green">' +row.couponId+'</font>，一次使用';
										if(value==3)
											return '兑换优惠券，<font color="green">' +row.couponId+'</font>，多次使用';
									}
								},
								 
																{
									field : 'createTime', 
									title : '创建时间<img src="/img/sort_both.png">',
									sortable : true
								},
								
																{
									field : 'createName', 
									title : '创建者' 
								},
								{
									field : 'reedeemCount', 
									title : '兑换总数量' 
								},
								{
									field : 'reedeemSurplus', 
									title : '未兑换数量' 
								},
								{
									field : 'reedeemSurplus', 
									title : '是否兑换',
									formatter : function(value, row, index) {
										if(value==0)
											return "已兑换";
										if(value>0)
											return "未兑换";
									}
									
								},
								{
									field: 'ifStop',
									title: '启用/停用',
									formatter : function(value, row, index) {
										if(row.reedeemType!=3) return '';
										var str = '';
										
										str +=' <div class="switch onoffswitch col-sm-1"> ';
											str +=' <div class="onoffswitch"> ';
												str +=' <input name="allowComment" '; 
												//启用状态 0：是；1：否
												if(row.ifStop == 0)
													str += ' checked="" ';
													
												str +=' type="checkbox" onchange="updateIfstop(' +row.id+ ',this)" value="' +row.id+ '" class="onoffswitch-checkbox" id="example1' +row.id+ '">  ';
												str +=' <label class="onoffswitch-label" for="example1' +row.id+ '">  ';
													str +=' <span class="onoffswitch-inner"></span> ';
													str +=' <span class="onoffswitch-switch"></span> ';
														str +=' </label> ';
											str +=' </div>';
										str +=' </div>';
										return str;
									} 
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
										var e='<button type="button" class="btn  btn-xs btn-default" onclick="edit(\''+row.id+'\',\''+row.ifStop+'\',\''+row.reedeemCount+'\',\''+row.reedeemSurplus+'\')">编辑</button>  ';
										var d='<button type="button" class="btn  btn-xs btn-danger" onclick="duihuanyonghu(\''+row.reedeemCode+'\')"> 兑换用户</button>  ';
									//	var f= '<button type="button" class="btn btn-xs btn-info" onclick="sendout(\''+row.reedeemCode+'\',\''+row.id+'\',\''+row.reedeemType+'\',\''+row.reedeemSurplus+'\',\''+row.reedeemBalance+'\',\''+row.courseName+'\',\''+row.validity+'\')">&nbsp;&nbsp;&nbsp;发放</button>  ';
										
									//	if(row.reedeemSurplus==0)
									//		f= '<button type="button" class="btn btn-xs btn-info" disabled="disabled">发放</button>  ';
								        return e+d;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '480px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id,ifStop,reedeemCount,reedeemSurplus) {
	if(ifStop==1){
		layer.msg("兑换码已经停用，不可编辑！！");
		return;
	}
	if(parseInt(reedeemSurplus)==0){
		layer.msg("兑换码已兑换，不可编辑！！");
		return;
	}
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '300px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}


function updateIfstop(id,enable){
	var isEnable = 1;
	if($(enable).prop("checked")){
		isEnable = 0;
	}

	$.ajax({
		url : prefix+"/updateIfStop",
		type : "post",
		data : {
			'id' : id,
			'enable':isEnable
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
}

function duihuanyonghu(reedeemCode){
	layer.open({
		type : 2,
		title : '兑换用户',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '480px' ],
		content : prefix + '/duihuanyonghu/'+ reedeemCode// iframe的url
	});
}