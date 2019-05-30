<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="./css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap-theme.min.css">

<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">생산ERP시스템</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="./mainPage.do">홈</a></li>
	        <li class="dropdown">
	          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Page 1-1</a></li>
	            <li><a href="#">Page 1-2</a></li>
	            <li><a href="#">Page 1-3</a></li>
	          </ul>
	        </li>
	        <li><a href="#">Page 2</a></li>
	        <c:if test="${fn:trim(acc.auth) eq 'S'}">
	        	<li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="#">사용자 관리 <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="./accountList.do">전체조회</a></li>
		            <li><a href="./changeAuthForm.do">권한변경</a></li>
		          </ul>
		        </li>
	        </c:if>
	        
	      </ul>	     
	      <ul class="nav navbar-nav navbar-right">
	        <li class="nav-item dropdown">
				<a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><span class="glyphicon glyphicon-user"></span>${acc.account_name}<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="./myPageForm.do" class="dropdown-item"><span class="glyphicon glyphicon-briefcase">마이페이지</a></li>
					<li><a href="./changePwForm.do" class="dropdown-item"><span class="glyphicon glyphicon-lock">비밀번호변경</a></li>
					<li class="divider dropdown-divider"></li>
					<li><a href="./logOut.do" class="dropdown-item"><span class="glyphicon glyphicon-off"></span>로그아웃</a></li>
				</ul>
			</li>
	      </ul>
	    </div>
	  </div>
	</nav>
</body>
</html>