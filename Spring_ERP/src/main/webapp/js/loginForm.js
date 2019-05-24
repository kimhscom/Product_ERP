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