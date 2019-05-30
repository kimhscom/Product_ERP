<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권한변경 페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<script type="text/javascript" src="./js/changeAuthForm.js"></script>
<div class="container">
<h2>권한변경</h2>
<hr>
<h3>총 사용자 수 : ${paging.total}명</h3>
	<form action="#" method="post" id="frmPaging" name="frmPaging">
		<table class="table table-bordered">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>사번</th>
				<th>부서</th>
				<th>권한</th>
			</tr>
			
			<c:forEach var="dto" items="${lists}">
				<tr>
					<td>
					<input type="hidden" name="account_id" value="${dto.account_id}">
					${dto.account_id}
					</td>					
					<td>${dto.account_name}</td>
					<td>${dto.empno}</td>
					<td>${dto.account_position}</td>
					<td>
						<select name="auth">
							<option value="U" ${dto.auth eq 'U' ? 'selected="selected"':""}>사용자</option>
							<option value="A" ${dto.auth eq 'A' ? 'selected="selected"':""}>관리자</option>
							<option value="S" ${dto.auth eq 'S' ? 'selected="selected"':""}>최고관리자</option>
						</select>
						<button type="button" class="btn btn-success" >변경</button>					
					</td>
				</tr>
			</c:forEach>
		</table>
		${paging}
		
		<!-- 페이징 처리 -->
		<!-- 출력할 페이지 번호, 출력할 페이지 시작번호, 출력할 리스트 갯수 -->
		<input type="hidden" name="index" id="index" value="${paging.index}">
		<input type="hidden" name="pageNum" id="pageNum" value="${paging.pageNum}">
		<input type="hidden" name="listNum" id="listNum" value="${paging.listNum}">
		
		<div class="text-center">
			<ul class="pagination">
				<!-- 맨 첫페이지 이동 -->
				<li><a href="#" onclick="pageStart(${paging.pageList+1},${paging.pageList})">&laquo;</a></li>
				
				<!-- 페이지 번호 -->
				<c:forEach var="i" begin="${paging.pageNum}"
								   end="${paging.count}" step="1">
					<li><a href="#" onclick="pageIndex(${i})">${i}</a></li>
				</c:forEach>				
				
				<!-- 마지막 페이지 이동 -->
				<li><a href="#" onclick="pageLast(${paging.pageNum},${paging.total},${paging.listNum},${paging.pageList})">&raquo;</a></li>
			</ul>		
		</div>		
	</form>	
</div>
</body>
</html>