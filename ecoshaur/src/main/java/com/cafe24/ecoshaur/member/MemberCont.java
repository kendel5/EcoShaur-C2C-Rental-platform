package com.cafe24.ecoshaur.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.ecoshaur.home.HomeDTO;
import net.utility.Utility;

@Controller
public class MemberCont {
  @Autowired
  private MemberDAO dao;
  

  public MemberCont() {
    System.out.println("---HomeCont()객체 생성됨...");
  }
  
//상세보기
 @RequestMapping(value = "Member.do", method = RequestMethod.GET)
 public ModelAndView read() {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("member/abc");   
   return mav;
 }// read() end
  
}
