<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.name }님의 아이디는 
${requestScope.id }입니다.
<a href="/starter.do?content=/hwang/Login.jsp">로그인하기</a>
<a href="/starter.do?content=/hwang/FindPwd.jsp">비밀번호찾기</a>
</body>
</html>