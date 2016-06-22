<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

  <script type="text/javascript">

 
	 function modify_chk() {
		  alert("modify_chk 페이지입니다.");
			 var loopback = document.modifyForm;
			 loopback.p_code.value = "modify_chk"
			 loopback.submit();
				}


 
</script>


<title>회원 가입 페이지</title>
</head>
<body>




	<form action="user.do" method="post" name=modifyForm>
*학번 : &nbsp;&nbsp;<input type="text" name="j_num" size="10" placeholder="학번" value="${MEM.num }" readonly> 
<br> <br> 
*이름 : <input type="text" name="j_name" size="8" placeholder="이름" value="${MEM.name }">
		<br> <br>
		<p>
*이메일 <input type="text" name="j_email" value="" size="15" >
		</p>
*전화번호 : <input type="text" name="j_tel" value="" size="15"><br> <br>

*부서: <input type="text" name="j_dept" value="" >


		<br> <br>
*신분 : 
<select name="j_type">
    <option value="">신분선택</option>
    <option value="1">교직원</option>
    <option value="2">교수</option>
    <option value="3">학생</option>
</select>
		<br> <br>


 &nbsp; &nbsp;&nbsp; <input type="button" value="modify 제출" name="name" onclick="modify_chk()">
 
 <input type="hidden" name="p_code" value="">

</form>
</body>
</html>


