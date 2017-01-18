<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
클라이언트가 게시판을 통해 작성한 글 목록들이 DB에 불려온다.
글 목록을 클릭하면 게시판에 있는 자신이 쓴 글의 페이지로 넘어간다. 
 -->
 
<h1 align="center"><font color="#006699"><font size=15>내가 작성한 게시글</font></font></h1>

<form action="mpjang.do" method="post">
<table align="center" width="600" border="1"> 
	<tr align="center" bgcolor="#ccffcc">
	   <td>글번호</td>
	   <td>아이디</td>
	   <td>제목</td>
	   <td align="center">
	   <input type="submit" name="delete" value="삭제"/>
	   </td>	
	</tr> 
</table>
</form>

</body>
</html>



