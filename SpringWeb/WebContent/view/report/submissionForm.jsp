<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> ����Ʈ ���� </title>
</head>
<body>

<h3>Ŀ�ǵ� ��ü ���</h3>
<form action="${pageContext.request.contextPath }/report/submitReport3.do" method="post" enctype="multipart/form-data">

	�й� : <input type="text" name="studentNumber" /> <br/>
	
	����Ʈ ���� : <input type="file" name="report" /> <br/>
	
		<input type="submit"/> <br/>

</form>

</body>
</html>


