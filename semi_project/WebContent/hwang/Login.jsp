<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<p>로그인을 하시면 보다 많은 혜택을 누리실 수 있습니다.</p>
<form action="/CustomerInfo.do?cmd=login" method="post">
	<input type="hidden" name="cnt" value=1>
	아이디 <input type="text" name="id" value="${param.id }"><br>
	비밀번호 <input type="password" name="pwd"value="${param.pwd }">
	<div id="errMsg">${requestScope.errMsg }</div>
	<input type="submit" value="로그인"><br>
	<a href="/starter.do?content=/hwang/FirstJoin.jsp">회원가입</a>
	<a href="/starter.do?content=/hwang/FindId.jsp">아이디 찾기</a>
	<a href="/starter.do?content=/hwang/FindPwd.jsp">비밀번호 찾기</a>
</form>
</body>
</html>