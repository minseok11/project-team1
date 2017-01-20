<%@page import="shopping.dto.CreateCouponDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.sp{display:inline-block;width:50px; }
	.sps{display:inline-block;width:220px; }
</style>
<script type="text/javascript">
	function c_select(){
		var pp=window.opener.document.getElementsByName("pp");
		var coupon=document.getElementsByName("coupon");
		var sale=window.opener.document.getElementById("sale");
		var discount=window.opener.document.getElementsByName("discount")[0];
		var price=window.opener.document.getElementsByName("price");
		var totPrice=window.opener.document.getElementById("totPrice");
		var totalPrice=window.opener.document.getElementsByName("totalPrice")[0];
		discount.value=coupon[0].value;
		if(coupon[0].value==null||coupon[0].value==""){
			discount.value=0;
		}
		sale.value=totPrice.value*discount.value/100;
		for(var i=0;i<price.length;i++){
			price[i].value=pp[i].value-Math.ceil(pp[i].value*coupon[0].value/100);
		}
		totalPrice.value=totPrice.value-sale.value;
		self.close();

	}
</script>
<%
	
%>
</head>
<body>
<div align="center">
	<select name="coupon">
	<c:forEach var="cc" items="${clist }">
		<option value="${cc.discount }">${cc.name}</option>
	</c:forEach>
	</select>
	<input type="button" value="확인" onclick="c_select()"><br>

</div>	
</body>
</html>