<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span style="font-size: 30px;font-weight: bold;">문의내역</span><br><br>
	<span class="sp">글제목</span><input type="text" value="${dto2.title }" name="title" readonly="readonly"><br>
	<span class="sp">작성자</span><input type="text" value="${dto2.id }" name="writer" readonly="readonly"><br>
	<span class="sp">문의분류</span><input type="text" value="${dto2.qaList }" name="qalist" readonly="readonly"><br>
	<span class="sp">문의내역</span><br>
	<textarea rows="10" cols="60" name="content" style="font-size: 20px;font-weight: bold;" readonly="readonly">${dto.content }</textarea><br>
	<br>
	<span style="font-size: 30px;font-weight: bold;">답변내역</span><br><br>
	<span class="sp">글제목</span><input type="text" value="${dto3.title }" name="title" readonly="readonly"><br>
	<span class="sp">작성자</span><input type="text" value="${dto3.id }" name="writer" readonly="readonly"><br>
	<span class="sp">문의분류</span><input type="text" value="${dto3.qaList }" name="qalist" readonly="readonly"><br>
	<span class="sp">답변내역</span><br>
	<textarea rows="10" cols="60" name="content" style="font-size: 20px;font-weight: bold;" readonly="readonly">${dto.content }</textarea><br>
	<br>
	
</body>
</html>