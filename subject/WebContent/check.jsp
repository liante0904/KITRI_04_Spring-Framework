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
			alert("���̵� �ߺ��˴ϴ�.");
		} else if (cu == "0") {
			document.checkForm.num.value="${num}";
			alert("��밡���� ���̵��Դϴ�.");
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
		 out.print("<script>alert('��밡��'); document.checkForm.num.value="+num+";</script>");
	 }else{
		 out.print("<script>alert('���Ұ���');</script>");
	 }
 } %>
 

		num:<input type="text" name="num"> <br> <input
			type="submit" value="�ߺ�üũ"> <br> <input type="button"
			value="��ȣ���" onclick="idOK()"> 
			 
			 

			
	</form>
</body>
</html>



