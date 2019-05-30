<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 상세조회 페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<div class="container">
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">계정 상세조회</a></li>
  <li role="presentation"><a href="#">권한변경</a></li>
</ul>
<h2>계정 상세조회</h2>
<hr>
<table class="table table-striped">
	<tr>
		<th>아이디</th>
		<td>${dto.account_id}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${dto.account_name}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${dto.account_phone}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${dto.account_email}</td>
	</tr>
	<tr>
		<th>사번</th>
		<td>${dto.empno}</td>
	</tr>
	<tr>
		<th>부서</th>
		<td>${dto.account_position}</td>
	</tr>
	<tr>
		<th>권한</th>
		<td>
		<c:if test="${dto.auth eq 'U'}">사용자</c:if>
		<c:if test="${dto.auth eq 'A'}">관리자</c:if>
		<c:if test="${dto.auth eq 'S'}">최고관리자</c:if>
		</td>
	</tr>
	<tr>
		<th>등록일</th>
		<td>${dto.account_regdate}</td>
	</tr>
</table>
</div>
</body>
</html>