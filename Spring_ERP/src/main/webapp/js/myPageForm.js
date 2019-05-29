$(document).ready(function(){
	
	$(".btn-warning").click(function() {
		document.frm.action = "./modifyAccountForm.do";
		document.frm.submit();
	});
	
});