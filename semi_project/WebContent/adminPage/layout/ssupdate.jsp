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
	<jsp:include page="/adminPage/admin.jsp"></jsp:include>
	<div>
		<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
	</div>
	<br>
	<a href="/Yoseop/supplier.do?cmd=list">이전</a>
	<br>
	<form action="/Yoseop/supplier.do?cmd=update" method="post">
		<table border="1" width="600">
		<c:forEach var="list" items="${list }">		
			<tr>
				<td>공급업체명</td>
				<td><input type="text" name="supplier" readonly="readonly" value="${list.supplier }"></td>
			</tr>
			<tr>
				<td>담당자</td>
				<td><input type="text" name="manager" value="${list.manager }"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="contect" value="${list.contect }"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="수정"> <input
					type="reset" value="취소"></td>
			</tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>