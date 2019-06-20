/**
 * 导航栏navigations
 */
$(document).ready(function(){
	$('#ret').on('click',function(){
		$('#ret-ul').fadeToggle(200);
	});
	$('#ret-ul li').on('click',function(){
		$(this).addClass('active').siblings('li').removeClass('active');
	});
});