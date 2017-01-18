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
	function lChange(n){//메인페이지 아이템항목 ajax 페이징처리
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
			while(div.hasChildNodes()){ //div에 자식객체가 있으면 없을때까지
				div.removeChild( div.lastChild );//마지막 자식객체를 삭제함
			}
			for(var i=0;i<item.length;i++){//item객체의 개수만큼 루프
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
				var code=xml.getElementsByTagName("code")[i].firstChild.nodeValue;//테그네임이 code인 대상을 code에 담음
				var itemImgRoot=xml.getElementsByTagName("itemImgRoot")[i].firstChild.nodeValue;//테그네임이 itemImgRoot인 대상을 itemImgRoot에 담음
				var name=xml.getElementsByTagName("name")[i].firstChild.nodeValue;//테그네임이 name인 대상을 name에 담음
				divC.innerHTML="<a href=/itemDetail.do?code="+code+"><img src="+itemImgRoot+"></a><br><br>"
						+"<a href=/itemDetail.do?code="+code+">"+name+"</a>";//divC에 innerHTML을 통해 대상 담기
				div.appendChild(divC);//div에 divC를 자식객체로 담음
			}
		}
	}
	onload=lChange(1);//창이 다 로드되고 나면 lChange(1)을 실행함
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