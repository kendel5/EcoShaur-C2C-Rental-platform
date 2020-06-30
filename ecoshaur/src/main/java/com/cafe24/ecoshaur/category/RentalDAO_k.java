package com.cafe24.ecoshaur.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.category.RentalDTO;

import kr.co.mymelon.media.MediaDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

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

    public RentalDAO() { }
    
    public ArrayList<RentalDTO> list(RentalDTO dto){
      try{
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT Product_No, Title, Sub-title, Product_name, Description, Price_daily, Deposit, Total_quantity, Remaining_quantity, thmb_name thmb_size, Image_name, Image_size, RegDate ID, Category_code ");
        sql.append(" FROM Rental_list ");
        sql.append(" WHERE availability='Y' AND category_code = ?");
        sql.append(" ORDER BY Product_No DESC");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getCategory_code());
        rs = pstmt.executeQuery();
        if(rs.next()){
          list = new ArrayList<RentalDTO>();
          do {
            dto = new RentalDTO();
            dto.setProduct_no(rs.getString("product_no"));
            dto.setProduct_name(rs.getString("product_name"));
            dto.setTitle(rs.getString("title"));
            dto.setSub_title(rs.getString("sub_title"));
            dto.setDescription(rs.getString("description"));
            dto.setPrice_daily(rs.getString("price_daily"));
            dto.setDeposit(rs.getInt("deposit"));
            dto.setTotal_quantity(rs.getInt("total_quantity"));
            dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
            dto.setThmb_name(rs.getString("thmb_name"));
            dto.setThmb_size(rs.getInt("thmb_size"));
            dto.setImage_name(rs.getString("image_name"));
            dto.setImage_size(rs.getLong("image_size"));
            dto.setReg_date(rs.getString("reg_date"));
            dto.setId(rs.getString("id"));
            dto.setCategory_code(rs.getString("category_code"));

            
            list.add(dto);
          } while(rs.next());
        }else{
          list = null;
        }//if end

      }catch(Exception e){
         System.out.println("Rental 목록 실패:"+e);
      }finally{
         DBClose.close(con, pstmt, rs);
      }//end
      return list;
    }//list() end
    
    
    public int register(RentalDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO Rental(Product_No, Title, Sub-title, Product_name, Description, Price_daily, Deposit, Total_quantity, thmb_name thmb_size, Image_name, Image_size, RegDate ID, Category_code ");
        sql.append(" VALUES((SELECT NVL(MAX(Product_No), 0)+1 as Product_No FROM Rental_list), ?, sysdate, ?, ?, ?, ?)"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getProduct_no());
        pstmt.setString(2, dto.getProduct_name());
        pstmt.setString(3, dto.getTitle());
        pstmt.setString(4, dto.getSub_title());
        pstmt.setString(5, dto.getDescription());
        pstmt.setString(6, dto.getPrice_daily());
        pstmt.setInt(7, dto.getDeposit());
        pstmt.setInt(8, dto.getTotal_quantity());
        pstmt.setString(9, dto.getThmb_name());
        pstmt.setLong(10, dto.getThmb_size());
        pstmt.setString(11, dto.getImage_name());
        pstmt.setLong(12, dto.getImage_size());
        pstmt.setString(13, dto.getReg_date());
        pstmt.setString(14, dto.getId());
        pstmt.setString(15, dto.getCategory_code());
        
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("기기 등록 실패: "+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//register() end 
    
    
    public RentalDTO read(int Product_No) {
      RentalDTO dto = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT Product_No, Title, Sub-title, Product_name, Description, Price_daily, Deposit, Total_quantity, Remaining_quantity, thmb_name thmb_size, Image_name, Image_size, RegDate ID, Category_code ");
        sql.append(" FROM Rental_list ");
        sql.append(" WHERE Product_No = ?"); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, Product_No);
        rs = pstmt.executeQuery();
        if(rs.next()) {
          dto = new RentalDTO();
          dto.setProduct_no(rs.getString("product_no"));
          dto.setProduct_name(rs.getString("product_name"));
          dto.setTitle(rs.getString("title"));
          dto.setSub_title(rs.getString("sub_title"));
          dto.setDescription(rs.getString("description"));
          dto.setPrice_daily(rs.getString("price_daily"));
          dto.setDeposit(rs.getInt("deposit"));
          dto.setTotal_quantity(rs.getInt("total_quantity"));
          dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
          dto.setThmb_name(rs.getString("thmb_name"));
          dto.setThmb_size(rs.getInt("thmb_size"));
          dto.setImage_name(rs.getString("image_name"));
          dto.setImage_size(rs.getLong("image_size"));
          dto.setReg_date(rs.getString("reg_date"));
          dto.setId(rs.getString("id"));
          dto.setCategory_code(rs.getString("category_code"));
        }//if end

      } catch (Exception e) {
          System.out.println("상세 보기 실패: "+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return dto;
    }//read() end
    
    
    public int delete(String product_no) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" DELETE FROM RENTAL_LIST ");
        sql.append(" WHERE Product_No =? ");  
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, product_no);
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("삭제 실패: "+e);
      } finally {
          dbclose.close(con, pstmt);
      }//end
      return cnt;
    }//delete() end
    
    
    public int update(RentalDTO dto) {
      int cnt = 0; 

      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" UPDATE RNETAL_LIST ");
        sql.append(" SET Category_code =?, product_name=?, title=?, sub_title=?, Description=?, Price_daily=?, Deposit=?, Total_quantity=?, Thmb_name=?, Thmb_size=?, Image_name=?, Image_size=? ");
        sql.append(" WHERE Product_No =? "); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getCategory_code());
        pstmt.setString(2, dto.getProduct_name());
        pstmt.setString(3, dto.getTitle());
        pstmt.setString(4, dto.getSub_title());
        pstmt.setString(5, dto.getDescription());
        pstmt.setString(6, dto.getPrice_daily());
        pstmt.setInt(7, dto.getDeposit());
        pstmt.setInt(8, dto.getTotal_quantity());
        pstmt.setString(9, dto.getThmb_name());
        pstmt.setLong(10, dto.getThmb_size());
        pstmt.setString(11, dto.getImage_name());
        pstmt.setLong(12, dto.getImage_size());
        cnt = pstmt.executeUpdate();

      } catch (Exception e) {
        System.out.println("수정 실패: "+e);
      } finally {
          dbclose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//update() end  

    
}
