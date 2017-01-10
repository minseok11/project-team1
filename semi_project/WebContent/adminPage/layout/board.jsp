	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{width: 1000px;}
</style>
</head>
<body>
<jsp:include page="/adminPage/admin.jsp"></jsp:include>
<div>
	<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
</div>
<div id="wrap">
	<a href="/Yoseop/adminPage/layout/insert.jsp">상품추가</a>
<br>
<br>
<span style="font-size:20px;font-weight: bold;">상품검색</span>
<table border="1" width="800px">
	<tr>
		<td>
		<select>
			<option>상품코드</option>
			<option>상품명</option>
		</select>
		</td>
		<td>
		<input type="text" name="search">
		<input type="button" value="검색">
		</td>
	</tr>
	<tr>
		<td>
			카테고리 분류
		</td>
		<td>
		<select>
			<option>카테고리1</option>
			<option>카테고리2</option>
		</select>
		<input type="button" value="검색">
		</td>
	</tr>
</table>
<br>
<span style="font-size:20px;font-weight: bold;">상품목록</span>
<table border="1" width="800px">
	<tr>
		<th>상품코드</th><th>카테고리</th><th>상품명</th><th>가격</th><th>수정</th>
	</tr>
</table>
</div>
	
</body>
</html>