package com.cafe24.ecoshaur.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;

@Controller
public class BoardCont {
  @Autowired
  BoardDAO dao;

  //글 목록
  @RequestMapping("Board.do")
  public ModelAndView Board() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/Board");
    mav.addObject("list", dao.list());
    return mav;
  }
  
  //글 상세보기
  @RequestMapping("BRead.do")
  public ModelAndView Bread(int postno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BRead");
    //조회수 증가
    dao.vupdate(postno);
    mav.addObject("dto", dao.read(postno));
    return mav;
  }

  //글 작성 페이지 호출
  @RequestMapping(value = "BCreate.do", method = RequestMethod.GET)
  public String BCreate() {
    return "community/BCreate";
  }

  //글 작성
  @RequestMapping(value = "BCreate.do", method = RequestMethod.POST)
  public ModelAndView BCreate(BoardDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BResult");
    String basePath = req.getRealPath("/community/storage");
    
    MultipartFile posterMF = dto.getPosterMF();

    String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);

    dto.setImage_name(poster);
    dto.setImage_size(posterMF.getSize());

    int cnt = dao.create(dto);
    if (cnt == 0) {
      mav.addObject("msg",  "<p>글 작성을 실패하였습니다.ㅠㅠ</p>");
    } else {
      mav.addObject("msg",  "<p>글 작성을 성공하였습니다!</p>");
    }
    return mav;
  }

  //글 수정 페이지 호출
  @RequestMapping(value="BUpdate.do", method=RequestMethod.GET)
  public ModelAndView BUpdate(BoardDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BUpdate");
    mav.addObject("dto", dao.read(dto.getPostno()));
    return mav;
  }
  
  //글 수정 
  @RequestMapping(value="BUpdate.do", method=RequestMethod.POST)
  public ModelAndView BUpdate(BoardDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BResult");
    
    String basePath = req.getRealPath("/community/storage");
    
    //기존에 저장된 정보 가져오기
    BoardDTO oldDTO = dao.read(dto.getPostno());

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
  
  //글 삭제 페이지 호출
  @RequestMapping(value="BDelete.do", method=RequestMethod.GET)
  public ModelAndView BDelete(BoardDTO dto) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BDelete");
    mav.addObject("dto", dao.read(dto.getPostno()));
    return mav;
  }
   
  //글 삭제
  @RequestMapping(value = "BDelete.do", method = RequestMethod.POST)
  public ModelAndView BDelete(BoardDTO dto, HttpServletRequest req) {
    ModelAndView mav = new ModelAndView();  
    mav.setViewName("community/BResult"); 
    int cnt = dao.delete(dto.getPostno());
    if (cnt == 0) {
      mav.addObject("msg",  "<p>글삭제를 실패하였습니다.ㅠㅠ</p>");
    } else {
      mav.addObject("msg",  "<p>정상적으로 글이 삭제되었습니다!</p>");
    }
    return mav;
  }
  
  //좋아요
  @RequestMapping(value="Good.do",method=RequestMethod.GET)
  public ModelAndView Good(int postno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BRead");
    dao.gupdate(postno);
    mav.addObject("dto", dao.read(postno));
    return mav;
  }
  
  //싫어요
  @RequestMapping(value="Bad.do",method=RequestMethod.GET)
  public ModelAndView Bad(int postno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("community/BRead");
    dao.bupdate(postno);
    mav.addObject("dto", dao.read(postno));
    return mav;
  }
}
