<%@page import="Y.shopping.dto.StatisticDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
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
	<form action="/Yoseop/statistic.do?cmd=year_list" method="post">
	<select name="year">
		<c:forEach var="i" items="${listAll }">
			<option value="${i.year_month}">20${Math.round(i.year_month/100) }년 ${i.year_month-Math.round(i.year_month/100)*100 }월</option>
		</c:forEach>
	</select>
	<input type="submit" value="검색">
	</form>
	<br>
	<h1>총 결산</h1>
	<table border="1" width="600">
		<tr>
			<th>날짜</th><th>총 원가합계</th><th>총 판매금액</th><th>순수익</th>
		</tr>
		<c:forEach var="st" items="${list }">
			<tr>
				<td>20${Math.round(st.year_month/100) } / ${st.year_month-Math.round(st.year_month/100)*100 }</td>
				<td>${st.totalRetailPrice }</td>
				<td>${st.totalSales }</td>
				<td>${st.totalSales-st.totalRetailPrice }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>