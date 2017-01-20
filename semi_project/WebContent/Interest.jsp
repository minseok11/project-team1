<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
var total=0;
var rprice=0;
var rcnt=0;
function Price() {
	var choice=document.getElementsByName("choice");
	var price=document.getElementsByName("price");
	var cnt=document.getElementsByName("cnt");
	var div=document.getElementById("result");
	for(var i=0; i<price.length;i++){
			rprice=parseFloat(price[i].value);

			rcnt=parseFloat(cnt[i].value);

			total=total+(rprice*rcnt);	

	}
div.innerHTML=total+"원";
total=0;
}
onload=Price;
function changeV(){
	Price();
}
</script>
</head>
<body>
<!-- 
		마음에 드는 상품을 주문하기 전에 장바구니에 상품정보를 담으면 DB에 구매미완료로 저장된다.
		또한 이미지를 누르면 상품정보 페이지로 넘어간다. 
		상품코드 상품정보 판매가격 수량 (삭제버튼) 
 		(선택상품주문버튼)(전체상품주문하기버튼)
 -->
<h1>찜하기</h1>
	<table border="1" width="1200px" ></table>
	상품정보&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	상품금액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	배송정보
	<table border="1" width="1200px" ></table>
	<div id="box1">
		<c:forEach var="dto" items="${requestScope.list3 }">
			<img src="${dto.itemimgroot }">
			${dto.name }
			<input type="number" min="0" value="1" name="cnt" id="cnt" style='width:3em' onchange="changeV()">
			<input type="text" name="price" value="${dto.price}" readonly="readonly">
			무료배송
			<a href="/interest.do?cmd=delete&code=${dto.code }">삭제</a>
			<a href="/itemDetail.do?code=${dto.code }">상품페이지로 이동</a>
			<br>	
		</c:forEach>		
	</div>
	<div id="box2">
		총상품가격 <div id="result"></div>
		총 배송비 0원
		
	</div>	
	<a href="/starter.do" >계속쇼핑하기</a>
</body>
</html>