<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr=null;
	function checkPwd() {
		var pwd=document.getElementById("Pwd").value;
		
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callcheckPwd;
		xhr.open("get","MyPage.do?cmd=checkPwd&pwd="+pwd,true);
		xhr.send();
	}
		function callcheckPwd() {
			if(xhr.readyState==4 && xhr.status==200){
				
				var xml=xhr.responseXML;
				
				
			}			
		}

</script>
</head>
<body>
비밀번호 <input type="password" name="checkPwd" id="Pwd">
<input type="button" value="확인">
</body>
</html>