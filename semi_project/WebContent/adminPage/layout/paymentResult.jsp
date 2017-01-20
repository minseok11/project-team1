<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function payResult(){
		location.href="/starter.do?content=/adminPage/admin.jsp";//마이페이지 결제내역 확인 페이지로
	}
	function mainPage(){
		location.href="/starter.do";//메인화면으로
	}

</script>
<style type="text/css">
	#wrap{border: 2px solid gray;width:700px;height: 200px;}
</style>
</head>
<body>
<div id="wrap">
	<table border="0" width="600px" height="200px" align="center">
		<tr>
			<th colspan="1">결제가 완료되었습니다.</th>
		</tr>
		<tr>
			<td colspan="1" align="center">
				<input type="button" value="결제내역 확인하기" onclick="payResult()">&nbsp;&nbsp;&nbsp;
				<input type="button" value="메인으로" onclick="mainPage()">
			</td>
		</tr>
	</table>
</div>
</body>
</html>