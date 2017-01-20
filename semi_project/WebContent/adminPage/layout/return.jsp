<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#deleted{width: 800px;}

</style>
<script type="text/javascript">
	function update() {
		var condi=document.getElementById("condi").value;
		var del=document.getElementsByName("del");
		if(condi=="accept"){
			del.disabled=false;
			alert(condi);
		}
	}
</script>
</head>
<body>
<jsp:include page="/adminPage/admin.jsp"></jsp:include>
<div>
	<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
</div>
<div id="wrap">
<br>
<br>
<span style="font-size:20px;font-weight: bold;">검색</span>
<form action="/returnitem.do?cmd=search" method="post">
			<table border="1" width="800px">
				<tr>
					<td><select name="option">
							<option value="returnno">반품코드</option>
							<option value="code">상품코드</option>
					</select></td>
					<td><input type="text" name="search"> <input
						type="submit" value="검색"></td>
				</tr>
			</table>
		</form>
<br>
<div align="right" id="deleted">
<form action="/returnitem.do?cmd=delete" method="post">
	<a href="">반품이 완료된 상품 제거하기</a>
</form>
</div>

<span style="font-size:20px;font-weight: bold;">반품목록</span>
<table border="1" width="800px">
	<tr>
		<th>반품코드</th><th>아이디</th><th>상품코드</th><th>반품사유</th><th>결제번호</th>
	</tr>
	<c:forEach var="list" items="${list }">
	<tr>
		<td align="center"><input style="width:20px" type="text" name="returnNo" value="${list.returnNo }" readonly="readonly"></td>
		<td>${list.code }</td>
		<td>${list.id }</td>
		<td>${list.reason }</td>
		<td>${list.paymentNum }</td>
		
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>