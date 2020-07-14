package com.cafe24.ecoshaur.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.payment.CartDTO;
import com.cafe24.ecoshaur.payment.RentalDTO;
import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.Utility;

@Component
public class CartDAO {
    @Autowired
    private DBOpen dbopen=null;
    private DBClose dbclose=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null; 
    
    public CartDAO() {
    	dbopen=new DBOpen();
    }
    //페이징
    public ArrayList<CartDTO> list(String id, int nowpage, int recordPerPage){
      int startRow = ((nowpage-1) * recordPerPage) ;
      int endRow   = recordPerPage;
      
    	 ArrayList<CartDTO> list=null;
		  try {
			  con=dbopen.getConnection();
			  sql=new StringBuilder();
			  sql.append(" SELECT cart_no, id, product_no, quantity, rental_period, receipt_date, cart_date, total_price");
			  sql.append(" FROM Cart");
			  sql.append(" WHERE id= ? ");
			  sql.append(" ORDER BY Cart_no DESC");
			  sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;
			  
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
    
    //페이징
    public ArrayList<RentalDTO> rental_pdlist(String id, int nowpage, int recordPerPage) {
      int startRow = ((nowpage-1) * recordPerPage) ;
      int endRow   = recordPerPage;
      
    	RentalDTO dto = null;
    	ArrayList<RentalDTO> list=null;
	    try {
	      con = dbopen.getConnection();
	      sql = new StringBuilder();
	      sql.append(" SELECT A.product_no product_no, A.title title, A.price_daily price_daily, A.deposit deposit, A.thmb_name thmb_name, A.id id, A.category_code category_code ");
	      sql.append(" FROM rental_list A ");
        sql.append(" INNER JOIN Cart B ");
        sql.append(" ON A.product_no = B.product_no ");
        sql.append(" WHERE B.id = ? ");
        sql.append(" ORDER BY A.product_no ");
        sql.append(" LIMIT " + startRow + " , " + endRow + " ") ;
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
  	        list.add(dto);
	        } while (rs.next());
	      }//if end

	    } catch (Exception e) {
	        System.out.println("대여상품목록 확인"+e);
	    } finally {
	        DBClose.close(con, pstmt, rs);
	    }//end
	    return list;
	  }//read() end
    
    // 페이징X 목록
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
    
    // 페이징X 목록
    public ArrayList<RentalDTO> rental_pdlist(String id) {
      
      RentalDTO dto = null;
      ArrayList<RentalDTO> list=null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT A.product_no product_no, A.title title, A.price_daily price_daily, A.deposit deposit, A.thmb_name thmb_name, A.id id, A.category_code category_code ");
        sql.append(" FROM rental_list A ");
        sql.append(" INNER JOIN Cart B ");
        sql.append(" ON A.product_no = B.product_no ");
        sql.append(" WHERE B.id = ? ");
        sql.append(" ORDER BY A.product_no ");
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
            list.add(dto);
          } while (rs.next());
        }//if end

      } catch (Exception e) {
          System.out.println("대여상품목록 확인"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return list;
    }//read() end
    
 // 목록 최대 페이징 수
    public int count(String id) {
      int count=0;
      try {
        // DB연결
        con = dbopen.getConnection();
        
        //4)SQL문 작성
          sql=new StringBuilder();
          sql.append(" SELECT count(*) as cnt FROM cart ");
          sql.append(" WHERE id=? ");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, id);
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
    
    public int total_price(String id) {
      int point=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT SUM(total_price) total_price ");
        sql.append(" FROM cart ");
        sql.append(" WHERE id = ? "); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()) {
          point=rs.getInt("total_price");
        }//if end

      } catch (Exception e) {
          System.out.println("총금액 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return point;
    }//read() end
    
    // 포인트 증감
    public int pointUpdate(String id, PointDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO point(NO, id, point, date) ");
        sql.append(" VALUES((SELECT ifnull(max(NO),0)+1 FROM point as TB), ?, ?, now()) ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        pstmt.setInt(2, dto.getPoint());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("포인트 증감실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }
    
    // 대여자 연락처 가져오기
    public int get_tel(String id) {
      int point=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT SUM(total_price) tp ");
        sql.append(" FROM cart ");
        sql.append(" WHERE id = ? "); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()) {
          point=rs.getInt("tp");
        }//if end

      } catch (Exception e) {
          System.out.println("총금액 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return point;
    }
    
 // 장바구니 갯수 가져오기
    public int get_cartCnt(String id) {
      int point=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT COUNT(cart_no) no ");
        sql.append(" FROM cart ");
        sql.append(" WHERE id = ? "); 
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()) {
          point=rs.getInt("no");
        }//if end

      } catch (Exception e) {
          System.out.println("총금액 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return point;
    }
    
    
  // 주문서번호 max값 가져오기
    public int OMax_code() {
      int num = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT ORDER_NO ");
        sql.append(" FROM ORDER_SHEET ");
        sql.append(" order by ORDER_NO desc ");
        sql.append(" LIMIT 1 ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          num = rs.getInt("ORDER_NO");
        }
      } catch (Exception e) {
        System.out.println("max값 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return num;
    } 
    
 // 주문서 입력
    public int order_create(OrderDTO dto, String cid, int total_price, int number, int cartcnt) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO ORDER_SHEET(ORDER_NO, PAYMENT_PRICE, ID, RECIPIENT, DELIVERY_METHOD, ADDRESS, ADDRESS_R, TEL) ");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?) ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, number);
        pstmt.setInt(2, total_price);
        pstmt.setString(3, cid);
        pstmt.setString(4, dto.getRecipient());
        pstmt.setString(5, dto.getDelivery_method());
        pstmt.setString(6, dto.getAddress());
        pstmt.setString(7, dto.getAddress_R());
        pstmt.setString(8, dto.getTel());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("주문서 작성 실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }
    
 // 주문내역서 입력
    public int orderhistory_create(OrderHistoryDTO ohdto, String cid, int total_price, int number, ArrayList<CartDTO> cdto, ArrayList<RentalDTO> rdto) {
      int cnt = 0;
      try {
        for(int i=0;i<cdto.size();i++) {
          con = dbopen.getConnection();
          sql = new StringBuilder();
          sql.append(" INSERT INTO Order_History(ORDER_DETAIL_NO, order_no, product_no, quantity, total_price, payment, credit_card, card_num, payment_date, Order_condition, deposit) ");
          sql.append(" VALUES((SELECT ifnull(max(ORDER_DETAIL_NO),0)+1 FROM Order_History as TB), ?, ?, ?, ?, ?, ?, ?, now(), 'P', ?) ");
          pstmt = con.prepareStatement(sql.toString());
          pstmt.setInt(1, number);
          pstmt.setString(2, cdto.get(i).getProduct_no());
          pstmt.setInt(3, cdto.get(i).getQuantity());
          pstmt.setInt(4, total_price);
          pstmt.setString(5, ohdto.getPayment());
          pstmt.setString(6, ohdto.getCredit_card());
          pstmt.setString(7, ohdto.getCard_num());
          pstmt.setInt(8, rdto.get(i).getDeposit());
          cnt = pstmt.executeUpdate();
          if(cnt == 0) {
            break;
          }
        }
      } catch (Exception e) {
        System.out.println("주문내역서 작성 실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }
    
    
    //삭제
    public int cart_del(String id) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" DELETE from cart ");
        sql.append(" WHERE id = ? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("장바구니 삭제실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }// delete() end

    
    // 장바구니 추가
    public int create(CartDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO cart(cart_no, id, product_no, quantity, rental_period, receipt_date, cart_date, total_price) ");
        sql.append(" VALUES((SELECT ifnull(max(cart_no),0)+1 FROM cart as TB), ?, ?, ?, ?, ?, now(), ?) ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getId());
        pstmt.setString(2, dto.getProduct_no());
        pstmt.setInt(3, dto.getQuantity());
        pstmt.setString(4, dto.getRental_period());
        pstmt.setString(5, dto.getReceipt_date());
        pstmt.setInt(6, dto.getTotal_price());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("장바구니 추가 실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }
    
    
  //장바구니 삭제
    public int delete(int no) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" DELETE FROM CART ");
        sql.append(" WHERE cart_no=? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setInt(1, no);
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("장바구니삭제실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }// delete() end
    
    //장바구니 총금액
    public int total(String id) {
      int total = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT SUM(TOTAL_PRICE) price FROM CART ");
        sql.append(" WHERE id=? ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()) {
          total=rs.getInt("price");
        }//if end
      } catch (Exception e) {
        System.out.println("장바구니 총금액 가져오기 실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return total;
    }// delete() end
    
} // cart class  () end 
