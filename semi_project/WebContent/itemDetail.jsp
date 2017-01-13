<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#allPage{width:1100px;height:1500px;background-color:yellow;overflow: auto;}
	#itemImg{width:600px;height:600px;background-color: blue;float:left}
	#itemOption{width:450px;height:600px;background-color: red;float:left}
	#itemInfoImg1{width:800px;height:1000px;background-color:pink;float:left}
	
</style>
<script>
	function cal(){
		var itemPrice=document.getElementsByName("itemPrice")[0].value;
		var itemCount=document.getElementsByName("itemCount")[0].value;
		var totalPrice=document.getElementsByName("totalPrice");
		totalPrice[0].value=itemPrice*itemCount;
		
	}
	function dTransfer(url){
		var form=document.getElementById("frm");
		form.method="post";
		form.action="url";
		form.submit;
	}
</script>
</head>
<body>
<div id="allPage">
<div id="itemImg"><img src="${requestScope.itemImgRoot}"></div>
<div id="itemOption" align="center">
	<form id="frm">	
		<p>상품명:${requestScope.name }</p>
		<p>상품가격:${requestScope.price }</p>
		<input type="hidden" value="${requestScope.code }" name="itemCode">
		<input type="hidden" value="${requestScope.price }" name="itemPrice">
		<input type="hidden" value="${requestScope.inventory }" name="itemInven">
		<input type="hidden" value="${requestScope.name }" name="itemName">
		<input type="hidden" value="${requestScope.retailPrice }" name="itemRprice">
		<input type="hidden" value="${requestScope.itemImgRoot }" name="itemImgRoot">
		<input type="hidden" value="${requestScope.categoryList }" name="itemCate">
		<input type="hidden" value="${requestScope.supplier }" name="itemSupplier">
		<p>수량</p>
		<input type="text" name="itemCount" size="5" onchange="cal()"><br>
		<p>합계금액</p>
		<input type="text" name="totalPrice" size="5" readonly="readonly"><br><br><br>
		<input type="button" value="즉시구매" id="buyItem" onclick="dTransfer(/itemBuy.do)">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="장바구니" id="basket" onclick="dTransfer(/basket.do)">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="찜하기" id="jjim" onclick="dTransfer(/jjim.do)">
	</form>
</div>
<div id="itemInfoImg1"></div>
<div>
	
</div>

</div>
</body>
</html>