package com.cafe24.ecoshaur.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
  public ModelAndView loginForm(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("member/loginForm");
    mav.addObject("root", Utility.getRoot());
 
    return mav;
  }//createForm() end
  
  //로그인 결과
  @RequestMapping(value="loginProc.do", method=RequestMethod.POST)
  public ModelAndView loginProc(MemberDTO dto, HttpServletRequest req , HttpServletResponse resp, HttpSession session) {
    ModelAndView mav = new ModelAndView();
 
    mav.setViewName("member/loginProc");
    mav.addObject("member", dao.loginProc(dto));
//-------------------------------------------

    return mav;
  }
  
  //로그아웃 처리
  @RequestMapping(value="loginOut.do", method=RequestMethod.GET)
  public ModelAndView logOut(HttpSession session) {
	  ModelAndView mav = new ModelAndView();
	  mav.addObject("root", Utility.getRoot());
	  mav.setViewName("member/logout");
	  mav.addObject("msg", "logout");
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
  
  //id중복확인
  @RequestMapping(value="idCheck.do", method=RequestMethod.GET)
  public ModelAndView idCheck(HttpSession session) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("member/idCheckForm");
	  mav.addObject("root", Utility.getRoot());
	
	  return mav;
  }
  
  //id중복확인결과
  @RequestMapping(value="idCheckPro.do", method=RequestMethod.POST)
  public ModelAndView idCheckPro(HttpServletRequest req) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("member/idCheckProc");
	  
	  String id = req.getParameter("id").trim();
	  int cnt = dao.duplicateID(id);
		
	  mav.addObject("root", Utility.getRoot());
	  mav.addObject("cnt", cnt);
	
	  return mav;
  }
  
  //email중복확인
  @RequestMapping(value="emailCheck.do", method=RequestMethod.GET)
  public ModelAndView emailCheck(HttpSession session) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("member/emailCheckForm");
	  mav.addObject("root", Utility.getRoot());
	
	  return mav;
  }
  
  //email중복확인결과
  @RequestMapping(value="emailCheckPro.do", method=RequestMethod.POST)
  public ModelAndView emailCheckPro(HttpServletRequest req) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("member/emailCheckProc");
	  
	  String email = req.getParameter("email").trim();
	  int cnt = dao.duplicateEmail(email);
		
	  mav.addObject("root", Utility.getRoot());
	  mav.addObject("cnt", cnt);
	
	  return mav;
  }
  
  //회원가입
  @RequestMapping(value="memberForm.do", method=RequestMethod.GET)
  public ModelAndView memberForm(HttpSession session, MemberDTO dto) {
	  ModelAndView mav=new ModelAndView();
	  mav.setViewName("member/memberForm");
	  mav.addObject("root", Utility.getRoot());
	  
	  return mav;
  }//memberForm() end
  
  
  
  
}//class end
