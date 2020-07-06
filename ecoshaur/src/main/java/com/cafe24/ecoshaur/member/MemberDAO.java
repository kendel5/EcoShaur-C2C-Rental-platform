package com.cafe24.ecoshaur.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	        sql.append("values(?,?,?,?,?,?,?,?,?, 'U', now(),now(),?)");
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
	
}
