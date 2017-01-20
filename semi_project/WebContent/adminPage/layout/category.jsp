<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
<jsp:include page="/adminPage/admin.jsp"></jsp:include>
<div>
	<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
</div>
<br>
<table border="0" width="500">
	<tr>
		<th>카테고리명</th><th align="center">수정</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td align="center">${dto.categoryList }</td>
			<td align="center"><a href="/Yoseop/scategory.do?cmd=delete&cate=${dto.categoryList}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<div>
<form method="post" action="/Yoseop/scategory.do?cmd=insert">
	카테고리 명<input type="text" name="cate">
	<input type="submit" value="추가">
</form>
</div>
</body>
</html>