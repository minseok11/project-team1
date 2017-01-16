<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#allPage {
	width: 1100px;
	height: 1500px;
	background-color: yellow;
	overflow: auto;
}

#itemImg {
	width: 600px;
	height: 600px;
	background-color: blue;
	float: left
}

#itemOption {
	width: 450px;
	height: 600px;
	background-color: red;
	float: left;
}

#itemInfoImg1 {
	width: 1050px;
	height: 1200px;
	background-color: pink;
	float: left;
}

#itemImage {
	width: 580px;
	height: 580px;
	margin-top: 10px;
}

#writePart {
	width: 580px;
	height: 580px;
}
</style>
<script>
	function cal() {
		var itemPrice = document.getElementsByName("itemPrice")[0].value;
		var itemCount = document.getElementsByName("itemCount")[0].value;
		var totalPrice = document.getElementsByName("totalPrice");
		totalPrice[0].value = itemPrice * itemCount;
	}
	function dTransfer(url) {
		var form = document.getElementById("frm");
		form.method = "post";
		form.action = url;
		form.submit();
	}
	function wResult() {
		var result1 = document.getElementById("result1");
		if (result1.value == null || result1.value == "") {
			result1.value = "구매후기 입력란입니다.";
		} else {
			alert(result1.value);
		}
	}
	onload = wResult;
</script>
</head>
<body>
	<div id=allPage>
	<div id="itemImg" align="center">
		<img src="${requestScope.itemImgRoot}" id="itemImage">
	</div>
	<div id="itemOption" align="center">
		<form id="frm">
			<br> <br> <br> <br> <br>
			<p>상품명:${requestScope.name }
			<p>상품가격:${requestScope.price }</p>
			<input type="hidden" value="${requestScope.code }" name="itemCode">
			<input type="hidden" value="${requestScope.price }" name="itemPrice">
			<input type="hidden" value="${requestScope.inventory }"
				name="itemInven"> <input type="hidden"
				value="${requestScope.name }" name="itemName"> <input
				type="hidden" value="${requestScope.retailPrice }" name="itemRprice">
			<input type="hidden" value="${requestScope.itemImgRoot }"
				name="itemImgRoot"> <input type="hidden"
				value="${requestScope.categoryList }" name="itemCate"> <input
				type="hidden" value="${requestScope.supplier }" name="itemSupplier">
			<p>수량</p>
			<input type="text" name="itemCount" size="5" onchange="cal()"><br>
			<p>합계금액</p>
			<input type="text" name="totalPrice" size="5" readonly="readonly"><br>
			<br> <br>
			<p>배송비 : 무료</p>
			<br> <input type="image" value="즉시구매" src="/images/buy.gif"
				id="buyItem" onclick="dTransfer('/itemBuy.do')">&nbsp; <input
				type="image" value="장바구니" src="/images/basket.gif" id="basket"
				onclick="dTransfer('/basket.do')">&nbsp; <input type="image"
				value="찜하기" src="/images/love.gif" id="jjim"
				onclick="dTransfer('/jjim.do')">
		</form>
	</div>
	<div id="itemInfoImg1"></div>
	<div>
		<div>
			<div id="boardList" align="center">
				<c:forEach var="list2" items="${requestScope.list3 }">
					<img src="">
					<p>제목:${list2.title }</p>
					<p>작성자:${list2.id }</p>
					<p>${list2.content }</p>
				</c:forEach>
			</div>
			<div id="pageing" align="center">
				<c:choose>
					<c:when test="${requestScope.startPage==1 }">
			[이전]
		</c:when>
					<c:otherwise>
						<a href="/write.do?start=${requestScope.startPage-1 }">[이전]</a>
					</c:otherwise>
				</c:choose>
				<c:forEach var="number" begin="${requestScope.startPage }"
					end="${requestScope.endPage }">
					<a href="/write.do?start=${number }">[${number }]</a>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.endPage==requestScope.pageCount }">
			[다음]
		</c:when>
					<c:otherwise>
						<a href="/write.do?start=${requestScope.endPage+1 }">[다음]</a>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="writePart">
				<form action="/write.do" method="post" enctype="multipart/form-data">
					<br>제목<input type="text" name="title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" id="result1" value="${requestScope.wResult }"
						readonly="readonly"><br>
					<textarea rows="10" cols="60" name="wContent"></textarea>
					<br> <input type="file" name="uploadImg"> <input
						type="hidden" value="${requestScope.code }" name="code">
					<input type="submit" value="작성">
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>