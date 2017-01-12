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
	#choice{width:1000px;height:50px;background-color:white;margin-left:50px;padding-top:50px;}
	#content1{width:1000px;height:900px;background-color:white;margin-left:50px;}
	img{width:240px;height:280px;border-radious:2px;margin-top:15px;}
	a{font-size:30px;font-family:'Nanum Pen Script';text-decoration:none;color:black}
	
</style>
<script type="text/javascript">
	var xhr=null;
	function lChange(n){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=doChange;
		xhr.open("get", "/mainController.do?cmd=itemChange&num="+n, true);
		xhr.send();
	}
	function doChange(){
		if(xhr.readyState==4&&xhr.status==200){
			var xml=xhr.responseXML;
			var div=document.getElementById("content1");
			var item=xml.getElementsByTagName("item");
			while(div.hasChildNodes()){ 
				div.removeChild( div.lastChild );
			}
			for(var i=0;i<item.length;i++){
				var img=document.createElement("img");
				var divC=document.createElement("div");
				divC.style.width="300px";
				divC.style.height="350px";
				divC.style.border="1px solid black";
				divC.style.borderRadius="5px";
				divC.style.marginRigth="50px";
				divC.style.float="left";
				divC.style.marginLeft="20px";
				divC.style.marginTop="50px";
				divC.style.textAlign="center";
				var code=xml.getElementsByTagName("code")[i].firstChild.nodeValue;
				var itemImgRoot=xml.getElementsByTagName("itemImgRoot")[i].firstChild.nodeValue;
				var name=xml.getElementsByTagName("name")[i].firstChild.nodeValue;
				divC.innerHTML="<a href=/mainController.do?cmd=itemPage&$itemCode="+code+"><img src="+itemImgRoot+"></a><br><br>"
						+"<a href=/mainController.do?cmd=itemPage&$itemCode="+code+">"+name+"</a>";
				div.appendChild(divC);
			}
		}
	}
	onload=lChange(1);
</script>
</head>
<body>
<div id="choice" align="center">
	<a href="javascript:lChange(1)">●</a>
	<a href="javascript:lChange(7)">●</a>
	<a href="javascript:lChange(13)">●</a>
</div>
<div id="content1"></div>
</body>
</html>