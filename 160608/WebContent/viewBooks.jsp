<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>책 정보 보기</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
function loadBooks() {
	sendRequest("books.jsp", null, loadedBooks, "GET");
}
function loadedBooks() {
    if (httpRequest.readyState == 4) {   // 서버로부터 모든 데이터 로딩
        if (httpRequest.status == 200) { // 정상 처리
            var xmlDoc = httpRequest.responseXML; // 응답 문자열이 XML
            // <book>태그 목록을 배열로 추출
            var bookList = xmlDoc.getElementsByTagName("book");
            // length: 갯수
            var message = "책 개수 : "+bookList.length+"권 ";
            // 출력
            for (var i = 0 ; i < bookList.length ; i++) {
                // 첫번째 <book>태그 추출
                var book = bookList.item(i);
                // .getElementsByTagName("title"): <book>태그에서 <title>추출
                // .item(0): <title>태그의 첫번째 자식 태그 추출
                // .firstChild: 태그 문자열 태그, 'Core JAVA' 값 태그
                // .nodeValue : 태그 문자열 태그의 값, 'Core JAVA' 문자열
                var titleValue = 
                	book.getElementsByTagName("title").item(0).firstChild.nodeValue;
                // author태그의 값
                // getElementsByTagName("author").item(0).firstChild.nodeValue;
                var authorValue = book.getElementsByTagName("author").item(0)
                                      .firstChild.nodeValue;
                // 모든 태그의 값 조합
                message += titleValue + "(" + authorValue + ") ";
            }
            alert(message);
            
            var div = document.getElementById('bookList');
            div.innerHTML = message;
        }
    }r
}

// 페이지가 브러우저로 로딩되면 자동으로 loadBooks()함수를 실행
window.onload = function() {
    loadBooks();
}
</script>
</head>
<body>
<div id="bookList">
책 목록을 서버에서 XML로 가져옵니다.<br>
잠시 기다리세요.<br>
</div>
</body>
</html>



