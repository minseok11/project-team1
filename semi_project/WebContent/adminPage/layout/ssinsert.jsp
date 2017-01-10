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
	<a href="/Yoseop/layout/support.jsp">이전</a>
<br>
<table border="1" width="600">
<tr>
<td>
	공급업체명
</td>
<td>
<input type="text" name="name"><br>
</td>
</tr>
<tr>
<td>
	담당자
</td>
<td>
<input type="text" name="price1"><br>
</td>
</tr>
<tr>
<td>
	연락처
</td>
<td>
<input type="text" name="price2"><br>
</td>
</tr>
<tr>
<td>
	상품코드
</td>
<td>
<input type="text" name="category"><br>
</td>
</tr>
<tr align="center">
	<td colspan="2"><input type="button" value="등록"> <input type="reset" value="취소"></td>
</tr>
</table>

</body>
</html>