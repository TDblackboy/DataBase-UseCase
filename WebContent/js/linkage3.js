/**
 * 
 */
//数组 - 键值对  [键：值，];
//这三个数组也可以从数据库中读出
var arr3_p=[
	{'id':0,'text':'选择学课'},
	{'id':1,'text':'天文学'},
	{'id':2,'text':'生物学'},
	{'id':3,'text':'心理学'},
];

var arr3_c=[
	{'id':0,'c_id':0,'text':'next'},
	{'id':1,'c_id':1,'text':'天体力学'},
	{'id':2,'c_id':1,'text':'宇宙化学'},
	{'id':3,'c_id':2,'text':'生物物理'},
	{'id':4,'c_id':2,'text':'生物化学'},
	{'id':5,'c_id':3,'text':'认知心理学'},
	{'id':6,'c_id':3,'text':'社会心理学'},
];

var arr3_a=[
	{'id':0,'a_id':0,'text':'next'},
	{'id':1,'a_id':1,'text':'摄动原理'},
	{'id':2,'a_id':1,'text':'天体力学理论'},
	{'id':3,'a_id':2,'text':'空间化学'},
	{'id':4,'a_id':2,'text':'天体元素学'},
	{'id':5,'a_id':3,'text':'生物电磁'},
	{'id':6,'a_id':3,'text':'生物能量'},
	{'id':7,'a_id':4,'text':'核酸化学'},
	{'id':8,'a_id':4,'text':'多肽化学'},
	{'id':9,'a_id':5,'text':'知觉'},
	{'id':10,'a_id':5,'text':'心理语言学'},
	{'id':11,'a_id':6,'text':'家庭'},
	{'id':12,'a_id':6,'text':'婚姻'},
	
]
//基础：select—下拉框，option-框中内容
//第一个下拉菜单
function general_x_p(){
	var select = $("#lesson_x");
	var len=arr3_p.length;
	for(var i=0;i<len;i++){
		var option='<option value="'+arr3_p[i]['id']+'">'+arr3_p[i]['text']+'</option>'
		select.append(option);
	}
}
//第二个
function general_x_c(c_id){
	var select=$("#lesson_y");
	select.empty();//清空option的值
	var len=arr3_c.length;
	for(var i=0;i<len;i++){
		if(arr3_c[i]['c_id']==c_id){
			var option='<option value="'+arr3_c[i]['id']+'">'+arr3_c[i]['text']+'</option>'
			select.append(option);
		}
	}
}
//第三个
function general_x_a(a_id){
	var select=$("#lesson_z");
	select.empty();
	var len=arr3_a.length;
	for(var i=0;i<len;i++){
		if(arr3_a[i]['a_id']==a_id){
			var option='<option value="'+arr3_a[i]['id']+'">'+arr3_a[i]['text']+'</option>'
			select.append(option);
		}
	}
}

//加载方法
//$().ready()
$(document).ready(function(){
	general_x_p();
	general_x_c(0);
	general_x_a(0);
	
	//select-加change事件
	//p->c,c->a
	$("#lesson_x").change(function(){
		var c_id=$(this).val();//当前元素的第一个值
		general_x_c(c_id);
		var a_id=$("#lesson_y").val();
		general_x_a(a_id);
	});
	$("#lesson_y").change(function(){
		var a_id=$(this).val();
		general_x_a(a_id);
	})
})

