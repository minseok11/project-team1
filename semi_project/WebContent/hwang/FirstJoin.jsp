<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	#box1{display: inline-block;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

function idcheck(){
	var val=document.getElementById("idval");
	val.value=0;
	
}

function emailcheck(){
	var eval=document.getElementById("emailval");
	eval.value=0;
	
}

    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                //document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
    	
 	var b=0;
    function checkId(){
    	window.open("/hwang/idCheck.html","_blank","width=300 height=300");
    	var val=document.getElementById("idval"); 	
    	val.value=1;
    }
    
 	function checkEmail(){
 		//-blank 팝업창 띄우기
 		window.open("/hwang/EmailCheck.html","_blank","width=300 height=300");
 		var val=document.getElementById("emailval"); 	
    	val.value=1;
 	}	
	
    	function CheckAll() {
    		var id=document.frm1.id.value;
    		var pwd=document.frm1.pwd.value;
			var pwd1=document.frm1.pwd1.value;
			var ans=document.frm1.ans.value;
			var name=document.frm1.name.value;
			var email=document.frm1.email.value;
			var postno=document.frm1.postno.value;
			var adress1=document.frm1.adress1.value;
			var detailadr=document.frm1.detailadr.value;
			var phoneno2=document.frm1.phoneno2.value;
			var phoneno3=document.frm1.phoneno3.value;
			var phoneno=phoneno2+phoneno3;
			
			var btn=document.frm1.btn;
			var idbtn=document.frm1.idbtn;
			
			var val=document.getElementById("idval");
			var eval=document.getElementById("emailval");
			
			
			if(id==""){
				alert("아이디를 입력해주세요.");
				return false;
			}
			
			//아이디가 5자 이상인지 확인
			if(id.length<5){
				alert("아이디는 5자 이상 입력하세요");
				return false;
			}
			
			//아이디가 영소문자와 숫자로만 이뤄져있는지 확인 		
			for(var i=0; i<id.length; i++){
				var ch=id.charAt(i);
				if(!(ch>='a'&& ch<='z'|| ch>='0' && ch<='9')){
					alert("아이디를 영소문자&숫자 이외는 불가합니다.");
					return false;
				}
			}
			//아이디가 영소문자와 숫자의 조합인지 확인하는 방법(영소문자로만 이뤄지면 x, 숫자로만 이뤄지면 x)
			var check1=0;
			var check2=0;
			for(var i=0; i<id.length; i++){
				var ch1=id.charAt(i);
				if(ch1>='a' && ch1<='z'){
					check1++;
				}else if(ch1>='0' && ch1<='9'){
					check2++;
				}
			}
			if(!(check1>=1 && check2>=1)){
				alert("아이디를 영소문자&숫자를 조합해주세요.");
				return false;
			}
				
			if(val.value==0){
				alert("아이디 중복체크를 하세요!");
				return false;	
			}
				
			//비빌번호 입력했는지 확인
			if(pwd==""){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			//비밀번호는 8자리 이상으로 구성해야함 
			if(pwd.length<8){
				alert("비밀번호는 8자리 이상 입력해주세요.");
				return false;
			}
		
			//비밀번호가 문자(소문자/대문자), 숫자, 특수문자를 모두 포함하고 있는지 확인
			var chk1=0;
			var chk2=0;
			var chk3=0;
			var chk4=0;
			for(var i=0; i<pwd.length; i++){
				var p=pwd.charAt(i);
				if((p>='a'&& p<='z')){
					chk1++;
				}else if(p>='0' && p<='9'){
					chk2++;
				}else if(p>='A' && p<='Z'){
					chk3++;
				}else if(p=='!'|| p=='@'|| p=='#'|| p=='$'|| p=='%'|| p=='^'|| p=='&'|| p=='*'|| p=='('|| p==')'|| p=='?'|| p=='_'|| p=='~'){
					chk4++;
				}	
			}
			if(!(chk1>=1 && chk2>=1 && chk4>=1 || chk2>=1 && chk3>=1 && chk4>=1|| chk1>=1 && chk2>=1 && chk3>=1 && chk4>=1)){
				alert("비밀번호에 문자(소문자/대문자), 숫자, 특수문자를 모두 포함해주세요.");
				return false;
			}
			
			//비밀번호에 아이디가 포함되면 안된다.
			if(!(pwd.indexOf(id)==-1)){
				alert("비밀번호에 아이디가 포함될 수 없습니다.");
				return false;
			}
			
			//비밀번호에 연속된 숫자가 포함되어 있으면 안된다.
			var temp="";
			var temp2=pwd.substring(0,1);
			var con=1;
			
			for(var i=1; i<pwd.length; i++){
				temp=pwd.substring(i,i+1);
					if(temp>='0' && temp<='9'&& temp==temp2){
						con++
					}else{
						con=1;
						temp2=temp;
					}
						
					if(con==3){
						alert("숫자를 연속해서 사용할 수 없습니다: "+ temp2);
						return false;
					}
				}
			

			//첫번째 입력한 비밀번호와 두번째 입력한 비밀번호가 맞지 않을때
			if(pwd!=pwd1){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			if(ans==null||ans==""){
				alert("비밀번호 질문에 대한 답변을 입력해주세요.");
				return false;	
			}
			
			if(name==""){
				alert("이름을 입력해주세요.");
				return false;
			}
			
			//이름이 문자가 아닐 때
			for(var i=0; i<name.length; i++){
				var n=name.charAt(i);
				if(n>='0' && n<='9'){
					alert("이름은 문자로만 입력해주세요.");
					return false;
				}
			}
			
			if(email==""){
				alert("이메일을 입력해주세요.");
				return false;
			}
			
			if(eval.value==0){
				alert("이메일 중복체크를 하세요!");
				return false;	
			}
			
			if(postno==""){
				alert("우편번호를 입력해주세요.");
				return false;
			}
			
			if(detailadr==""){
				alert("상세주소를 입력해주세요.");
				return false;
			}
			
			for(var i=0; i<phoneno.length; i++){
				var phone=phoneno.charAt(i);
				if(!(phone>='0' || phone<='9')){
					alert("핸드폰 번호는 숫자로만 입력해주세요.");
					return false;
				}
			}
			
			if(phoneno2==""){
				alert("핸드폰 번호를 입력해주세요.");
				return false;			
			}
			if(phoneno2.length>4){
				alert("올바른 핸드폰번호를 입력해주세요.");
				return false;	
			}
			
			if(phoneno3==""){
				alert("핸드폰 번호를 입력해주세요.");
				return false;
			}
			if(phoneno3.length>4){
				alert("올바른 핸드폰번호를 입력해주세요.");
				return false;				
			}
			
			return true;
		}
</script>
</head>
<body>
<h2>회원가입</h2>
<h4>로그인을 하시면 보다 많은 혜택을 누릴 수 있습니다.</h4>

<h5>개인회원정보<span style="color:red">* 필수입력사항</span></h5>

<form action="/CustomerInfo.do?cmd=insert" method="post" name="frm1" onsubmit="return CheckAll();">
<input type="hidden" id="idval" value="0">		
<input type="hidden" id="emailval" value="0">														
아이디*<input type="text" name="id" id="id" onkeypress="idcheck()">
<input type="button" value="아이디중복확인" id="idbtn" onclick="checkId()">
<span style="color:gray; font-family:돋움" >영소문자&숫자 조합</span><br><br>
비밀번호*<input type="password" id="pwd" name="password">[8글자이상]<br>
비밀번호확인*<input type="password" id="pwd1" name="password1"><br>
비밀번호 질문*
<select name=qeslist id="qeslist">
	<option value="당신의 보물 1호는?">당신의 보물 1호는?</option>
	<option value="당신의 어머니의 이름은?">당신의 어머니의 이름은?</option>
	<option value="당신의 아버지의 이름은?">당신의 아버지의 이름은?</option>
	<option value="가장 기억에 남는 선생님의 성함은?">가장 기억에 남는 선생님의 성함은?</option>
	<option value="가장 기억에 남는 장소는?">가장 기억에 남는 장소는?</option>
	<option value="처음 키운 애완동물의 이름은?">처음 키운 애완동물의 이름은?</option>
	<option value="제일 좋아하는 운동선수 이름은?">제일 좋아하는 운동선수 이름은?</option>
</select><br>
답변*<input type="text" name="ans" id="ans"><br>
이름*<input type="text" name="name" id="name" ><br>
성별*<input type="radio" name="gender" value="남" id="gender" checked="checked">남<input type="radio" name="gender" value="여" id="gender">여<br>
이메일*<input type="email" name="email" id="email"><input type="button" value="메일중복확인" onclick="checkEmail()"><input type="checkbox" value="1" checked="checked">광고성정보,이벤트성메일수신
	  <br><span style="color: orange">※ 주문 관련 정보, 주요 공지사항 및 이벤트 당첨 안내 등은 수신 동의 여부에 관계없이 자동 발송됩니다.</span><br>
주소*<input type="text" id="sample4_postcode" name="postno" placeholder="우편번호" readonly="readonly">
	<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" id="sample4_roadAddress" name="adress1" placeholder="도로명주소" readonly="readonly">
	<input type="text" name="detailadr" id="detailadr">
	<span id="guide" style="color:#999"></span><br>
핸드폰*<select name="phoneno1" id="phoneno1">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="016">016</option>
		<option value="017">017</option>
		<option value="019">019</option>
	</select>
	 -<input type="text" name="phoneno2" id="phoneno2"> -<input type="text" name="phoneno3" id="phoneno3">
	  <input type="checkbox" vlaue="1" checked="checked">광고성정보,이벤트성메일수신
	  <br><span style="color: orange">※ 주문 관련 정보, 주요 공지사항 및 이벤트 당첨 안내 등은 수신 동의 여부에 관계없이 자동 발송됩니다.</span><br>
<input type="submit" value="회원가입" id="btn">
<input type="reset" value="이전으로">

</form>
</body>
</html>