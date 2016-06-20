<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
				var myDiv = document.getElementById("checkMsg");			
				var html = "";
				if(o.flag){
					html = "사용가능한 아이디";
				}else{
					html = "사용불가능한 아이디";
				}
				myDiv.innerHTML = html;
			}
		}
	}	
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/join/join.do"
method="post" name="f">
id:<input type="text" name="id">
<input type="button" value="중복체크" onclick="idCheck()">
<span id="checkMsg"></span><br>
pwd:<input type="text" name="pwd"><br>
name:<input type="text" name="name"><br>
email:<input type="text" name="email"><br>
<input type="reset" value="취소">
<input type="submit" value="가입">
</form>
</body>
</html>