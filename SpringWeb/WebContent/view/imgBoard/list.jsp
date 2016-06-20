<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">

function rep_delete(a) {
	var here = document.repForm;
	
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
					<form action="${pageContext.request.contextPath }/imgBoard/addrep.do" name="repForm">
						<input type="hidden" value="${sessionScope.id }" name="writer">					
						<input type="hidden" value="${i.num }" name="imgNum">					
						<input type="text" name="content">
						
						 <input type="submit" value="댓글작성">
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="div_${i.num }">
						<c:forEach var="r" items="${i.reps }">
	${r.content }(작성자:${r.writer })<a href="${pageContext.request.contextPath }/imgBoard/delrep.do?num=${r.num}">삭제</a>

					 <br>

						</c:forEach>
					</div>
		</table>

	</c:forEach>



</body>
</html>


