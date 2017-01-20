<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
	*{margin:0px; padding:0px;}
	#background{width:1400px; height:800px;}
	#picture{margin-left:10px; margin-top:10px; widht:600px; height:400px; float:left;}
	#wrap1{background-color: green; margin-top:10px; width:597px; height:400px;float:left;}
	#list1{width:600px; height:100px; position:relative;}
		#list1 ul{list-style: none;}
		#list1 ul li{float: left;}
		#list1 ul li img{width:194px; height:130px; border-right: 5px solid green;}
	#list2{width:600px; height:100px; position:relative;}
		#list2 ul{list-style: none;}
		#list2 ul li{float: left;}
		#list2 ul li img{width:194px; height:130px; border-right: 5px solid green;}
	#list3{width:600px; height:100px; position:relative;}
		#list3 ul{list-style: none;}
		#list3 ul li{float: left;}
		#list3 ul li img{width:194px; height:131px; border-right: 5px solid green;}			
</style>
<script type="text/javascript">
	
		function change(event){
			var targetImg=event.target;
			//targetImg.style.opacity="1";//선명하게하기
			//targetImg.style.border="2px solid red";
			var img1=document.getElementById("img1");
			img1.src=targetImg.src;	
			
		}
		function reset(event){
			var targetImg=event.target;
			//targetImg.style.opacity="0.3";
			//targetImg.style.border="2px solid green";
		}
</script>
</head>
<body>
<h1>MD추천상품</h1>
<div id="background">
<div id="picture">
	<img id="img1" style="width:600px; height:400px;" src="images/1.jpg">
</div>

<div id="wrap1">
	<div id="list1">
		<ul>
			<li><a href=""><img src="images/1.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
			<li><a href=""><img src="images/2.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
			<li><a href=""><img src="images/3.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
		</ul>
	</div>
	<div id="list2">
		<ul>
			<li><a href=""><img src="images/4.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
			<li><a href=""><img src="images/5.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
			<li><a href=""><img src="images/6.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
		</ul>
	</div>
	<div id="list3">
		<ul>
			<li><a href=""><img src="images/7.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
			<li><a href=""><img src="images/8.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
			<li><a href=""><img src="images/4.jpg" onmouseover="change(event)" onmouseout="reset(event)"></a></li>
		</ul>
	</div>
</div>

</div>
</body>
</html>