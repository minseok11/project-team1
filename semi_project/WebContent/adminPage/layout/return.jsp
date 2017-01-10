<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div id="wrap">
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
<span style="font-size:20px;font-weight: bold;">반품목록</span>
<table border="1" width="800px">
	<tr>
		<th>반품번호</th><th>반품사유</th><th>반품상태</th><th>결제번호</th><th>완료여부</th>
	</tr>
</table>
</div>
</body>
</html>