/* myscript.js */
/* charset=utf-8 */

function bbsCheck(f){ //게시판 유효성 검사	
    //this 자기자신
	//f -> <form name=bbsfrm></form>
	
	//1)작성자 2글자이상 입력
	var wname=f.wname.value;
	wname=wname.trim();
	if(wname.length<2){
		alert("작성자 2글자이상 입력해 주세요");   
		f.wname.focus();//커서 생성
		return false;
	}//if end
	
	//2)제목 2글자이상 입력
	var subject=f.subject.value;
	subject=subject.trim();
	if(subject.length<2){
		alert("제목 2글자이상 입력해 주세요");   
		f.subject.focus();//커서 생성
		return false;
	}//if end
	
	//3)내용 2글자이상 입력
	var content=f.content.value;
	content=content.trim();
	if(content.length<2){
		alert("내용 2글자이상 입력해 주세요");   
		f.content.focus();//커서 생성
		return false;
	}//if end
	
	//4)비밀번호 4글자 이상 입력
    var passwd=f.passwd.value;
    passwd=passwd.trim();
    if(passwd.length<4){
	    alert("비밀번호 4글자이상 입력해 주세요");
	    f.passwd.focus();
	    return false;
    }//if end	
	  
	//onsubmit이벤트에서 서버로 전송
	return true;
}//bbsCheck() end


function pwCheck(f) {
	//비밀번호가 4글자 이상 입력되었는지 검사
    var passwd=f.passwd.value;
    passwd=passwd.trim();
    if(passwd.length<4){
	    alert("비밀번호 4글자이상 입력해 주세요");
	    f.passwd.focus();
	    return false;
    }//if end    
    
    var message="진행된 내용은 복구되지 않습니다\n계속 진행할까요?";
    if(confirm(message)){//확인 true, 취소 false
      return true; //서버로 전송됨
    }else{
      return false;
    }//if end
    
}//pwCheck() end


function searchCheck(f){
	var word=f.word.value;
	word=word.trim();
	if(word.length==0){
		alert("검색어를 입력하세요");
		return false;//서버 전송 불가
	}//if end
	return true;     //서버로 전송
}//searchCheck() end


function loginCheck(f) {//로그인 유효성 검사
	//1)아이디 5~10글자 이내
	var id=f.id.value;
	id=id.trim();
	if(id.length<5 || id.length>10){
		alert("아이디 5~10글자 이내 입력해 주세요");
		f.id.focus();
		return false;
	}//if end
	
	//2)비밀번호 5~10글자 이내
	var passwd=f.passwd.value;
	passwd=passwd.trim();
	if(passwd.length<5 || passwd.length>10){
		alert("비밀번호 5~10글자 이내 입력해 주세요");
		f.passwd.focus();
		return false;
	}//if end
	
	return true;
}//loginCheck() end


function idCheck(){
	//아이디 중복확인
	
	//부트스트랩 모달창
	//->부모창과 자식창이 한몸으로 구성되어 있음
	
	//새창만들기
	//->부모창과 자식창이 별개로 구성되어 있음
	//->모바일에 기반을 둔 frontend단에서는 사용하지 말것!!
	//window.open("파일명","새창이름","다양한옵션들")
	window.open("idCheckForm.jsp"
			  , "idwin"
			  , "width=400, height=350");
	
}//idCheck() end

function emailCheck(){
	//이메일 중복확인
	//새창만들기
	//window.open("파일명","새창이름","다양한옵션들")
	window.open("emailCheckForm.jsp"
			  , "emailwin"
			  , "width=400, height=350");
}//emailCheck() end

function memberCheck(f){
	//회원가입 유효성 검사(과제)
	
	//1)아이디 5~10글자 인지?
	var id=f.id.value;
	id=id.trim();
	if(id.length>=5 && id.length<=10){
		alert("아이디 5글자 이상 10글자 이내 입력해 주세요");   
		f.id.focus();//커서 생성
		return false;
	}//if end
	
	//2)비밀번호 5~10글자 인지?
	var passwd=f.passwd.value;
	passwd=passwd.trim();
	if(passwd.length>=5 && passwd.length<=10){
		alert("비밀번호 5글자 이상 10글자 이내 입력해 주세요");   
		f.passwd.focus();//커서 생성
		return false;
	}//if end
	
	//3)비밀번호와 비밀번호확인이 서로 일치하는지?
	
	
	//4)이름 1~20글자 인지?
	var wname=f.wname.value;
	wname=wname.trim();
	if(wname.length>=1 && wname.length<=10){
		alert("작성자 10글자 이내 입력해 주세요");   
		f.wname.focus();//커서 생성
		return false;
		
	//정규표현식(regular expression)
	//공백지우기(trim()함수와 동일)
	//replace(/^\s+|\s+$/gm,'');
	
	//5)이메일 주소형식 유효한지?
	//->정규표현식 사용해서
	//<input type="email">요소도 있음
	alert(document.getElementById("email").value);
	var email = document.getElementById("email").value;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(exptext.test(email)==false){
	//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐 경우
	   alert("이메일 형식이 올바르지 않습니다.");
	   return false;
	}//if end
		
		
	//6)직업을 선택했는지?
	var job=f.job.value;
	if(job=="0"){
		alert("직업 선택해 주세요");
		return false;
	}//if end
	
	//유효성 검사를 모두 통과했으므로
	//memberProc.jsp로 전송됨
	return true;
}//memberCheck() end


function pdsCheck(f) {
	//포토갤러리 유효성 검사
    //1)이름 2글자 미만인지?
	var wname=f.wname.value;
	wname=wname.trim();
	if(wname.length<2){
		alert("작성자 2글자 이상 입력해 주세요");   
		f.wname.focus();//커서 생성
		return false;
	}//if end
	
    //2)제목 2글자 미만인지?
	var subject=f.subject.value;
	subject=subject.trim();
	if(subject.length<2){
		alert("제목 2글자 이상 입력해 주세요");   
		f.subject.focus();//커서 생성
		return false;
	}//if end
	
    //3)비밀번호는 4글자 미만?	
    var passwd=f.passwd.value;
    passwd=passwd.trim();
    if(passwd.length<4){
	    alert("비밀번호 4글자이상 입력해 주세요");
	    f.passwd.focus();
	    return false;
    }//if end
    
    
	//4)첨부파일
    var filename=f.filename.value;
    filename=filename.trim();
    if(filename.length==0){
    	alert("첨부파일 선택해 주세요");
    	return false;
    }else{
        //이미지파일(png / jpg / gif)만 가능
    	
    	//마지막 .의 위치를 확인
    	var dot=filename.lastIndexOf(".");
    	if(dot==-1){// .기호가 없다면
    		alert("첨부파일 다시 선택해 주세요");
    		return false;
    	}else{
    		//마지막 .기호 이후 문자열 자르기
    		var ext=filename.substr(dot+1);
    		//전부 소문자로 치환
    		ext=ext.toLowerCase();
		    if(ext=="png" || ext=="jpg" || ext=="gif"){
				return true;
			}else{
				alert("이미지 파일만 가능합니다!!");
				return false;
			}//if end
    	}//if end    	
    }//if end
	}//if end
}//pdsCheck() end








