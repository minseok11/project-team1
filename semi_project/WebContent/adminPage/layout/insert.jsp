<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
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
	<a href="/Yoseop/adminPage/layout/item.jsp">이전</a>
	<br>
	<form action="<%=request.getContextPath()%>/Aitems.do?cmd=insert" method="post" enctype="multipart/form-data">
	<table border="1" width="800">
		<tr>
			<td>상품코드</td>
			<td><input type="text" name="code"><br></td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text" name="name"><br></td>
		</tr>
		<tr>
			<td>원가</td>
			<td><input type="number" name="retail" min="0"><br></td>
		</tr>
		<tr>
			<td>판매가격</td>
			<td><input type="number" name="price" min="0"><br></td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td><select name="category">
					<c:forEach var="cate" items="${clist }">
						<option value="${cate.categoryList }">${cate.categoryList }</option>
					</c:forEach>
				</select></td>
		</tr>
		<tr>
			<td>수량</td>
			<td><input type="number" name="inventory" min="0"><br></td>
		</tr>
		<tr>
			<td>공급업체</td>
			<td><select name="supplier">
			<c:forEach var="sp" items="${list }" >
				<option value="${sp.supplier }">${sp.supplier }</option>
			</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>대표이미지</td>
			<td><span style="width: 100px; height: 100px;"><img
					src="/Yoseop/images/aa.jpg"></span> <span style="color: blue;"><p>
						- 쇼핑몰에 기본으로 보여지는 상품이미지를 등록합니다.<br> - 대표이미지 등록 시, 상세, 목록,
						작은목록, 축소 이미지에 자동 리사이징 되어 들어갑니다.<br>
					</p></span> <input type="file" name="imgs"></td>
		</tr>
		<tr>
			<td>상세이미지</td>
			<td><span style="width: 100px; height: 100px;"><img
					src="/Yoseop/images/aa.jpg"></span> <span style="color: blue;font-size: 30px;"><p>
						- 상세이미지는 상품상세보기시, 설명문구로 들어가는 이미지입니다.
					</p></span> <input type="file" name="detailImg"></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="등록"> <input
				type="reset" value="취소"></td>
		</tr>
	</table>
	</form>
</body>
</html>