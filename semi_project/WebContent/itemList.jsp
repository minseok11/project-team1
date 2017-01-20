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
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/itemOrder.do?cmd=NewItem&cate=${cate }">신상품순</a>&nbsp;&nbsp;
<a href="/itemOrder.do?cmd=HotItem&cate=${cate }">인기상품순</a>&nbsp;&nbsp;
<a href="/itemOrder.do?cmd=LowPrice&cate=${cate }">낮은가격순</a>&nbsp;&nbsp;
<a href="/itemOrder.do?cmd=HighPrice&cate=${cate }">높은가격순</a>&nbsp;&nbsp;
<div id="box" align="center">
	<form action="/cateSearch.do">
		<input type="text" name="search">
		<input type="hidden" name="cate" value="${cate }">
		<input type="submit" value="검색">
	</form>		
</div>
<div id="content1">
	<c:forEach var="list2" items="${requestScope.list3 }">
		<div class="titleBox">
		<a href="/itemDetail.do?code=${list2.code }"><img src="/images/${list2.itemImgRoot }"></a><br><br>
		<a href="/itemDetail.do?code=${list2.code }">${list2.name }</a>
		</div>
	</c:forEach>
</div>
<!-- /////// 페이징 처리 ////////////// -->

<c:choose>

	<c:when test="${send=='A'}">
	<div id="part1" align="center">
		<c:choose>
			<c:when test="${startPage>10 }">
				<a href="/itemOrder.do?cmd=NewItem&pageNum=${startPage-1 }">이전</a>	
			</c:when>
		</c:choose>
			<c:forEach var="i" begin="${startPage }" end="${endPage }" >
				<c:choose>
					<c:when test="${pageNum==i }"><%--현재페이지인경우 색상다르게 표시하기 --%>
						<a href="/itemOrder.do?cmd=NewItem&pageNum=${i }&cate=${cate }"><span style="color:red">[${i }]</span></a>
					</c:when>
					<c:otherwise>
						<a href="/itemOrder.do?cmd=NewItem&pageNum=${i }&cate=${cate }"><span style="color:#555">[${i }]</span></a>
					</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPage<pageConut }">
				<a href="/itemOrder.do?cmd=NewItem&pageNum=${endPage+1}">다음</a>	
			</c:when>
		</c:choose>
	</div>	
	</c:when>
		
	<c:when test="${send=='B'}">
		<div id="part2" align="center">
				<c:choose>
					<c:when test="${startPage>10 }">
						<a href="/itemOrder.do?cmd=HotItem&pageNum=${startPage-1 }">이전</a>
					</c:when>
				</c:choose>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${pageNum==i }">
								<%--현재페이지인경우 색상다르게 표시하기 --%>
								<a href="/itemOrder.do?cmd=HotItem&pageNum=${i }&cate=${cate }"><span style="color: red">[${i }]</span></a>
							</c:when>
							<c:otherwise>
								<a href="/itemOrder.do?cmd=HotItem&pageNum=${i }&cate=${cate }"><span style="color: #555">[${i }]</span></a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				<c:choose>
					<c:when test="${endPage<pageConut }">
						<a href="/itemOrder.do?cmd=HotItem&pageNum=${endPage+1}">다음</a>
				</c:when>
				</c:choose>
			</div>
		</c:when>
		
		<c:when test="${send=='C'}">
			<div id="part3" align="center">
				<c:choose>
					<c:when test="${startPage>10 }">
						<a href="/itemOrder.do?cmd=LowPrice&pageNum=${startPage-1 }">이전</a>
					</c:when>
				</c:choose>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${pageNum==i }">
								<%--현재페이지인경우 색상다르게 표시하기 --%>
								<a href="/itemOrder.do?cmd=LowPrice&pageNum=${i }&cate=${cate }"><span
									style="color: red">[${i }]</span></a>
							</c:when>
							<c:otherwise>
								<a href="/itemOrder.do?cmd=LowPrice&pageNum=${i }&cate=${cate }"><span
									style="color: #555">[${i }]</span></a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				<c:choose>
					<c:when test="${endPage<pageConut }">
						<a href="/itemOrder.do?cmd=LowPrice&pageNum=${endPage+1}">다음</a>
					</c:when>
				</c:choose>
			</div>
		</c:when>
		
		<c:when test="${send=='D'}">
			<div id="part4" align="center">
				<c:choose>
					<c:when test="${startPage>10 }">
						<a href="/itemOrder.do?cmd=HighPrice&pageNum=${startPage-1 }">이전</a>
					</c:when>
				</c:choose>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${pageNum==i }">
								<%--현재페이지인경우 색상다르게 표시하기 --%>
								<a href="/itemOrder.do?cmd=HighPrice&pageNum=${i }&cate=${cate }"><span
									style="color: red">[${i }]</span></a>
							</c:when>
							<c:otherwise>
								<a href="/itemOrder.do?cmd=HighPrice&pageNum=${i }&cate=${cate }"><span
									style="color: #555">[${i }]</span></a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				<c:choose>
					<c:when test="${endPage<pageConut }">
						<a href="/itemOrder.do?cmd=HighPrice&pageNum=${endPage+1}">다음</a>
					</c:when>
				</c:choose>
			</div>
		</c:when>
		<c:when test="${send=='E'}">
		<div id="part5" align="center">
			<c:choose>
				<c:when test="${startPage>10 }">
						<a href="/cateSearch.do?pageNum=${startPage-1 }">이전</a>
				</c:when>
				</c:choose>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${pageNum==i }">
								<a href="/cateSearch.do?cate=${cate }&search=${search }&pageNum=${i }"><span style="color:red">[${i }]</span></a>
							</c:when>
							<c:otherwise>
								<a href="/cateSearch.do?cate=${cate }&search=${search }&pageNum=${i }"><span style="color:red">[${i }]</span></a>
							</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${endPage<pageCount }">
						<a href="/cateSearch.do?pageNum=${endPage+1 }">다음</a>
				</c:when>
			</c:choose>
			</div>
		</c:when>
		<c:otherwise>
			<div id="pageing" align="center">
				<c:choose>
					<c:when test="${requestScope.startPage==1 }">
					[이전]
				</c:when>
					<c:otherwise>
						<a href="/itemController.do?start=${requestScope.startPage-1 }">[이전]</a>
					</c:otherwise>
				</c:choose>
				<c:forEach var="number" begin="${requestScope.startPage }"
					end="${requestScope.endPage }">
					<a
						href="/itemController.do?cate=${requestScope.cate }&start=${number }">[${number }]</a>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.endPage==requestScope.pageCount }">
					[다음]
				</c:when>
					<c:otherwise>
						<a href="/itemController.do?start=${requestScope.endPage+1 }">[다음]</a>
					</c:otherwise>
				</c:choose>
			</div>
		</c:otherwise>
	</c:choose>	
		<div id="errMsg"><a href="">이전페이지로</a></div>	
</body>
</html>