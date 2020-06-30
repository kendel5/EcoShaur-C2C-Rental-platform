package com.cafe24.ecoshaur.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mymelon.media.MediaDTO;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class RentalCont {
  
  @Autowired
  RentalDAO dao;
  
  public RentalCont() {
    System.out.println("---RentalCont() 객체 생성됨");
  }  
  
  @RequestMapping("/Category/list.do")
  public ModelAndView list(RentalDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/Category");
    mav.addObject("root", Utility.getRoot());
    mav.addObject("list", dao.list(dto));
    //부모글번호
    mav.addObject("Product_no", dto.getProduct_no());
    return mav;
  }//list() end
  
 
//상품 등록
  @RequestMapping(value="/category/register.do", method=RequestMethod.GET)
  public ModelAndView register(RentalDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("category/Register");
    mav.addObject("root", Utility.getRoot());
    mav.addObject("Product_No", dto.getProduct_no());
    return mav;
  }//register() end
  
  @RequestMapping(value="/category/register.do", method=RequestMethod.POST)
  public ModelAndView registerProc(RentalDTO dto, HttpServletRequest req , HttpServletResponse resp, HttpSession session) {
    
    ModelAndView mav = new ModelAndView();
    mav.setViewName("Rental/msgView");
    mav.addObject("root", Utility.getRoot());
//-------------------------------------------
//  전송된 파일 처리 
//  -> 실제 파일은 /category/storage폴더에 저장
//  -> 저장된 파일관련 정보는 Rental테이블에 저장   
    
//  실제 물리적인 경로
    String basePath = req.getRealPath("/category/storage"); //???
    
    MultipartFile thmbMF = dto.getThmbMF();
    String thmb_name = UploadSaveManager.saveFileSpring30(thmbMF, basePath); 
    dto.setThmb_name(thmb_name);    
  
    MultipartFile imageMF = dto.getImageMF();
    String image_name = UploadSaveManager.saveFileSpring30(imageMF, basePath);
    dto.setImage_name(image_name);
    //dto.setFilesize(imageMF.getSize());
//--------------------------------------------
    
    int cnt=dao.register(dto);
    if(cnt==0) {
      mav.addObject("msg1",  "<p>등록 실패</p>");
      mav.addObject("img",   "<img src='../images/fail.png'>");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='javascript:history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록으로' onclick='location.href=\"./list.do?Product_no=" + dto.getProduct_no() + "\"'>");
    }else {
      mav.addObject("msg1",  "<p>등록 성공</p>");
      mav.addObject("img",   "<img src='../images/sound.png'>");
      mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"./list.do?Product_no=" + dto.getProduct_no() + "\"'>");      
    }//if end
   
    return mav; 
  }//registerProc() end
  
  //상세보기
  @RequestMapping(value="/category/readRental.do", method=RequestMethod.GET)
  public ModelAndView read(int Product_No) {
    ModelAndView mav = new ModelAndView();
    RentalDTO dto = dao.read(Product_No);
    mav.addObject("root", Utility.getRoot());
    mav.addObject("dto", dto);
    return mav;
  }//read() end

  
  @RequestMapping(value="/category/delete.do", method=RequestMethod.GET)
  public ModelAndView deleteForm(RentalDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("Rental/deleteForm");
    mav.addObject("root", Utility.getRoot());
    //삭제관련정보 가져오기
    mav.addObject("dto", dao.read(dto.getProduct_no()));    
    return mav;
  }//deleteForm() end
  

  @RequestMapping(value="/category/delete.do", method=RequestMethod.POST)
  public ModelAndView deleteProc(RentalDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("category/msgView");
    mav.addObject("root", Utility.getRoot());
  
    //삭제하고 하는 정보 가져오기
    RentalDTO oldDTO = dao.read(dto.getProduct_no());
    int cnt = dao.delete(dto.getProduct_no());
    if(cnt==0) {
      mav.addObject("msg1",  "<p>삭제 실패!</p>");
      mav.addObject("img",   "<img src='../images/fail.png'>");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='javascript:history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick='location.href=\"./list.do?Product_no="+dto.getProduct_no()+"\"'>");
    }else {
      //관련 파일 삭제
      String basepath = req.getRealPath("/category/storage");
      UploadSaveManager.deleteFile(basepath, oldDTO.getThmb_name());
      UploadSaveManager.deleteFile(basepath, oldDTO.getImage_name());
      mav.addObject("msg1",  "<p>삭제 되었습니다</p>");
      mav.addObject("img",   "<img src='../images/sound.png'>");
      mav.addObject("link1", "<input type='button' value='목록' onclick='location.href=\"./list.do?Product_no="+dto.getProduct_no()+"\"'>");           
    }//if end
    
    return mav;
  }//deleteProc() end
  
  
  @RequestMapping(value="/category/update.do", method=RequestMethod.GET)  
  public ModelAndView updateForm(RentalDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("Rental/updateForm");
    mav.addObject("root", Utility.getRoot());
    mav.addObject("dto", dao.read(dto.getProduct_no()));
    return mav;
  }//updateForm() end
  
  
  @RequestMapping(value="/category/update.do", method=RequestMethod.POST)  
  public ModelAndView updateProc(RentalDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("Rental/msgView");
    mav.addObject("root", Utility.getRoot());

    String basePath = req.getRealPath("/category/storage");
    
    //기존에 저장된 정보 가져오기
    RentalDTO oldDTO = dao.read(dto.getProduct_no());
//------------------------------------------------------    
//  파일을 수정할 것인지?
//  1)
    MultipartFile thmbMF = dto.getThmbMF();    
    if(thmbMF.getSize()>0) {
      //새로운 포스터파일이 전송된경우
      //기존 파일 삭제
      UploadSaveManager.deleteFile(basePath, oldDTO.getThmb_name());
      //신규 파일 저장
      String thmb_name = UploadSaveManager.saveFileSpring30(thmbMF, basePath);
      dto.setThmb_name(thmb_name);      
    }else {
      //포스터 파일을 수정하지 않는 경우
      dto.setThmb_name(oldDTO.getThmb_name());
    }//if end

//  2)
    MultipartFile imageMF = dto.getImageMF();
    if(imageMF.getSize()>0){
      UploadSaveManager.deleteFile(basePath, oldDTO.getImage_name());
      String image_name = UploadSaveManager.saveFileSpring30(imageMF, basePath);
      dto.setImage_name(image_name);             
      dto.setImage_size(imageMF.getSize());      
    }else {
      dto.setImage_name(oldDTO.getImage_name());
      dto.setImage_size(oldDTO.getImage_size());
    }//if end
//------------------------------------------------------    
    int cnt = dao.update(dto);
    if(cnt == 0) {
      mav.addObject("msg1", "파일 수정 실패");
      mav.addObject("img",  "<img src='../images/fail.png'>");
      mav.addObject("link1", "<input type='button' value='다시 시도' onclick='javascript:history.back()'>");
      mav.addObject("link2", "<input type='button' value='목록' onclick='location.href=\"./list.do?Product_no="+ dto.getProduct_no()+"\"'>");
    }
    else {
      mav.addObject("msg1", "파일이 수정 되었습니다");
      mav.addObject("img",  "<img src='../images/sound.png'>");
      mav.addObject("link1", "<input type='button' value='목록' onclick='location.href=\"./list.do?Product_no="+ dto.getProduct_no()+"\"'>");
    }
    
    return mav;
  }//updateProc() end
  
  
  
  
}//class end
