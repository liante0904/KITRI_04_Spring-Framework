<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/join/login.do" method="post">
<h2>�α��� ������</h2>
${join.id }�� �α��� ����!<br><br><br>


id:<input type="text" name="id"><br>
pwd:<input type="text" name="pwd"><br>

<input type="submit" name="�α���">
<a href="${pageContext.request.contextPath }/view/join/joinForm.jsp">ȸ������</a>
</form>
</body>
</html>


