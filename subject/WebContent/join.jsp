<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">


function load() {
   var txt = document.getElementById("j_num");
   var params = "reqType=checkId&num=" + txt.value;
	sendRequest("${pageContext.request.contextPath}/user.do", params, dup_chk, 'POST');
}



	function dup_chk() {
    if (httpRequest.readyState == 4) {
       if (httpRequest.status == 200) {
          alert(httpRequest.responseText);
          var result = httpRequest.responseText;
          var o  = eval("("+result+")");
          if (o.flag) {
			html = "사용가능한 아이디입니다.";
		} else{
			html = "중복된 아이디입니다.";
		}
          var mySpan = document.getElementById("mySpan");
          mySpan.innerHTML = html;
          
       } else {
          alert("실패:" + httpRequest.status);
       }
    }
 }

	function check() {
		open("check.jsp", "", "width:50,height:50");
	}

	function join_chk() {
		var loopback = document.joinForm;
		if (loopback.j_num.value == "") {
			alert("학번를 입력 해주세요.")
			loopback.j_num.focus;
		} else if (loopback.j_name.value == "") {
			alert("이름을 입력 해주세요.")
			loopback.j_name.focus;
		} else if (loopback.j_email.value == "") {
			alert("이메일을 입력 해주세요.")
			loopback.j_email.focus;
		} else if (loopback.j_tel.value == "") {
			alert("전화번호을 입력 해주세요.")
			loopback.j_tel.focus;
		} else if (loopback.j_dept.value == "") {
			alert("신분을 입력 해주세요.")
			loopback.j_dept.focus;
		} else if (loopback.dup_flag.value == "false"){
			alert("아이디 중복체크를 해야합니다.")
		} else if(loopback.dup_flag.value == "true"){
			loopback.p_code.value = "join_chk";
			alert(loopback.p_code.value);
			loopback.submit();
		} else {
			
		}

	}
</script>


<title>회원 가입 페이지</title>
</head>
<body>




	<h2>가입 페이지</h2> 

	<form action="user.do" method="post" name=joinForm>
		*학번 : &nbsp;&nbsp;<input type="text" name="j_num" size="10" id="j_num"
			placeholder="학번">
			<span id="mySpan"></span> <input type="button" name="checkId"
			value="중복체크" onclick="check()"> <input type="button" name="checkId"
			value="중복체크 ajax" onclick="load()"><br> <br> 
			*이름 : &nbsp;&nbsp; <input
			type="text" name="j_name" size="8" placeholder="이름"> <br>
		<br>
		<p>
			*이메일 <input type="text" name="j_email" value="" size="15">
		</p>
		*전화번호 : <input type="text" name="j_tel" value="" size="15"><br>
		<br> *부서: <input type="text" name="j_dept" value=""> *신분
		: <select name="j_type">
			<option value="">신분 선택</option>
			<option value="1">교직원</option>
			<option value="2">교수</option>
			<option value="3">학생</option>
		</select> <br> <br> &nbsp; &nbsp;&nbsp; <input type="button"
			value="회원가입 제출" name="name" onclick="join_chk()"> <input
			type="hidden" name="p_code" value="">
	<input type="hidden" name="dup_flag" value="false">
	
	</form>
</body>
</html>


