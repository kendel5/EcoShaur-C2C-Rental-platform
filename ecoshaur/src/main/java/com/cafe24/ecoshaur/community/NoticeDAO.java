package com.cafe24.ecoshaur.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class NoticeDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<NoticeDTO> list = null;
     
    NoticeDTO dto = null;

    public NoticeDAO() { }

    public ArrayList<NoticeDTO> list(){
      try{
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT postno, head, title, contents, image_name, image_size, post_date, view ");
        sql.append(" FROM notice");       
        sql.append(" ORDER BY head DESC, postno DESC");
        
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if(rs.next()){
          list = new ArrayList<NoticeDTO>();
          do {
            dto = new NoticeDTO();
            dto.setPostno(rs.getInt("postno"));
            dto.setHead(rs.getString("head"));
            dto.setTitle(rs.getString("title"));
            dto.setPost_date(rs.getString("post_date"));
            dto.setView(rs.getInt("view"));
            list.add(dto);
          } while(rs.next());
        }else{
          list = null;
        }

      }catch(Exception e){
         System.out.println("공지사항 목록 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }
      return list;
    }//list() end
    
    public NoticeDTO read(int postno){
      try{
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT postno, head, title, contents, image_name, image_size, post_date, view ");
        sql.append(" FROM notice");       
        sql.append(" WHERE postno = ?");       
        
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);
        rs = pstmt.executeQuery();
        if(rs.next()){
            dto = new NoticeDTO();
            dto.setPostno(rs.getInt("postno"));
            dto.setHead(rs.getString("head"));
            dto.setTitle(rs.getString("title"));
            dto.setContents(rs.getString("contents"));
            dto.setImage_name(rs.getString("image_name"));
            dto.setImage_size(rs.getLong("image_size"));
            dto.setPost_date(rs.getString("post_date"));
            dto.setView(rs.getInt("view"));
        }
      }catch(Exception e){
         System.out.println("공지사항 보기 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }
      return dto;
    }//read end  
    
    public int create(NoticeDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO notice(postno, head, title, contents, image_name, image_size, post_date, view)");
        sql.append(" VALUES((select ifnull(max(postno),0)+1 from notice as TB),");
        sql.append(" ?, ?, ?, ?, ?, now(), ?)");
       
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getHead());
        pstmt.setString(2, dto.getTitle());
        pstmt.setString(3, dto.getContents());
        pstmt.setString(4, dto.getImage_name());
        pstmt.setLong(5, dto.getImage_size());
        pstmt.setInt(6, dto.getView());

        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("공지사항 등록실패"+e);
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
        sql.append(" DELETE FROM notice");
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
    
    public int update(NoticeDTO dto) {
      int cnt = 0; 
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE notice");
        sql.append(" SET title=?, contents=?, image_name=?, head=?");
        sql.append(" WHERE postno=?"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getTitle());
        pstmt.setString(2, dto.getContents());
        pstmt.setString(3, dto.getImage_name());
        pstmt.setString(4, dto.getHead());
        pstmt.setInt(5, dto.getPostno());
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
        sql.append(" UPDATE notice");
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
}
