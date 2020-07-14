package com.cafe24.ecoshaur.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.admin.*;

import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.Utility;

@Component



public class AdminDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    public AdminDAO() { }
    
    public int total_price() {
      int price=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT SUM(total_price) total_price ");
        sql.append(" FROM order_history ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if(rs.next()) {
          price=rs.getInt("total_price");
        }//if end

      } catch (Exception e) {
          System.out.println("총금액가져오기 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return price;
    }//read() end
    
    // 신규회원 수 
    public int new_user() {
      int cnt=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT Count(*) cnt ");
        sql.append(" FROM member ");
        sql.append(" where Joined_date = now() ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if(rs.next()) {
          cnt=rs.getInt("cnt");
        }//if end

      } catch (Exception e) {
          System.out.println("신규회원 수 가져오기 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//read() end
    
    // 오늘 방문자
    public int visitor() {
      int cnt=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT Count(*) cnt ");
        sql.append(" FROM member ");
        sql.append(" where LastDate = now() ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if(rs.next()) {
          cnt=rs.getInt("cnt");
        }//if end

      } catch (Exception e) {
          System.out.println("방문자 수 가져오기 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//read() end
    
    // 총 주문수
    public int total_order() {
      int cnt=0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT Count(*) cnt ");
        sql.append(" FROM order_history ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if(rs.next()) {
          cnt=rs.getInt("cnt");
        }//if end

      } catch (Exception e) {
          System.out.println("총 주문 수 가져오기 실패"+e);
      } finally {
          DBClose.close(con, pstmt, rs);
      }//end
      return cnt;
    }//read() end
    
    
  //상품 목록 가져오기
    public ArrayList<RentalDTO> Rental_list() {
      RentalDTO dto = new RentalDTO();
      ArrayList<RentalDTO> list = new ArrayList<RentalDTO>();
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT A.product_no, A.title, A.sub_title, A.product_name, A.price_daily, A.deposit, A.total_quantity, A.remaining_quantity, A.thmb_name, A.id ");
        sql.append(" FROM RENTAL_LIST A ");
        sql.append(" INNER JOIN order_history B ");
        sql.append(" ON A.product_no = B.product_no ");
        sql.append(" ORDER BY B.payment_date DESC ");
        sql.append(" LIMIT " + 0 + " , " + 4 + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          do {
            dto = new RentalDTO();
            dto.setProduct_no(rs.getString("product_no"));
            dto.setTitle(rs.getString("title"));
            dto.setSub_title(rs.getString("sub_title"));
            dto.setProduct_name(rs.getString("product_name"));
            dto.setPrice_daily(rs.getInt("price_daily"));
            dto.setDeposit(rs.getInt("deposit"));
            dto.setTotal_quantity(rs.getInt("total_quantity"));
            dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
            dto.setThmb_name(rs.getString("thmb_name"));
            dto.setId(rs.getString("id"));
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
    
 // 주문내역서 목록
    public ArrayList<OrderHistoryDTO> orderhistory_list() {
      OrderHistoryDTO dto = new OrderHistoryDTO();
      ArrayList<OrderHistoryDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT ORDER_DETAIL_NO, order_no, product_no, quantity, total_price, payment, credit_card, card_num, payment_date, Order_condition, deposit ");
        sql.append(" FROM ORDER_HISTORY ");
        sql.append(" ORDER BY payment_date DESC");
        sql.append(" LIMIT " + 0 + " , " + 4 + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<OrderHistoryDTO>();
          do {
            dto = new OrderHistoryDTO();
            dto.setOrder_detail_no(rs.getInt("ORDER_DETAIL_NO"));
            dto.setOrder_no(rs.getInt("order_no"));
            dto.setProduct_no(rs.getString("product_no"));
            dto.setQuantity(rs.getInt("quantity"));
            dto.setTotal_price(rs.getInt("total_price"));
            dto.setPayment(rs.getString("payment"));
            dto.setCredit_card(rs.getString("credit_card"));
            dto.setCard_num(rs.getString("card_num"));
            dto.setPayment_date(rs.getString("payment_date"));
            dto.setOrder_condition(rs.getString("Order_condition"));
            dto.setDeposit(rs.getInt("deposit"));
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
    
  //최근 주문목록 id 리스트 가져오기
    public ArrayList<OrderDTO> ID_list() {
      OrderDTO dto = new OrderDTO();
      ArrayList<OrderDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT A.id ");
        sql.append(" FROM Order_sheet A ");
        sql.append(" INNER JOIN order_history B ");
        sql.append(" ON A.order_no = B.order_no ");
        sql.append(" ORDER BY B.payment_date DESC ");
        sql.append(" LIMIT " + 0 + " , " + 4 + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<OrderDTO>();
          do {
            dto = new OrderDTO();
            dto.setId(rs.getString("id"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("최근주문목록 id목록 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }
    
//---------------------------------------------------------------------------------------
//     최근 주문목록
//----------------------------------------------------------------------------------------
  //상품 목록 가져오기
    public ArrayList<RentalDTO> Rental_list_t() {
      RentalDTO dto = new RentalDTO();
      ArrayList<RentalDTO> list = new ArrayList<RentalDTO>();
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT A.product_no, A.title, A.sub_title, A.product_name, A.price_daily, A.deposit, A.total_quantity, A.remaining_quantity, A.thmb_name, A.id ");
        sql.append(" FROM RENTAL_LIST A ");
        sql.append(" INNER JOIN order_history B ");
        sql.append(" ON A.product_no = B.product_no ");
        sql.append(" ORDER BY B.payment_date DESC ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          do {
            dto = new RentalDTO();
            dto.setProduct_no(rs.getString("product_no"));
            dto.setTitle(rs.getString("title"));
            dto.setSub_title(rs.getString("sub_title"));
            dto.setProduct_name(rs.getString("product_name"));
            dto.setPrice_daily(rs.getInt("price_daily"));
            dto.setDeposit(rs.getInt("deposit"));
            dto.setTotal_quantity(rs.getInt("total_quantity"));
            dto.setRemaining_quantity(rs.getInt("remaining_quantity"));
            dto.setThmb_name(rs.getString("thmb_name"));
            dto.setId(rs.getString("id"));
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
    
 // 주문내역서 목록
    public ArrayList<OrderHistoryDTO> orderhistory_list_t() {
      OrderHistoryDTO dto = new OrderHistoryDTO();
      ArrayList<OrderHistoryDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT ORDER_DETAIL_NO, order_no, product_no, quantity, total_price, payment, credit_card, card_num, payment_date, Order_condition, deposit ");
        sql.append(" FROM ORDER_HISTORY ");
        sql.append(" ORDER BY payment_date DESC");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<OrderHistoryDTO>();
          do {
            dto = new OrderHistoryDTO();
            dto.setOrder_detail_no(rs.getInt("ORDER_DETAIL_NO"));
            dto.setOrder_no(rs.getInt("order_no"));
            dto.setProduct_no(rs.getString("product_no"));
            dto.setQuantity(rs.getInt("quantity"));
            dto.setTotal_price(rs.getInt("total_price"));
            dto.setPayment(rs.getString("payment"));
            dto.setCredit_card(rs.getString("credit_card"));
            dto.setCard_num(rs.getString("card_num"));
            dto.setPayment_date(rs.getString("payment_date"));
            dto.setOrder_condition(rs.getString("Order_condition"));
            dto.setDeposit(rs.getInt("deposit"));
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
    
  //최근 주문목록 id 리스트 가져오기
    public ArrayList<OrderDTO> ID_list_t() {
      OrderDTO dto = new OrderDTO();
      ArrayList<OrderDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT A.id ");
        sql.append(" FROM Order_sheet A ");
        sql.append(" INNER JOIN order_history B ");
        sql.append(" ON A.order_no = B.order_no ");
        sql.append(" ORDER BY B.payment_date DESC ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<OrderDTO>();
          do {
            dto = new OrderDTO();
            dto.setId(rs.getString("id"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("최근주문목록 id목록 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }
//---------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------
    
    // top 유저포인트
    public ArrayList<PointDTO> top_point() {
      PointDTO dto = new PointDTO();
      ArrayList<PointDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT id, sum(point) point ");
        sql.append(" FROM point ");
        sql.append(" group by id ");
        sql.append(" ORDER BY point DESC ");
        sql.append(" LIMIT " + 0 + " , " + 5 + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<PointDTO>();
          do {
            dto = new PointDTO();
            dto.setId(rs.getString("id"));
            dto.setPoint(rs.getInt("point"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("포인트 순위 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
    
 // top 환불이 많은 상품의 대여자 순위(rental)
    public ArrayList<RentalDTO> topFail_rental() {
      RentalDTO dto = new RentalDTO();
      ArrayList<RentalDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" select A.id id, A.product_no product_no, count(B.order_condition) as BB from rental_list A ");
        sql.append(" inner join order_history B ");
        sql.append(" on A.product_no = B.product_no ");
        sql.append(" where B.order_condition = 'F' ");
        sql.append(" group by id ");
        sql.append(" order by BB ");
        sql.append(" LIMIT " + 0 + " , " + 5 + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<RentalDTO>();
          do {
            dto = new RentalDTO();
            dto.setId(rs.getString("id"));
            dto.setProduct_no(rs.getString("product_no"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("환불순위 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
    
    
 // top 환불이 많은 상품의 대여자 순위(count)
    public ArrayList<OrderHistoryDTO> topFail_condition() {
      OrderHistoryDTO dto = new OrderHistoryDTO();
      ArrayList<OrderHistoryDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" select count(B.order_condition) BB from rental_list A ");
        sql.append(" inner join order_history B ");
        sql.append(" on A.product_no = B.product_no ");
        sql.append(" where B.order_condition = 'F' ");
        sql.append(" group by A.id ");
        sql.append(" order by BB ");
        sql.append(" LIMIT " + 0 + " , " + 5 + " ") ;
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<OrderHistoryDTO>();
          do {
            dto = new OrderHistoryDTO();
            dto.setDeposit(rs.getInt("BB"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("환불 순위 가져오기(갯수) 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
  //---------------------------------------------------------------------------------------
  //----------------------------------------------------------------------------------------
      
      // top 유저포인트
      public ArrayList<PointDTO> top_point_t() {
        PointDTO dto = new PointDTO();
        ArrayList<PointDTO> list = null;
        try {
          con = dbopen.getConnection();
          sql = new StringBuilder();
          sql.append(" SELECT id, sum(point) point, date ");
          sql.append(" FROM point ");
          sql.append(" group by id ");
          sql.append(" ORDER BY point DESC ");
          pstmt = con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
          if (rs.next()) {
            list = new ArrayList<PointDTO>();
            do {
              dto = new PointDTO();
              dto.setId(rs.getString("id"));
              dto.setPoint(rs.getInt("point"));
              dto.setDate(rs.getString("date"));
              list.add(dto);
            } while (rs.next());
          } else {
            list = null;
          } // if end
        } catch (Exception e) {
          System.out.println("포인트 순위 가져오기 실패:" + e);
        } finally {
          DBClose.close(con, pstmt, rs);
        }
        return list;
      }//read() end
      
      
   // top 환불이 많은 상품의 대여자 순위(rental)
      public ArrayList<RentalDTO> topFail_rental_t() {
        RentalDTO dto = new RentalDTO();
        ArrayList<RentalDTO> list = null;
        try {
          con = dbopen.getConnection();
          sql = new StringBuilder();
          sql.append(" select A.id id, A.product_no product_no, count(B.order_condition) as BB from rental_list A ");
          sql.append(" inner join order_history B ");
          sql.append(" on A.product_no = B.product_no ");
          sql.append(" where B.order_condition = 'F' ");
          sql.append(" group by id ");
          sql.append(" order by BB ");
          pstmt = con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
          if (rs.next()) {
            list = new ArrayList<RentalDTO>();
            do {
              dto = new RentalDTO();
              dto.setId(rs.getString("id"));
              dto.setProduct_no(rs.getString("product_no"));
              list.add(dto);
            } while (rs.next());
          } else {
            list = null;
          } // if end
        } catch (Exception e) {
          System.out.println("환불순위 가져오기 실패:" + e);
        } finally {
          DBClose.close(con, pstmt, rs);
        }
        return list;
      }//read() end
      
      
      
   // top 환불이 많은 상품의 대여자 순위(count)
      public ArrayList<OrderHistoryDTO> topFail_condition_t() {
        OrderHistoryDTO dto = new OrderHistoryDTO();
        ArrayList<OrderHistoryDTO> list = null;
        try {
          con = dbopen.getConnection();
          sql = new StringBuilder();
          sql.append(" select count(B.order_condition) BB from rental_list A ");
          sql.append(" inner join order_history B ");
          sql.append(" on A.product_no = B.product_no ");
          sql.append(" where B.order_condition = 'F' ");
          sql.append(" group by A.id ");
          sql.append(" order by BB ");
          pstmt = con.prepareStatement(sql.toString());
          rs = pstmt.executeQuery();
          if (rs.next()) {
            list = new ArrayList<OrderHistoryDTO>();
            do {
              dto = new OrderHistoryDTO();
              dto.setDeposit(rs.getInt("BB"));
              list.add(dto);
            } while (rs.next());
          } else {
            list = null;
          } // if end
        } catch (Exception e) {
          System.out.println("환불 순위 가져오기(갯수) 실패:" + e);
        } finally {
          DBClose.close(con, pstmt, rs);
        }
        return list;
      }//read() end
//------------------------------------------------------------------------------------------------
  //세부목록
    public String[][] Category_info() {
      String[][] list = new String[5][8];
      try {   
        // 카테고리명, 상품게시글 갯수, 평균 상품금액, 총 상품금액, 평균 보증금, 총 보증금
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" select major, count(product_no) as cnt_no, cast(ifnull(avg(price_daily),0) AS signed integer) as avg_price, "
                  +" cast(ifnull(sum(price_daily),0) AS signed integer) as sum_price, cast(ifnull(avg(Deposit),0) AS signed integer) as avg_dep, cast(ifnull(sum(Deposit),0) AS signed integer) as sum_dep ");
        sql.append(" from rental_list as A ");
        sql.append(" right join rental_category as B ");
        sql.append(" on A.category_code = B.code ");
        sql.append(" group by B.major ");
        sql.append(" order by B.major ");
        
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          int count=0;
          do {
            list[count][0] = rs.getString("major");
            list[count][1] = rs.getString("cnt_no");
            list[count][2] = rs.getString("avg_price");
            list[count][3] = rs.getString("sum_price");
            list[count][4] = rs.getString("avg_dep");
            list[count][5] = rs.getString("sum_dep");
            count++;
          } while (rs.next());
        } else {
          list = null;
        } // if end
        
        // 카테고리별 평균 거래금액, 총 거래금액
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" select cast(ifnull(avg(total_price),0) AS signed integer) as avg_order, cast(ifnull(sum(total_price),0) AS signed integer) as sum_order ");
        sql.append(" from order_history as A ");
        sql.append(" inner join rental_list as B ");
        sql.append(" on A.product_no = B.product_no ");
        sql.append(" right join rental_category as C ");
        sql.append(" on B.category_code = C.code ");
        sql.append(" group by C.major ");
        sql.append(" order by C.major ");
        
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          int count=0;
          do {
            list[count][6] = rs.getString("avg_order");
            list[count][7] = rs.getString("sum_order");
            count++;
          } while (rs.next());
        } else {
          list = null;
        } // if end
      }catch (Exception e) {
        System.out.println("카테고리별 요약목록가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
    
 // 회원목록 리스트
    public ArrayList<MemberDTO> member_list() {
      MemberDTO dto = new MemberDTO();
      ArrayList<MemberDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" select id, mem_name, pw, birth, contact_number, email, zip, address, address_r, grade, joined_date, lastdate, pro_name ");
        sql.append(" from member ");
        sql.append(" order by id ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<MemberDTO>();
          do {
            dto = new MemberDTO();
            dto.setId(rs.getString("id"));
            dto.setMem_name(rs.getString("mem_name"));
            dto.setPw(rs.getString("pw"));
            dto.setBirth(rs.getString("birth"));
            dto.setContact_number(rs.getString("contact_number"));
            dto.setEmail(rs.getString("email"));
            dto.setZip(rs.getString("zip"));
            dto.setAddress(rs.getString("address"));
            dto.setAddress_r(rs.getString("address_r"));
            dto.setGrade(rs.getString("grade"));
            dto.setJoined_date(rs.getString("joined_date"));
            dto.setLastdate(rs.getString("lastdate"));
            dto.setPro_name(rs.getString("pro_name"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("회원목록 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
  //회원정보 수정
    public int member_update(MemberDTO dto){
        int cnt = 0;
        try{
          con = dbopen.getConnection();
          sql = new StringBuilder();
          sql.append(" UPDATE member");
          sql.append(" SET mem_name=?, id=?, pw=?, birth=?, contact_number=?, email=?, zip=?, address=?, address_r=?, lastdate=?, pro_name=?, joined_date=?");
          sql.append(" WHERE id = ?");
          pstmt = con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getMem_name());
          pstmt.setString(2, dto.getId());
          pstmt.setString(3, dto.getPw());
          pstmt.setString(4, dto.getBirth());
          pstmt.setString(5, dto.getContact_number());
          pstmt.setString(6, dto.getEmail());
          pstmt.setString(7, dto.getZip());
          pstmt.setString(8, dto.getAddress());
          pstmt.setString(9, dto.getAddress_r());
          pstmt.setString(10, dto.getLastdate());
          pstmt.setString(11, dto.getPro_name());
          pstmt.setString(12, dto.getJoined_date());
          pstmt.setString(13, dto.getId());
          cnt = pstmt.executeUpdate();
        }catch(Exception e){
          System.out.println("회원정보 수정 실패: "+e);
        }finally{
          DBClose.close(con, pstmt);
        }
        return cnt;
      }//update() end
    
    
  //회원정보 불러오기
    public MemberDTO member_read(String id) {
          MemberDTO dto = new MemberDTO();
          try {
            con = dbopen.getConnection();
            sql = new StringBuilder();
            sql.append(" SELECT id, pw, mem_name, birth, contact_number, email, zip, address, address_r, joined_date, lastdate, pro_name, grade ");
            sql.append(" FROM member ");
            sql.append(" WHERE id = ? ");
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
              dto.setId(rs.getString("id"));
              dto.setPw(rs.getString("pw"));
              dto.setMem_name(rs.getString("mem_name"));
              dto.setBirth(rs.getString("birth"));
              dto.setContact_number(rs.getString("contact_number"));
              dto.setEmail(rs.getString("email"));
              dto.setZip(rs.getString("zip"));
              dto.setAddress(rs.getString("address"));
              dto.setAddress_r(rs.getString("address_r"));
              dto.setJoined_date(rs.getString("joined_date"));
              dto.setLastdate(rs.getString("lastdate"));
              dto.setPro_name(rs.getString("pro_name"));
              dto.setGrade(rs.getString("grade"));
            }
          } catch (Exception e) {
            System.out.println("회원정보 가져오기 실패:" + e);
          } finally {
            DBClose.close(con, pstmt, rs);
          }
          return dto;
        }// read()
    
    
  //회원정보 수정
    public int update(MemberDTO dto){
        int cnt = 0;
        String id = dto.getId();
        try{
          con = dbopen.getConnection();
          sql = new StringBuilder();
          sql.append(" UPDATE member");
          sql.append(" SET mem_name=?, pw=?, birth=?, contact_number=?, email=?, zip=?, address=?, address_r=?, lastdate=?, id=?, pro_name=?, joined_date=?, grade=? ");
          sql.append(" WHERE id = ?");
          pstmt = con.prepareStatement(sql.toString());
          pstmt.setString(1, dto.getMem_name());
          pstmt.setString(2, dto.getPw());
          pstmt.setString(3, dto.getBirth());
          pstmt.setString(4, dto.getContact_number());
          pstmt.setString(5, dto.getEmail());
          pstmt.setString(6, dto.getZip());
          pstmt.setString(7, dto.getAddress());
          pstmt.setString(8, dto.getAddress_r());
          pstmt.setString(9, dto.getLastdate());
          pstmt.setString(10, id);
          pstmt.setString(11, dto.getPro_name());
          pstmt.setString(12, dto.getJoined_date());
          pstmt.setString(13, dto.getGrade());
          pstmt.setString(14, id);
          cnt = pstmt.executeUpdate();
        }catch(Exception e){
          System.out.println("회원정보 수정 실패: "+e);
        }finally{
          DBClose.close(con, pstmt);
        }
        return cnt;
      }//update() end
    
 // top 유저포인트
    public ArrayList<PointDTO> point() {
      PointDTO dto = new PointDTO();
      ArrayList<PointDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT id, point, date ");
        sql.append(" FROM point ");
        sql.append(" ORDER BY date DESC ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<PointDTO>();
          do {
            dto = new PointDTO();
            dto.setId(rs.getString("id"));
            dto.setPoint(rs.getInt("point"));
            dto.setDate(rs.getString("date"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("포인트 순위 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
    
 // 포인트 증감
    public int point_insert(PointDTO dto) {
      int cnt = 0;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" INSERT INTO POINT(NO, ID, POINT, DATE) ");
        sql.append(" VALUES((SELECT Ifnull(Max(no), 0) FROM point AS TB), ?, ?, NOW()) ");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getId());
        pstmt.setInt(2, dto.getPoint());
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
        System.out.println("포인트 증감실패 : " + e);
      } finally {
        dbclose.close(con, pstmt);
      }
      return cnt;
    }
    
 // 좋아요/싫어요 리스트
    public ArrayList<RatingDTO> rating() {
      RatingDTO dto = new RatingDTO();
      ArrayList<RatingDTO> list = null;
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT NO, id_give, id_receive, evaluation, rated_date ");
        sql.append(" FROM rating ");
        sql.append(" ORDER BY Rated_date DESC ");
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          list = new ArrayList<RatingDTO>();
          do {
            dto = new RatingDTO();
            dto.setNo(rs.getString("NO"));
            dto.setId_give(rs.getString("id_give"));
            dto.setId_receive(rs.getString("id_receive"));
            dto.setEvaluation(rs.getString("evaluation"));
            dto.setRated_date(rs.getString("rated_date"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("좋아요/싫어요 리스트 가져오기 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }//read() end
    
    
  //상품목록 리스트
    public ArrayList<RentalDTO> rental_list() {
      ArrayList<RentalDTO> list = null;
      RentalDTO dto = new RentalDTO();
      try {       
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT product_no, title, sub_title, product_name, price_daily, deposit, total_quantity, remaining_quantity, thmb_name, id, availability, reg_date ");
        sql.append(" FROM RENTAL_LIST ");
        sql.append(" ORDER BY product_no DESC ");
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
            dto.setAvailability(rs.getString("availability"));
            dto.setReg_date(rs.getString("reg_date"));
            list.add(dto);
          } while (rs.next());
        } else {
          list = null;
        } // if end
      } catch (Exception e) {
        System.out.println("상품목록 실패:" + e);
      } finally {
        DBClose.close(con, pstmt, rs);
      }
      return list;
    }
}
