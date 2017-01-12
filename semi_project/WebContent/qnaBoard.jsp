<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#qalist{width:1000px;height:1300px;background-color:#BEEFFF;margin:auto;padding-top:100px;font-size:30px;}
	#pageing{width:1000px;height:100px;background-color:#CEBEE1;margin:auto;font-size:30px;}
	.titleBox{width:300px;;height:50px;border:1px solid blue;}
	.qaoption{width:300px;;height:50px;border:1px solid blue;}
</style>
</head>
<body>
<div>
	<div id="qalist" align="center">
	<c:forEach var="list2" items="${requestScope.list3 }">
		<span class="titleBox">
		<a href="/starter.do?content=/qaDetail.jsp&num=${list2.num }">${list2.title }</a>
		</span>
		<span class="qaoption">
		${list2.qaList }
		</span><br>
	</c:forEach>
	</div>
	<div id="pageing" align="center">
	<c:choose>
		<c:when  test="${requestScope.startPage==1 }">
			[이전]
		</c:when>
		<c:otherwise>
			<a href="/QAboard.do?start=${requestScope.startPage-1 }">[이전]</a>
		</c:otherwise>
	</c:choose>
	<c:forEach var="number" begin="${requestScope.startPage }" end="${requestScope.endPage }">
		<a href="/QAboard.do?start=${number }">[${number }]</a>
	</c:forEach>
	<c:choose>
		<c:when  test="${requestScope.endPage==requestScope.pageCount }">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="/QAboard.do?start=${requestScope.endPage+1 }">[다음]</a>
		</c:otherwise>
	</c:choose>
	</div>
</div>
</body>
</html>