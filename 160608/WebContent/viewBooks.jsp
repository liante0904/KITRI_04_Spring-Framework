<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>å ���� ����</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
function loadBooks() {
	sendRequest("books.jsp", null, loadedBooks, "GET");
}
function loadedBooks() {
    if (httpRequest.readyState == 4) {   // �����κ��� ��� ������ �ε�
        if (httpRequest.status == 200) { // ���� ó��
            var xmlDoc = httpRequest.responseXML; // ���� ���ڿ��� XML
            // <book>�±� ����� �迭�� ����
            var bookList = xmlDoc.getElementsByTagName("book");
            // length: ����
            var message = "å ���� : "+bookList.length+"�� ";
            // ���
            for (var i = 0 ; i < bookList.length ; i++) {
                // ù��° <book>�±� ����
                var book = bookList.item(i);
                // .getElementsByTagName("title"): <book>�±׿��� <title>����
                // .item(0): <title>�±��� ù��° �ڽ� �±� ����
                // .firstChild: �±� ���ڿ� �±�, 'Core JAVA' �� �±�
                // .nodeValue : �±� ���ڿ� �±��� ��, 'Core JAVA' ���ڿ�
                var titleValue = 
                	book.getElementsByTagName("title").item(0).firstChild.nodeValue;
                // author�±��� ��
                // getElementsByTagName("author").item(0).firstChild.nodeValue;
                var authorValue = book.getElementsByTagName("author").item(0)
                                      .firstChild.nodeValue;
                // ��� �±��� �� ����
                message += titleValue + "(" + authorValue + ") ";
            }
            alert(message);
            
            var div = document.getElementById('bookList');
            div.innerHTML = message;
        }
    }r
}

// �������� �귯������ �ε��Ǹ� �ڵ����� loadBooks()�Լ��� ����
window.onload = function() {
    loadBooks();
}
</script>
</head>
<body>
<div id="bookList">
å ����� �������� XML�� �����ɴϴ�.<br>
��� ��ٸ�����.<br>
</div>
</body>
</html>



