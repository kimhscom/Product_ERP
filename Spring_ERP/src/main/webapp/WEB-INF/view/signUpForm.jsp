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
<script type="text/javascript" src="./js/signUpForm.js"></script>
<title>계정 등록</title>
</head>
<body>
	<div id="container">
		<div class="signup-form">
			<input type="hidden" value="0" id="chaVal">
			<form action="./signUp.do" method="post" id="frm" name="frm" onsubmit="return check()">
				<h2>계정 등록</h2>
				<p>계정을 만들려면 이 양식을 입력하십시오!</p>
				<hr>
				<div class="form-group">
					<label>*아이디(중복체크 / 영문과 숫자 포함 6자리이상 입력하세요)</label>
					<input type="text" class="form-control" id="account_id" name="account_id" placeholder="아이디를 입력하세요" required="required">
					<span id="result_id"></span>
				</div>
				<div class="form-group">
					<label>*비밀번호(영문과 숫자, 특수문자 포함 최소 8자리에서 최대 12자리까지 입력하세요)</label>
					<input type="password" class="form-control" id="account_pw" name="account_pw" placeholder="비밀번호를 입력하세요" maxlength="12" required="required">
					<span id="result_pw"></span>
				</div>
				<div class="form-group">
					<label>*비밀번호 확인</label>
					<input type="password" class="form-control" id="confirmPw" placeholder="비밀번호를 한번 더 입력하세요" required="required">
					<span id="result_comfirm"></span>
				</div>
				<div class="form-group">
					<label>*이름</label>
					<input type="text" class="form-control" id="account_name" name="account_name" placeholder="이름을 입력하세요" required="required">
					<span id="result_name"></span>
				</div>
				<div class="form-group">
					<label>*전화번호</label>
					<input type="text" class="form-control" id="account_phone" name="account_phone" placeholder="전화번호를 입력하세요" required="required">
					<span id="result_phone"></span>
				</div>
				<div class="form-group">
					<label>*이메일 주소</label>
					<input type="text" class="form-control" id="account_email" name="account_email" placeholder="이메일 주소를 입력하세요" required="required">
					<span id="result_email"></span>
				</div>
				<div class="form-group"> 
				  <label>*소속</label>
				     <select name="account_position" class="form-control selectpicker">
				      <option value="">-- 부서를 선택하세요 --</option>
				      <option value="생산계획">생산계획</option>
				      <option value="전산관리">전산관리</option>
				      <option value="공정관리">공정관리</option>
				      <option value="품질관리">품질관리</option>				      
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