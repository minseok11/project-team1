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
<span style="font-size:20px;font-weight: bold;">고객목록</span>
<table border="1" width="800px">
	<tr>
		<th>아이디</th><th>이름</th><th>이메일</th><th>전화번호</th><th>주소</th><th>성별</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td><a href="/Yoseop/userinfo.do?cmd=list&id=${dto.id }">${dto.id }</a></td><td>${dto.name }</td><td>${dto.email }</td><td>${dto.phoneNo }</td><td>${dto.adress }</td><td>${dto.gender }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>