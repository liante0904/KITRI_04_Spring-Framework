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
<h3>�ּҷ�</h3>
<a href="${pageContext.request.contextPath }/form.do">�߰�</a>

<table border="1">
<tr><th>num</th><th>name</th><th>tel</th><th>address</th>
<c:forEach var="m" items="${list }">

<tr><td>${m.num }</td><td>${m.name }</td><td>${m.tel }</td>
<td>${m.address }</td></tr>

</c:forEach>
</table>


</body>
</html>


