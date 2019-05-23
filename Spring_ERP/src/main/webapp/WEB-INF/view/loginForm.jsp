<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap-theme.min.css">

<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js"></script>
</head>
<script type="text/javascript">
function loginCheck() {
	var account_id = document.getElementById("inputId").value;
	var account_pw = document.getElementById("inputPw").value;
// 	alert(account_id+":"+account_pw);

	var frm = document.forms[0]; // document.getElementById("frm");
	frm.action = "./login.do";
	var result = "";
	
	if (account_id==null || account_id=="") {
		swal("로그인","아이디를 확인해 주세요");
	}else if(account_pw==null || account_pw==""){
		swal("로그인","비밀번호를 확인해 주세요");
	}else{
		jQuery.ajax({
			url : "./loginCheck.do",
			type : "post",
			data : "account_id="+account_id+"&account_pw="+account_pw,
			success : function(msg){
// 				alert(msg);
				var temp1 = "";
				var temp2 = "";
				
				var temp1 = msg;
				var temp2 = msg;
				
				temp1 = temp1.slice(0,2);
				if (temp1 == "성공") {
// 					alert("if문 들어 옴");
					temp2 = temp2.split("/")[1];
					document.getElementById("loginChk").value = temp2;
					frm.submit();
				}else{
					swal("로그인 실패", "아이디나 비밀번호를 확인해주세요");
				}				
			}
		}); 
	}			
	
}

</script>
<body>
	<div class="container">
    <div class="row">
        <div class='col-md-3'></div>
        <div class="col-md-6">
            <div class="login-box well">
                    <form method="post" id="frm">
                    <input type="hidden" id="loginChk" name="auth" value="0">
                        <legend>로그인</legend>
                        <div class="form-group">
                            <label for="inputId">아이디</label>
                            <input id="inputId" name="account_id" placeholder="아이디를 입력하세요" type="text" class="form-control" maxlength="50" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="inputPw">비밀번호</label>
                            <input id="inputPw" name="account_pw" placeholder="비밀번호를 입력하세요" type="password" class="form-control" maxlength="50" required="required" />
                        </div>
                        <div class="input-group">
                          <div class="checkbox">
                            <label>
                              <input id="login-remember" type="checkbox" name="remember" value="1"> 아이디 저장
                            </label>
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="button" class="btn btn-default btn-login-submit btn-block m-t-md" id="login" name="login" value="로그인" onclick="loginCheck()" />
                        </div>
                        <span class='text-center'><a href="/resetting/request" class="text-sm">비밀번호를 잊으셨습니까?</a></span>
                        <div class="form-group">
                            <p class="text-center m-t-xs text-sm">계정이 없으십니까?</p> 
                            <a href="./signUpForm.do" class="btn btn-default btn-block m-t-md">계정 등록</a>
                        </div>
                    </form>
                
            </div>
        </div>
        <div class='col-md-3'></div>
    </div>
</div>		
</body>
</html>