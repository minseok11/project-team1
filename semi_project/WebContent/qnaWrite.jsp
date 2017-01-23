<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#1{width:200px;height:100px;border:1px solid black;}
	#2{width:605px;height:600px;border:1px solid black;}
	.qnaP{font-size:8px;}
</style>
<script type="text/javascript">
	function msg(){
		if("${requestScope.errMsg}" != ""){
			alert("${requestScope.errMsg}");
		}
	}
	onload=msg;
</script>
</head>
<body>
<form method="post" action="/QAController.do">
문의항목<select name="qaList">
	<option value="취소문의">취소문의</option>
	<option value="쿠폰문의">쿠폰문의</option>
	<option value="교환문의">교환문의</option>
	<option value="배송문의">배송문의</option>
	<option value="회원문의">회원문의</option>
	<option value="결제문의">결제문의</option>
	<option value="상품문의">상품문의</option>
	<option value="기타문의">기타문의</option>
</select><br>
<p class="qnaP">단순변심에 의한 환불은 제품 수령 후 7일이내까지만 가능합니다.(업체배송 : 왕복배송비 고객부담 / 로켓배송 : 반품비(5,000원) 고객부담) </p>
<p class="qnaP">제품 하자의 경우 물품수령 후 3개월이내 또는 그 사실을 안 날로부터 30일이내 반품 가능합니다.</p>
<br>
<div id="1">
답변받으실분<br>
성명<input type="text" value="${requestScope.name }" disabled="disabled"><br>
이메일<input type="text" value="${requestScope.email }" disabled="disabled"><br>
연락처<input type="text" value="${requestScope.phone }" disabled="disabled"><br>
</div>
<div id="2">
문의하기<br>
제목<input type="text" name="title"><br><br>
내용<br><textarea name="content" rows="30" cols="80"></textarea><br><br>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="문의하기">
</form>
</body>
</html>