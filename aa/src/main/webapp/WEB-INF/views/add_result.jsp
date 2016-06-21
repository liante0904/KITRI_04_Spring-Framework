<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

name:${xxx.name }<br><br>
tel:${xxx.tel }<br><br>
address:${xxx.address }<br><br>
<a href="${pageContext.request.contextPath }/list.do">목록보기</a>

</body>
</html>


