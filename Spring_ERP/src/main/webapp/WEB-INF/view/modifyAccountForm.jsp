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
			<input type="text" class="form-control" name="account_id" value="${dto.account_id}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>이름</label>
			<input type="text" class="form-control" name="account_name" value="${dto.account_name}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>*전화번호</label>
			<input type="text" class="form-control" name="account_phone" value="${dto.account_phone}">		
		</div>
		<div class="form-group">
			<label>*이메일</label>
			<input type="text" class="form-control" name="account_email" value="${dto.account_email}">		
		</div>
		<div class="form-group">
			<label>사번</label>
			<input type="text" class="form-control" name="empno" value="${dto.empno}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>*부서</label>
			 <select name="account_position" class="form-control selectpicker">
				<option value="생산계획" ${dto.account_position eq '생산계획' ? 'selected="selected"':""}>생산계획</option>
				<option value="전산관리" ${dto.account_position eq '전산관리' ? 'selected="selected"':""}>전산관리</option>
				<option value="공정관리" ${dto.account_position eq '공정관리' ? 'selected="selected"':""}>공정관리</option>
				<option value="품질관리" ${dto.account_position eq '품질관리' ? 'selected="selected"':""}>품질관리</option>				      
			 </select>		
		</div>
		<div class="box-footer">
			<button type="button" class="btn btn-primary">저장</button>
			<button type="button" class="btn btn-warning" onclick="location.href='./myPageForm.do?account_id=${dto.account_id}'">취소</button>
			<span class="pull-right"><button type="button" class="btn btn-danger">탈퇴</button></span>		
		</div>
	</div>
</form>


</body>
</html>