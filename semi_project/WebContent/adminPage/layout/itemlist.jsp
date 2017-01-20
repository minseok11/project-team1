<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body onload="sel()">
	<jsp:include page="/adminPage/admin.jsp"></jsp:include>
	<div>
		<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
	</div>
	<a href="/Yoseop/adminPage/layout/item.jsp">이전</a>	
	<h1>상품검색</h1>
	<form action="/Yoseop/Aitems.do?cmd=search" method="post">
			<table border="1" width="800px">
				<tr>
					<td><select name="option">
							<option value="name">상품명</option>
							<option value="code">상품코드</option>
					</select></td>
					<td><input type="text" name="search"> <input type="submit" value="검색"></td>
				</tr>
			</table>
		</form>
	<br>
	<h2>상품목록</h2>
<table border="1" width="800">
	<tr>
		<th>상품이미지</th>
				<th>상품코드</th>
				<th>상품분류</th>
				<th>공급업체</th>
				<th>상품명</th>
				<th>재고량</th>
				<th>원가</th>
				<th>판매가격</th>
				<th>수정</th>
	</tr>
	<c:forEach var="it" items="${ilist }">
				<tr>
					<td><img width="100" height="100" src="../Yoseop/images/${it.itemImgRoot }"></td>
					<td>${it.code }</td>
					<td>${it.categoryList}</td>
					<td>${it.supplier }</td>
					<td>${it.name }</td>
					<td>${it.inventory }</td>
					<td>${it.retailPrice }</td>
					<td>${it.price }</td>
					<td>
					<a href="/Yoseop/Aitems.do?cmd=detail&code=${it.code }">수정</a>
					<a href="<%=request.getContextPath() %>/Aitems.do?cmd=delete&code=${it.code }">삭제</a>
					</td>
				</tr>
	</c:forEach>
</table>
<!-- /////// 페이징 처리 ////////////// -->
<div>
<!-- 이전 -->
<c:choose>
	<c:when test="${startPage>4 }">
		<a href="/Yoseop/Aitems.do?cmd=search&pageNum=${startPage-1 }">이전</a>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<c:forEach var="i" begin="${startPage }" end="${endPage }" >
	<c:choose>
		<c:when test="${pageNum==i }"><%--현재페이지인경우 색상 다르게 표시하기 --%>
			<a href="/Yoseop/Aitems.do?cmd=search&pageNum=${i }&option=${option }&search=${search }"><span style="color:red">[${i }]</span></a>
		</c:when>
		<c:otherwise>
			<a href="/Yoseop/Aitems.do?cmd=search&pageNum=${i }&option=${option }&search=${search }"><span style="color:#555">[${i }]</span></a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<!-- 다음 -->
<c:choose>
	<c:when test="${endPage<pageCount }">
		<a href="/Yoseop/Aitems.do?cmd=search&pageNum=${endPage+1 }&option=${option }&search=${search }">다음</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>

<%
	String option = "writer";
	String search = "";  
	if(request.getAttribute("option") != null){
		option = (String)request.getAttribute("option");
	}
	if(request.getAttribute("search") != null){
		search =  (String)request.getAttribute("search");
	}
%>
<script>
	function sel(){
		var option = document.getElementsByName("option");
		option[0].value = "<%=option%>";
		var search = document.getElementsByName("search");
		search[0].value = "<%=search%>";
	}
</script>
</body>
</html>


