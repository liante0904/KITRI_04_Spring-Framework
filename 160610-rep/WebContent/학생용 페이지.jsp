<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/httpRequest.js"></script>
<script type="text/javascript">
   window.onload=function(){
      var param = "code=listSub";
      sendRequest("${pageContext.request.contextPath}/main.do", 
            param, listResult, "POST");
   }
   
   function listResult(){
      if(httpRequest.readyState==4){
         if(httpRequest.status==200){
            var str = httpRequest.responseText;
            var o = eval("(" + str + ")");
			var message = "-----------------------------------------------------------";
			for (i = 0; i < o.length; i++) {
				message += "Num: "+o[i].num+", Name: "+o[i].name+", Flag: "+o[i].flag+"<br>";
			}
			//html += "num: "+o.num+", name: "+o.name+", tel: "+o.tel;
			document.getElementById("members").innerHTML = message;
         }
      }
   }

   </script>
</head>
<body>
<div id="members"></div>
</body>
</html>
