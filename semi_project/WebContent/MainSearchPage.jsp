<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	#errMsg{position: absolute; top: 600px; left: 500px;}
</style>
<script type="text/javascript">
	function ErrMsg() {
		var content1=document.getElementById("category1");
		var content1C=category1.getElementsByTagName("div");
		var errMsg=document.getElementById("errMsg");
		if(content1[0]==null){
			errMsg.innerHTML="<p>죄송합니다 고객님</p><p>검색하신 상품이 없습니다.</p>";
		}
	}
	onload=ErrMsg;
</script>
</head>
<body>
<div id="content1">
	<c:forEach var="list2" items="${requestScope.list3 }">
		<div class="titleBox">
		<a href="/itemDetail.do?code=${list2.code }"><img src="${list2.itemImgRoot }"></a><br><br>
		<a href="/itemDetail.do?code=${list2.code }">${list2.name }</a>
		</div>
	</c:forEach>
</div>
<!-- 페이징처리 -->
	<c:choose>
		<c:when test="${startPage>10 }">
			<a href="/search.do?pageNum=${startPage-1 }">이전</a>		
		</c:when>
	</c:choose>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<a href="/search.do?search=${search }&pageNum=${i }"><span style="color:red">[${i }]</span></a>
				</c:when>
				<c:otherwise>
						<a href="/search.do?search=${search }&pageNum=${i }"><span style="color:#555">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<a href="/search.do?pageNum=${endPage+1 }">다음</a>		
		</c:when>
	</c:choose>
<div id="errMsg"></div>
</body>
</html>