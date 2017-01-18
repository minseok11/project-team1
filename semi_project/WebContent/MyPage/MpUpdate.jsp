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

<h1>회원정보수정</h1>
<!-- 
		처음에 가입했던 정보를 수정하는 기능
		각 항목을 입력한 후 수정 버튼을 누르면 DB에 저장되어 있는 정보를 변경한다. 
		 성명
		 주소
		 전화번호
		 이메일
		 나의정보수정버튼...
 -->
<%
	String id=request.getParameter("id");
%>

					<div>
						<h3>개인정보 수정</h3>
						<ul>
							<li>고객님의 주소와 연락처 등 개인정보를 수정하실 수 있습니다.</li>
							<li>휴대전화번호와 이메일은 한번 더 확인하시어, 주문하신 상품에 대한 배송 안내와 다양한 이벤트정보를 제공해 드리는 SMS, 메일서비스 혜택을 받으시기 바랍니다.</li>
						</ul>
					</div>		
						<h4>나의 정보관리</h4>
						
						<fieldset>
						<form action="/MyPage.do?cmd=update" method="post" name="info" style="margin:0px;">
							
							<table>
							
							<colgroup>
								<col width="140" /> <col width="" /> <col width="130" />
							</colgroup>
							
							<tr>
								<th scope="row">
									
									<label for="memId">아이디</label>
								</th>
								
								<td colspan="2"><input type="text" name="userid" value="${requestScope.dto.getId()}" id="memId"maxlength="30" readonly="readonly" style="width:178px;" /></td>
							   
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memPw">비밀번호</label>
								</th>
								<td colspan="2"><input type="text" name="userPw" value="${dto.password}" id="memPw" maxlength="30" style="width:178px;" /></td>
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memEmail">이메일</label>
								</th>
								<td colspan="2"><input type="text" name="userEmail" value="${dto.email}" id="memEmail"maxlength="30" style="width:178px;" /></td>
							</tr>
						    <tr>
								<th scope="row">
									
									<label for="memPh">전화번호</label>
								</th>
								<td colspan="2"><input type="text" name="userPh" value="${dto.phoneNo}" id="memPh" maxlength="30" style="width:178px;" /></td>
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memAd">주소</label>
								</th>
								<td colspan="2"><input type="text" name="userAd" value="${dto.adress}" id="memAd" maxlength="30" style="width:178px;" /></td>
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memPo">우편번호</label>
								</th>
								<td colspan="2"><input type="text" name="userPo" value="${dto.postNo}" id="memPo" maxlength="30" style="width:178px;" /></td>
							</tr>
							
							</table>
							
						
							
						</form>
					</fieldset>
</body>
</html>