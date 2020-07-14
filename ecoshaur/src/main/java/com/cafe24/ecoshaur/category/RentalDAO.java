package com.cafe24.ecoshaur.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.category.RentalDTO;

import com.cafe24.ecoshaur.category.CategoryDTO;
import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.Utility;

@Component



public class RentalDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<RentalDTO> list = null;
    ArrayList<CategoryDTO> category_list = null;
    public RentalDAO() { }

  //목록
    public ArrayList<RentalDTO> list(int nowpage, int recordPerPage) {
      try {
        RentalDTO dto = new RentalDTO();
        int startRow = ((nowpage-1) * recordPerPage) ;
        int endRow   = recordPerPage;
        
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT product_no, title, sub_title, product_name, price_daily, deposit, total_quantity, remaining_quantity, thmb_name, id ");
        sql.append(" FROM RENTAL_LIST ");
        sql.append(" WHERE availability='Y' ");
        sql.append(" ORDER BY product_no DESC ");
        sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<RentalDTO>();
          do {
            dto = new RentalDTO();
            dto.setProduct_no(rs.getString("product_no"));
            dto.setTitle(rs.getString("title").trim());
            dto.setSub_title(rs.getString("sub_title").trim());
            dto.setProduct_name(rs.getString("product_name").trim());
            dto.setPrice_daily(rs.getInt("price_daily"));
            dto.setDeposit(rs.getInt("deposit"));
            dto.setTotal_quantity(rs.getInt("total_quantity"));
            dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
            dto.setThmb_name(rs.getString("thmb_name").trim());
            dto.setId(rs.getString("id").trim());
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("Category목록 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }
    
    // 목록 최대 페이징 수
    public int count() {
      int count=0;
      try {
        // DB연결
        con = dbopen.getConnection();
        
        //4)SQL문 작성
          sql=new StringBuilder();
          sql.append(" SELECT count(*) as cnt FROM Rental_list ");
          sql.append(" WHERE availability='Y' ");
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
    
 // 세부목록 최대 페이징 수
    public int countDT(String category) {
      int count=0;
      try {
        // DB연결
        con = dbopen.getConnection();
        
        //4)SQL문 작성
          sql=new StringBuilder();
          sql.append(" SELECT count(*) as cnt ");
          sql.append(" FROM RENTAL_LIST A ");
          sql.append(" INNER JOIN RENTAL_CATEGORY B ");
          sql.append(" ON A.Category_code = B.code ");
          if(category.equals("컴퓨터"))
            sql.append(" WHERE availability='Y' and B.major = '컴퓨터' ");
          else if(category.equals("TV/영상가전"))
            sql.append(" WHERE availability='Y' and B.major = 'TV/영상가전' ");
          else if(category.equals("음향기기"))
            sql.append(" WHERE availability='Y' and B.major = '음향기기' ");
          else if(category.equals("콘솔/게이밍"))
            sql.append(" WHERE availability='Y' and B.major = '콘솔/게이밍' ");
          else
            sql.append(" WHERE availability='Y' and B.major = '카메라' ");
          pstmt=con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
        if(rs.next()) { // cursor 가 있는지?
          count = rs.getInt("cnt");
        }else {
          System.out.println("DT행 갯수를 얻지못함!!");
        }// if end
      }catch(Exception e) {
        System.out.println(" 카운트실패:" + e);
      }finally {
        DBClose.close(con, pstmt ,rs);
      }// try end
      return count;
    } // count() end
    
 // 세부목록 최대 페이징 수
    public int countDTC(String[] category, int size) {
      int count=0;
      try {
        // DB연결
        con = dbopen.getConnection();
        
        //4)SQL문 작성
          sql=new StringBuilder();
          sql.append(" SELECT count(*) as cnt ");
          sql.append(" FROM RENTAL_LIST A ");
          sql.append(" INNER JOIN RENTAL_CATEGORY B ");
          sql.append(" ON A.Category_code = B.code ");
          sql.append(" WHERE availability='Y'");
          for(int i=0;i<size;i++) {
            sql.append(" and B.minor = '" + category[i] + "' ");
          }
          
          pstmt=con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
        if(rs.next()) { // cursor 가 있는지?
          count = rs.getInt("cnt");
        }else {
          System.out.println("DT행 갯수를 얻지못함!!");
        }// if end
      }catch(Exception e) {
        System.out.println(" 카운트실패:" + e);
      }finally {
        DBClose.close(con, pstmt ,rs);
      }// try end
      return count;
    } // count() end
    
  //세부목록
    public ArrayList<RentalDTO> listDT(String category, int nowpage, int recordPerPage) {
      try {
        RentalDTO dto = new RentalDTO();
        int startRow = ((nowpage-1) * recordPerPage) ;
        int endRow   = recordPerPage;
        
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT product_no, title, sub_title, product_name, price_daily, deposit, total_quantity, remaining_quantity, thmb_name, id ");
        sql.append(" FROM RENTAL_LIST A ");
        sql.append(" INNER JOIN RENTAL_CATEGORY B ");
        sql.append(" ON A.Category_code = B.code ");
        if(category.equals("컴퓨터"))
          sql.append(" WHERE availability='Y' and B.major = '컴퓨터' ");
        else if(category.equals("TV/영상가전"))
          sql.append(" WHERE availability='Y' and B.major = 'TV/영상가전' ");
        else if(category.equals("음향기기"))
          sql.append(" WHERE availability='Y' and B.major = '음향기기' ");
        else if(category.equals("콘솔/게이밍"))
          sql.append(" WHERE availability='Y' and B.major = '콘솔/게이밍' ");
        else
          sql.append(" WHERE availability='Y' and B.major = '카메라' ");
        sql.append(" ORDER BY product_no DESC ");
        sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<RentalDTO>();
          do {
            dto = new RentalDTO();
            dto.setProduct_no(rs.getString("product_no"));
            dto.setTitle(rs.getString("title").trim());
            dto.setSub_title(rs.getString("sub_title").trim());
            dto.setProduct_name(rs.getString("product_name").trim());
            dto.setPrice_daily(rs.getInt("price_daily"));
            dto.setDeposit(rs.getInt("deposit"));
            dto.setTotal_quantity(rs.getInt("total_quantity"));
            dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
            dto.setThmb_name(rs.getString("thmb_name").trim());
            dto.setId(rs.getString("id").trim());
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end

      } catch (Exception e) {
        System.out.println("Category세부목록 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }
    
    
    
    
    //카테고리 명(대분류 가져오면 소분류리스트 가져오기)
    public ArrayList<CategoryDTO> category(String category) {
      try {
        CategoryDTO dto = new CategoryDTO();
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT major, minor, code ");
        sql.append(" FROM RENTAL_CATEGORY ");
        if(category.equals("컴퓨터"))
          sql.append(" WHERE major = '컴퓨터' ");
        else if(category.equals("TV/영상가전"))
          sql.append(" WHERE major = 'TV/영상가전' ");
        else if(category.equals("음향기기"))
          sql.append(" WHERE major = '음향기기' ");
        else if(category.equals("콘솔/게이밍"))
          sql.append(" WHERE major = '콘솔/게이밍' ");
        else
          sql.append(" WHERE major = '카메라' ");
        sql.append(" ORDER BY major ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          category_list = new ArrayList<CategoryDTO>();
          do {
            dto = new CategoryDTO();
            dto.setMajor(rs.getString("major").trim());
            dto.setMinor(rs.getString("minor").trim());
            dto.setCode(rs.getString("code").trim());
            category_list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end

      } catch (Exception e) {
        System.out.println("Category세부목록 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return category_list;
    }
    
    
    
    
    
    
    //선택카테고리 가져오기(대분류 가져오면 해당하는 상품들 리스트 가져오기)
    public ArrayList<RentalDTO> select_listDT(String[] category, int size,  int nowpage, int recordPerPage) {
      int startRow = ((nowpage-1) * recordPerPage) ;
      int endRow   = recordPerPage;
      
      try {
        RentalDTO dto = new RentalDTO();
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT product_no, title, sub_title, product_name, price_daily, deposit, total_quantity, remaining_quantity, thmb_name, id ");
        sql.append(" FROM RENTAL_LIST A ");
        sql.append(" INNER JOIN RENTAL_CATEGORY B ");
        sql.append(" ON A.Category_code = B.code ");
        sql.append(" WHERE availability='Y'");
        for(int i=0;i<size;i++) {
          sql.append(" and B.minor = '" + category[i] + "' ");
        }
        sql.append(" ORDER BY product_no DESC ");
        sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;
        
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<RentalDTO>();
          do {
            dto = new RentalDTO();
            dto.setProduct_no(rs.getString("product_no"));
            dto.setTitle(rs.getString("title").trim());
            dto.setSub_title(rs.getString("sub_title").trim());
            dto.setProduct_name(rs.getString("product_name").trim());
            dto.setPrice_daily(rs.getInt("price_daily"));
            dto.setDeposit(rs.getInt("deposit"));
            dto.setTotal_quantity(rs.getInt("total_quantity"));
            dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
            dto.setThmb_name(rs.getString("thmb_name").trim()); 
            dto.setId(rs.getString("id").trim());
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end

      } catch (Exception e) {
        System.out.println("Category세부목록 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }
   
    
    // 소분류 가져오기(리스트가져오기)
    public ArrayList<CategoryDTO> MNcategory() {
      try {
        CategoryDTO dto = new CategoryDTO();
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT minor ");
        sql.append(" FROM RENTAL_CATEGORY ");
        sql.append(" ORDER BY minor ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          category_list = new ArrayList<CategoryDTO>();
          do {
            dto = new CategoryDTO();
            dto.setMinor(rs.getString("minor").trim());
            category_list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end

      } catch (Exception e) {
        System.out.println("Category세부목록 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return category_list;
    }

    
 // 카테고리 소분류로 코드 가져오기
    public String category_code(String minor) {
      String code = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT code ");
        sql.append(" FROM RENTAL_CATEGORY ");
        sql.append(" WHERE minor = ? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, minor);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          code = rs.getString("code");
        }
      } catch (Exception e) {
        System.out.println("코드가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return code;
    } 
    
    // 카테고리 코드 가져오기
    public String rental_code(String product_no) {
      String code = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT category_code ");
        sql.append(" FROM RENTAL_LIST ");
        sql.append(" WHERE product_no = ? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, product_no);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          code = rs.getString("category_code");
        }
      } catch (Exception e) {
        System.out.println("카테고리 코드가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return code;
    } 
    
    // 카테고리 코드로 소분류 가져오기
    public String category_minor(String code) {
      String minor = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT minor ");
        sql.append(" FROM RENTAL_CATEGORY ");
        sql.append(" WHERE code = ? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, code);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          minor = rs.getString("minor");
        }
      } catch (Exception e) {
        System.out.println("소분류가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return minor;
    } 
    
    //해당 소분류의 코드번호 max가져오기
    public String Max_code(String code) {
      String num = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT product_no ");
        sql.append(" FROM RENTAL_LIST ");
        sql.append(" WHERE CATEGORY_CODE = ? ");
        sql.append(" ORDER BY product_no ");
        sql.append(" LIMIT 1 ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, code);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          num = rs.getString("product_no");
        }else {
          num="000-00-000000";
        }
      } catch (Exception e) {
        System.out.println("max코드가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return num;
    } 
    
    
    // 상품등록
    public int create(RentalDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO RENTAL_LIST(product_no, product_name, title, sub_title, description, price_daily, "
                  + "deposit, total_quantity, remaining_quantity, thmb_name, thmb_size, image_name, image_size, reg_date, id, category_code, availability) ");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, ?, 'Y') ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getProduct_no());
        pstmt.setString(2, dto.getProduct_name());
        pstmt.setString(3, dto.getTitle());
        pstmt.setString(4, dto.getSub_title());
        pstmt.setString(5, dto.getDescription());
        pstmt.setInt(6, dto.getPrice_daily());
        pstmt.setInt(7, dto.getDeposit());
        pstmt.setInt(8, dto.getTotal_quantity());
        pstmt.setInt(9, dto.getTotal_quantity());
        pstmt.setString(10, dto.getThmb_name());
        pstmt.setLong(11, dto.getThmb_size());
        pstmt.setString(12, dto.getImage_name());
        pstmt.setLong(13, dto.getImage_size());
        pstmt.setString(14, dto.getId());
        pstmt.setString(15, dto.getCategory_code());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("상품등록실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }

    
    
 // 상품상세보기에서 좋아요 수 가져오기
    public int Rental_good(String no) {
      int count = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT count(no) count ");
        sql.append(" FROM RATING ");
        sql.append(" WHERE (NO = ?) and (EVALUATION = 'Good') ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, no);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          count = rs.getInt("count");
        }
      } catch (Exception e) {
        System.out.println("좋아요 수 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return count;
    } 
    
    // 상품상세보기에서 싫어요 수 가져오기
    public int Rental_bad(String no) {
      int count = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT count(no) count ");
        sql.append(" FROM RATING ");
        sql.append(" WHERE (no = ?) and (Evaluation = 'Bad') ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, no);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          count = rs.getInt("count");
        }
      } catch (Exception e) {
        System.out.println("싫어요 수 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return count;
    } 
    
    
    //상세보기
    public RentalDTO Read(String product_no) {
      RentalDTO dto = new RentalDTO();
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT product_no, title, sub_title, description, product_name, price_daily, deposit, total_quantity, remaining_quantity, thmb_name, image_name, category_code, id ");
        sql.append(" FROM RENTAL_LIST ");
        sql.append(" WHERE product_no = ? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, product_no);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          dto.setProduct_no(rs.getString("product_no"));
          dto.setTitle(rs.getString("title"));
          dto.setSub_title(rs.getString("sub_title"));
          dto.setDescription(rs.getString("description"));
          dto.setProduct_name(rs.getString("product_name"));
          dto.setPrice_daily(rs.getInt("price_daily"));
          dto.setDeposit(rs.getInt("deposit"));
          dto.setTotal_quantity(rs.getInt("total_quantity"));
          dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
          dto.setThmb_name(rs.getString("thmb_name"));
          dto.setImage_name(rs.getString("image_name"));
          dto.setCategory_code(rs.getString("category_code"));
          dto.setId(rs.getString("id"));
        }
      } catch (Exception e) {
        System.out.println("상세보기 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return dto;
    } 
    
  //수정
    public int update(RentalDTO dto, String saveDirectory) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE rental_list ");
        sql.append(" set product_name=?, title=?, sub_title=?, description=?, deposit=?, total_quantity=?, remaining_quantity=?, thmb_name=?, image_name=?, id=?, category_code=? ");
        sql.append(" WHERE product_no=? ");
        pstmt = con.prepareStatement(sql.toString());

        pstmt.setString(1, dto.getProduct_name());
        pstmt.setString(2, dto.getTitle());
        pstmt.setString(3, dto.getSub_title());
        pstmt.setString(4, dto.getDescription());
        pstmt.setInt(5, dto.getDeposit());
        pstmt.setInt(6, dto.getTotal_quantity());
        pstmt.setInt(7, dto.getTotal_quantity());
        pstmt.setString(8, dto.getThmb_name());
        pstmt.setString(9, dto.getImage_name());
        pstmt.setString(10, dto.getId());
        pstmt.setString(11, dto.getCategory_code());
        pstmt.setString(12, dto.getProduct_no());

        cnt = pstmt.executeUpdate();
        if(cnt==1) {
          Utility.deleteFile(saveDirectory, dto.getThmb_name());
          Utility.deleteFile(saveDirectory, dto.getImage_name());
        }
      } catch (Exception e) {
        System.out.println("상품 수정실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }// update() end

    //삭제
    public int delete(String product_no, String saveDirectory, String thum, String image) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" DELETE FROM rental_list ");
        sql.append(" WHERE product_no=? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, product_no);
        cnt = pstmt.executeUpdate();
        if(cnt==1) {
          Utility.deleteFile(saveDirectory, thum);
          Utility.deleteFile(saveDirectory, image);
        }
      } catch (Exception e) {
        System.out.println("상품삭제실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }// delete() end
    
    
    
    
    
}
