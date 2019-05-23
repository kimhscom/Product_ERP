<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="./css/SignUp.css">

<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js"></script>
<title>계정 등록</title>
</head>
<script type="text/javascript">
function check() {
	// pw 확인, id 중복
	var account_pw = document.getElementById("account_pw").value;
	var passOK = document.getElementById("passOK").value;
	alert(account_pw+":"+passOK);
}

//id 중복 + 유효값 ajax
	$(document).ready(function(){
		$("#account_id").keyup(function(){
			var inputLength = $(this).val().length;
// 			alert(inputLength);
			var account_id = $(this).val();
			// 공백 유효값 검사
			if(id.indexOf(" ") != -1){
// 				alert("공백 있음");
				$("#result").css("color","red");
				$("#result").html("공백이 포함된 아이디는 사용이 불가 합니다.");
				$("#chaVal").val("0"); // document.getElementById("chaVal").value = "0";
			}else if(inputLength > 5){
// 				alert("아작스 작동");
				jQuery.ajax({
					url : "./idCheck.do",
					type : "post",
					data : "account_id="+$(this).val(),
					async : true,
					success : function(msg) {
// 						alert(msg);
						$("#result").html(msg);
						var temp = msg;
						temp = temp.substring(0,temp.indexOf("디")+1);
						if (temp == "사용가능한 아이디") {
							$("#chaVal").val(1);
							$("#result").css("color","blue");
						}else{
							$("#chaVal").val(0);
							$("#result").css("color","red");
						}
					}
				});
			}else{
				$("#result").css("color","red");
				$("#result").html("6자리 이상만 사용가능합니다.");
				$("#chaVal").val("0"); // document.getElementById("chaVal").value = "0";
			}
		});
	});

</script>
<body>
	<div id="container">
		<div class="signup-form">
			<input type="hidden" value="0" id="chaVal">
			<form action="./signUp.do" method="post" id="frm" name="frm" onsubmit="return check()">
				<h2>계정 등록</h2>
				<p>계정을 만들려면 이 양식을 입력하십시오!</p>
				<hr>
				<span id="result"></span>
				<div class="form-group">
					<label>*아이디</label>
					<input type="text" class="form-control" id="account_id" name="account_id" required="required">
					<span id="result"></span>
				</div>
				<div class="form-group">
					<label>*비밀번호</label>
					<input type="password" class="form-control" id="account_pw" name="account_pw" required="required">
				</div>
				<div class="form-group">
					<label>*비밀번호 확인</label>
					<input type="password" class="form-control" name="passOK" required="required">
				</div>
				<div class="form-group">
					<label>*이름</label>
					<input type="text" class="form-control" name="account_name" required="required">
				</div>
				<div class="form-group">
					<label>*전화번호</label>
					<input type="tel" class="form-control" name="account_phone" required="required">
				</div>
				<div class="form-group">
					<label>*이메일 주소</label>
					<input type="email" class="form-control" name="account_email" required="required">
				</div>
				<div class="form-group">
					<label>*사번</label>
					<input type="text" class="form-control" name="account_code" required="required">
				</div>
				<div class="form-group"> 
				  <label>*소속</label>
				     <select name="account_position" class="form-control selectpicker">
				      <option value="">당신의 소속을 선택하세요</option>
				      <option>생산계획</option>
				      <option>전산관리</option>
				      <option>공정관리</option>
				      <option>품질관리</option>				      
				    </select>				 
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg">계정 등록</button>
				</div>
			</form>
			<div class="text-center">
				이미 계정이 있으십니까? <a href="./loginForm.do">여기에 로그인하십시오</a>
			</div>
		</div>
	</div>
</body>
</html>