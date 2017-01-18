<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리스트</h1>
<form method="post" action="/MyPage.do?cmd=list">
<table border="1" width="600">
<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>질문</th>
		<th>답</th>
		<th>이름</th>
		<th>성별</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>우편번호</th>
</tr>
<c:forEach var="dto" items="${request.list }">
		<tr>
			<td>${dto.id }</td>
			<td>${dto.password }</td>
			<td>${dto.qesList }</td>
			<td>${dto.ans }</td>
			<td>${dto.name }</td>
			<td>${dto.gender }</td>
			<td>${dto.email }</td>
			<td>${dto.phoneNo }</td>
			<td>${dto.adress }</td>
			<td>${dto.postNo }</td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>