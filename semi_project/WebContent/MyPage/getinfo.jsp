<%@page import="shopping.dto.CustomerInfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getinfo.jsp</title>
<style type="text/css">
#errMsg{color: red;font-size: 12px;}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" >
	function sBtn(){
		var memPw=document.getElementById("memPw").value;
		var memEmail=document.getElementById("memEmail").value;
		var memPh=document.getElementById("memPh").value;
		var memAd=document.getElementById("sample4_roadAddress").value;
		var detailadr=document.getElementById("detailadr").value;
		var memPo=document.getElementById("sample4_postcode").value;
		if(memPw==""||memEmail==""||memPh==""||memAd==""||memPo==""||detailadr==""){
			alert("수정할 정보를 입력해주세요");
			return false;
		}
		return true;
	}
	   //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                //document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
	   }

</script>
</head>
<body>
<%
	CustomerInfoDTO dto=(CustomerInfoDTO)request.getAttribute("dto");
	String addr=dto.getAdress();
	String [] adr=addr.split("_");
	String adr1=adr[0];
	String adr2="";
	if(adr.length>1)adr2=adr[1];
%>
<h1>회원정보수정</h1>
					<div>
						<h3>개인정보 수정</h3>
						<ul>
							<li>고객님의 주소와 연락처 등 개인정보를 수정하실 수 있습니다.</li>
							<li>휴대전화번호와 이메일은 한번 더 확인하시어, 주문하신 상품에 대한 배송 안내와 다양한 이벤트정보를 제공해 드리는 SMS, 메일서비스 혜택을 받으시기 바랍니다.</li>
						</ul>
					</div>		
						<h4>나의 정보관리</h4>
						
						<fieldset>
						<form action="/MyPage.do?cmd=update" method="post"  name="info"  style="margin:0px;" onsubmit="return sBtn();">
							
							<table>
							
							<colgroup>
								<col width="140" /> <col width="" /> <col width="130" />
							</colgroup>
							
							<tr>
								<th scope="row">
									
									<label for="memId">아이디</label>
								</th>
								
								<td colspan="2"><input type="text" name="userid"  value="${sessionScope.id}" id="memId"maxlength="30" readonly="readonly" style="width:178px;" /></td>
							   
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memPw">비밀번호</label>
								</th>
								<td colspan="2">
								<input type="password" name="userPw" id="memPw" maxlength="30" style="width:178px;" />
								<div id="errMsg">${requestScope.errMsg }</div>
								</td>
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memEmail">이메일</label>
								</th>
								<td colspan="2"><input type="text" name="userEmail" value="${requestScope.dto.getEmail()}" id="memEmail" maxlength="30" style="width:178px;" /></td>
							</tr>
						    <tr>
								<th scope="row">
									
									<label for="memPh">전화번호</label>
								</th>
								<td colspan="2"><input type="text" name="userPh" value="${requestScope.dto.getPhoneNo()}" id="memPh" maxlength="30" style="width:178px;" /></td>
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memAd">주소</label>
								</th>
								<td colspan="2"><input type="text" name="userAd" value="<%=adr1%>" id="sample4_roadAddress" maxlength="30" style="width:178px;" />
								<br><input type="text" name="detailadr" id="detailadr" value="<%=adr2%>"></td>
							</tr>
							<tr>
								<th scope="row">
									
									<label for="memPo">우편번호</label>
								</th>
								<td colspan="2"><input type="text" name="userPo" value="${requestScope.dto.getPostNo()}" id="sample4_postcode" maxlength="30" style="width:178px;" />
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"></td>
							</tr>
							</table>
							
							<div>
								<input type="submit" value="나의정보 수정" />
							</div>
							
						</form>
					</fieldset>
</body>
</html>