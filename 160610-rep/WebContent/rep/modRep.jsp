<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[
<c:forEach var="r" items="${list }" varStatus="status">
	<c:if test="not status.first">,</c:if>
{num:${r.num }, name:'${r.name }', content: '${r.content }'}

</c:forEach>
]