<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�α���</h3>
<form action="${pageContext.request.contextPath }/join/login.do" 
method="post">
id:<input type="text" name="id"><br>
pwd:<input type="text" name="pwd"><br>
<input type="submit" value="�α���">
<a href="${pageContext.request.contextPath }
/view/join/joinForm.jsp">
ȸ������
</a>
</form>
</body>
</html>