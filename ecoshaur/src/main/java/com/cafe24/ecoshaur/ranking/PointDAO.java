package com.cafe24.ecoshaur.ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cafe24.ecoshaur.ranking.PointDTO;
import com.cafe24.ecoshaur.member.MemberDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class PointDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<PointDTO> pointlist = null;
    ArrayList<MemberDTO> memberlist = null;
    
    public PointDAO() {}
    
    public ArrayList<PointDTO> pointlist(){ 
    	  try {
    		  PointDTO dto1 = new PointDTO();
    		  con=dbopen.getConnection();
    	      sql=new StringBuilder();
    	      
    	    /* 포인트 테이블 목록
  			sql.append(" SELECT no, id, point, date "); 
  			sql.append(" FROM point ");
  			sql.append(" ORDER BY point DESC ");
  			포인트 테이블, 멤버 테이블 조인
  			sql.append(" SELECT m.pro_name, m.mem_name, p.point, m.grade "); 
  			sql.append(" FROM point AS p ");
  			sql.append(" JOIN member AS m ");
  			sql.append(" WHERE p.id=m.id ");
  			SELECT m.pro_name, m.mem_name, p.point, m.grade 
  			FROM point AS p
  			JOIN member AS m
  			ON p.id=m.id
  			ORDER BY point DESC;
  		    */
    	      sql.append(" SELECT point ");
    	      sql.append(" FROM point AS p ");
    	      sql.append(" JOIN member AS m ");
    	      sql.append(" ON p.id = m.id ");
    	      sql.append(" ORDER BY point DESC");  	      
    	      pstmt=con.prepareStatement(sql.toString());
    	      rs=pstmt.executeQuery();
    	      if(rs.next()){
    	    	  pointlist=new ArrayList<PointDTO>();
    	    	  do {
    	    		  	dto1=new PointDTO();
    		            dto1.setPoint(rs.getInt("point"));
    			        pointlist.add(dto1);
    	    	  	}while(rs.next());
    	      }else {
    	    	  pointlist=null;
    	      }//if end
    	  }catch (Exception e) {
    	      System.out.println("목록 불러오기 실패:"+e);
    	  }finally {
    	    DBClose.close(con, pstmt, rs);
    	  }//try end
    	  return pointlist;
      }//pointlist end


    public ArrayList<MemberDTO> memberlist(){ 
  	  try {
  		  MemberDTO dto2 = new MemberDTO();
  		  con=dbopen.getConnection();
  	      sql=new StringBuilder();
  	      sql.append(" SELECT pro_name, mem_name, grade ");
  	      sql.append(" FROM point AS p ");
  	      sql.append(" JOIN member AS m ");
  	      sql.append(" ON p.id = m.id ");    	      
  	      pstmt=con.prepareStatement(sql.toString());
  	      rs=pstmt.executeQuery();
  	      if(rs.next()){
  	    	  memberlist=new ArrayList<MemberDTO>();
  	    	  do {
  	    		  	dto2=new MemberDTO();
  		            dto2.setPro_name(rs.getString("pro_name"));
  		            dto2.setMem_name(rs.getString("mem_name"));
  		            dto2.setGrade(rs.getString("grade"));
  			        memberlist.add(dto2);
  	    	  	}while(rs.next());
  	      }else {
  	    	  memberlist=null;
  	      }//if end
  	  }catch (Exception e) {
  	      System.out.println("목록 불러오기 실패:"+e);
  	  }finally {
  	    DBClose.close(con, pstmt, rs);
  	  }//try end
  	  return memberlist;
   }//memberlist end
    
    public ArrayList<> list(){
    	pointlist.addAll(pointlist);
    }
}
