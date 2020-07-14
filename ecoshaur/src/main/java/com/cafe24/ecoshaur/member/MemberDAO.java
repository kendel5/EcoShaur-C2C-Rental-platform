package com.cafe24.ecoshaur.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.category.RentalDTO;
import com.cafe24.ecoshaur.member.MemberDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class MemberDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<MemberDTO> list = null;
    ArrayList<MypageDTO> mypage = null;

    public MemberDAO() { }

    public String loginProc(MemberDTO dto) {
	    String grade=null;
	    try{
		con=dbopen.getConnection();
	      sql=new StringBuilder();
	      sql.append(" SELECT grade ");
	      sql.append(" FROM member ");
	      sql.append(" WHERE id=? AND pw=? ");
	      sql.append(" AND grade IN ('U', 'S', 'P', 'D','W','M') ");
	      pstmt=con.prepareStatement(sql.toString());
	      pstmt.setString(1, dto.getId());
	      pstmt.setString(2, dto.getPw());
	      rs= pstmt.executeQuery();
	      if(rs.next()){
	          grade=rs.getString("grade");
	      }else{
	          grade=null;
	      }//if end
	    }catch(Exception e){
	      System.out.println("로그인실패:" + e);
	    }finally {
	      DBClose.close(con, pstmt, rs);
	    }//try end
	    return grade;  
	  }//loginProc() end
	
	public int duplicateID(String id) {
		 int cnt=0;
	      try {
	        con=dbopen.getConnection();          
	        sql=new StringBuilder();
	        sql.append(" SELECT COUNT(id) as cnt ");
	        sql.append(" FROM member ");
	        sql.append(" WHERE id=? ");
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setString(1, id);
	        rs=pstmt.executeQuery();
	        if(rs.next()) {
	          cnt=rs.getInt("cnt");
	        }
	      }catch (Exception e) {
	        System.out.println("아이디 중복 확인 실패 : " + e);
	      }finally {
	        DBClose.close(con, pstmt, rs);
	      }//try end
	      return cnt;

	  }//duplecateID() end
	
	
	public int insertmember(MemberDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
	        sql = new StringBuilder();
	        sql.append(" INSERT INTO MEMBER(id, mem_name, pw, birth, contact_number, email, "
	                  + "zip, address, address_r, grade, joined_date, lastdate, pro_name) ");
	        sql.append("values(?,?,?,?,?,?,?,?,?, 'U', now(), now(),?)");
	        pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1, dto.getId());
	        pstmt.setString(2, dto.getMem_name());
	        pstmt.setString(3, dto.getPw());
	        pstmt.setString(4, dto.getBirth());
	        pstmt.setString(5, dto.getContact_number());
	        pstmt.setString(6, dto.getEmail());
	        pstmt.setString(7, dto.getZip());
	        pstmt.setString(8, dto.getAddress());
	        pstmt.setString(9, dto.getAddress_r());
	        pstmt.setString(10, dto.getPro_name());
	        cnt = pstmt.executeUpdate();
	      } catch (Exception e) {
	        System.out.println("회원가입실패 : " + e);
	      } finally {
	        dbclose.close(con, pstmt);
	      }
	      return cnt;
		}//insertmember() end
	
	//회원정보 불러오기
	public MemberDTO read(String id) {
	      MemberDTO dto = new MemberDTO();
	      try {
	        con = dbopen.getConnection();
	        sql = new StringBuilder();
	        sql.append(" SELECT mem_name, birth, contact_number, email, zip, address, address_r, joined_date, lastdate ");
	        sql.append(" FROM member ");
	        sql.append(" WHERE id = ? ");
	        pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	          dto.setMem_name(rs.getString("mem_name"));
	          dto.setBirth(rs.getString("birth"));
	          dto.setContact_number(rs.getString("contact_number"));
	          dto.setEmail(rs.getString("email"));
	          dto.setZip(rs.getString("zip"));
	          dto.setAddress(rs.getString("address"));
	          dto.setAddress_r(rs.getString("address_r"));
	          dto.setJoined_date(rs.getString("joined_date"));
	          dto.setLastdate(rs.getString("lastdate"));
	   
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
	    try{
	      con = dbopen.getConnection();
	      sql = new StringBuilder();
	      sql.append(" UPDATE member");
	      sql.append(" SET mem_name=?, pw=?, birth=?, contact_number=?, email=?, zip=?, address=?, address_r=?, lastdate=?");
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
	      pstmt.setString(10, dto.getId());
	      cnt = pstmt.executeUpdate();
	    }catch(Exception e){
	      System.out.println("회원정보 수정 실패: "+e);
	    }finally{
	      DBClose.close(con, pstmt);
	    }
	    return cnt;
	  }//update() end
	
	//회원탈퇴
		public int delete(String id){
	        int cnt = 0;
	        try{
	          con = dbopen.getConnection();
	          sql = new StringBuilder();
	          sql.append(" UPDATE  member ");
	          sql.append(" set grade='H' ");
	          sql.append(" WHERE id = ? ");
	          pstmt = con.prepareStatement(sql.toString());
	          pstmt.setString(1, id);
	          cnt = pstmt.executeUpdate();
	        }catch(Exception e){
	          System.out.println(e.toString());
	        }finally{
	          DBClose.close(con, pstmt);
	        }
	        return cnt;
	    }//delete() end
	
	public ArrayList<MypageDTO> mypage(String id) {
		try {
			MypageDTO dto = new MypageDTO();
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT m.id, r.product_no, r.product_name, r.title, r.reg_date ");
			sql.append(" FROM rental_list AS r ");
			sql.append(" JOIN member AS m ");
			sql.append(" ON r.id = m.id ");
			sql.append(" WHERE r.id = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mypage = new ArrayList<MypageDTO>();
				do {
					dto = new MypageDTO();
					dto.setId_receive(rs.getString("id"));
					dto.setProduct_no(rs.getString("product_no"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setTitle(rs.getString("title"));
					dto.setReg_date(rs.getString("reg_date"));
					mypage.add(dto);
				} while (rs.next());
			} else {
				mypage= null;
			} // if end
		} catch (Exception e) {
			System.out.println("목록 불러오기 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end
		return mypage;
	}//list end
	
	// 비밀번호 찾기
		public int findpw(String id, String email) {
		int cnt = 0;
		try {
				// DB연결
				con = dbopen.getConnection();
						
				//4)SQL문 작성
				sql=new StringBuilder();
			    sql.append(" SELECT email FROM member ");
				sql.append(" WHERE id=? and email=? ");
					
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, email);
				cnt = pstmt.executeUpdate();
					} catch (Exception e) {
						System.out.println("비밀번호 찾기 실패 : " + e);
					} finally {
						DBClose.close(con, pstmt);
					} // try end
					return cnt;
			} // find_password() end
	
}
