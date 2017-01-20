<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문상세조회</h1>
	<!-- 클라이언트의 주문내역
      현재 주문한 상품의 상품정보 DB에서 불러오기
      교환반품 신청버튼 누르면 교환반품에 대한 사유와 신청이 DB에 저장  -->
<%--
	<ul>
		<li><a href="">MY 쇼핑활동</a>
			<ul>
				<li><a href="/MyPage/OrderList.jsp" title="내가 구매한 상품 보기">내가
						구매한 상품</a></li>
				<li><a href="/MyPage/Order_return_detail.jsp" title="교환/반품">교환/반품</a></li>
			</ul></li>

	</ul>
 --%>
 <h4><span style="color: blue">교환/반품 문의시 문의게시판을 통해 신청해주세요.</span></h4>
	<div>
		<h2>${id }님의 주문상품정보</h2>
		<input type="hidden" value="${id }" name="id">
	</div>
<div style="width: 1000px;height: 500px;">	
	<table align="left" width="800" border="1">
			<tr>
				<th>결제번호</th>
				<th>상품코드</th>
				<th>상품이미지</th>
				<th>상품이름</th>
				<th>판매가</th>
				<th>수량</th>
				<th>쿠폰</th>
				<th>결제금액</th>
				<th>배송정보</th>
			</tr>
			<c:forEach var="dto" items="${list3 }">
				<tr>
					<td>${dto.paymentNum }</td>
					<td>${dto.code }</td>
					<td><img src="../Yoseop/images/${dto.itemImgRoot }" width="80" height="80"></td>
					<td>${dto.name }</td>
					<td>${dto.price }</td>
					<td>${dto.cnt }</td>
					<td>${dto.coupon }</td>
					<td>${dto.itemCost }</td>
					<td>${dto.deliveryCondi }</td>
				</tr>
			</c:forEach>
	</table>
</div>
<div>
<!-- 이전 -->
<c:choose>
	<c:when test="${startPage>4 }">
		<a href="/payment.do?cmd=paymentList&pageNum=${startPage-1 }&id=${id}">이전</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>

<c:forEach var="i" begin="${startPage }" end="${endPage }" >
	<c:choose>
		<c:when test="${pageNum==i }"><%--현재페이지인경우 색상 다르게 표시하기 --%>
			<a href="/payment.do?cmd=paymentList&pageNum=${i }&id=${id}"><span style="color:red">[${i }]</span></a>
		</c:when>
		<c:otherwise>
			<a href="/payment.do?cmd=paymentList&pageNum=${i }&id=${id}"><span style="color:black">[${i }]</span></a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<!-- 다음 -->
<c:choose>
	<c:when test="${endPage<pageCount }">
		<a href="/payment.do?cmd=paymentList&pageNum=${endPage+1 }&id=${id}">다음</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>

</body>
</html>