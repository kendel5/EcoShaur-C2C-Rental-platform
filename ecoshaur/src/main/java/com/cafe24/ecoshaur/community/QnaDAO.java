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
public class QnaDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<QnaDTO> list = null;
    
    QnaDTO dto = null;
    public QnaDAO() { }
    
    public ArrayList<QnaDTO> list(int nowpage, int recordPerPage){
      try{
        QnaDTO dto = new QnaDTO();
        
        int startRow = ((nowpage-1) * recordPerPage) ;
        int endRow   = recordPerPage;
        
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT postno, head, title, contents, image_name, post_date, ");
        sql.append(" id, pcode, ccode FROM qna ");       
        sql.append(" ORDER BY pcode DESC, ccode");
        sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;       
       
        pstmt = con.prepareStatement(sql.toString());     
        rs = pstmt.executeQuery();       
        if(rs.next()){
          list = new ArrayList<QnaDTO>();
          do {
            dto = new QnaDTO();
            dto.setPostno(rs.getInt("postno"));
            dto.setHead(rs.getString("head"));
            dto.setTitle(rs.getString("title"));
            dto.setContents(rs.getString("contents"));
            dto.setImage_name(rs.getString("image_name"));
            dto.setPost_date(rs.getString("post_date"));
            dto.setId(rs.getString("id"));
            dto.setPcode(rs.getInt("pcode"));
            dto.setCcode(rs.getInt("ccode"));
            list.add(dto);
          } while(rs.next());
        }else{
          list = null;
        }

      }catch(Exception e){
         System.out.println("질문목록 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }
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
          sql.append(" SELECT count(*) as cnt FROM qna ");
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
    public QnaDTO read(int postno){
      try{
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT postno, head, title, contents, image_name, post_date, ");
        sql.append(" id, pcode, ccode FROM qna ");      
        sql.append(" WHERE postno = ?");       
        
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, postno);
        rs = pstmt.executeQuery();
        if(rs.next()){
            dto = new QnaDTO();
            dto.setPostno(rs.getInt("postno"));
            dto.setHead(rs.getString("head"));
            dto.setTitle(rs.getString("title"));
            dto.setContents(rs.getString("contents"));
            dto.setImage_name(rs.getString("image_name"));
            dto.setPost_date(rs.getString("post_date"));
            dto.setId(rs.getString("id"));
            dto.setPcode(rs.getInt("pcode"));
            dto.setCcode(rs.getInt("ccode"));
        }
      }catch(Exception e){
         System.out.println("문의목록 보기 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }
      return dto;
    }//read end  
    
    public int create(QnaDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO qna(postno, head, title, contents, image_name, post_date,id, pcode)");
        sql.append(" VALUES((select ifnull(max(postno),0)+1 from qna as TB),");
        sql.append(" ?, ?, ?, ?, now(), ?, (select ifnull(max(pcode),0)+1 from qna as TB))");
       
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getHead());
        pstmt.setString(2, dto.getTitle());
        pstmt.setString(3, dto.getContents());
        pstmt.setString(4, dto.getImage_name());
        pstmt.setString(5, dto.getId());


        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("문의사항 등록실패"+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//create() end
    
    public int Rcreate(QnaDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO qna(postno, head, title, contents, image_name, post_date,id,                                    pcode, ccode)");
        sql.append(" VALUES((select ifnull(max(postno),0)+1 from qna as TB),");
        sql.append(" ?, ?, ?, ?, now(), ?, ?,?)");
       
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getHead());
        pstmt.setString(2, dto.getTitle());
        pstmt.setString(3, dto.getContents());
        pstmt.setString(4, dto.getImage_name());
        pstmt.setString(5, dto.getId());
        pstmt.setInt(6, dto.getPcode());
        pstmt.setInt(7, dto.getCcode());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("답변등록 실패"+e);
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
        sql.append(" DELETE FROM qna");
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
}
