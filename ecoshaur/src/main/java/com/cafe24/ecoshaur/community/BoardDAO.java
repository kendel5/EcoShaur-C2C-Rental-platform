package com.cafe24.ecoshaur.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.category.RentalDTO;

import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class BoardDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<BoardDTO> list = null;
     
    BoardDTO dto = null;

    public BoardDAO() { }

    public ArrayList<BoardDTO> list(int nowpage, int recordPerPage){
      try{        
        BoardDTO dto = new BoardDTO();
        
        //startRow 시작할 레코드의 번호
        //nowpage 현재 페이지의 목록 번호  
        //recordPerPage 한페이지에 보여줄 게시글수
        
        int startRow = ((nowpage-1) * recordPerPage) ;
        int endRow   = recordPerPage;
        
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT postno, title, post_date, id, view, good, bad ");
        sql.append(" FROM board");       
        sql.append(" ORDER BY postno DESC");
        sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;        
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if(rs.next()){
          list = new ArrayList<BoardDTO>();
          do {
            dto = new BoardDTO();
            dto.setPostno(rs.getInt("postno")); 
            dto.setTitle(rs.getString("title"));
            dto.setPost_date(rs.getString("post_date"));
            dto.setId(rs.getString("id"));
            dto.setView(rs.getInt("view"));
            dto.setGood(rs.getInt("good"));
            dto.setBad(rs.getInt("bad"));
            list.add(dto);
          } while(rs.next());
        }else{
          list = null;
        }//if end

      }catch(Exception e){
         System.out.println("자유게시판 목록 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }//end
      return list;
    }//list() end
    
    // 목록 최대 페이징 수
    public int count() {
      int count=0;
      try {
        // DB연결
        con = dbopen.getConnection();
        
        //4)SQL문 작성
          sql=new StringBuilder();
          sql.append(" SELECT count(*) as cnt FROM board ");
          pstmt=con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
        if(rs.next()) { // cursor 가 있는지?
          count = rs.getInt("cnt");
        }else {
          System.out.println("행 갯수를 얻지못함!!");
        }// if end
      }catch(Exception e) {
        System.out.println(" 카운트실패:" + e);
      }finally {
        DBClose.close(con, pstmt ,rs);
      }// try end
      return count;
    } // count() end
    
    public BoardDTO read(int postno){
      try{
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT postno, title, contents, image_name, post_date, id, view, good, bad ");
        sql.append(" FROM board");       
        sql.append(" WHERE postno = ?");       
        
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);
        rs = pstmt.executeQuery();
        if(rs.next()){
            dto = new BoardDTO();
            dto.setPostno(rs.getInt("postno"));
            dto.setTitle(rs.getString("title"));
            dto.setContents(rs.getString("contents"));
            dto.setImage_name(rs.getString("image_name"));
            dto.setPost_date(rs.getString("post_date"));
            dto.setId(rs.getString("id"));
            dto.setView(rs.getInt("view"));
            dto.setGood(rs.getInt("good"));
            dto.setBad(rs.getInt("bad"));
        }
      }catch(Exception e){
         System.out.println("자유게시판 보기 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }//end
      return dto;
    }//read() end    
    
    public int create(BoardDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO board(postno, title, contents, image_name, post_date, id, view, good, bad)");
        sql.append(" VALUES((select ifnull(max(postno),0)+1 from board as TB),");
        sql.append(" ?, ?, ?, now(), ?, ?, ?, ?)");
       
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getTitle());
        pstmt.setString(2, dto.getContents());
        pstmt.setString(3, dto.getImage_name());
        pstmt.setString(4, dto.getId());
        pstmt.setInt(5, dto.getView());
        pstmt.setInt(6, dto.getGood());
        pstmt.setInt(7, dto.getBad());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("자유게시물 등록실패"+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//create() end 
    
    public int delete(int postno) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" DELETE FROM board");
        sql.append(" WHERE postno=?");  
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("삭제실패"+e);
      } finally {
          dbclose.close(con, pstmt);
      }//end
      return cnt;
    }//delete() end
    
    public int update(BoardDTO dto) {
      int cnt = 0; 
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE board");
        sql.append(" SET title=?, contents=?, image_name=?");
        sql.append(" WHERE postno=?"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getTitle());
        pstmt.setString(2, dto.getContents());
        pstmt.setString(3, dto.getImage_name());
        pstmt.setInt(4, dto.getPostno());
        cnt = pstmt.executeUpdate();

      } catch (Exception e) {
        System.out.println("수정실패"+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//update() end 
    
    //조회수 증가
    public int vupdate(int postno){
      int cnt = 0; 
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE board");
        sql.append(" SET view=view+1 ");
        sql.append(" WHERE postno=?"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);        
        cnt = pstmt.executeUpdate();

      } catch (Exception e) {
        System.out.println("조회수 실패"+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//vupdate() end 
    
    //좋아요 증가
    public int gupdate(int postno){
      int cnt = 0; 
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE board");
        sql.append(" SET good=good+1 ");
        sql.append(" WHERE postno=?"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);        
        cnt = pstmt.executeUpdate();

      } catch (Exception e) {
        System.out.println("좋아요 실패"+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//gupdate() end 
    
    //싫어요 증가
    public int bupdate(int postno){
      int cnt = 0; 
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE board");
        sql.append(" SET bad=bad+1 ");
        sql.append(" WHERE postno=?"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);        
        cnt = pstmt.executeUpdate();

      } catch (Exception e) {
        System.out.println("싫어요 실패"+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//bupdate() end 
}