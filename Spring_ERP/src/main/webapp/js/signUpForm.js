$(document).ready(function(){
	// id 중복 + 유효값 ajax
	$("#account_id").keyup(function(){
		var inputLength = $(this).val().length;
//		alert(inputLength);
		var account_id = $(this).val();
		// 공백 유효값 검사
		if (account_id.indexOf(" ") != -1) {
//			alert("공백 있음");
			$("#result_id").css("color","red");
			$("#result_id").html("공백이 포함된 아이디는 사용이 불가 합니다.");
			$("#chaVal").val("0"); // document.getElementById("chaVal").value = "0";
		}else if(inputLength > 5){
//			alert("ajax 작동");
			jQuery.ajax({
				url : "./idCheck.do",
				type : "post",
				data : "account_id="+$(this).val(),
				async : true,
				success : function(msg) {
//					alert(msg);
					$("#result_id").html(msg);
					var temp = msg;
					temp = temp.substring(0,temp.indexOf("디")+1);
					if (temp == "사용가능한 아이디") {
						$("#chaVal").val(1);
						$("#result_id").css("color","blue");
					}else{
						$("#chaVal").val(0);
						$("#result_id").css("color","red");
					}
				}
			});
		}else{
			$("#result_id").css("color","red");
			$("#result_id").html("6자리 이상만 사용가능합니다.");
			$("#chaVal").val("0"); // document.getElementById("chaVal").value = "0";
		}
	});
	
	// 비밀번호 유효값
	$("#account_pw").keyup(function(){
		var pwLength = $(this).val().length;
//		alert(pwLength);
		var account_pw = $(this).val();
		var rePw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;
		if (account_pw.indexOf(" ") != -1) {
//			alert("공백 있음");
			$("#result_pw").css("color","red");
			$("#result_pw").html("공백이 포함된 비밀번호는 사용이 불가 합니다.");
		}else if(pwLength > 7){
//			alert("유효값 통과");
			if (rePw.test(account_pw) == true) {
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
	$("#confirmPw").keyup(function(){
		var confirmPw = $(this).val();
//		alert(confirmPw);
		var account_pw = $("#account_pw").val();
		if (account_pw == confirmPw) {
//			alert("일치");
			$("#result_comfirm").css("color","blue");
			$("#result_comfirm").html("비밀번호 일치!");
		}else{
//			alert("불일치");
			$("#result_comfirm").css("color","red");
			$("#result_comfirm").html("비밀번호 불일치!!!");
		}
	});	

	// 이메일 유효값
	$("#account_email").keyup(function(){
		var account_email = $(this).val();
//		alert(account_email);
		var reMail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

		if (reMail.test(account_email) == true) {
//			alert("값이 유효함");
			$("#result_email").css("color","blue");
			$("#result_email").html("이메일 주소가 유효합니다.");
		}else{
//			alert("값이 유효하지 않음");
			$("#result_email").css("color","red");
			$("#result_email").html("이메일 주소가 유효하지 않습니다.");
		}
	});

	// 전화번호 유효값
	$("#account_phone").keyup(function(){
		var account_phone = $(this).val();
//		alert(account_phone);
		var rePhone = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

		if (rePhone.test(account_phone) == true) {
//			alert("값이 유효 함");
			$("#result_phone").css("color","blue");
			$("#result_phone").html("전화번호가 유효합니다.");
		}else{
//			alert("값이 유효 하지않음");
			$("#result_phone").css("color","red");
			$("#result_phone").html("전화번호가 유효하지 않습니다.");
		}
	});
	
	// 이름 유효값
	$("#account_name").keyup(function(){
		var account_name = $(this).val();
//		alert(account_name);
		var reName = /^[가-힣]{2,50}$/;
		
		if (reName.test(account_name) == true) {
//			alert("값이 유효 함");
			$("#result_name").css("color","blue");
			$("#result_name").html("이름이 유효합니다.");
		}else{
//			alert("값이 유효 하지않음");
			$("#result_name").css("color","red");
			$("#result_name").html("이름이 유효하지 않습니다.");
		}
	});

});


function check() {
	var frm = document.forms[0]; // document.frm // document.getElementById("frm")
	var chk = document.getElementById("chaVal").value;
	
	if (chk == "0") {
		swal("계정 등록 오류","각 항목 중복체크 및 잘못된 값을 확인해 주세요");
		return false;
	}else{
		return true;
	}
}