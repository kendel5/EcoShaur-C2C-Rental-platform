package com.cafe24.ecoshaur.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class MemberCont {
  
  @Autowired
  private MemberDAO dao;
  
  public MemberCont() {
    System.out.println("---MemberCont()객체 생성됨");
  }  
   
//로그인
  @RequestMapping(value="login.do", method=RequestMethod.GET)
  public ModelAndView loginForm(MemberDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("member/loginForm");
    mav.addObject("root", Utility.getRoot());
 
    return mav;
  }//createForm() end
  
  	//로그인 결과
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(MemberDTO dto, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String grade = dao.loginProc(dto);

		HttpSession session = request.getSession();
		mav.setViewName("member/loginProc");
		String id=null;
		if (grade != null) {
			id=dto.getId();
		}
		session.setAttribute("id", id);
		session.setAttribute("grade", grade);
		session.setMaxInactiveInterval(30);
		return mav;
	}
  
	//로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		mav.setViewName("member/logout");
		session.invalidate();

		return mav;
	}
  
  //약관동의
  @RequestMapping(value="agree.do", method=RequestMethod.GET)
  public ModelAndView agreement(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("member/agreement");
    mav.addObject("root", Utility.getRoot());
 
    return mav;
  }//createForm() end
  
  
//쿠키를 활용하여 아이디 중복확인을 해야만 회원가입 한다
 @RequestMapping("memberForm.do")
 public void idCheckProc3(HttpServletRequest req, HttpServletResponse resp) {
	 String uid=req.getParameter("uid");
	 
	 if(uid != null) {
		 try{
			 int cnt=dao.duplicateID(uid);
		     System.out.println("asd");
		     //1)text응답-----------------------
		     /*
		     resp.setContentType("text/plain; charset=UTF-8");
		     PrintWriter out=resp.getWriter();
		     out.println(cnt);
		     out.flush();
		     out.close();
		     */ 
		     
		     //2)json응답-----------------------
		     // https://mvnrepository.com에서
		     // json-simple검색후 
		     // pom.xml에 의존성 추가해야 함
		     JSONObject json=new JSONObject();
		     //json.put(key, value)
		     json.put("count", cnt);
		     resp.setContentType("text/plain; charset=UTF-8");
		     PrintWriter out=resp.getWriter();
		     out.println(json.toString());
		     out.flush();
		     out.close();
    
		 }catch (Exception e) {
		     System.out.println("아이디중복확인쿠키실패:"+e);
		   }//try end
	 }

   
 }//idCheckProc3() end
   
  //회원가입
  @RequestMapping(value="memberForm.do", method=RequestMethod.GET)
  public ModelAndView memberForm(MemberDTO dto, HttpServletRequest req, HttpSession session) throws Exception{
	  ModelAndView mav=new ModelAndView();
	  mav.setViewName("member/memberForm");
	  mav.addObject("root", Utility.getRoot());
	  
	  return mav;
  }//memberForm() end
  
//회원가입 결과
  @RequestMapping(value="memberProc.do", method=RequestMethod.POST)
  public ModelAndView memberProc(MemberDTO dto, HttpServletRequest req, HttpSession session) throws Exception {
	  ModelAndView mav = new ModelAndView();
	  
	  mav.addObject("check", dao.insertmember(dto));
	  
	  mav.setViewName("member/memberProc");
	  return mav;
  }
  
  //회원정보 보기
  @RequestMapping(value="mypage.do", method=RequestMethod.GET)
  public ModelAndView mypage(HttpServletRequest request, HttpSession session ){
	  ModelAndView mav = new ModelAndView();
	  String id=(String) session.getAttribute("id");
	  mav.addObject("mymem", dao.read(id));
	  mav.addObject("mypage", dao.mypage(id));
	 
	  mav.setViewName("member/mypage");
	  return mav;
  }
  
//회원수정
	@RequestMapping(value="ModifyForm.do", method=RequestMethod.GET)
	  public ModelAndView ModifyForm(String id) {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("member/ModifyForm");
	    mav.addObject("mymem", dao.read(id));
	    return mav;
	  }//ModifyForm() end
	  
	
	  //회원수정
	  @RequestMapping(value="ModifyProc.do", method=RequestMethod.POST)
	  public ModelAndView ModifyProc(MemberDTO dto ) {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("member/msgView");
	    int cnt=dao.update(dto);
	    if(cnt!=1) { 
	        mav.addObject("msg1", "<script>alert('회원수정에 실패하였습니다'); window.location.href = '../login.do';</script>");
	      } else {
	        mav.addObject("msg1", "<script>alert('회원수정에 성공하였습니다'); window.location.href = '../login.do';</script>");
	      }
	    
	    return mav;
	  }//ModifyProc() end
	  
	//회원탈퇴
		@RequestMapping(value="delete.do", method=RequestMethod.GET)
		public ModelAndView deleteForm(HttpSession session) {
		      ModelAndView mav = new ModelAndView();
		      mav.setViewName("member/memberdel");

		      return mav;
		  }//deleteForm() end

		//회원탈퇴
		@RequestMapping(value="deleteProc.do", method=RequestMethod.GET)
		  public ModelAndView deleteProc(HttpSession session) {
		      ModelAndView mav = new ModelAndView();
		      mav.setViewName("member/memberdel");
		      String id = (String) session.getAttribute("id");
		      int cnt = dao.delete(id);
		      if(cnt!=1) {
		        mav.addObject("msg1", "<script>alert('회원탈퇴에 실패하였습니다'); window.location.href = 'login.do';</script>");
		      } else {
		        mav.addObject("msg1", "<script>alert('회원탈퇴에 성공하였습니다'); window.location.href = 'login.do';</script>");
		      }
		      return mav;
		  }//deleteProc() end
  
  //비밀번호 찾기
  @RequestMapping(value="findpw.do", method=RequestMethod.GET)
  public ModelAndView findPw(MemberDTO dto, HttpServletRequest req) throws Exception {
	  ModelAndView mav = new ModelAndView();
	  
	  mav.setViewName("member/findPw");
	  return mav;
	  
  }
}//class end
