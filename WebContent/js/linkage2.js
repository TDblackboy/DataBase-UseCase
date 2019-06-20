/**
 * 
 */
//数组 - 键值对  [键：值，];
//这三个数组也可以从数据库中读出
var arr2_p=[
	{'id':0,'text':'选择行业'},
	{'id':1,'text':'建筑业'},
	{'id':2,'text':'信息设备制造'},
	{'id':3,'text':'互联网'},
];

var arr2_c=[
	{'id':0,'c_id':0,'text':'next'},
	{'id':1,'c_id':1,'text':'房屋'},
	{'id':2,'c_id':1,'text':'土木'},
	{'id':3,'c_id':2,'text':'计算机制造'},
	{'id':4,'c_id':2,'text':'通讯制造'},
	{'id':5,'c_id':3,'text':'互联网信息'},
	{'id':6,'c_id':3,'text':'互联网平台'},
];

var arr2_a=[
	{'id':0,'a_id':0,'text':'next'},
	{'id':1,'a_id':1,'text':'体育'},
	{'id':2,'a_id':1,'text':'住宅'},
	{'id':3,'a_id':2,'text':'铁路'},
	{'id':4,'a_id':2,'text':'公路'},
	{'id':5,'a_id':3,'text':'外围设备'},
	{'id':6,'a_id':3,'text':'零件制造'},
	{'id':7,'a_id':4,'text':'终端制造'},
	{'id':8,'a_id':4,'text':'音响'},
	{'id':9,'a_id':5,'text':'搜索'},
	{'id':10,'a_id':5,'text':'游戏'},
	{'id':11,'a_id':6,'text':'生活'},
	{'id':12,'a_id':6,'text':'生产'},
	
]
//基础：select—下拉框，option-框中内容
//第一个下拉菜单
function general_h_p(){
	var select = $("#economy_a");
	var len=arr2_p.length;
	for(var i=0;i<len;i++){
		var option='<option value="'+arr2_p[i]['id']+'">'+arr2_p[i]['text']+'</option>'
		select.append(option);
	}
}
//第二个
function general_h_c(c_id){
	var select=$("#economy_b");
	select.empty();//清空option的值
	var len=arr2_c.length;
	for(var i=0;i<len;i++){
		if(arr2_c[i]['c_id']==c_id){
			var option='<option value="'+arr2_c[i]['id']+'">'+arr2_c[i]['text']+'</option>'
			select.append(option);
		}
	}
}
//第三个
function general_h_a(a_id){
	var select=$("#economy_c");
	select.empty();
	var len=arr2_a.length;
	for(var i=0;i<len;i++){
		if(arr2_a[i]['a_id']==a_id){
			var option='<option value="'+arr2_a[i]['id']+'">'+arr2_a[i]['text']+'</option>'
			select.append(option);
		}
	}
}

//加载方法
//$().ready()
$(document).ready(function(){
	general_h_p();
	general_h_c(0);
	general_h_a(0);
	
	//select-加change事件
	//p->c,c->a
	//根据当前值来选择性的显示下一个下拉框的信息
	$("#economy_a").change(function(){
		var c_id=$(this).val();//当前元素的第一个值
		general_h_c(c_id);
		var a_id=$("#economy_b").val();
		general_h_a(a_id);
	});
	$("#economy_b").change(function(){
		var a_id=$(this).val();
		general_h_a(a_id);
	})
})

