<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>리포트 제출 완료</title>
</head>
<body>

이미지 리스트

<a href="${pageContext.request.contextPath }/view/report/submissionForm.jsp">이미지 올리기</a>
<c:forEach var="i" items="${files }"><br><br>
<img src="/img/${i }" style="width:1000px;height:500px"><br><br>
</c:forEach>

</body>
</html>


