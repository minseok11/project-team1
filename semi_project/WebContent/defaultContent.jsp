<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<div id="content1">
	<c:forEach var="list1" items="${requestScope.list1 }">
		<a href="/mainController.do?cmd=itemPage&$item={list.categoryList}">${list1.categoryList}</a><br>
		
		
	</c:forEach>
</div>
</body>
</html>