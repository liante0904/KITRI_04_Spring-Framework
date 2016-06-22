<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

  <script type="text/javascript">

 function addUser() {
	 location.href = "join.jsp";
}
 
 function loginUser() {
	 var loopback = document.loginForm;
	 if(loopback.j_num.value == "")
	 {
		 alert("학번을 입력 해주세요.")
		 loopback.j_num.focus;
	 } else if(loopback.j_name.value == ""){
		 alert("이름을 입력 해주세요.")
		 loopback.j_name.focus;
	 } else {
		 loopback.p_code.value = "login_chk";
		 loopback.submit();
}

	 }

function keyevent() {
		// 키보드 enter키 눌렀을때 동작하기
		if(event.keyCode ==13){
			// TODO : 실행시킬 코드
			loginUser();
		}
	}
  

</script>
<title>로그인 페이지</title>
</head>
<body>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<form action="user.do" method="post" name="loginForm">
<p align="center">
  학번 : <input type="text" name="j_num" placeholder="학번" onkeydown="keyevent()">
</p>

<p align="center">
  이름 : <input type="text" name="j_name" placeholder="이름" onkeydown="keyevent()">
</p>
<p align="center">
&nbsp;&nbsp;			<input type="button" name="name" value="회원가입" onclick="addUser()">
&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="name" value="로그인" onclick="loginUser()">
<br><br><br>

</P>
<input type="hidden" name="p_code" value="">

</form>

</body>
</html>
