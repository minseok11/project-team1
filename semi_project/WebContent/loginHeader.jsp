<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#headMenu{width:300px;height:100px;float:right;}
	ul{list-style:none;}
	ul li{float:left;margin-left:15px;margin-top:15px;}
	a{text-decoration: none}
	#banner{float:left;}
	#banner1{width:130px;height:90px;}
</style>
</head>
<body>
<div id="banner">
	<a href="/starter.do"><img src="/images/banner.png" id="banner1"></a>
</div>
<div id="headMenu">
<ul>
	<li><a href="/CustomerInfo.do?cmd=logout">로그아웃</a></li>
	<li><a href="/MyPage.do?cmd=main">마이페이지</a></li>
	<li><a href="/support.do">고객센터</a></li>
</ul>
</div>
</body>
</html>