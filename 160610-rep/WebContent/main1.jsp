<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	window.onload=function(){
		var param = "type=list";
		sendRequest

("${pageContext.request.contextPath}/RepController", 
				param, listResult, "POST");
	}
	function listResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var repList = eval("(" + str + ")");
				alert(str);
				var repListD = 

document.getElementById("repList");			
				for(i=0;i<repList.length;i++){
					repListD.appendChild

(makeRepDiv(repList[i]));	
				}
			}
		}
	}	
	function makeRepDiv(rep){
		var RepDiv = document.createElement('div');
		RepDiv.setAttribute('id', 'rep_'+rep.num);
		var html = "name:"+rep.name+"<br/>"
					+"content:"+rep.content

+"<br/>"
					+"<input type='button' value='

수정' "
					+"onclick='showUpdateForm

("+rep.num+")'>"
					+"<input type='button' value='

삭제' "
					+"onclick='delRep("+rep.num

+")'>";
		
					RepDiv.innerHTML = html;
		return RepDiv;
	}
	
	function addRep(){
		var param = "type=addRep&name="+document.f.name.value
					

+"&content="+document.f.content.value;
		sendRequest

("${pageContext.request.contextPath}/RepController", 
				param, addResult, "POST");
		document.f.name.value="";
		document.f.content.value="";
	}
	
	function addResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var rep = eval("(" + str + ")");
				var repDiv = makeRepDiv(rep);
				var repList = document.getElementById

("repList");
				repList.appendChild(RepDiv);
			}
		}
	}
	
	function showUpdateForm(num){
		var param = "type=getRep&num="+num;
		sendRequest

("${pageContext.request.contextPath}/RepController", 
				param, getRepResult, "POST");
	}
	
	function getRepResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var rep = eval("(" + str + ")");
				var updateFormDiv = 
					document.getElementById

("updateFormDiv");
				var repDiv = 
					document.getElementById

("rep_"+rep.num);
				repDiv.appendChild(updateFormDiv);
				document.updateForm.style.display='';
				

document.updateForm.u_num.value=rep.num;
				

document.updateForm.u_name.value=rep.name;
				

document.updateForm.u_content.value=rep.content;
			}
		}
	}
	function hideUpdateForm(){
		var bodyNode = document.getElementsByTagName

("body").item(0);
		var updateFormDiv = 
			document.getElementById("updateFormDiv");
		bodyNode.appendChild(updateFormDiv);
		document.updateForm.u_name.value='';
		document.updateForm.u_content.value='';
		document.updateForm.style.display='none';
	}
	
	function editRep(){
		var params = "type=editRep&num="
		+document.updateForm.u_num.value +"&name="
		+document.updateForm.u_name.value + "&content="
		+document.updateForm.u_content.value;
		
		sendRequest

("${pageContext.request.contextPath}/RepController", 
				params, editRepResult, "POST");
		hideUpdateForm();
	}
	
	function editRepResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var rep = eval("(" + str + ")");
				var repDiv = makeRepDiv(rep);
				var repList = document.getElementById

("repList");
				var oldDiv = document.getElementById

("rep_"+rep.num);
				repList.replaceChild(repDiv, oldDiv);
			}
		}
	}
	function delRep(num){
		var flag = confirm("삭제하겠습니까?");
		if(!flag){
			return;
		}
		var params = "type=delRep&num="+num;
		sendRequest

("${pageContext.request.contextPath}/RepController", 
				params, delRepResult, "POST");
	}
	function delRepResult(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var str = httpRequest.responseText;
				var o = eval("(" + str + ")");
				if(!o.flag){
					alert("삭제가 처리되지 

않았다");
					return;
				}
				var repList = document.getElementById

("repList");
				var repDiv = document.getElementById

("rep_"+o.num);
				repList.removeChild(repDiv);
			}
		}
	}
</script>
</head>
<body>
<div id="updateFormDiv">
<form name="updateForm" style="display:none">
<table border='1'>
<tr><th>name</th><td><input type="text" name="u_name"></td></tr>
<tr><th>content</th><td><input type="text" name="u_content">
</td></tr>
<tr><td colspan="2">
<input type="button" value="수정" onclick="editRep()">
<input type="button" value="취소" onclick="hideUpdateForm()">
</td></tr>
</table>
<input type="hidden" name="u_num">
</form>
</div>
<form name="f">
<table border='1'>
<tr><th>name</th><td><input type="text" name="name"></td></tr>
<tr><th>content</th><td><input type="text" name="content"></td></tr>
<tr><td colspan="2"><input type="button" value="작성" onclick="addRep

()"></td></tr>
</table>
</form>
<div id="repList">
</div>
</body>
</html>