<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#qalist {
	width: 1000px;
	height: 1300px;
	background-color: #BEEFFF;
	margin: auto;
	padding-top: 100px;
}

#pageing {
	width: 1000px;
	height: 100px;
	background-color: #CEBEE1;
	margin: auto;
}
.num{display: inline-block;width:100px;border:1px solid gray;}
.title{display: inline-block;width:430px;border:1px solid gray;}
.id{display: inline-block;width:100px;border:1px solid gray;}
.qalist{display: inline-block;width:200px;border:1px solid gray;}
</style>
</head>
<body>
	<div>
		<div id="qalist" align="center">
		<h3>나의 문의내역</h3>
			<span class="num" style="border: 1px solid black;">글번호</span>
			<span class="title" style="border: 1px solid black;">글제목</span>
			<span class="id" style="border: 1px solid black;">작성자</span>
			<span class="qalist" style="border: 1px solid black;">문의내역</span>
				<br>
			<c:forEach var="list2" items="${list3 }">
				<span class="num">${list2.num }</span>
				<span class="title"><a href="/qna.do?cmd=MyQA&num=${list2.num }" style="text-decoration: none;">${list2.title }</a></span>
				<span class="id">${list2.id }</span>
				<span class="qalist">${list2.qaList }</span>
				<br>
			</c:forEach>
		</div>
		<div id="pageing" align="center">
			<c:choose>
				<c:when test="/qna.do?cmd=qaList&pageNum=${requestScope.startPage==1 }">
			[이전]
		</c:when>
				<c:otherwise>
					<a href="/qna.do?cmd=qaList&pageNum=${requestScope.startPage-1 }">[이전]</a>
				</c:otherwise>
			</c:choose>
			<c:forEach var="number" begin="${requestScope.startPage }"
				end="${requestScope.endPage }">
				<a href="/qna.do?cmd=qaList&pageNum=${number }">[${number }]</a>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.endPage==requestScope.pageCount }">
			[다음]
		</c:when>
				<c:otherwise>
					<a href="/qna.do?cmd=qaList&pageNum=${requestScope.endPage+1 }">[다음]</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>



