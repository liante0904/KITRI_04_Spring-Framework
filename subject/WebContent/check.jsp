<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function dup_check() {
		var cu = "${check_id}"
		if (cu == "1") {
			alert("아이디가 중복됩니다.");
		} else if (cu == "0") {
			document.checkForm.num.value="${num}";
			alert("사용가능한 아이디입니다.");
		}
	}
		function idOK() { 
			opener.document.joinForm.j_num.value = "${num}";
			opener.document.joinForm.dup_flag.value = "true";
			window.close();
			
		}
		
</script>
<title>Insert title here</title>
</head>
<body onload="dup_check()">

	<form action="user.do?reqType=checkId" method="post" name="checkForm">


			 <% if(request.getMethod().equals("POST")){
	 boolean flag = (boolean)request.getAttribute("flag");
	 int num = 0;
	 if(flag){
		 num = (Integer)request.getAttribute("num");
		 out.print("<script>alert('사용가능'); document.checkForm.num.value="+num+";</script>");
	 }else{
		 out.print("<script>alert('사용불가능');</script>");
	 }
 } %>
 

		num:<input type="text" name="num"> <br> <input
			type="submit" value="중복체크"> <br> <input type="button"
			value="번호사용" onclick="idOK()"> 
			 
			 

			
	</form>
</body>
</html>



