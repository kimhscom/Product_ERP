<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정 페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<script type="text/javascript" src="./js/modifyAccountForm.js"></script>
<form name="frm" method="post">
	<div class="box-body">
		<h2>개인정보 수정</h2>
		<hr>
		<div class="form-group">
			<label>아이디</label>
			<input type="text" class="form-control" name="account_id" value="${acc.account_id}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>이름</label>
			<input type="text" class="form-control" name="account_name" value="${acc.account_name}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>*전화번호</label>
			<input type="text" class="form-control" name="account_phone" value="${acc.account_phone}">		
		</div>
		<div class="form-group">
			<label>*이메일</label>
			<input type="text" class="form-control" name="account_email" value="${acc.account_email}">		
		</div>
		<div class="form-group">
			<label>사번</label>
			<input type="text" class="form-control" name="empno" value="${acc.empno}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>*부서</label>
			 <select name="account_position" class="form-control selectpicker">
			 	<option value="${acc.account_position}">${acc.account_position}</option>
			 	<option value="">-- 부서를 선택하세요 --</option>
				<option value="생산계획">생산계획</option>
				<option value="전산관리">전산관리</option>
				<option value="공정관리">공정관리</option>
				<option value="품질관리">품질관리</option>				      
			 </select>		
		</div>
		<div class="box-footer">
			<button type="button" class="btn btn-primary">저장</button>
			<button type="button" class="btn btn-warning">취소</button>
			<span class="pull-right"><button type="button" class="btn btn-danger">탈퇴</button></span>		
		</div>
	</div>
</form>


</body>
</html>