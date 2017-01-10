<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<br>
	<a href="/Yoseop/adminPage/layout/board.jsp">이전</a>
<br>
<table border="1" width="600">
<tr>
<td>
	상품명
</td>
<td>
<input type="text" name="name"><br>
</td>
</tr>
<tr>
<td>
	구입가격
</td>
<td>
<input type="text" name="price1"><br>
</td>
</tr>
<tr>
<td>
	판매가격
</td>
<td>
<input type="text" name="price2"><br>
</td>
</tr>
<tr>
<td>
	카테고리 분류
</td>
<td>
<input type="text" name="category"><br>
</td>
</tr>
<tr>
<td>
	수량
</td>
<td>
<input type="text" name="num"><br>
</td>
</tr>
<tr>
<td>
	이미지등록
</td>
<td>
	<span style="width:100px;height: 100px;"><img src="/Yoseop/images/aa.jpg"></span>
	<span style="color:blue;"><p>
		- 쇼핑몰에 기본으로 보여지는 상품이미지를 등록합니다.<br>
		- 대표이미지 등록 시, 상세, 목록, 작은목록, 축소 이미지에 자동 리사이징 되어 들어갑니다.<br>
	</p></span>
	<input type="file" name="profile">
</td>
</tr>
<tr align="center">
	<td colspan="2"><input type="button" value="등록"> <input type="reset" value="취소"></td>
</tr>
</table>
</body>
</html>