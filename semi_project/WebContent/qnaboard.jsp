<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/"></form>
문의항목<select>
	<option value="취소문의">취소문의</option>
	<option value="쿠폰문의">쿠폰문의</option>
	<option value="교환문의">교환문의</option>
	<option value="배송문의">배송문의</option>
	<option value="회원문의">회원문의</option>
	<option value="결제문의">결제문의</option>
	<option value="상품문의">상품문의</option>
	<option value="기타문의">기타문의</option>
</select><br><br>
답변받으실분<br>
성명<input type="text" value="${requestScope.name }" disabled="disabled">
<input type="hidden" value="${requestScope.name }" name="name"><br>
이메일<input type="text" value="${requestScope.email }" name="email"><br>
연락처<input type="text" value="${requestScope.phone }" name="phone"><br>
문의하기<br>
제목<input type="text" name="title"><br><br>
내용<br><textarea name="content" rows="30" cols="80"></textarea><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="문의하기">
</body>
</html>