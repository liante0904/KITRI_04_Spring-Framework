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
			html = "��밡���� ���̵��Դϴ�.";
		} else{
			html = "�ߺ��� ���̵��Դϴ�.";
		}
          var mySpan = document.getElementById("mySpan");
          mySpan.innerHTML = html;
          
       } else {
          alert("����:" + httpRequest.status);
       }
    }
 }

	function check() {
		open("check.jsp", "", "width:50,height:50");
	}

	function join_chk() {
		var loopback = document.joinForm;
		if (loopback.j_num.value == "") {
			alert("�й��� �Է� ���ּ���.")
			loopback.j_num.focus;
		} else if (loopback.j_name.value == "") {
			alert("�̸��� �Է� ���ּ���.")
			loopback.j_name.focus;
		} else if (loopback.j_email.value == "") {
			alert("�̸����� �Է� ���ּ���.")
			loopback.j_email.focus;
		} else if (loopback.j_tel.value == "") {
			alert("��ȭ��ȣ�� �Է� ���ּ���.")
			loopback.j_tel.focus;
		} else if (loopback.j_dept.value == "") {
			alert("�ź��� �Է� ���ּ���.")
			loopback.j_dept.focus;
		} else if (loopback.dup_flag.value == "false"){
			alert("���̵� �ߺ�üũ�� �ؾ��մϴ�.")
		} else if(loopback.dup_flag.value == "true"){
			loopback.p_code.value = "join_chk";
			alert(loopback.p_code.value);
			loopback.submit();
		} else {
			
		}

	}
</script>


<title>ȸ�� ���� ������</title>
</head>
<body>




	<h2>���� ������</h2> 

	<form action="user.do" method="post" name=joinForm>
		*�й� : &nbsp;&nbsp;<input type="text" name="j_num" size="10" id="j_num"
			placeholder="�й�">
			<span id="mySpan"></span> <input type="button" name="checkId"
			value="�ߺ�üũ" onclick="check()"> <input type="button" name="checkId"
			value="�ߺ�üũ ajax" onclick="load()"><br> <br> 
			*�̸� : &nbsp;&nbsp; <input
			type="text" name="j_name" size="8" placeholder="�̸�"> <br>
		<br>
		<p>
			*�̸��� <input type="text" name="j_email" value="" size="15">
		</p>
		*��ȭ��ȣ : <input type="text" name="j_tel" value="" size="15"><br>
		<br> *�μ�: <input type="text" name="j_dept" value=""> *�ź�
		: <select name="j_type">
			<option value="">�ź� ����</option>
			<option value="1">������</option>
			<option value="2">����</option>
			<option value="3">�л�</option>
		</select> <br> <br> &nbsp; &nbsp;&nbsp; <input type="button"
			value="ȸ������ ����" name="name" onclick="join_chk()"> <input
			type="hidden" name="p_code" value="">
	<input type="hidden" name="dup_flag" value="false">
	
	</form>
</body>
</html>


