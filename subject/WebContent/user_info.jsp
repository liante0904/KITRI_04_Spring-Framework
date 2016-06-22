<%@ page language="java" contentType="text/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[
<c:forEach var="m" items="${list }" varStatus="status">
<c:if test="${not status.first }">,</c:if>
{num:${m.num},name:'${m.name}', tel:${m.tel}, email:'${m.email}', dept:'${m.dept}', type:${m.type} }
</c:forEach>
]