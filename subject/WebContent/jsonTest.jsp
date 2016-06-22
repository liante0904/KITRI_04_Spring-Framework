<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">

function a() {
	sendRequest("jason1.jsp", null, result, "GET");
}

function result() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			var res = httpRequest.responseText;
			var o = eval("("+res+")");
			var html = "";
			for (i = 0; i < o.length; i++) {
				
				html +=  "num:" + o[i].num + "name:" + o[i].name + "tel" + o[i].tel + "\n";
					
			}
			alert(html);
			}
		
	}
}

</script>
<title>Insert title here</title>
</head>
<body>

<input type="button" value="클릭" onclick="a()">

</body>
</html>


