/**
 * 
 */

	$(document).ready(function(){
		//增加
		$('#div-add').click(function(){
			var newTr="<tr><td>共建单位名称：</td>";
			newTr+="<td><input type='text' name='pgongjian' class='div-input-class'></td>";
			newTr+="<td><img src='../img/minus.jpg' id='div-minus'></td>";
			$('#div-table').append(newTr);
		});
		//删除
		$('table').on('click','#div-minus',function(){
			$(this).parent().parent().remove();
		}); 
	});