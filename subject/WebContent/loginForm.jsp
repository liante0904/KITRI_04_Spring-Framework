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
		 alert("�й��� �Է� ���ּ���.")
		 loopback.j_num.focus;
	 } else if(loopback.j_name.value == ""){
		 alert("�̸��� �Է� ���ּ���.")
		 loopback.j_name.focus;
	 } else {
		 loopback.p_code.value = "login_chk";
		 loopback.submit();
}

	 }

function keyevent() {
		// Ű���� enterŰ �������� �����ϱ�
		if(event.keyCode ==13){
			// TODO : �����ų �ڵ�
			loginUser();
		}
	}
  

</script>
<title>�α��� ������</title>
</head>
<body>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<form action="user.do" method="post" name="loginForm">
<p align="center">
  �й� : <input type="text" name="j_num" placeholder="�й�" onkeydown="keyevent()">
</p>

<p align="center">
  �̸� : <input type="text" name="j_name" placeholder="�̸�" onkeydown="keyevent()">
</p>
<p align="center">
&nbsp;&nbsp;			<input type="button" name="name" value="ȸ������" onclick="addUser()">
&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="name" value="�α���" onclick="loginUser()">
<br><br><br>

</P>
<input type="hidden" name="p_code" value="">

</form>

</body>
</html>
