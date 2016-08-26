<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js_files/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="./js_files/httpRequest.js"></script>
</head>
<body>

<div align="center">
	<h2>메 뉴 수 정</h2>
	<hr color="green">
	<form action="updateOne.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${ dto.num }">
		<table border="1" style="text-align: center">
			<tr>
				<td colspan="2" style="font-size: 30px;">${ each.num }</td>
			</tr>
			<tr>
				<td>메뉴명</td><td><input type="text" name="name" value="${ dto.name }"></td>
			</tr>
			<tr>
				<td>가격</td><td><input type="text" name="price" value="${ dto.price }"></td>
			</tr>
			<tr>
				<td colspan="2"><img id="imgArea" alt="" src="files/${ dto.sysname }" style="width: 500px; height: 250px;">
			</tr>
			<tr>
			
				<td>이미지</td><td><input id="up" type="file" name="upfile" value="${ dto.sysname }">&nbsp;
				<input type="button" value="이미지삭제" id="bt" onclick="getData()"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정완료"></td>
				<div id="aa"></div>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
	function getData(){
		var params =""+$("#up").attr("value");
		alert(params);
		
		sendRequest("updatePic.do", params, callback, "get");
	}
	function callback(){
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				
				$("#aa").text("1234");
// 				document.imgArea.setAttribute("src", "");
				$("img").fadeout(200);
				
				alert("완료");
			}else{
				alert(httpRequest.status);
			}
		}
	}
</script>
</body>
</html>