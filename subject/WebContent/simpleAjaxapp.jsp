<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
   var httpRequest = null;
   function getXMLHttpRequest() {
      if (window.ActiveXObject) {
         try {
            return new ActiveXObject("Msxml2.XMLHTTP");
         } catch (e) {
            try {
               return new ActiveXObject("Mixcrosoft.XMLHTTP");
            } catch (e) {
               return null;
            }
         }
      } else if (window.XMLHttpRequest) {
         return new XMLHttpRequest();
      } else {
         return null;
      }
   }
   function load(url) {
	   var txt = document.getElementById("name");
	   var params = "name="+ txt.value;
	sendRequest(url, params, viewMessage,'POST');
   }
   function viewMessage() {
      if (httpRequest.readyState == 4) {
         if (httpRequest.status == 200) {
            alert(httpRequest.responseText);
            var result = httpRequest.responseText;
            var mySpan = document.getElementById("mySpan");
            mySpan.innerHTML = result;
         } else {
            alert("실패:" + httpRequest.status);
         }
      }
   }
   var httpRequest = null;

   function sendRequest(url, params, callback, method) {
   	httpRequest = getXMLHttpRequest();
   	var httpMethod = method ? method : 'GET';
   	if (httpMethod != 'GET' && httpMethod != 'POST') {
   		httpMethod = 'GET';
   	}
   	var httpParams = (params == null || params == '') ? null : params;
   	var httpUrl = url;
   	if (httpMethod == 'GET' && httpParams != null) {
   		httpUrl = httpUrl + "?" + httpParams;
   	}
   	httpRequest.open(httpMethod, httpUrl, true);
   	httpRequest.setRequestHeader(
   		'Content-Type', 'application/x-www-form-urlencoded');
   	httpRequest.onreadystatechange = callback;
   	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
   }

</script>
</head>
<body>
   <input type="text" id="name" /><span id="mySpan"></span>

   <input type="button" value="전송" onclick="load('simple.jsp')" />
</body>
</html>

