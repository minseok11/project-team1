<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{width:1300px;height:1300px}
	#header{width:1100px;height:250px;background-color:pink;margin-left:100px;}
	#content{width:1100px;height:800px;background-color:yellow;margin-left:100px;}
	#footer{width:1100px;height:250px;background-color:gray;margin-left:100px;}
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
	<jsp:include page="${requestScope.head }"/>
	</div>
	<div id="content">
	<jsp:include page="${requestScope.content }"/>
	</div>
	<div id="footer">
	<jsp:include page="/footer.jsp"/>
	</div>
</div>
</body>
</html>