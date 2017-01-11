<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#content1{width:800px;height:1000px;background-color:white;margin-left:150px;}
	.items{width:100px;height:120px;border:1px solid black;border-radious:2px;margin-rigth:50px;}
	img{width:40px;height:50px;border-radious:2px}
	
	
</style>
<script type="text/javascript">
</script>
</head>
<body>
<div id="content1">
	<c:forEach var="list1" items="${requestScope.list1 }">
		<div class="items">
			<a href="/mainController.do?cmd=itemPage&$item=${list1.name}"><img src="${list1.itemImgRoot }"></a><br>
			<a href="/mainController.do?cmd=itemPage&$item=${list1.name}">${list1.name}</a><br>
		</div>
	</c:forEach>
</div>
</body>
</html>