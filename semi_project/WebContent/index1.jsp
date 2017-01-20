<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adult Toy에 오신것을 환영합니다♥</title>
<style type="text/css">
	#wrap2{width:100%;height:100%;}
	#header{width:1100px;height:100px;background-color:pink;margin-left:100px;}
	#category{width:1100px;height:100px;background-color:gold;margin-left:100px;}
	#content{width:1100px;height:1500px;background-color:yellow;margin-left:100px;}
	#footer{width:1100px;height:150px;background-color:gray;margin-left:100px;}
</style>
</head>
<%--include를 활용한 기본 메인화면 --%>
<body>
<div id="wrap2" align="center">
	<div id="header">
	<jsp:include page="${requestScope.head }"/>
	</div>
	<div id="category">
	<jsp:include page="/defaultCategory.jsp"/>
	</div>
	<div id="content">
	 <jsp:include page="${requestScope.content }"/>
	</div>
	<div id="footer">
	<jsp:include page="/footer.jsp"/>
	</div>
</div>
</body>
</html>