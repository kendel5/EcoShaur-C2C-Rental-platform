package com.cafe24.ecoshaur.category;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class RentalCont {
  @Autowired
  private RentalDAO dao;

  public RentalCont() {}
  
//전체보기 
 @RequestMapping(value = "Category.do", method = RequestMethod.GET)
 public ModelAndView CategoryList(int nowpage) {
   // recordPerPage = 현재페이지에 표시될 갯수
   int recordPerPage = 8;
   int endRow   = nowpage * recordPerPage;

   
   ModelAndView mav = new ModelAndView();
   mav.setViewName("category/Category");   
   mav.addObject("root", Utility.getRoot());
   mav.addObject("list", dao.list(nowpage, recordPerPage));
   mav.addObject("recordPerPage", recordPerPage);
   mav.addObject("end", endRow);
   mav.addObject("nowpage", nowpage);
   mav.addObject("count", dao.count());
   return mav;
 }// CategoryList() end
 
 
//소그룹
@RequestMapping(value = "CategoryDT.do", method = RequestMethod.GET)
public ModelAndView CategoryDTList(String category, int nowpage) {
  int recordPerPage = 8;
  int endRow   = nowpage * recordPerPage;
  
  ModelAndView mav = new ModelAndView();
  mav.setViewName("category/CategoryDT");   
  mav.addObject("root", Utility.getRoot());// 
  mav.addObject("cg", category);
  mav.addObject("list", dao.listDT(category, nowpage, recordPerPage));
  mav.addObject("category", dao.category(category));
  
  mav.addObject("recordPerPage", recordPerPage);
  mav.addObject("end", endRow);
  mav.addObject("nowpage", nowpage);
  mav.addObject("count", dao.countDT(category));
  return mav;
}// CategoryList() end


@RequestMapping(value = "CategoryDT.do", method = RequestMethod.POST)
public ModelAndView testCheck(HttpServletRequest req, String cg, int nowpage) {
  int recordPerPage = 8;
  int endRow   = nowpage * recordPerPage;
  
  String[] valueArr = req.getParameterValues("test_check");
  ModelAndView mav = new ModelAndView();
  mav.setViewName("category/CategoryDT");
  int size = valueArr.length;
  mav.addObject("root", Utility.getRoot());// 
  mav.addObject("cg", cg);
  mav.addObject("list", dao.select_listDT(valueArr ,size, nowpage, recordPerPage));
  mav.addObject("category", dao.category(cg));
  
  
  mav.addObject("recordPerPage", recordPerPage);
  mav.addObject("end", endRow);
  mav.addObject("nowpage", nowpage);
  mav.addObject("count", dao.countDTC(valueArr ,size));
  return mav;
}
 
// 상품등록
@RequestMapping(value = "Rental_resister.do", method = RequestMethod.GET)
public ModelAndView Rental_resister() {
  ModelAndView mav = new ModelAndView();
  mav.setViewName("category/Rental_resister");   
  mav.addObject("minor", dao.MNcategory());
  return mav;
}// CategoryList() end

 @RequestMapping(value = "Rental_resister.do", method = RequestMethod.POST)
 public ModelAndView createProc(RentalDTO dto, HttpServletRequest req, String ctCode) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("category/Category");
   mav.addObject("root", Utility.getRoot());
   
   String code = dao.category_code(ctCode);
   dto.setCategory_code(code);

   // 상품목록번호 작업
   String number = dao.Max_code(code);        // 카테고리코드에 해당하는 상품목록번호 최대값 가져오기
   String max_num = number.substring(7, 13);  // 번호부분만 가져오기
   int Int_maxNum = Integer.parseInt(max_num); // 번호를 정수로 바꾸기
   String max_number = String.format("%06d", Int_maxNum+1); // 000001 형식으로 바꾸기
   String product_no = code + "-"  + max_number;
   dto.setProduct_no(product_no);

   
//---------------------------------------------------------------------------
   String basePath = req.getRealPath("/category/storage");

   MultipartFile PosterMF = dto.getPosterMF();
   String poster = UploadSaveManager.saveFileSpring30(PosterMF, basePath);
   dto.setThmb_name(poster);
   dto.setThmb_size(PosterMF.getSize());
   
   MultipartFile filenameMF = dto.getFilenameMF();  
   String image = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
   dto.setImage_name(image);
   dto.setImage_size(filenameMF.getSize());
//---------------------------------------------------------------------------
   dto.setCategory_code(dao.category_code(ctCode));

   int cnt = dao.create(dto);

   return mav;
 }// createProc() end

 
 
 // 상품상세보기
 @RequestMapping(value = "RentalRead.do", method = RequestMethod.GET)
 public ModelAndView Rental_Read(String product_no) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("category/RentalRead");   
   
   // 좋아요, 싫어요 퍼센트
   double good = dao.Rental_good(product_no); // 좋아요 수 가져오기
   double bad = dao.Rental_bad(product_no);   // 싫어요 수 가져오기
   double sum = good + bad;           
   good = good / sum * 100;                 // 좋아요 수 퍼센트
   good = Integer.parseInt(String.valueOf(Math.round(good))); // 정수로 바꾸기
   if(good != 0)
     bad = 100 - good;
   else
     bad = 0;
   mav.addObject("good", good);
   mav.addObject("bad", bad);
   ////////////////////////////////////////////////////////////////////
   mav.addObject("dto", dao.Read(product_no));
   String code = dao.rental_code(product_no);
   mav.addObject("code", dao.category_minor(code));
   
   return mav;
 }// CategoryList() end
 
 // 상품수정
 @RequestMapping(value = "rental_update.do", method = RequestMethod.GET)
 public ModelAndView Rental_update(String product_no) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("category/rental_update"); 
   mav.addObject("dto", dao.Read(product_no));
   String code = dao.rental_code(product_no);
   String minor = dao.category_minor(code);
   mav.addObject("select_minor", minor);
   mav.addObject("minor", dao.MNcategory());
   return mav;
 }// CategoryList() end
 
 @RequestMapping(value = "rental_update.do", method = RequestMethod.POST)
 public ModelAndView Rental_updateProc(RentalDTO dto, HttpServletRequest req, String ctCode) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("category/msgView");
   mav.addObject("root", Utility.getRoot());
   
   //기존파일 삭제를 위한 루트경로 가져오기
   String saveDirectory = Utility.getRoot();
   
   String code = dao.category_code(ctCode);
   dto.setCategory_code(code);

   // 업데이트 기존파일 삭제 X
//---------------------------------------------------------------------------
   String basePath = req.getRealPath("/category/storage");

   MultipartFile PosterMF = dto.getPosterMF();
   String poster = UploadSaveManager.saveFileSpring30(PosterMF, basePath);
   dto.setThmb_name(poster);
   
   MultipartFile filenameMF = dto.getFilenameMF();  
   String image = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
   dto.setImage_name(image);
//---------------------------------------------------------------------------
   dto.setCategory_code(dao.category_code(ctCode));

   int cnt = dao.update(dto, saveDirectory);
   if(cnt!=1) {
     mav.addObject("msg1", "<script>alert('상품수정에 실패하였습니다'); window.location.href = './Category.do?nowpage=1';</script>");
   } else {
     mav.addObject("msg1", "<script>alert('상품수정에 성공하였습니다'); window.location.href = './Category.do?nowpage=1';</script>");
   }
   
   return mav;
 }// CategoryList() end
 
 
//상품삭제
@RequestMapping(value = "rental_delete.do", method = RequestMethod.GET)
public ModelAndView Rental_delete(String product_no) {
 ModelAndView mav = new ModelAndView();
 mav.setViewName("category/rental_delete");  
 mav.addObject("product_no", product_no);
 return mav;
}// CategoryList() end

@RequestMapping(value = "rental_delete.do", method = RequestMethod.POST)
public ModelAndView Rental_deleteProc(String product_no) {
 ModelAndView mav = new ModelAndView();
 mav.setViewName("category/msgView");
 
 //기존파일 삭제를 위한 루트경로 가져오기
 String saveDirectory = Utility.getRoot();
 RentalDTO dto = dao.Read(product_no);
 String thum = dto.getThmb_name();
 String image = dto.getImage_name();
 int cnt = dao.delete(product_no, saveDirectory, thum, image);
 if(cnt!=1) {
   mav.addObject("msg1", "<script>alert('상품삭제에 실패하였습니다'); window.location.href = './Category.do?nowpage=1';</script>");
 } else {
   mav.addObject("msg1", "<script>alert('상품삭제에 성공하였습니다'); window.location.href = './Category.do?nowpage=1';</script>");
 }
 
 return mav;
}// CategoryList() end
 

 
}
