<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>아이디 찾기</h1>
<p> ID를 잊으셨나요? 가입당시 이름과 이메일 주소로 찾을 수 있습니다. </p>
<form action="CustomerInfo.do?cmd=findId" method="post">
이름<input type="text" name="name" id="name">
가입 메일주소<input type="email" name="email" id="email">
<input type="submit" value="찾기"><br>
</form>
<a href="/starter.do?content=/findPwd.jsp">비밀번호로 찾기</a> 
<a href="/starter.do?content=/Login.jsp">로그인 하기</a> 
</body>
</html>