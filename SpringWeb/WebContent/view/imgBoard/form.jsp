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



<h3>이미지 작성 게시판</h3>
<form action="${pageContext.request.contextPath }/imgBoard/add.do" method="post" enctype="multipart/form-data">
writer:<input type="text" name="writer" 
value="${sessionScope.id }" readonly><br>
title:<input type="text" name="title"><br>
content:<input type="text" name="content"><br>
img:<input type="file" name="file">

<br><br><br><br><br>
<input type="submit" value="작성">
</form>
</body>
</html>


