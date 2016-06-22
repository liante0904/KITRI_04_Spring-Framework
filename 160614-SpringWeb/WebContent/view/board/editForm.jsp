<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function a(type){
	var myAction = "${pageContext.request.contextPath }/board/";
	if(type==1){
		myAction += "edit.do";
	}else if(type==2){
		myAction += "delete.do";
	}else{
		return;
	}
	document.f.action = myAction;
	document.f.submit();
}
</script>
</head>
<body>
<h3>글내용</h3>
<a href="${pageContext.request.contextPath }/board/list.do">
글목록으로 이동</a><br>
<c:if test="${sessionScope.id!=a.writer }">
  <c:set var="str">readonly</c:set>
</c:if>
<form name="f">
num:<input type="text" name="num" value="${a.num }" readonly><br>

writer:<input type="text" name="writer" 
value="${a.writer }" readonly><br>

date:${a.w_date }<br>

title:<input type="text" name="title" 
value="${a.title }" ${str }><br>

content:<input type="text" name="content" 
value="${a.content }" ${str }><br>

<c:if test="${sessionScope.id==a.writer }">
  <input type="button" value="수정" onclick="a(1)">
  <input type="button" value="삭제" onclick="a(2)">
</c:if>
</form>
<form action="${pageContext.request.contextPath }
/board/write.do" method="post">
<input type="text" name="content">
<input type="hidden" name="parent" value="${a.num }">
<input type="hidden" name="writer" value="${sessionScope.id }">
<input type="hidden" name="title" value="-->${a.title }">
<input type="submit" value="댓글달기">
</form>
<h3>댓글목록</h3>
<table border="1">
<tr><th>작성자</th><th>내용</th></tr>
<c:forEach var="rep" items="${reps }">
<tr><td>${rep.writer }</td>
<td><a href="${pageContext.request.contextPath }
/board/read.do?num=${rep.num}">${rep.content }</a></td></tr>
</c:forEach>
</table>
</body>
</html>