<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	function idCheck(){
		var param = "id="+document.f.id.value;
		sendRequest("${pageContext.request.contextPath}/join/idCheck.do", 
				param, checkResult, "POST");
	}
	function checkResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var o = eval("(" + str + ")");
				var myDiv= document.getElementById("checkMsg");			
				var html = "";
				if (o.flag) {
					html= "��밡���� ���̵��Դϴ�.";
					
				}else {
					html= "��� �Ұ����� ���̵��Դϴ�.";
					
				}
				myDiv.innerHTML = html;
			}
		}
	}	

	

</script>
</head>
<body>
<h2>ȸ������</h2>
<form action="${pageContext.request.contextPath }/join/join.do" method="post" name="f">


id:<input type="text" name="id">
<input type="button" value="�ߺ�üũ" onclick="idCheck()">

<span id="checkMsg"></span><br>
pwd:<input type="text" name="pwd"><br>
name:<input type="text" name="name"><br>
email:<input type="text" name="email"><br>
<input type="reset" value="���">
<input type="submit" name="����">

</form>
</body>
</html>


