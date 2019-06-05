<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>품목조회 페이지</title>
</head>
<body>
<%@include file="/WEB-INF/view/erpTopMenu.jsp" %>
<script type="text/javascript" src="./js/itemList.js"></script>
<div class="container">
<h2>품목조회</h2>
<hr>
<h3>총 품목 갯수 : ${paging.total}개</h3>
	<form action="./itemList.do" method="get" id="frmPaging">
		<table class="table table-bordered">
			<tr>
				<th>품목코드</th>
				<th>품목명</th>
				<th>품목가격</th>
				<th>삭제여부(Y/N)</th>			
			</tr>
			
			<c:forEach var="dto" items="${lists}">
				<tr>
					<td>
					<a data-toggle="modal" data-target="#detailModal" href="#">
					${dto.item_code}
					</a>					
					</td>
					<td>${dto.item_name}</td>
					<td>${dto.item_price}원</td>
					<td>${dto.item_delflag}</td>
				</tr>			
			</c:forEach>		
		</table>
		
		<!-- 품목 상세조회 Modal 생성버튼 -->
		<button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#detailModal">품목상세조회</button>
		
		<!-- 품목등록 Modal 생성버튼 -->
		<span class="pull-right">
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#insertModal">품목등록</button>
		</span>
		
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
	
	<!-- 품목등록 Modal -->
	  <div class="modal fade" id="insertModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">품목등록</h4>
	        </div>
	        <div class="modal-body">
	        	<table class="table">
	        		<tr>
	        			<th>품목명</th>
	        			<td>
	        			<input type="text" class="form-control"  id="item_name">
	        			</td>
	        		</tr>
	        		<tr>
	        			<th>품목가격</th>
	        			<td>
	        			<input type="text" class="form-control" id="item_price">
	        			</td>
	        		</tr>
	        	</table>	        	
	        </div>
	        <div class="modal-footer">
	          <button type="button" id="modalSubmit" class="btn btn-success">등록</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  
	  <!-- 품목 상세조회 Modal -->
	  <div class="modal fade" id="detailModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">품목 상세조회</h4>
	        </div>
	        <div class="modal-body">
	          <p>Some text in the modal.</p>
	        </div>
	        <div class="modal-footer">
	          <span class="text-left">
	          	<button type="button" class="btn btn-danger" >삭제</button>
	          </span>	          	        
	          <button type="button" id="modalSubmit" class="btn btn-success">수정</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	
</div>
</body>
</html>