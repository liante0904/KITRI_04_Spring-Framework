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

${sessionScope.id }�� �α��� ����!<br><br><br>
<a href="${pageContext.request.contextPath }/join/editForm.do">�� ���� ����</a><br>
<a href="${pageContext.request.contextPath }/join/logout.do">�α� �ƿ�</a><br>
<a href="${pageContext.request.contextPath }/join/out.do">Ż��</a><br>
<a href="${pageContext.request.contextPath }/board/list.do">�Խ���</a><br>



</body>
</html>


