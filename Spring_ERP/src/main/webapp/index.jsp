<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	<a href="./loginForm.do">로그인 폼이동</a>
</h1>

<a href="./insertAccount.do?
account_id=mingee&account_pw=1111&account_name=조민지&account_phone=010-7777-8888&
account_email=mingee@gmail.com&account_code=100003&account_position=공정관리">
사용자등록</a>
<a href="./idCheck.do?account_id=kimhscom">사용자 중복 체크</a>
<a href="./getLogin.do?account_id=mingee&account_pw=1111">로그인</a>
<a href="./findAccountPw.do?
account_id=youngjae&temp_pw=4444&account_email=youngjae@gmail.com">
비밀번호 찾기</a>
<a href="./changePw.do?account_id=iseul&account_pw=2222&change_pw=5555">비밀번호 변경</a>

<hr>
<a href="./detailAccount.do?account_id=kimhscom">사용자 상세조회</a>
<a href="./accountListRow.do?">사용자 총 인원 조회</a>
<a href="./accountList.do?">사용가능 전체조회(페이징)</a>
<a href="./modifyAccount.do?
account_id=youngjae&account_phone=010-2222-3333&account_email=youngjae@gmail.com&account_position=생산계획">
사용자 정보 수정</a>
<a href="./changeAuth.do?account_id=mingee&auth=U">사용자 권한 수정</a>
<a href="./deleteAccount.do?account_id=iseul">사용자 삭제</a>

</body>
</html>
