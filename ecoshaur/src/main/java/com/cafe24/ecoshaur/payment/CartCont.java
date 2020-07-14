package com.cafe24.ecoshaur.payment;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
   public ModelAndView list(String id, int nowpage) {
     int recordPerPage = 4;
     int endRow   = nowpage * recordPerPage;
     ModelAndView mav = new ModelAndView();
     
     mav.setViewName("cart/Cart");
     mav.addObject("cart_list", dao.list(id, nowpage, recordPerPage));
     mav.addObject("rental_list", dao.rental_pdlist(id, nowpage, recordPerPage));
     mav.addObject("id", id);
     mav.addObject("price", dao.total(id));
    
     mav.addObject("recordPerPage", recordPerPage);
     mav.addObject("end", endRow);
     mav.addObject("nowpage", nowpage);
     mav.addObject("count", dao.count(id));
     return mav;
   }// read() end
   
   // 장바구니 추가
   @RequestMapping(value = "Cart.do", method = RequestMethod.POST)
   public ModelAndView add(int price_daily, int deposit, CartDTO dto, int nowpage) {
     int recordPerPage = 4;
     int endRow   = nowpage * recordPerPage;
     ModelAndView mav = new ModelAndView();
     mav.setViewName("cart/Cart");
     
     // 총금액 계산
     int total_price = (price_daily*dto.getQuantity()) + deposit;
     dto.setTotal_price(total_price);
     
     // 장바구니 추가
     int cnt = dao.create(dto);
     
     mav.addObject("cart_list", dao.list(dto.getId(), nowpage, recordPerPage));
     mav.addObject("rental_list", dao.rental_pdlist(dto.getId(), nowpage, recordPerPage));
     mav.addObject("id", dto.getId());
     
     
     mav.addObject("recordPerPage", recordPerPage);
     mav.addObject("end", endRow);
     mav.addObject("nowpage", nowpage);
     mav.addObject("count", dao.count(dto.getId()));
     return mav;
   }// read() end
   
  //장바구니 결제페이지
  @RequestMapping(value = "Cartpayment.do", method = RequestMethod.GET)
  public ModelAndView rental_pdlist(String id, int nowpage) {
    int recordPerPage = 4;
    int endRow   = nowpage * recordPerPage;
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("cart/Cartpayment");
    mav.addObject("cart_list", dao.list(id, nowpage, recordPerPage));
    mav.addObject("rental_list", dao.rental_pdlist(id, nowpage, recordPerPage));
    mav.addObject("point", dao.Point(id));
    mav.addObject("id", id);
    mav.addObject("total_price", dao.total_price(id));
    
    mav.addObject("recordPerPage", recordPerPage);
    mav.addObject("end", endRow);
    mav.addObject("nowpage", nowpage);
    mav.addObject("count", dao.count(id));
    return mav;
  }// read() end

  /* point          : point
   * cid            : id
   * payment        : 주문내역서 
   * credit_card    : 주문내역서
   * card_num       : 주문내역서
   * address        : 주문서
   * address_r      : 주문서
   * delivery_method: 주문서
   * tel            : 주문서
   * 
   * point는 id와 point를 가져와서 포인트감소 계산 ㅇ
   * 주문서는 odto와 id, 포인트를 계산한 총결제금액, 결제상품갯수,  주문서번호를 계산후 가져와서 입력
   * 주문내역서는 ohdto와 id, 포인트를 계산한 총결제금액, 주문서번호 가져와서 id를 이용해서 카트테이블에 상품번호, 수량가져오고 입력
   */
  
  @RequestMapping(value = "Cartpayment.do", method = RequestMethod.POST)
  public ModelAndView cartpayproc(String cid, OrderDTO odto, OrderHistoryDTO ohdto, PointDTO pdto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("cart/msgView");
    
    // 포인트를 계산한 총결제금액
    int total_price = dao.total_price(cid) - pdto.getPoint();
    // 장바구니 갯수
    int cartcnt = dao.get_cartCnt(cid);
    // 주문서번호 작업
    int number = dao.OMax_code()+1;        // 카테고리코드에 해당하는 상품목록번호 최대값 가져오기
    // 장바구니 리스트 (상품번호 order)
    ArrayList<CartDTO> cdto = new ArrayList<CartDTO>();
    cdto = dao.list(cid);
    // 상품목록 보증금 (상품번호 order)
    ArrayList<RentalDTO> rdto = new ArrayList<RentalDTO>();
    rdto = dao.rental_pdlist(cid);
    
    // 포인트 증감 입력
    int point_cnt = dao.pointUpdate(cid, pdto);
    
    // 주문서 입력
    int order_cnt = dao.order_create(odto, cid, total_price, number, cartcnt);
    
    // 주문내역서 입력
    int orderhistory = dao.orderhistory_create(ohdto, cid, total_price, number, cdto, rdto);
    
    // 장바구니 삭제 
    int cart_del = dao.cart_del(cid);
    
    int check = point_cnt + order_cnt + orderhistory + cart_del;
    
    if (check != 4) {
      mav.addObject("msg1", "<script>alert('결제에 실패하였습니다'); window.location.href = './';</script>");
    } else {
      mav.addObject("msg1", "<script>alert('결제에 성공하였습니다'); window.location.href = './';</script>");
    }

    return mav;
  }// read() end
  
  
// 장바구니 삭제
 @RequestMapping(value = "CartDel.do")
 public void CategoryList(HttpServletRequest req, HttpServletResponse resp) {   
   try {
     String uno=req.getParameter("no");
     int no = Integer.parseInt(uno);
     int cnt = dao.delete(no);
     
     JSONObject json=new JSONObject();
     json.put("count", cnt);
     resp.setContentType("text/plain; charset=UTF-8");
     PrintWriter out=resp.getWriter();
     out.println(json.toString());
     out.flush();
     out.close();
     
   }catch (Exception e) {
     System.out.println("카테고리 삭제 실패:"+e);
   }
 }// CategoryList() end
  
}
