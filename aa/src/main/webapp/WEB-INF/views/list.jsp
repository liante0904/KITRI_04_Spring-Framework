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

<c:forEach var="m" items="${datas }">
name= <a href="${pageContext.request.contextPath }/search.do?num=${m.num}">${m.name }</a>, tel: ${m.tel }, address : ${m.address }
<a href="${pageContext.request.contextPath }/del.do?num=${m.num}">delete</a>
<br>

</c:forEach>


</body>
</html>


