<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���ۼ�</h3>
<form action="${pageContext.request.contextPath }/board/write.do" 
method="post">
writer:<input type="text" name="writer" 
value="${sessionScope.id }" readonly><br>
title:<input type="text" name="title"><br>
content:<input type="text" name="content"><br>
<input type="submit" value="�ۼ�">
</form>
</body>
</html>