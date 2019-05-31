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

<script type="text/javascript">

$(document).ready(function(){
	//권한변경 처리
	$(".btn-success").click(function(){
		alert("권한변경 되었습니다.");
	});
	
	// 전체조회 돌아가기
	$(".btn-warning").click(function(){
		location.href = "./accountList.do";
	});
});
</script>

<div class="container">
<ul class="nav nav-tabs">
  <li class="active"><a href="#tab1" data-toggle="tab">계정 상세조회</a></li>
  <li><a href="#tab2" data-toggle="tab">권한변경</a></li>
</ul>

<div class="tab-content">
	<div class="tab-pane active" id="tab1">
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
				<td>
					<!-- String date -> date -> 형태 String date -->					
					<fmt:parseDate var="Stringdate" value="${dto.account_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${Stringdate}" pattern="yyyy.MM.dd"/>
				</td>
			</tr>
		</table>
		<div class="box-footer">
			<button type="button" class="btn btn-warning">돌아가기</button>
		</div>
	</div>
	
	<div class="tab-pane" id="tab2">
		<h2>권한변경</h2>
		<hr>
		<form action="./changeAuth.do" method="post">
		<input type="hidden" name="account_id" value="${dto.account_id}">
		<table class="table table-striped">
			<tr>
				<th>권한</th>
				<td>변경</td>
			</tr>
			<tr>
				<th>
				<select name="auth">
					<option value="U" ${dto.auth eq 'U' ? 'selected="selected"':""}>사용자</option>
					<option value="A" ${dto.auth eq 'A' ? 'selected="selected"':""}>관리자</option>
					<option value="S" ${dto.auth eq 'S' ? 'selected="selected"':""}>최고관리자</option>
				</select>
				</th>
				<td>
					<button type="submit" class="btn btn-success">변경</button>
				</td>
			</tr>
			
		</table>
		</form>
		<div class="box-footer">
			<button type="button" class="btn btn-warning">돌아가기</button>
		</div>
	</div>

</div>

</div>
</body>
</html>