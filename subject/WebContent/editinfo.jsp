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
		  alert("modify_chk �������Դϴ�.");
			 var loopback = document.modifyForm;
			 loopback.p_code.value = "modify_chk"
			 loopback.submit();
				}


 
</script>


<title>ȸ�� ���� ������</title>
</head>
<body>




	<form action="user.do" method="post" name=modifyForm>
*�й� : &nbsp;&nbsp;<input type="text" name="j_num" size="10" placeholder="�й�" value="${MEM.num }" readonly> 
<br> <br> 
*�̸� : <input type="text" name="j_name" size="8" placeholder="�̸�" value="${MEM.name }">
		<br> <br>
		<p>
*�̸��� <input type="text" name="j_email" value="" size="15" >
		</p>
*��ȭ��ȣ : <input type="text" name="j_tel" value="" size="15"><br> <br>

*�μ�: <input type="text" name="j_dept" value="" >


		<br> <br>
*�ź� : 
<select name="j_type">
    <option value="">�źм���</option>
    <option value="1">������</option>
    <option value="2">����</option>
    <option value="3">�л�</option>
</select>
		<br> <br>


 &nbsp; &nbsp;&nbsp; <input type="button" value="modify ����" name="name" onclick="modify_chk()">
 
 <input type="hidden" name="p_code" value="">

</form>
</body>
</html>


