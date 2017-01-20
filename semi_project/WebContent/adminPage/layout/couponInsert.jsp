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

	<form action="/coupon.do?cmd=insert" method="post">
	<table>
		<tr>
			<td>쿠폰명</td><td><input type="text" name="c_name"></td>
		</tr>
		<tr>
			<td>할인율</td>
			<td>
			<select name="discount">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>%
			</td>
		</tr>
		<tr>
			<td colspan="1"><input type="submit" value="등록"></td>
		</tr>		
	</table>
	</form>
</body>
</html>