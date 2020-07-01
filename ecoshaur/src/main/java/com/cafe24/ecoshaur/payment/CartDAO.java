package com.cafe24.ecoshaur.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.payment.CartDTO;



import com.cafe24.ecoshaur.category.RentalDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class CartDAO {
    @Autowired
    private DBOpen dbopen=null;  
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null; 
    ArrayList<RentalDTO> list = null;
    
    public CartDAO() {
    	dbopen=new DBOpen();
    }
    
    public ArrayList<CartDTO> list(String id){
    	 ArrayList<CartDTO> list=null;
		  try {
			  con=dbopen.getConnection();
			  sql=new StringBuilder();
			  sql.append(" SELECT cart_no, id, product_no, quantity, rental_period, receipt_date, cart_date, total_price");
			  sql.append(" FROM Cart");
			  sql.append(" WHERE id= ? ");
			  sql.append(" ORDER BY Cart_no DESC");
			  
			  pstmt=con.prepareStatement(sql.toString());
			  pstmt.setString(1, id);
			  rs=pstmt.executeQuery();
			  if(rs.next()){
				  list = new ArrayList<CartDTO>(); 
			        do {
			          CartDTO dto=new CartDTO();
			          dto = new CartDTO();
			          dto.setCart_no(rs.getInt("cart_no"));
			          dto.setId(rs.getString("id"));
			          dto.setProduct_no(rs.getString("product_no"));
			          dto.setQuantity(rs.getInt("quantity"));
			          dto.setRental_period(rs.getString("rental_period"));
			          dto.setReceipt_date(rs.getString("receipt_date"));
			          dto.setCart_date(rs.getString("cart_date"));
			          dto.setTotal_price(rs.getInt("total_price"));
			          list.add(dto);
			        } while(rs.next());
			      }else{
			        list = null;
			      }//if end
		  }catch(Exception e) {
			  System.out.println("목록 확인 실패:" +e);
		  }finally {
			  DBClose.close(con,pstmt,rs);
		  }
		  return list;
    } //list end

 // 총금액 가져오기
    public ArrayList<CartDTO> get_total_price(String id) {
      ArrayList<CartDTO> list=null;
      try {
        con=dbopen.getConnection();
        sql=new StringBuilder();
        sql.append(" SELECT total_price, cart_date ");
        sql.append(" FROM Cart");
        sql.append(" WHERE id= ? ");
        sql.append(" ORDER BY product_no ");
        
        pstmt=con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        rs=pstmt.executeQuery();
        if(rs.next()){
          list = new ArrayList<CartDTO>(); 
              do {
                CartDTO dto=new CartDTO();
                dto = new CartDTO();
                dto.setTotal_price(rs.getInt("total_price"));
                dto.setCart_date(rs.getString("cart_date"));
                list.add(dto);
              } while(rs.next());
            }else{
              list = null;
            }//if end
      }catch(Exception e) {
        System.out.println("총금액 가져오기 실패:" +e);
      }finally {
        DBClose.close(con,pstmt,rs);
      }
      return list;
    } //get_total_price() end
    
    
    public RentalDTO rental_pdlist(String id) {
    	RentalDTO dto = null;
	    try {
	      con = dbopen.getConnection();
	      sql = new StringBuilder();
	      sql.append(" SELECT product_no, title, price_daily, deposit, thmb_name, id, category_code, ");
	      sql.append(" FROM rental_list A ");
        sql.append(" INNER JOIN Cart B ");
        sql.append(" ON A.product_no = B.product_no ");
        sql.append(" WHERE B.id = ? ");
        sql.append(" ORDER BY product_no ");
	      pstmt = con.prepareStatement(sql.toString());
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	      if(rs.next()) {
	        list = new ArrayList<RentalDTO>();
	        do {
  	        dto = new RentalDTO();
  	        dto.setProduct_no(rs.getString("product_no"));
  	        dto.setTitle(rs.getString("title"));
  	        dto.setPrice_daily(rs.getInt("price_daily"));
  	        dto.setDeposit(rs.getInt("deposit"));
  	        dto.setThmb_name(rs.getString("thmb_name"));
  	        dto.setId(rs.getString("id"));
  	        dto.setCategory_code(rs.getString("category_code"));
	        } while (rs.next());
	      }//if end

	    } catch (Exception e) {
	        System.out.println("대여상품목록 확인"+e);
	    } finally {
	        DBClose.close(con, pstmt, rs);
	    }//end
	    return dto;
	  }//read() end
    
    
    public int Point(String id ) {
    	int point=0;
	    try {
	      con = dbopen.getConnection();
	      sql = new StringBuilder();
	      sql.append(" SELECT SUM(point) point ");
	      sql.append(" FROM point");
	      sql.append(" WHERE id = ?"); 
	      pstmt = con.prepareStatement(sql.toString());
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	      if(rs.next()) {
	        point=rs.getInt("point");
	      }//if end

	    } catch (Exception e) {
	        System.out.println("포인트확인"+e);
	    } finally {
	        DBClose.close(con, pstmt, rs);
	    }//end
	    return point;
	  }//read() end
    
    
    
    

} // cart class  () end 
