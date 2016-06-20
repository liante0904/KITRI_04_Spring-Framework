<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 리포트 제출 </title>
</head>
<body>

<h3>커맨드 객체 사용</h3>
<form action="${pageContext.request.contextPath }/report/submitReport3.do" method="post" enctype="multipart/form-data">

	학번 : <input type="text" name="studentNumber" /> <br/>
	
	리포트 파일 : <input type="file" name="report" /> <br/>
	
		<input type="submit"/> <br/>

</form>

</body>
</html>


