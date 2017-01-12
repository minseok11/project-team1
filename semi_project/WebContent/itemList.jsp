<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	@import url(http://fonts.googleapis.com/earlyaccess/nanumpenscript.css);
	#pageing{width:1000px;height:100px;background-color:#CEBEE1;margin:auto;font-size:30px;}
	.titleBox{width:160px;height:290px;border:1px solid black;border-radius:5px;margin-right:30px;float:left;margin-left:50px;margin-top:50px;text-align:center;}
	#content1{width:1000px;height:1200px;background-color:white;margin-left:50px;}
	img{width:130px;height:190px;border-radious:2px;margin-top:15px;}
	a{font-size:30px;font-family:'Nanum Pen Script';text-decoration:none;color:black}
</style>
</head>
<body>
<div id="content1">
	<c:forEach var="list2" items="${requestScope.list3 }">
		<div class="titleBox">
		<a href="/starter.do?content=/itemDetail.jsp&code=${list2.code }"><img src="${list2.itemImgRoot }"></a><br><br>
		<a href="/starter.do?content=/itemDetail.jsp&code=${list2.code }">${list2.name }</a>
		</div>
	</c:forEach>
</div>
	<div id="pageing" align="center">
	<c:choose>
		<c:when  test="${requestScope.startPage==1 }">
			[이전]
		</c:when>
		<c:otherwise>
			<a href="/itemController.do?start=${requestScope.startPage-1 }">[이전]</a>
		</c:otherwise>
	</c:choose>
	<c:forEach var="number" begin="${requestScope.startPage }" end="${requestScope.endPage }">
		<a href="/itemController.do?cate=${requestScope.cate }&start=${number }">[${number }]</a>
	</c:forEach>
	<c:choose>
		<c:when  test="${requestScope.endPage==requestScope.pageCount }">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="/itemController.do?start=${requestScope.endPage+1 }">[다음]</a>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>