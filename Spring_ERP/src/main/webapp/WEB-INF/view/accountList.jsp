<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회 페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<h2>전체조회</h2>
<hr>
	<div class="panel-group">
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>사번</th>
				<th>부서</th>
				<th>삭제여부</th>
				<th>등록일</th>
			</tr>
			
			<c:forEach var="dto" items="${lists}" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${dto.account_id}</td>					
					<td>${dto.account_name}</td>
					<td>${dto.account_phone}</td>
					<td>${dto.account_email}</td>
					<td>${dto.empno}</td>
					<td>${dto.account_position}</td>
					<td>${dto.account_delfag}</td>					
					<td>
					<!-- String date -> date -> 형태 String date -->
					<fmt:parseDate var="Stringdate" value="${dto.account_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${Stringdate}" pattern="yyyy.MM.dd"/>					
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>