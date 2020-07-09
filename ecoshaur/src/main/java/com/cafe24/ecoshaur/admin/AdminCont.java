package com.cafe24.ecoshaur.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.ecoshaur.admin.AdminDAO;

import net.utility.Utility;

@Controller
public class AdminCont {
  @Autowired
  private AdminDAO dao;

  public AdminCont() {
    System.out.println("---HomeCont()객체 생성됨...");
  }
  
//상세보기
 @RequestMapping(value = "admin/index.do", method = RequestMethod.GET)
 public ModelAndView index() {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("admin/index");     
   
   // 총금액
   mav.addObject("total_price", dao.total_price());
   
   // 신규회원 수
   mav.addObject("new_user", dao.new_user());
   
   // 방문자 수
   mav.addObject("visitor", dao.visitor());
   
   // 거래 총 갯수
   mav.addObject("total_order", dao.total_order());
   
   // 최근 거래목록
   // Rental
   mav.addObject("Rlist", dao.Rental_list());
   // Order_history
   mav.addObject("Olist", dao.orderhistory_list());
   // Order_sheet -> id
   mav.addObject("IDlist", dao.ID_list());
   
   // top 포인트
   mav.addObject("top_point", dao.top_point());
   
   // 환불 TOP 순위
   mav.addObject("topFail_rental", dao.topFail_rental());
   mav.addObject("topFail_condition", dao.topFail_condition()); // Deposit 으로 받음
   
   // 카테고리별 요약목록
   mav.addObject("Category_info", dao.Category_info());
   return mav;
 }// read() end
  
}
