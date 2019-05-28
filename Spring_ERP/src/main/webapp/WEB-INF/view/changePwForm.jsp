<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<div id="container">
	<form method="post" name="frm">
		<h2>비밀번호 변경</h2>
		<hr>
		<input type="hidden" id="account_id" name="account_id" value="${acc.account_id}" readonly="readonly">
		<div class="form-group">
			<label>현재 비밀번호</label>
			<input type="password" class="form-control" id="account_pw" name="account_pw" maxlength="12" required="required">
		</div>
		<div class="form-group">
			<label>새로운 비밀번호</label>
			<input type="password" class="form-control" id="change_pw" name="change_pw" maxlength="12" required="required">
			<span id="result_pw"></span>
		</div>
		<div class="form-group">
			<label>새로운 비밀번호 확인</label>
			<input type="password" class="form-control" id="passOK" maxlength="12" required="required">
			<span id="result_confirm"></span>
		</div>
		<div class="form-group">			
			<button type="button" class="btn btn-primary btn-lg" id="btnConfirm">비밀번호 변경</button>
		</div>
	</form>
</div>
</body>
</html>