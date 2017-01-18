<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 
		마음에 드는 상품을 주문하기 전에 장바구니에 상품정보를 담으면 DB에 구매미완료로 저장된다.
		또한 이미지를 누르면 상품정보 페이지로 넘어간다. 
		상품코드 상품정보 판매가격 수량 (삭제버튼) 
 		(선택상품주문버튼)(전체상품주문하기버튼)
 -->
<%
	//ArrayList<item> itemlist=(ArrayList<item>)request.getAttribute("itemlist");
	int totalprice = (Integer)request.getAttribute("totalprice");
%>

<h1 align="center"><font color="black"><font size=15>장바구니</font></font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="itemlist.jsp">쇼핑계속하기</a></td>
</tr>
</table>

<form action="mpjang.do" method="post">
<table align="center" width="600" border="1"> 
	<tr align="center" bgcolor="pink">
	   <td>번호</td>
	   <td>상품이미지</td>
	   <td>상품명</td>
	   <td>가격</td>
	   <td>수량</td>	 
	   <td align="center">
	   <input type="button" name="delete" value="삭제"/>
	   </td>	
	</tr> 

</table>
</form>

</body>
</html>