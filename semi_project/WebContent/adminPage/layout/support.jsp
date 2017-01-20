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
<a href="/Yoseop/adminPage/layout/ssinsert.jsp">공급업체 추가</a>
<div>
<span style="font-size:20px;font-weight: bold;">공급업체</span>
<table border="1" width="800px">
	<tr>
		<th>공급업체명</th><th>담당자</th><th>연락처</th><th>수정</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.supplier }</td>
			<td>${dto.manager }</td>
			<td>${dto.contect }</td>
			<td>
			<a href="/Yoseop/supplier.do?cmd=detail&supplier=${dto.supplier }">수정</a>
			<a href="/Yoseop/supplier.do?cmd=delete&supplier=${dto.supplier }">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>

</div>
</body>
</html>