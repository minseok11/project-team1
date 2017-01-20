<%@page import="Y.shopping.dto.CustomerInfoDTO"%>
<%@page import="Y.shopping.dto.ItemDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style>
	h1{color:#FF4500;}
	th{border: 1px solid olive;}
	td{align:"center";}
</style>
<%
	int sale=0;
	int totalprice=0;
	int total=0;
	int price=0;
	int retail=0;
	int sell=0;
	int size=0;
	
	
	
	String [] bnum=null;
	String [] count=(String [])request.getAttribute("itemCount");
	String [] buynum=(String [])request.getAttribute("buynum");
	int [] cnt=new int[count.length];
	if(count!=null){
		for(int i=0;i<count.length;i++){
			cnt [i] = Integer.parseInt(count[i]);
			bnum=new String[count.length];
			bnum[i]="0";
		}
	}
	if(buynum==null){
		buynum=bnum;
	}
	ArrayList<ItemDTO> itemlist=(ArrayList<ItemDTO>)request.getAttribute("ilist");
	size=itemlist.size();
	ItemDTO idto=new ItemDTO();
	String [] i_img=new String[size];
	String [] i_code=new String[size];
	String [] i_name=new String[size];
	int [] i_price=new int[size];
	int [] i_retail=new int[size];
	for(int i=0;i<itemlist.size();i++){
		idto=itemlist.get(i);
		i_code[i]=idto.getCode();
		i_name[i]=idto.getName();
		i_price[i]=idto.getPrice();
		i_retail[i]=idto.getRetailPrice();
		
		sell=idto.getPrice();
		price=idto.getPrice()*cnt[i];
		System.out.println("B:"+cnt[i]);
		retail=idto.getRetailPrice()*cnt[i];
		total=total+price;
		totalprice=totalprice+(i_price[i]*cnt[i]);
	}
%>
<script type="text/javascript">
	function selectCoupon(){
		window.open("/coupon.do?cmd=cnt&","_blank","width=400,height=300");
	}

</script>
</head>
<body onload="addrCheck()">
<div>
<h1>주문상세내역</h1>
<form action="/payment.do?cmd=insert" method="post">
<table border="0" width="600px">
<tr>
	<td>상품이미지</td><td>상품명</td><td>수량</td><td>판매가격</td><td>배송비</td><td>합계</td>
</tr>
<%--
<c:forEach var="item" items="${ilist }">
		<td><img src="../Yoseop/images/${item.itemImgRoot }" width="80px" height="80px"></td>
		<input type="hidden" value="${item.code }" name="code">
		<input type="hidden" value="${item.price }" name="price">
		<input type="hidden" value="${item.price }" name="pp">
		<input type="hidden" value="${item.retailPrice }" name="retail">
		 --%>
		 <% for(int i=0;i<size;i++){ %>
		<td><img src="../images/itemImg<%=i_img[i] %>" width="80px" height="80px"></td>
		<input type="hidden" value="<%=buynum[i] %>" name="buynum">
		<input type="hidden" value="<%=i_code[i] %>" name="code">
		<input type="hidden" value="<%=i_price[i] %>" name="price">
		<input type="hidden" value="<%=i_price[i] %>" name="pp">
		<input type="hidden" value="<%=i_retail[i] %>" name="retail">
		<input type="hidden" value="<%=cnt[i] %>" name="cnt">
		<td><%=i_name[i] %></td>
		<td><%=cnt[i] %></td>
		<td><%=i_price[i] %>원</td>
		<td>0원</td>
		<td><%=i_price[i]*cnt[i] %>원</td>
	</tr>
	<% } %>
	<tr>
		<td></td><td></td><td></td><td></td><td>합계금액:</td><td><%=totalprice %>원</td>
	</tr>
<%-- </c:forEach> --%>
</table>
</div>
<div>
<h1>주문서작성</h1>
<table border="0" width="500px">
	<c:forEach var="c_info" items="${clist }">
		<tr>
			<th rowspan="5" style="background-color: #D2B48C;">주문자정보</th><td>주문하시는분</td>
			<td><input type="text" name="name" value="${c_info.name }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>전화번호</td><td><input type="text" name="phoneNo" value="${c_info.phoneNo }" readonly="readonly"></td>
		</tr>
		<tr>
			<td rowspan="2">받으실 주소</td>
		<td><input type="text" name="postNo" value="${c_info.postNo }" readonly="readonly"></td>
		</tr>
		<tr>
		<td><input type="text" name="adress" value="${c_info.adress }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>이메일</td><td><input type="text" name="email" value="${c_info.email }" readonly="readonly"></td>
		</tr>
	</c:forEach>
</table>
<table border="0" width="1000px">
	<tr>
		<th rowspan="10" style="background-color: #D2B48C;">배송정보</th><td>배송지선택</td>
		<td>
			<input type="radio" name="adr_info" checked="checked" value="1" onclick="addrCheck()">기본 배송지
			<input type="radio" name="adr_info" value="3" onclick="addrCheck()">신규 배송지
		</td>
	</tr>
	<tr>
		<td>받으시는분</td><td><input type="text" name="d_name" disabled="disabled"></td>
	</tr>
	<tr>
		<td rowspan="2">받으실 주소</td>
		<td><input type="text" name="d_postNo" disabled="disabled"><input type="button" value="우편번호 찾기" onclick="openPopup()" disabled="disabled" id="searchAddr"></td>
		</tr>
		<tr>
		<td><input type="text" name="d_deliveryLoc">
		  나머지주소<input type="text" name="d_deliveryLoc2"></td>
	</tr>
	<tr>
		<td>전화번호</td><td><input type="text" name="d_phoneNo"></td>
	</tr>
	<tr>
		<td>요구사항</td><td><textarea cols="50" rows="5"></textarea></td>
	</tr>
</table>
<table border="0" width="800px">
	<tr>
		<th rowspan="4" style="background-color: #D2B48C;">결제금액</th><td>상품합계금액</td><td><%=totalprice %>원</td>
	</tr>
	<tr>
		<td>배송비</td><td>0원</td>
	</tr>
	<tr>
		<td rowspan="1">쿠폰적용</td><input type="hidden" name="discount" value="0">
		<td rowspan="1">할인:<input type="text" readonly="readonly" id="sale" value="0">원 <input type="button" value="쿠폰조회" onclick="selectCoupon()"></td>
	</tr>
	<tr><input type="hidden" id="totPrice" value="<%=totalprice %>" >
		<td>총 결제금액</td><td><input type="text" name="totalPrice" readonly="readonly" value="<%=totalprice %>" >원</td>
	</tr>
	<tr>
		<td colspan="3" rowspan="2" align="center"><br><input type="submit" value="결제하기">&nbsp;&nbsp;&nbsp;<input type="button" value="취소하기" onclick="canclePay()"></td>
	</tr>
</table>
</form>
<%
	ArrayList<CustomerInfoDTO> list=(ArrayList<CustomerInfoDTO>)request.getAttribute("clist");
	CustomerInfoDTO dto=new CustomerInfoDTO();
	String name="";
	String post="";
	String addr="";
	String phone="";
	System.out.println(list.size());
	for(int i=0;i<list.size();i++){
		dto=list.get(i);
		name=dto.getName();
		post=dto.getPostNo();
		addr=dto.getAdress();
		phone=dto.getPhoneNo();	
	}	
%>
<script type="text/javascript">
	function canclePay(){
		alert("결제가 취소되었습니다.");
	}

	function addrCheck(){
		var d_name=document.getElementsByName("d_name");
		var d_postNo=document.getElementsByName("d_postNo");
		var d_deliveryLoc=document.getElementsByName("d_deliveryLoc");
		var d_deliveryLoc2=document.getElementsByName("d_deliveryLoc2");
		var d_phoneNo=document.getElementsByName("d_phoneNo");
		var searchAddr=document.getElementById("searchAddr");
		
		var addr=document.getElementsByName('adr_info');
		if(addr[0].checked == true){
			d_name[0].disabled=true;
			d_postNo[0].disabled=true;
			d_deliveryLoc[0].disabled=true;
			d_deliveryLoc2[0].disabled=true;
			d_phoneNo[0].disabled=true;
			searchAddr.disabled=true;
			d_name[0].value="<%=name%>";
			d_postNo[0].value="<%=post%>";
			d_deliveryLoc[0].value="<%=addr%>";
			d_phoneNo[0].value="<%=phone%>";
		}else if(addr[1].checked == true){
			d_name[0].disabled=false;
			d_name[0].value="";
			d_postNo[0].disabled=false;
			d_postNo[0].value="";
			d_deliveryLoc[0].disabled=false;
			d_deliveryLoc[0].value="";
			d_deliveryLoc2[0].disabled=false;
			d_deliveryLoc2[0].value="";
			d_phoneNo[0].disabled=false;
			d_phoneNo[0].value="";
			searchAddr.disabled=false;
		}
	}
	function openPopup(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            document.getElementsByName("d_postNo")[0].value=data.zonecode;
	            document.getElementsByName("d_deliveryLoc")[0].value=data.address;
	            document.getElementsByName("d_deliveryLoc2")[0].focus();
	        }
	    }).open();
	}

</script>
</div>
</body>
</html>