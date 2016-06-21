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

var loginId = "";
function writeRep(f, num, writer){
	loginId = writer;
	var param = "imgNum="+num + "&content="+f.content.value + "&writer=" + writer;
	f.content.value="";
	sendRequest(
			"${pageContext.request.contextPath}/imgBoard/writeRep.do", 
			param, writeRepResult, "POST");
}
function writeRepResult(){
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			var str = httpRequest.responseText;
			var reps = eval("(" + str + ")");
			alert(str);
			var imgNum = reps[0].imgNum;
			var myDiv = document.getElementById("div_"+imgNum);			
			var html = "";
			 for ( i = 0; i < reps.length; i++) {
				html += reps[i].content + "(작성자:"		+reps[i].writer+ ")";
				if ('${sessionScope.id}'==reps[i].writer) {
					html += "<input type='button' value='삭제' onclick='delrep("+reps[i].num+",\"${sessionScope.id}\")'>";
				}
				html += "<br>";
			}
			myDiv.innerHTML = html;
		}
	}
}	



function delrep(num, writer){
	var loginId = writer
	var param = "num="+num;
	sendRequest(
			"${pageContext.request.contextPath}/imgBoard/deleteRep.do", 
			param, writeRepResult, "POST");
}



function delResult(){
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			var str = httpRequest.responseText;
			var reps = eval("(" + str + ")");
			alert(str);
			var imgNum = reps[0].imgNum;
			var myDiv = document.getElementById("div_"+imgNum);			
			var html = "";
			 for ( i = 0; i < reps.length; i++) {
				html += reps[i].content + "(작성자:"		+reps[i].writer+ ")";
				if (loginId==reps[i].writer) {
					html += "<input type='button' value='x' onclick='delRep("+reps[i].num+",\"${sessionScope.id}\")'";
				}
				html += "<br>";
			}
			myDiv.innerHTML = html;
		}
	}
}	
</script>
<title>Insert title here</title>
</head>
<body>

	<h3>이미지 게시판</h3>
	<br>

	<br>
	<input type="button" value="글쓰기"
		onclick="location.href='/SpringWeb/view/imgBoard/form.jsp'">
	<c:forEach var="i" items="${list }">
		<table border="1" cellspacing="0">
			<tr>
				<th>title</th>
				<td>${i.title }</td>
			</tr>
			<tr>
				<th>writer</th>
				<td>${i.writer }</td>
			</tr>
			<tr>
				<td colspan="2"><img src="${i.path }"
					style="width: 200px; height: 200px"></td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="">
						<input type="hidden" value="${sessionScope.id }" name="writer">
						<input type="hidden" value="${i.num }" name="imgNum"> <input
							type="text" name="content"> <input type="submit"
							value="댓글작성" onclick="writeRep(this.form, ${i.num}, '${sessionScope.id }')">
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="div_${i.num }">
						<c:forEach var="r" items="${i.reps }">
							${r.content }(작성자:${r.writer })
						
					
							<c:if test="${sessionScope.id == r.writer }">
							<input type="button" value="삭제" onclick="delrep(${r.num}, '${sessionScope.id }')">
							</c:if>
					
									<br>

						</c:forEach>
					</div>
		</table>

	</c:forEach>



</body>
</html>


