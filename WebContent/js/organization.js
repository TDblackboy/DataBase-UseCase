/**
 * 平台组织形式
 */

/**
 * 1select添加事件change
 * 2选择器的选取
*/
$(document).ready(function(){
	$('#pz').change(function(){
		var pz=$('#pz').val();
		if(pz=='独立法人'){
			$('.ddd9-2').css("display","block");
		}else{
			$('.ddd9-2').css("display","none");
		}
	})
})