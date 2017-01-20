<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumpenscript.css);
	.cateName{font-size:40px;font-family:'Nanum Pen Script';text-decoration:none}
	#category1{padding-top:30px;}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<div id="box1" align="center">
	<form action="/search.do">
		<input type="text" name="search" style="border: 5px solid black;"><input type="submit" value="검색" style="width:50px;font-size:20px;">
	</form>		
</div>
<div id="category1" align="center">
	<c:forEach var="list" items="${requestScope.list }"><%--list리퀘스트스코프에 담겨있는 대상을 객체수만큼 루프 --%>
	
		<a class="cateName" href="/itemController.do?cate=${list.categoryList}">${list.categoryList}</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%--카테고리 모두 출력 --%>
	</c:forEach>
</div>
</body>
</html>