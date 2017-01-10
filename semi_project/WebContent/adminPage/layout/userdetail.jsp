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
<h1>${id }님의 정보</h1>
<br>
<span style="font-size:20px;font-weight: bold;">문의목록</span>
<table border="1" width="800px">
	<tr>
		<th>글번호</th><th>제목</th><th>아이디</th><th>문의종류</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.num }</td><td><a href="">${dto.title }</a></td><td>${dto.id }</td><td>${dto.qaList }</td>
		</tr>
	</c:forEach>
</table>
<br>
<span style="font-size:20px;font-weight: bold;">쿠폰목록</span>
<table border="1" width="800px">
	<tr>
		<th>생성번호</th><th>쿠폰명</th><th>사용구분</th><th>기간</th>
	</tr>
</table>
<br>
<span style="font-size:20px;font-weight: bold;">결제목록</span>
<table border="1" width="800px">
	<tr>
		<th>결제번호</th><th>이메일</th><th>전화번호</th><th>주소</th><th>성별</th>
	</tr>
</table>

</body>
</html>