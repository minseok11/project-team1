<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.sp{display: inline-block;width: 100px;height: 20px;font-weight: bold;margin: 5px;}
	input{width:300px;height: 20px;}
	#answer{display: none;}
</style>
<script type="text/javascript">
	function addAnswer(){
		var answer=document.getElementById("answer");
		answer.style.display="block";
	}
</script>
</head>
<body>
<jsp:include page="/adminPage/admin.jsp"></jsp:include>
	<div>
		<jsp:include page="/adminPage/admin1.jsp"></jsp:include>
	</div>
	<span style="font-size: 30px;font-weight: bold;">문의내역</span><br><br>
	<span class="sp">글제목</span><input type="text" value="${dto.title }" name="title"><br>
	<span class="sp">작성자</span><input type="text" value="${dto.id }" name="writer"><br>
	<span class="sp">문의분류</span><input type="text" value="${dto.qaList }" name="qalist"><br>
	<span class="sp">문의내역</span><br>
	<textarea rows="10" cols="60" name="content" style="font-size: 20px;font-weight: bold;">${dto.content }</textarea><br>
	<br>
	<button onclick="addAnswer()">답변하기</button>
	
	<div id="answer">
	<form action="/Yoseop/qna.do?cmd=answer" method="post">
		<input type="hidden" value="${dto.refNum }" name="ref">
		<span class="sp">글제목</span><input type="text" name="a_title"><br>
		<span class="sp">작성자</span><input type="text" name="a_writer"><br>
		<span class="sp">문의분류</span><input type="text" value="${dto.qaList }" name="a_qalist"><br>
		<span class="sp">문의내역</span><br>
		<textarea rows="10" cols="60" name="a_content" style="font-size: 20px;font-weight: bold;"></textarea><br>
		<br>
		<input type="submit" value="등록" style="width:100px;height: 50px;">
	</form>		
	</div>
</body>
</html>