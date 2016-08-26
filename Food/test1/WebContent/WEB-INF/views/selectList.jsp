<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
	<hr color="red">
		<table border="1" style="text-align: center">
			<tr>
				<td>번호</td><td>메뉴</td>
			</tr>
			<%-- 여기서 사진 수정	 --%>
			<c:choose>
				<c:when test="${ list != null }">
					<c:forEach var="each" items="${ list }">
						<tr>
							<td>${ each.num }</td><td><a href="selectOne.do?num=${ each.num }">${ each.name }</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>저장된 정보가 없습니다</h3>
				</c:otherwise>
			</c:choose>
		</table>
	</div>

</body>
</html>