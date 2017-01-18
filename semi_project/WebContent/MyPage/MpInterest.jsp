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
		마음에 드는 상품을 저장한 정보를 DB에서 가져온다.
		또한 관심상품을 선택하면 장바구니에 넣거나 구매할 수 있다. 
 -->
 
 	<div>
					<div>
						<h3>관심상품</h3>
						<ul>
							<li>이곳에 담긴 상품은 바로 장바구니에 담으실 수 있습니다.</li>
							<li>관심품목에 담은 시점과 구매시점에서 상품가격이 변경될 수 있으며 조기품절 될 수 있습니다.</li>
						</ul>						
					</div>

	</div>
	<div>
									<h4>관심상품정보</h4>
								</div>
								<table align="left" width="600" border="1">
								
								<colgroup>
									<col width="98" /><col width="78" /><col width="*" /><col width="60"/>
								</colgroup>
								<thead>
								<tr>
									<th scope="col">상품코드</th>
									<th scope="col" colspan="2">상품정보</th>
									<th scope="col">판매가</th>
									<th scope="col">장바구니</th>
									
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
										<td>
											<div>
											<input type="button" value="장바구니" />
											</div>
										</td>
									</tr>
									
								</tbody>
								</table>
									
      
				
</body>
</html>