<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����Ʈ ���� �Ϸ�</title>
</head>
<body>

�̹��� ����Ʈ

<a href="${pageContext.request.contextPath }/view/report/submissionForm.jsp">�̹��� �ø���</a>
<c:forEach var="i" items="${files }"><br><br>
<img src="/img/${i }" style="width:1000px;height:500px"><br><br>
</c:forEach>

</body>
</html>


