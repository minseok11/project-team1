<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주문상세조회</h1>
<!-- 클라이언트의 주문내역
      현재 주문한 상품의 상품정보 DB에서 불러오기
      교환반품 신청버튼 누르면 교환반품에 대한 사유와 신청이 DB에 저장  -->

<ul>
				<li><a href="">MY 쇼핑활동</a>
					<ul>
						<li><a href="/MyPage/OrderList.jsp" title="내가 구매한 상품 보기">내가 구매한 상품</a></li>
						<li><a href="/MyPage/Order_return_detail.jsp" title="교환/반품">교환/반품</a></li>
					</ul>
				</li>
			
</ul>
      
								<div>
									<h4>주문상품정보</h4>
								</div>
								<table align="left" width="600" border="1">
								
								<colgroup>
									<col width="98" /><col width="78" /><col width="*" /><col width="90" />
								</colgroup>
								<thead>
								<tr>
									<th scope="col">상품코드</th>
									<th scope="col" colspan="2">상품정보</th>
									<th scope="col">판매가</th>
									<th scope="col">수량</th>
								</tr>
								</thead>
								<tbody>
								
									<tr>
										<td>
											<div>1111</div>
										</td>
										<td><img src="/images/1.png" width="50" height="50" alt="피규어01" /></td>
										<td>
											<div>피규어01</div>
										</td>
										<td>
											<p>10,000</p>원
	                               		</td>
										<td>1
										</td>
									</tr>
								
									
								</tbody>
								</table>
      
      
</body>
</html>