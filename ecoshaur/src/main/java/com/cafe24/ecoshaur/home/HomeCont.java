package com.cafe24.ecoshaur.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.ecoshaur.home.HomeDTO;
import net.utility.Utility;

@Controller
public class HomeCont {
  @Autowired
  private HomeDAO dao;
  

  public HomeCont() {
    System.out.println("---HomeCont()객체 생성됨...");
  }
  
//상세보기
 @RequestMapping(value = "home.do", method = RequestMethod.GET)
 public ModelAndView read() {
   ModelAndView mav = new ModelAndView();
   HomeDTO dto = dao.read();
   if(dto != null) {
     mav.setViewName("home/home");     
     
   }//if end
   
   mav.addObject("dto", dto);
   return mav;
 }// read() end
  
}
