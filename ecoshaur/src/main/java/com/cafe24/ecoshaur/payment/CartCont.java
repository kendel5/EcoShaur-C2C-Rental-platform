package com.cafe24.ecoshaur.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.ecoshaur.payment.CartDTO;
import net.utility.Utility;

@Controller
public class CartCont {
  @Autowired
  private CartDAO dao;
  

  public CartCont() {
    System.out.println("---CartCont()객체 생성됨...");
  }
  
//상세보기
 @RequestMapping(value = "Cart.do", method = RequestMethod.GET)
 public ModelAndView list(String id) {
   ModelAndView mav = new ModelAndView();
   
   mav.setViewName("cart/Cart");
   mav.addObject("list", dao.list(id));
   mav.addObject("id", id);
   return mav;
 }// read() end
 
//장바구니 결제페이지
@RequestMapping(value = "Cartpayment.do", method = RequestMethod.GET)
public ModelAndView rental_pdlist(String id) {
  ModelAndView mav = new ModelAndView();
  
  mav.setViewName("cart/Cartpayment");
  mav.addObject("cart_list", dao.list(id));
  mav.addObject("rental_list", dao.rental_pdlist(id));
  mav.addObject("point", dao.Point(id));
  mav.addObject("id", id);
  return mav;
}// read() end

//@RequestMapping(value = "Cartpayment.do", method = RequestMethod.POST)
//public ModelAndView cartpayproc(String cid, OrderDTO odto, OrderHistoryDTO ohdto, PointDTO pdto) {
//  ModelAndView mav = new ModelAndView();
//  mav.setViewName("cart/Cartpayment");
//  int cart_cnt=dao.cart_del(cid);
//  int order_cnt=dao.order_create(odto);
//  int orderhistory_cnt=dao.orderhistory_create(ohdto);
//  int point_cnt=dao.point_update(pdto);
//  return mav;
//}// read() end
  
}
