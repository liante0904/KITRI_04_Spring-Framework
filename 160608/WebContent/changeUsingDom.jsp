<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr" />
<title>DOM�� ����� ����</title>
<script type="text/javascript">
var count = 0;
function appendItem() { 
	count++; 
var newItem = document.createElement("div"); newItem.setAttribute("id", "item_" + count);
var html = '���� �߰��� ������['+count+']'+ '<input type="button" value="����" onclick="removeItem('+count+ ')"/>'; 

newItem.innerHTML = html;
var itemListNode = document.getElementById('itemList'); itemListNode.appendChild(newItem); }

function removeItem(idCount) {
var item = document.getElementById("item_"+idCount);
if (item != null)
{ item.parentNode.removeChild(item); }
}
</script>
</head>
<body>
<input type='button' value='�߰�' onclick='appendItem()' />
<div id="itemList"></div>
</body>
</html>