<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/sweetalert.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap-theme.min.css">

<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js"></script>
<title>비밀번호 찾기 페이지</title>
</head>
<script type="text/javascript">

</script>
<body>
<div id="container">
	<div class="row">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                          <h3><i class="fa fa-lock fa-4x"></i></h3>
                          <h2 class="text-center">비밀번호를 잊으셨습니까?</h2>
                          <p>여기서 비밀번호를 초기화할 수 있습니다.</p>
                            <div class="panel-body">
                              
                              <form class="form" action="./findPw.do" method="post">
                                <fieldset>
                                  <div class="form-group">
                                  	<div class="input-group">
                                  	  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                  	  <input class="form-control" type="text" id="account_id" name="account_id" placeholder="아이디" required="required">                                      
                                  	</div>
                                  </div>
                                  <div class="form-group">
                                    <div class="input-group">                                      
                                      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                      <input class="form-control" type="text" id="account_email" name="account_email" placeholder="이메일 주소" required="required">                                      
                                    </div>
                                  </div>
                                  <div class="form-group">
                                    <input class="btn btn-lg btn-primary btn-block" value="임시 비밀번호 전송" type="submit">
                                  </div>
                                </fieldset>
                              </form>
                              <div class="text-center">
								이미 계정이 있으십니까? <a href="./loginForm.do">여기에 로그인하십시오</a>
							  </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
</div>
</body>
</html>