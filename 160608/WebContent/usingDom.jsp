<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr" />
<title>DOM API를 사용한 HTML 문서 접근</title>
<script type="text/javascript">
   function log(msg) {
      var console = document.getElementById("debugConsole");
      if (console != null) {
         console.innerHTML += msg + "<br/>";
      }
   }
   window.onload = function() {
      var roodNode = document.documentElement;
      log("root 태그: " + roodNode.tagName);
      
      var bodyNode = document.getElementsByTagName("body").item(0);
      log("body 태그: " + bodyNode.tagName);
      
      var spanList = document.getElementsByTagName("span");
      log("span 태그의 개수: " + spanList.length);
      for (var i = 0; i < spanList.length; i++) {
         var span = spanList.item(i);
         log((i + 1) + "번째 span의 id : " + span.getAttribute("id"));
      }

      var debugConsoleDiv = document.getElementById("debugConsole");
      log("debugConsole 요소: " + debugConsoleDiv.tagName);
      var bodyLastChild = bodyNode.lastChild;
      log("body의 마지막 자식 노드: " + bodyLastChild.nodeName);
   }

</script>
</head>
<body>
   <SPAN id="a">a</SPAN>
   <p>test<span id="b">b</span></p>
   <div><p>p</p><span id="c">c</span></div>
   <div id="debugConsole" style="border: 1px solid #000"></div>
</body>
</html>