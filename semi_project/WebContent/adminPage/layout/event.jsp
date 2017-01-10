<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/adminPage/admin.jsp"></jsp:include>
<div>
	<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
</div>

<select>
	<option>공지사항</option>
	<option>이벤트</option>
</select>
<br>
제목<br>
<input type="text" name="title"><br>
내용<br>
<textarea rows="30" cols="100" name="content"></textarea><br>
<br>
자료첨부<input type="file" name="file1"><br>
<br>
<input type="button" value="등록"> <input type="reset" value="취소">
</body>
</html>