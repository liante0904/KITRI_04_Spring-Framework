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

function viewinfo() {
	alert(" 페이지입니다.");
}

function b() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
	var str = httpRequest.responseText;
	var memList = eval("("+str+")");
	var html = "<table border='1'>";
	for (var i = 0; i < memList.length; i++) {
		html += "<tr><td onmouserover=c("+memList[i].num+")>"+memList[i].num;
	}
	var userdiv = document.getElementById("userdiv");
	userdiv.innerHTML = html;
	}
}
}

function c() {
	var params = "reqType=alluser_json";
	var url = "${pageContext.request.contextPath}/user.do";
	sendRequest(url, params, e, 'POST');
	}
	
function e() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
	var str = httpRequest.responseText;
	var memList = eval("("+str+")");
	var html = "";
	
	
		html += "name:"+mem.name+"<br>";
		html += "tel:"+mem.tel+"<br>";
		html += "email:"+mem.email+"<br>";
		html += "dept:"+mem.dept+"<br>";
		html += "type:"+mem.type+"<br>";
	
	var userdiv = document.getElementById("userdiv2");
	userdiv.innerHTML = html;
	}
			}
}

function d() {
	var myDiv = document.getElementById("myDiv3");
	myDiv.innerHTML = "";
}


function alluser_json() {
	var txt = document.getElementById("name");
	var params = "reqType=alluser_json";
	var url = "${pageContext.request.contextPath}/user.do";
	sendRequest(url, params, alluser_json_core, 'POST');
	}

function alluser_json_core() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
	var str = httpRequest.responseText;
	var memList = eval("("+str+")");
	var html = "";
	for (var i = 0; i < memList.length; i++) {
		html += "num:"+memList[i].num;
		html += "/name:"+memList[i].name;
		html += "/tel:"+memList[i].tel;
		html += "/email:"+memList[i].email;
		html += "/dept:"+memList[i].dept;
		html += "/type:"+memList[i].type;
	}
	var userdiv = document.getElementById("userdiv");
	userdiv.innerHTML = html;
	}
			}
}




	function load() {
		var txt = document.getElementById("name");
		var params = "reqType=json";
		var url = "${pageContext.request.contextPath}/user.do";
		sendRequest(url, params, json, 'POST');
	}
	function json() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
		var str = httpRequest.responseText;
		var memList = eval("("+str+")");
		var html = "";
		for (var i = 0; i < memList.length; i++) {
			html += "num:"+memList[i].num;
			html += "/name:"+memList[i].name;
			html += "/tel:"+memList[i].tel;
			html += "/email:"+memList[i].email;
			html += "/dept:"+memList[i].dept;
			html += "/type:"+memList[i].type;
		}
		var myDiv = document.getElementById("myDiv");
		myDiv.innerHTML = html;
		}
			}
	}
	
	

	function logout() {
		alert("logout 페이지입니다.");
		var loopback = document.mainForm;
		loopback.p_code.value = "logout"
		loopback.submit();
	}

	function del() {
		alert("del 페이지입니다.");
		var loopback = document.mainForm;
		loopback.p_code.value = "delete"
		loopback.submit();
	}

	function modi() {
		alert("modi 페이지입니다.");
		var loopback = document.mainForm;
		loopback.p_code.value = "modify"
		loopback.submit();
	}
	function alluser() {
		var loopback = document.mainForm;
		loopback.p_code.value = "alluser"
		loopback.submit();
	}
	function mover() {
		alert("del 페이지입니다.");
	}
	function makeResult() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				xmlDoc = httpRequest.responseXML;
				var html = "";
				var memberList = xmlDoc.getElementsByTagName("member");
				for (var i = 0; i < memberList.length; i++) {
					var m = memberList.item(i);
					var num = m.getElementsByTagName("num").item(0).firstChild.nodeValue;
					var name = m.getElementsByTagName("name").item(0).firstChild.nodeValue;
					var tel = m.getElementsByTagName("tel").item(0).firstChild.nodeValue;
					var email = m.getElementsByTagName("email").item(0).firstChild.nodeValue;
					var dept = m.getElementsByTagName("dept").item(0).firstChild.nodeValue;
					var type = m.getElementsByTagName("type").item(0).firstChild.nodeValue;

					html += "num:" + num;
					html += "/name:" + name;
					html += "/tel:" + tel;
					html += "/email:" + email;
					html += "/dept:" + dept;
					html += "/type:" + type;

				}
				var myDiv = document.getElementById("myDiv");
				myDiv.innerHTML = html;
			}
		}
	}
	
window.onload = function(){
	var params = "reqType"
}
	
</script>
<title>Main Page</title>


</head>
<body>


	<form action="user.do" method="post" name=mainForm>


		<input type="button" value="로그아웃" name="name" onclick="logout()">
		<input type="button" value="탈퇴" name="name" onclick="del()"> <input
			type="button" value="modify" name="name" onclick="modi()"> <input
			type="hidden" value="" name="p_code" /> <input type="button"
			value="모든 회원정보 (리스트)" name="name" onclick="load()">
						<input type="button" value="회원가져오기" name="name" onclick="alluser()">
			<input type="button" value="회원 정보 읽어오기" name="name" onclick="alluser_json()">
		
		
		<div id="myDiv"></div>
		<div id="myDiv1"></div>
		<div id="myDiv2"></div>

		
		
	</form>
</body>
</html>


