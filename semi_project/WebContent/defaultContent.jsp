<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumpenscript.css);
	#content1{width:1000px;height:1000px;background-color:white;margin-left:50px;}
	.items{width:300px;height:350px;border:1px solid black;border-radious:2px;margin-rigth:50px;float:left;margin-left:20px;margin-top:50px;}
	img{width:240px;height:280px;border-radious:2px;margin-top:15px;}
	.a{font-size:30px;font-family:'Nanum Pen Script';text-decoration:none}
	
</style>
<script type="text/javascript">
	var xhr=null;
	function lChange(n){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=doChange;
		xhr.open("get", "/mainController.do?cmd=itemChange&sendNum='n'", true);
		xhr.send();
	}
	function doChange(){
		if(xhr.readyState==4&&xhr.status==200){
			var xml=xhr.responseXML;
			var div=document.getElementById("content1");
			var item=xml.getElementsByTagName(item).length;
			var img=document.createElement("img");
			var divC=document.createElement("div");
			for(var i=0;i<item;i++){
				var code=xml.getElementsByTagName("code")[i].firstChild.nodeValue;
				var itemImgRoot=xml.getElementsByTagName("itemImgRoot")[i].firstChild.nodeValue;
				var name=xml.getElementsByTagName("name")[i].firstChild.nodeValue;
				img.src=itemImgRoot;
				divC.innerHTML="<a href=\"mainController.do?cmd=itemPage&$itemCode=\"+'code'>"+img+"</a><br><br>"
						+"<a href=\"/mainController.do?cmd=itemPage&$itemCode=\"+'code'>"+name+"</a>";
			}
		}
	}
	onload=lChange(1);
</script>
</head>
<body>
<div id="content1">
	<a href="javascript:lChange(1)">☆</a>
	<a href="javascript:lChange(7)">☆</a>
	<a href="javascript:lChange(13)">☆</a>
	<%--
	<c:forEach var="list1" items="${requestScope.list1 }">
		<div class="items" align="center">
			<a href="/mainController.do?cmd=itemPage&$itemCode=${list1.code}"><img src="${list1.itemImgRoot }"></a><br><br>
			<a class="a" href="/mainController.do?cmd=itemPage&$itemCode=${list1.code}">${list1.name}</a>
		</div>
		<c:if test="${fn:length(requestScope.list1)%3}==0">
			<br><br>
		</c:if>
	</c:forEach>
	 --%>
</div>
</body>
</html>