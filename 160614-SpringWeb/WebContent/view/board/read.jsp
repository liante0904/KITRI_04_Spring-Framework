<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">



</script>
<title>Insert title here</title>
</head>
<body>

<h3>${a.num }번 게시물</h3>

<br><br><br><br>
${a.content }

<br><br><br><br><br><br><br><br>

<a href="${pageContext.request.contextPath }/board/modify.do?num=${a.num }">수정</a>
<a href="${pageContext.request.contextPath }/board/delete.do?num=${a.num }">삭제</a>

</body>
</html>

