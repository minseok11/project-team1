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
	function checkAll() {
		var chk=document.getElementById("chk");
		var choice=document.getElementsByName("choice");
		if(chk.value==0){
			for(var i=0; i<choice.length;i++){
				choice[i].checked=true;
				chk.value=1;
			}
		}else{
			for(var i=0; i<choice.length;i++){
				choice[i].checked=false;
				chk.value=0;
			}
		}
		Price();
	}
	
	var total=0;
	var rprice=0;
	var rcnt=0;
	function Price() {
		var choice=document.getElementsByName("choice");
		var price=document.getElementsByName("price");
		var cnt=document.getElementsByName("cnt");
		var div=document.getElementById("result");
		for(var i=0; i<choice.length;i++){
			if(choice[i].checked==true){
				rprice=parseFloat(price[i].value);
	
				rcnt=parseFloat(cnt[i].value);

				total=total+(rprice*rcnt);	

			}
		}
	div.innerHTML=total+"원";
	total=0;
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
<h1>장바구니</h1>
	<table border="1" width="1200px" ></table>
	<input type="checkbox" id="chk" value="0" onclick="checkAll()">전체선택&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	상품정보&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	상품금액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	배송정보
	<table border="1" width="1200px" ></table>
	<div id="box1">
		<c:forEach var="dto" items="${requestScope.list4 }">
			<input type="hidden" name="buyNum" value="${requestScope.buyNum }">
			<input type="checkbox" name="choice" onclick="Price()">
			<img src="${dto.itemimgroot }">
			${dto.name }
			<input type="number" min="0" value="${dto.cnt }" name="cnt" id="cnt" style="width: 3em">
			<input type="text" name="price" value="${dto.totalprice}" readonly="readonly">
			무료배송
			<a href="/basket.do?cmd=delete&buyNum=${dto.buyNum }">삭제</a>
			<br>	
		</c:forEach>		
	</div>
	<div id="box2">
		총상품가격 <div id="result"></div>
		총 배송비 0원
		
	</div>	
	<input type="submit" value="계속 쇼핑하기">
	<input type="submit" value="구매하기">
	
</body>
</html>