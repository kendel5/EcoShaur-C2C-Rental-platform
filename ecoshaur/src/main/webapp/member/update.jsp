<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
   
   margin: 0 auto;
</style>

<!-- 본문 시작 update.jsp-->
<br>
<br>
<br>
<br>

<c:if test="${id != null }">

<div class="container">
<form class="form-horizontal"
	  name="memberForm"
      method="post"
      action="updateProc.do"
      onsubmit="return memberCheck(this)" >
      
        <div class="py-5 text-center">
            <h4>회원정보 수정</h4>
        </div>
        <div class="col-sm-1"></div><div class="col-sm-10">
            <h4 class="mb-3 text-left"><strong>회원정보</strong></h4>
            
                <div class="form-group text-left font1">
                
                <div class="form-group text-left">
                    <div class="input-group">
                    	<span class="input-group-addon font1" style="min-width:120px;">* 프로필이미지</span>
                        <input type="file" class="form-control" name="pro_name" id="pro_name" size="15" required>
                    </div>
                </div>
                
                
                <div class="form-group text-left">
                    <div class="input-group">
                    	<span class="input-group-addon font1" style="min-width:120px;">* 비밀번호</span>
                        <input type="password" class="form-control" name="pw" id="pw" size="15" required>
                        
                    </div>
                </div>
                
                <div class="form-group text-left">
                    <div class="input-group">
                    	<span class="input-group-addon font1" style="min-width:120px;">* 비밀번호 확인</span>
                        <input type="password" class="form-control" name="pw2" id="pw2" size="15" required>
                    </div>
                </div>
                
                <div class="form-group text-left font1">
                    <div class="input-group" id="name_check">
                    	<span class="input-group-addon" style="min-width:120px;">* 이름</span>
                        <input type="text" class="form-control" name="mem_name" id="mem_name" value="${mem_name }" size="15" required>
                    </div>
                </div>
                
                <div class="form-group text-left font1">
                    <div class="input-group" id="birth">
                    	<span class="input-group-addon" style="min-width:120px;">* 생년월일</span>
                        <input type="date" id="birth" name="birth">
 					&nbsp;&nbsp;&nbsp;
 					*만 19세 미만은 가입 제한 	
                    </div> 
                </div> 
                
                <div class="form-group text-left font1">
                    <div class="input-group">
                    	<span class="input-group-addon" style="min-width:120px;">* 이메일</span>
                        <input type="text" class="form-control" name="email" id="email" value="${email }" size="15">
                    </div>
                </div>

				<div class="form-group text-left font1">
                    <div class="input-group">
                    	<span class="input-group-addon" style="min-width:120px;">* 연락처</span>
                        <input type="text" class="form-control" name="contact_number" id="contact_number"  value="${contact_number }"size="15">
                    </div>
                </div>
                
                <div class="form-group text-left font1">
                    <div class="input-group">
                    	<span class="input-group-addon" style="min-width:120px;">* 우편번호</span>
                        <input type="email" class="form-control" name="zip" id="zip" value="${zip }" size='7' >
                        <div class="input-group-btn">
                     		<input type="button" value="우편번호찾기" class="btn btn-default" onclick="DaumPostcode()">
                    	</div>
                    </div>
                    <div class="input-group">
                    	<span class="input-group-addon" style="min-width:120px;">* 주소</span>
                        <input type="text" class="form-control" name="address" id="address" value="${address }" size='45' >
                    	<span class="input-group-addon" style="min-width:100px;">나머지 주소</span>
                        <input type="text" class="form-control" name="address_r" id="address_r" value="${address_r }" size='45' >
                    </div>
                </div>
                
                
                <hr class="mb-4">
       
		</div><div class="col-sm-1"></div>
		<tr>
        <td colspan="2">
			<input type="submit" class="btn btn-outline-success" value="회원가입">
			<input type="reset" class="btn btn-outline-info" value="취소">
		</td>
		</tr>
		</form>
    </div>
	
	
<!-- ----- DAUM 우편번호 API 시작 ----- -->
<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 110px;position:absolute;top:50%;left:50%;margin-left:-150px;margin-left:-250px;z-index:3;">
  <img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">

</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }
    
    function DaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
        	
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zip').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
                
                $('#address_r').focus();
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);
      

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
<!-- ----- DAUM 우편번호 API 종료----- -->

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  <div class="modal" id="idcheck">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">아이디 중복확인</h4>

        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form name="memfrm" id="memfrm" onsubmit="return send()">
        <input type="text" name="uid" id="uid">
      <input type="button" id="checkId" value="중복확인">
      <span id="panel_id"></span> <!-- ID 중복 관련 메세지 -->
      </form>
      
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        <div class="container">
           <button type="button" class="btn btn-success" data-dismiss="modal" id="sm">적용</button>
             <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        </div>
        
      </div>
    </div>
  </div>
  

<!-- 아이디 중복확인 -->
<script>
$(function(){
   $.removeCookie("checkID");
});

//1)중복확인 버튼을 클릭했을때
$("#checkId").click(function(){
   //2)입력한 아이디를 변수에 대입하기
   var params="uid=" + $("#uid").val();
   
   //3)post방식으로 서버에 요청해서 응답받기
   //$.post("요청명령어", 전달값, 콜백함수, 응답받는형식)
   //$.post("idCheckProc3.do", params, checkID, "text");
   $.post("memberForm.do", params, checkID, "json");
   
});//click() end

//4)콜백함수 작성하기
function checkID(result){
   //5)서버에서 응답받은 메세지를
   //  id=panel_id에 출력하기
   
   //①text응답
   //alert(result);
   
   //②json응답
   //alert(result);//[object Object]
   //alert(result.count);   
   var count=eval(result.count);//형변환
   if(count==0){
     $("#panel_id").css("color", "blue");
     $("#panel_id").text("사용 가능한 아이디 입니다");
     //$.cookie("쿠키변수명", 값)
     $.cookie("checkID", "PASS");      
   }else{
     $("#panel_id").css("color", "red");
     $("#panel_id").text("중복된 아이디 입니다");
     $("#uid").focus(); //커서생성
   }//if end
}//checkID() end

//7)아이디 중복확인을 해야만
//  회원가입폼이 서버로 전송
function send(){
  //쿠키변수값 가져오기
  var checkID=$.cookie("checkID");
  if(checkID=="PASS"){
     return true;
  }else{
     $("#panel_id").css("color", "green");
     $("#panel_id").text("아이디 중복확인을 해주세요");
     $("#uid").focus(); //커서생성
     return false;
  }//if end
}//send() end

$("#sm").click(function() {
   var x = $("#uid").val();
    $('#id').val(x);
});
</script>
</c:if>
<!-- 본문 끝 -->		

<%@ include file="../footer.jsp" %>