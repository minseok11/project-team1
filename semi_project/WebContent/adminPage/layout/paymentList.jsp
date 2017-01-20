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
	<h2>검색기능</h2>
	<form action="" method="post">
	<select name="option">
		<option value="id">아이디</option>
		<option value="code">상품코드</option>
	</select>
	<input type="text" name="search">
	<input type="submit" value="검색">
	</form>
	<h1>결제정보</h1>	
	<table border="1" width="800">
		<tr>
			<th>결제번호</th><th>아이디</th><th>상품코드</th><th>결제금액</th><th>결제날짜</th><th>상태</th><th></th>
		</tr>
		<c:forEach var="pay" items="${list }">
			<tr>
				<td>${pay.paymentNum }</td>
				<td>${pay.id }</td>
				<td>${pay.code }</td>
				<td>${pay.itemCost }</td>
				<td>${pay.year_month }</td>
				<td>${pay.condition }</td>
				<td><a href="/Yoseop/payment.do?cmd=itemReturn&paymentnum=${pay.paymentNum }">반품신청</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>