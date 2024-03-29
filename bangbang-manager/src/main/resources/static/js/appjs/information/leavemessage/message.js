
var prefix = "/information/leavemessage"
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
								userId:$("#user_id option:selected").val(),
								ifanswer:$("#ifanswer option:selected").val()
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
									field : 'userName', 
									title : '留言人' 
								},
																{
									field : 'name', 
									title : '课程名' 
								},
								{
									field : 'chapterName', 
									title : '章节名' 
								},
																{
									field : 'publishTime', 
									title : '发表时间' 
								},
																{
									field : 'count', 
									title : '查看次数' 
								},
								{
									field : 'ifanswer', 
									title : '是否回复',
									formatter : function(value, row, index) {
										if(value==0)
											return '已回复';
										if(value==1)
											return '未回复';
									}
									
								},
								{
									field : 'ifprivate', 
									title : '是否公开',
									formatter : function(value, row, index) {
										if(value==0)
											return '公开';
										if(value==1)
											return '隐私';
									}
									
								},
								{
									field:'showhide',
									title:'显示/隐藏',
									formatter : function(value, row, index) {
										var str = '';
										
										str +=' <div class="switch onoffswitch col-sm-1"> ';
											str +=' <div class="onoffswitch"> ';
												str +=' <input name="allowComment" '; 
												//启用状态 0：是；1：否
												if(row.showhide == 0)
													str += ' checked="" ';
													
												str +=' type="checkbox" onchange="updateEnable(' +row.id+ ',this)" value="' +row.id+ '" class="onoffswitch-checkbox" id="example1' +row.id+ '">  ';
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
										
										var e='<button type="button" class="btn  btn-xs btn-info" onclick="detail(\''+row.id+'\')">查看详情</button>  ';
										return e ;
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
		area : [ '1000px', '800px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
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
function detail(id){
	layer.open({
		type : 2,
		title : '留言详情',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1000px', '800px' ],
		content : "/information/leavemessage/detail/"+id // iframe的url
	});
}

/**
 * 留言的显示和隐藏
 */
function updateEnable(id,enable) {
	var isEnable = 1;
	if($(enable).prop("checked")){
		isEnable = 0;
	}
		$.ajax({
			url : prefix+"/updateShowHide",
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
