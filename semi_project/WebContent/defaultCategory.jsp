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
<div id="category1" align="center">
	<c:forEach var="list" items="${requestScope.list }">
	
		<a class="cateName" href="/itemController.do?cate=${list.categoryList}">${list.categoryList}</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>
</div>
</body>
</html>