/**
 *  实现 可增加 检索条件
 */

$(document).ready(function(){
	$('.syn-plus').click(function(){
		var len=$('.syn-table').find('tr').length;
		if(len<4){
			len=len+1;
			console.log("length="+len+";");
			var newTr="<tr><td>增加</td><td>" +
					"<select name='pcondition' class='syn-table-select' id='s"+len+"'>" +
					"<option class='o1' value='pname'>平台名称</option>" +
					"<option class='o2' value='pyname'>院长/主任</option>" +
					"<option class='o3' value='yname'>依托单位</option>" +
					"<option class='o4' value='pgongjian'>共建单位</option>" +
					"</select></td>"+
					"<td><input type='text' name='pctext'></td></tr>";
			$('.syn-table').append(newTr);
			$("#s"+len+" option[class='o"+len+"']").attr("selected",true);
		}else{
			alert('最多可增加3个检索条件');
		}
		
	})
	
	$('.syn-minus').click(function(){
		var len=$('.syn-table').find('tr').length;
		console.log(len);
		if(len>1){
			$('.syn-table').find('tr').eq(len-1).remove();
		}else{
			alert('保留原始检索条件');
		}
		
		/*var remTr=$('.syn-table').find('tr').eq(len-1);
		console.log(remTr);
		remTr.remove();*/
		/*$('.syn-table '+remTr).remove();*/
		
	})
});