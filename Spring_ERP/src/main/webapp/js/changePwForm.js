$(document).ready(function(){
	// 비밀번호 유효값
	$("#change_pw").keyup(function(){
		var pwLength = $(this).val().length;
//		alert(pwLength);
		var change_pw = $(this).val();
		var account_pw = $("#account_pw").val();
		var rePw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;
		
		if (change_pw.indexOf(" ") != -1) {
//			alert("공백 있음");
			$("#result_pw").css("color","red");
			$("#result_pw").html("공백이 포함된 비밀번호는 사용이 불가 합니다.");
		}else if(account_pw == change_pw){
			$("#result_pw").css("color","red");
			$("#result_pw").html("기존 비밀번호는 사용하실 수 없습니다.");
		}else if(pwLength > 7){
//			alert("유효값 통과");
			if (rePw.test(change_pw) == true) {
//				alert("유효값 통과");
				$("#result_pw").css("color","blue");
				$("#result_pw").html("사용하실 수 있습니다.");
			}else{
//				alert("유효값 실패");
				$("#result_pw").css("color","red");
				$("#result_pw").html("사용하실 수 없습니다.");
			}
		}else{
			$("#result_pw").css("color","red");
			$("#result_pw").html("최소 8자리이상 사용가능합니다.");
		}
	});
	
	// 비밀번호 확인
	$("#passOK").keyup(function(){
		var confirmPw = $(this).val();
//		alert(confirmPw);
		var change_pw = $("#change_pw").val();
		if (change_pw == confirmPw) {
//			alert("일치");
			$("#result_confirm").css("color","blue");
			$("#result_confirm").html("비밀번호 일치!");
		}else{
//			alert("불일치");
			$("#result_confirm").css("color","red");
			$("#result_confirm").html("비밀번호 불일치!!!");
		}
	});
	
	// 변경 처리
	$("#btnConfirm").click(function(){
		var account_pw = $("#account_pw").val();
		var change_pw = $("#change_pw").val();
		var passOK = $("#passOK").val();
		
		// 확인 대화상자
		if (confirm("비밀번호를 변경하시겠습니까?")) {
//			alert("변경성공");
			if (account_pw == change_pw) {
				alert("기존 비밀번호는 사용할 수 없습니다.");
			}else if(change_pw != passOK){
				alert("비밀번호 변경 오류!!! 비밀번호를 확인하십시오.");				
			}else{
				alert("비밀번호를 변경하였습니다.");
				document.frm.action = "./changePw.do";
				document.frm.submit();
			}
			
		}else{
			alert("변경을 취소했습니다.");
		}
	});
});