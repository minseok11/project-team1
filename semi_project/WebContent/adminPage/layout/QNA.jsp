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
<div>
<table border="1" width="800px">
	<tr>
		<th>글번호</th><th>작성자</th><th>글제목</th><th>질문종류</th><th>답변여부</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.num }</td>
		<td>${dto.id }</td>
		<td><a href="/qna.do?cmd=SeeQA&num=${dto.num }">${dto.title }</a>
		</td><td>${dto.qaList }</td>
		<td>
			<select>
				<option>미완료</option>
				<option>완료</option>
			</select>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>