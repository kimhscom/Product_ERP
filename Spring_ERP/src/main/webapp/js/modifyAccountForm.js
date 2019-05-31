$(document).ready(function(){
	// 수정
	$(".btn-primary").click(function() {
		alert("개인정보가 수정되었습니다.");
		document.frm.action = "./modifyAccount.do";
		document.frm.submit();
	});
	
	// 취소
//	$(".btn-warning").click(function() {
//		location.href = "javascript:history.back(-1)";
//	});
	
	// 탈퇴
	$(".btn-danger").click(function() {
		if (confirm("사이트에서 탈퇴하시겠습니까?")) {
			alert("탈퇴처리 되었습니다.");
			document.frm.action = "./deleteAccount.do";
			document.frm.submit();
		}else{
			alert("취소 되었습니다.");
		}
		
	});
	
});