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

${sessionScope.id }님 로그인 성공!<br><br><br>
<a href="${pageContext.request.contextPath }/join/editForm.do">내 정보 수정</a><br>
<a href="${pageContext.request.contextPath }/join/logout.do">로그 아웃</a><br>
<a href="${pageContext.request.contextPath }/join/out.do">탈퇴</a><br>
<a href="${pageContext.request.contextPath }/board/list.do">게시판</a><br>



</body>
</html>


