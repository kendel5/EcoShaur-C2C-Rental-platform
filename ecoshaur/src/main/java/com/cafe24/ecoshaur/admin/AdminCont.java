package com.cafe24.ecoshaur.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.ecoshaur.admin.AdminDAO;

import net.utility.UploadSaveManager;
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
  
  //최근 주문목록
  @RequestMapping(value = "admin/pages/newOrderList.do", method = RequestMethod.GET)
  public ModelAndView newOrderList() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("admin/pages/newOrderList");     
    
    // 최근 거래목록
    // Rental
    mav.addObject("Rlist", dao.Rental_list_t());
    // Order_history
    mav.addObject("Olist", dao.orderhistory_list_t());
    // Order_sheet -> id
    mav.addObject("IDlist", dao.ID_list_t());
    
    return mav;
  }
  
  //Top 포인트
  @RequestMapping(value = "admin/pages/top_point.do", method = RequestMethod.GET)
  public ModelAndView top_point() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("admin/pages/top_point");     
    
 // top 포인트
    mav.addObject("top_point", dao.top_point_t());
    
    return mav;
  }
  
  
  // top 환불 
  @RequestMapping(value = "admin/pages/BadTopUser.do", method = RequestMethod.GET)
  public ModelAndView badTopuser() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("admin/pages/BadTopUser");     
    
 // 환불 TOP 순위
    mav.addObject("topFail_rental", dao.topFail_rental_t());
    mav.addObject("topFail_condition", dao.topFail_condition_t()); // Deposit 으로 받음
    
    return mav;
  }
  
//회원 관리
 @RequestMapping(value = "admin/pages/member_list.do", method = RequestMethod.GET)
 public ModelAndView member_list() {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("admin/pages/member_list");     
   
   // 회원목록 리스트
   mav.addObject("list", dao.member_list());
   
   return mav;
 }
 

  //회원 관리 수정
  @RequestMapping(value = "admin/pages/member_manager.do", method = RequestMethod.GET)
  public ModelAndView member_manager(String id) {
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("admin/pages/member_manager");
    
    mav.addObject("mymem", dao.member_read(id));
    return mav;
  }
  
  //회원 관리 수정
  @RequestMapping(value = "admin/pages/member_manager.do", method = RequestMethod.POST)
    public ModelAndView member_managerProc(MemberDTO dto, String old_pro_name, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("member/msgView");
    if(dto.getPro_name1().getSize() != 0) {
  //---------------------------------------------------------------------------
      String basePath = req.getRealPath("member/storage");
      MultipartFile pro_name1 = dto.getPro_name1();
      String poster = UploadSaveManager.saveFileSpring30(pro_name1, basePath);
      dto.setPro_name(poster);
    }
 //---------------------------------------------------------------------------
    else {
      dto.setPro_name(old_pro_name);
    }
    int cnt=dao.update(dto);
    if(cnt!=1) {  
        mav.addObject("msg1", "<script>alert('회원수정에 실패하였습니다'); window.location.href = 'member_list.do';</script>");
      } else {
        mav.addObject("msg1", "<script>alert('회원수정에 성공하였습니다'); window.location.href = 'member_list.do';</script>");
      }
    
    return mav;
  }
  
  
  // 회원 포인트
  @RequestMapping(value = "admin/pages/point.do", method = RequestMethod.GET)
  public ModelAndView member_point() {
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("admin/pages/point");
    
    //point
    mav.addObject("point", dao.point());
    // 회원목록 리스트
    mav.addObject("list", dao.member_list());
    
    return mav;
  }
  
  // 회원 포인트
  @RequestMapping(value = "admin/pages/point.do", method = RequestMethod.POST)
  public ModelAndView member_pointProc(PointDTO dto) {
    ModelAndView mav = new ModelAndView();
    System.out.println(dto.getId());
    System.out.println(dto.getPoint());
    mav.setViewName("admin/pages/msgView");
    
    int cnt = dao.point_insert(dto);
    
    if(cnt!=1) {  
      mav.addObject("msg1", "<script>alert('포인트증감에 실패하였습니다'); window.location.href = 'point.do';</script>");
      return mav;
    }
    else {
      mav.addObject("msg1", "<script>window.location.href = 'point.do';</script>");
      return mav;
    }
  }

  // 회원 좋아요/싫어요
  @RequestMapping(value = "admin/pages/rating.do", method = RequestMethod.GET)
  public ModelAndView member_rating() {
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("admin/pages/rating");
    
    //rating
    mav.addObject("rating", dao.rating());
    // 회원목록 리스트
    mav.addObject("list", dao.member_list());

    // Rental
    mav.addObject("Rlist", dao.rental_list());
    
    
    return mav;
  }
  
}
