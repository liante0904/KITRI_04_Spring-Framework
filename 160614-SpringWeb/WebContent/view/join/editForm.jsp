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
<h2>정보 수정 페이지</h2>

${sessionScope.id }

<form action="${pageContext.request.contextPath }/join/editjoin.do" method="post" name="f">


id:<input type="text" name="id" value="${sessionScope.id }" readonly="readonly">
<input type="button" value="중복체크" onclick="idCheck()">

<span id="checkMsg"></span><br>
pwd:<input type="text" name="pwd"><br>
name:<input type="text" name="name"><br>
email:<input type="text" name="email"><br>
<input type="reset" value="취소">
<input type="submit" name="가입">

</form>


</body>
</html>


