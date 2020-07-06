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
  @RequestMapping(value="login.do", method=RequestMethod.POST)
  public ModelAndView loginProc(MemberDTO dto, HttpServletRequest request, HttpServletResponse response){
	  ModelAndView mav= new ModelAndView();
	  String grade = dao.loginProc(dto);
	  
	  HttpSession session = request.getSession();
	  if(grade!=null) {
		  mav.setViewName("member/loginProc");
		  session.setAttribute("id", dto.getId());
	  }
	  session.setAttribute("grade", grade);
	  
	  return mav;
  }
  //로그아웃
  @RequestMapping(value="logout.do", method=RequestMethod.POST)
  public ModelAndView logout(MemberDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception	{
    ModelAndView mav= new ModelAndView();
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
  
  //email중복확인
  @RequestMapping(value="emailCheck.do", method=RequestMethod.GET)
  public ModelAndView emailCheck(HttpSession session) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("member/emailCheckForm");
	  mav.addObject("root", Utility.getRoot());
	
	  return mav;
  }
  
  
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
  
  
}//class end
