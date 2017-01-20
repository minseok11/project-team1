<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호찾기</h1>
<p>가입하실 때 작성하신 정보와 일치할 경우 E-mail로 비밀번호를 보내드립니다.</p>
<span style="color:red">비밀번호찾기</span>
기입하실 때 작성하신 정보와 일치할 경우 E-mail로 비밀번호를 보내드립니다.
<form action="/CustomerInfo.do?cmd=findPwd" method="post">
	아이디<input type="text" name="id" id="id"><br>
	이름<input type="text" name="name" id="name"><br>
	가입 메일주소<input type="text" name="email" id="email">
	<input type="submit" value="찾기"><br>
	<a href="/starter.do?content=/hwang/Login.jsp">로그인하기</a>  <a href="/starter.do?content=/hwang/FindId.jsp">아이디찾기</a>
</form>
</body>
</html>