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
<span style="font-size:20px;font-weight: bold;">고객정보</span>
<table border="1" width="800px">
	<c:forEach var="info" items="${info }">
		<tr>
			<td>이름</td><td>${info.name}</td>
			<td>이메일</td><td>${info.email}</td>
		</tr>
		<tr>
			<td>성별</td><td>${info.gender}</td>
			<td>전화번호</td><td>${info.phoneNo}</td>
		</tr>
		<tr>
			<td>우편번호</td><td>${info.postNo}</td>
			<td>주소</td><td>${info.adress}</td>
		</tr>
	</c:forEach>
</table>
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
	<c:forEach var="cc" items="${couponlist }">
		<tr>
			<td>${cc.createNum }</td><td>${cc.name }</td><td>${cc.used }</td><td>${cc.usedate }</td>
		</tr>
	</c:forEach>
</table>
<br>
<span style="font-size:20px;font-weight: bold;">결제목록</span>
<table border="1" width="800px">
	<tr>
		<th>결제번호</th><th>구매상태</th><th>쿠폰사용유무</th><th>상품코드</th><th>배송번호</th><th>날짜</th>
	</tr>
	<c:forEach var="pay" items="${pay }">
		<tr>
			<td>${pay.paymentNum }</td>
			<td>${pay.condition }</td>
			<td>${pay.coupon }</td>
			<td>${pay.code }</td>
			<td>${pay.deliveryNo }</td>
			<td>${pay.year_month }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>