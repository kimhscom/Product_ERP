<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<script type="text/javascript" src="./js/myPageForm.js"></script>
<div id="container">
	<form name="frm" method="get">
		<h2>마이페이지</h2>
		<hr>
		<div class="form-group">
			<label>아이디</label>
			<input type="text" class="form-control" id="account_id" value="${acc.account_id}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>이름</label>
			<input type="text" class="form-control" id="account_name" value="${acc.account_name}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>전화번호</label>
			<input type="text" class="form-control" id="account_phone" value="${acc.account_phone}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input type="text" class="form-control" id="account_email" value="${acc.account_email}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>사번</label>
			<input type="text" class="form-control" id="empno" value="${acc.empno}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>부서</label>
			<input type="text" class="form-control" id="account_position" value="${acc.account_position}" readonly="readonly">		
		</div>
		<div class="form-group">
			<label>등록일</label>
			<br>
			<!-- String date -> date -> 형태 String date -->
			<fmt:parseDate var="Stringdate" value="${acc.account_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${Stringdate}" pattern="yyyy-MM-dd"/>
		</div>	
	</form>
	<div class="box-footer">
		<button type="button" class="btn btn-warning">프로필 수정</button>	
	</div>
</div>
</body>
</html>