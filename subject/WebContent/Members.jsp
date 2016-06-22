<?xml version="1.0" encoding="euc-kr" ?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<members>
<c:forEach var="m" items="${list }">
	<member>
	<num>${m.num}</num>
	<name>${m.name}</name>
	<tel>${m.tel}</tel>
	<email>${m.email}</email>
	<dept>${m.dept}</dept>
	<type>${m.type}</type>
	</member>
</c:forEach>
</members>
