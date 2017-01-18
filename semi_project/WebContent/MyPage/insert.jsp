<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원입력</h1>
<form method="post" action="/MyPage.do?cmd=insert">

	아이디 <input type="text" name="id"><br>
	비밀번호 <input type="text" name="password"><br>
	질문 <input type="text" name="qesList"><br>
	답 <input type="text" name="ans"><br>
	이름 <input type="text" name="name"><br>
	성별 <input type="text" name="gender"><br>
	이메일 <input type="text" name="email"><br>
	전화번호 <input type="text" name="phoneNo"><br>
	주소 <input type="text" name="adress"><br>
	우편번호 <input type="text" name="postNo"><br>
	
	<input type="submit" value="저장">
	<input type="reset" value="취소">	
</form>

</body>
</html>