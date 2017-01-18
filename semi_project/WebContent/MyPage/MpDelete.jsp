<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		ul{list-style: none;}
		
		table{
			margin-left: inherit;
			margin-right: inherit;
			border: 3px solid skyblue;
		}
		td{
			border: 1px solid skyblue
		}
		#title{
			background-color: skyblue
		}
</style>
<script type="text/javascript">
	var errMsg=document.getElementById("errMsg");
	alert(errMsg.innerHTML);
	if(errMsg.innerHTML==null){
		errMsg.innerHTML="";
	}
//비밀번호 미입력시 경고창
function checkValue(){
	if(!document.MpDelete.password.value||!document.MpDelete.ans.value){
		alert("항목을 모두 입력해주세요.");
		return false;		
	}
}
</script>
</head>
<body>
<h1>회원탈퇴</h1>

<script type="text/javascript">

</script>
				<div>
					<div>
						<h3>회원탈퇴</h3>
						<div>
							<h4>회원탈퇴 안내</h4>
							<ul>
								<li><span>1.</span> <strong>회원탈퇴 시</strong> 고객님의 정보는 상품 반품 및 A/S를 위해 전자상거래 등에서의 소비자 보호에 관한 법률에 의거한 고객정보 보호정책에 따라 관리됩니다.</li>
								<li><span>2.</span> <strong>회원탈퇴 시</strong> 고객님께서 보유하셨던 쿠폰은 모두 삭제되며, 환급 또한 불가능합니다.</li>
								<li><span>3.</span> 현금 잔액을 환급 받으시려면 회원 탈퇴 전에 고객센터로 문의바랍니다. (TEL 1111-1111)</li>
								<li><span>4.</span> 한 번 탈퇴한 아이디는 다시 사용할 수 없습니다.</li>
							</ul>
						</div>
						
					</div>
				</div>
		
<br><br>

<form name="MpDelete" method="post" action="/MyPage.do?cmd=delete" onsubmit="return checkValue()">
	
	<table>
			
			<tr>
				<td bgcolor="skyblue">비밀번호</td>
				<td><input type="password" name="password" maxlength="50"></td>
			</tr>
			<tr>
				<td bgcolor="skyblue">질문</td>
				<td><input type="text" name="qesList" value="${requestScope.dto.getQesList() }" readonly="readonly"></td>
			</tr>
			<tr>
				<td bgcolor="skyblue">답변</td>
				<td><input type="text" name="ans"></td>
			</tr>
	</table>
	<div id="errMsg">${requestScope.errMsg }</div>
	<br>
	<input type="button" value="취소" onclick="javascript:window.location='MpMain.jsp'">
	<input type="submit" value="회원탈퇴"/>
</form>
</body>
</html>



