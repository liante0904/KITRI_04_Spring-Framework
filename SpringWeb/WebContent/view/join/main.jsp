<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${sessionScope.id }�� �α�����<br>
<a href="${pageContext.request.contextPath }/join/editForm.do">
����������
</a>
<a href="${pageContext.request.contextPath }/join/logout.do">
�α׾ƿ�
</a>
<a href="${pageContext.request.contextPath }/join/out.do">
Ż��
</a><br>
<a href="${pageContext.request.contextPath }/board/list.do">
�Խ���
</a>

<a href='${pageContext.request.contextPath }/imgBoard/list.do'>�̹��� �Խ���</a>


</body>
</html>