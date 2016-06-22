<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="${pageContext.request.contextPath}/view/join/httpRequest.js"></script>
<script type="text/javascript">

function over(num){
	var param = "num="+num;
	sendRequest(
			"${pageContext.request.contextPath}/board/preview.do", 
			param, previewResult, "POST");
}
function previewResult(){
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			var str = httpRequest.responseText;
			var o = eval("(" + str + ")");
			var myDiv = document.getElementById("previewDiv");			
			var html = o.content;
			myDiv.innerHTML = html;
		}
	}
}	
function out(){
	var myDiv = document.getElementById("previewDiv");			
	myDiv.innerHTML = "";
}

function search(){
	var ch = document.f2.type;
	var x;
	for(i=0;i<ch.length;i++){
		if(ch[i].checked==true){
			x = ch[i].value;
		}
	}
	var param = "";
	var url = "";
	if(x==1){
		param = "writer="+document.f2.keyword.value;
		url = "searchById.do";
	}else if(x==2){
		param = "title="+document.f2.keyword.value;
		url = "searchByTitle.do";
	}
	sendRequest(
			"${pageContext.request.contextPath}/board/"+url, 
			param, searchResult, "POST");
}

function searchResult(){
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			var str = httpRequest.responseText;
			var o = eval("(" + str + ")");
			var myDiv = document.getElementById("searchDiv");			
			var html = "<table border='1'><tr><th>�۹�ȣ</th>"
			+"<th>�ۼ���</th><th>�ۼ���</th><th>����</th><tr>";
			for(i=0;i<o.length;i++){
				html += "<tr>";
				html += "<td>"+o[i].num+"</td>";
				html += "<td>"+o[i].writer+"</td>";
				html += "<td>"+o[i].w_date+"</td>";
				html += "<td>"
				+"<a href='${pageContext.request.contextPath }"
				+"/board/read.do?num="+o[i].num+"'>"+o[i].title
						+"</a></td>";
				html += "</tr>";
			}
			html += "</table>";
			myDiv.innerHTML = html;
		}
	}
}	



</script>
<title>Insert title here</title>
</head>
<body>

	<h3>�Խ���</h3>
	<a href="${pageContext.request.contextPath }/view/board/writeForm.jsp">�۾���</a>

	<table border="1">
		<tr>
			<th>num</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<c:forEach var="a" items="${list }">

				<tr>
					<td>${a.num }</td>
					<td><a href="${pageContext.request.contextPath }/board/read.do?num=${a.num }"  onmouseover="over(${a.num })" onmouseout="out()">${a.title }</a></td>
					<td>${a.writer }</td>
				</tr>

			</c:forEach>
	</table>
	<div id="previewDiv"
		style="position: absolute; top: 300px; left: 500px"></div>
	<form name="f2">



		<input type="radio" name="type" value="1"> �ۼ��� <input
			type="radio" name="type" value="2"> ���� <input type="text"
			name="keyword"> <input type="button" value="�˻�"
			onclick="search">
	</form>
	<div id="searchDiv"></div>

</body>
</html>


