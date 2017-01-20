<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{width: 400px;height: 1000px;float: left;}
	#menu2{width: 250px;height: 900px;float: left;margin: 50px;background: #323232}
	.menu{background-color: white;border: 5px solid #323232;}
	#wrap ul li{list-style: none;}
	#wrap ul li a{text-decoration: none;font-size:20px;color:black;}
</style>
</head>
<body>
<div id="wrap">
	<div id="menu2" align="center">
	<span style="color:white;font-size:30px;font-weight: bold;">카테고리</span>
		<div class="menu" align="left">
			<ul>
				<li><a href="/scategory.do?cmd=list">카테고리설정</a></li>
				<%-- <li><a href="/Yoseop/layout/event.jsp">이벤트 등록</a></li> --%>
				<li><a href="/qna.do?cmd=list">1:1문의</a></li>
			</ul>
		</div>
		<span style="color:white;font-size:30px;font-weight: bold;">시스템 관리</span>
		<div class="menu" align="left">
			<ul>
				<li><a href="/users.do?cmd=list">고객 관리</a></li>
				<li><a href="/supplier.do?cmd=list">공급업체 관리</a></li>
				<li><a href="/Aitems.do?cmd=list">상품 관리</a></li>
				<li><a href="/returnitem.do?cmd=list">반품 관리</a></li>
				<li><a href="/adminPage/layout/coupon.jsp">쿠폰 관리</a></li>
				<li><a href="/starter.do">메인페이지로 이동</a></li>
			</ul>
		</div>
		<span style="color:white;font-size:30px;font-weight: bold;">통계</span>
		<div class="menu" align="left">
			<ul>
				<li><a href="/payment.do?cmd=list">결제내역</a></li>                                                         
				<li><a href="/statistic.do?cmd=list">통계</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>