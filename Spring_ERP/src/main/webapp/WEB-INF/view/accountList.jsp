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
<script type="text/javascript" src="./js/accountList.js"></script>
<div class="container">
<h2>전체조회</h2>
<hr>
<h3>총 사용자 수 : ${paging.total}명</h3>
	<form action="./accountList.do" method="post" id="frmPaging">
		<table class="table table-bordered">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>사번</th>
				<th>부서</th>
				<th>권한</th>
				<th>삭제여부(Y/N)</th>
				<th>등록일</th>
			</tr>
			
			<c:forEach var="dto" items="${lists}">
				<tr>
					<td>
					<a href="./detailAccount.do?account_id=${dto.account_id}">
					${dto.account_id}
					</a>
					</td>					
					<td>${dto.account_name}</td>
					<td>${dto.empno}</td>					
					<td>${dto.account_position}</td>
					<td>
					<c:if test="${dto.auth eq 'U'}">사용자</c:if>
					<c:if test="${dto.auth eq 'A'}">관리자</c:if>
					<c:if test="${dto.auth eq 'S'}">최고관리자</c:if>
					</td>
					<td>${dto.account_delfag}</td>					
					<td>
					<!-- String date -> date -> 형태 String date -->					
					<fmt:parseDate var="Stringdate" value="${dto.account_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${Stringdate}" pattern="yyyy.MM.dd"/>					
					</td>
				</tr>
			</c:forEach>
		</table>
		
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