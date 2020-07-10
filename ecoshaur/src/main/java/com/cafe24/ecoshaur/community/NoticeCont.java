package com.cafe24.ecoshaur.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class NoticeCont {

  @Autowired
  NoticeDAO dao;

  //공지사항 목록
  @RequestMapping("Notice.do")
  public ModelAndView Notice(int nowpage) {
    int recordPerPage = 8;
    int endRow   = nowpage * recordPerPage;

    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/Notice");
    mav.addObject("list", dao.list(nowpage, recordPerPage));
    mav.addObject("end", endRow);
    mav.addObject("nowpage", nowpage);
    mav.addObject("recordPerPage", recordPerPage);
    mav.addObject("count", dao.count());
    return mav;
  }

  //공지사항 상세보기
  @RequestMapping("NRead.do")
  public ModelAndView Nread(int postno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/NRead");
    //조회수 증가
    dao.vupdate(postno);
    mav.addObject("dto", dao.read(postno));
    return mav;
  }
  
  //공지사항 작성 페이지 호출
  @RequestMapping(value = "NCreate.do", method = RequestMethod.GET)
  public String NCreate() {
    return "community/NCreate";
  }

  //공지사항 작성
  @RequestMapping(value = "NCreate.do", method = RequestMethod.POST)
  public ModelAndView NCreate(NoticeDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/NResult");
    String basePath = req.getRealPath("/community/storage");
    
    MultipartFile posterMF = dto.getPosterMF();

    String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);

    dto.setImage_name(poster);

    int cnt = dao.create(dto);
    if (cnt == 0) {
      mav.addObject("msg",  "<p>공지사항 작성을 실패하였습니다.ㅠㅠ</p>");
    } else {
      mav.addObject("msg",  "<p>공지사항 작성을 성공하였습니다!</p>");
    }
    return mav;
  }
  
  //공지사항 수정 페이지 호출
  @RequestMapping(value="NUpdate.do", method=RequestMethod.GET)
  public ModelAndView NUpdate(NoticeDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/NUpdate");
    mav.addObject("dto", dao.read(dto.getPostno()));
    return mav;
  }
  
  //공지사항 수정 
  @RequestMapping(value="NUpdate.do", method=RequestMethod.POST)
  public ModelAndView NUpdate(NoticeDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/NResult");
    
    String basePath = req.getRealPath("/community/storage");
    
    //기존에 저장된 정보 가져오기
    NoticeDTO oldDTO = dao.read(dto.getPostno());

    MultipartFile posterMF = dto.getPosterMF();    
    if(posterMF.getSize()>0) {
      
      //1)파일을 수정할 경우
      //신규 파일 저장
      String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
      dto.setImage_name(poster);      
    }else {
      
      //2)파일을 수정하지 않을 경우
      //기존 파일 불러오기
      dto.setImage_name(oldDTO.getImage_name());
    }
       
    int cnt = dao.update(dto);
    if(cnt == 0) {
      mav.addObject("msg",  "<p>글 수정을 실패하였습니다.ㅠㅠ</p>");
    } else {
      mav.addObject("msg",  "<p>글 수정을 성공하였습니다!</p>");
    }
    return mav;
  }
  
  
  
  //공지사항 삭제 페이지 호출
  @RequestMapping(value="NDelete.do", method=RequestMethod.GET)
  public ModelAndView NDelete(NoticeDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/NDelete");
    mav.addObject("dto", dao.read(dto.getPostno()));
    return mav;
  }
  
  //공지사항 삭제
  @RequestMapping(value = "NDelete.do", method = RequestMethod.POST)
  public ModelAndView NDelete(NoticeDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();  
    mav.setViewName("community/NResult"); 
    int cnt = dao.delete(dto.getPostno());
    if (cnt == 0) {
      mav.addObject("msg",  "<p>공지사항 삭제를 실패하였습니다.ㅠㅠ</p>");
    } else {
      mav.addObject("msg",  "<p>정상적으로 공지사항이 삭제되었습니다!</p>");
    }
    return mav;
  }
}
