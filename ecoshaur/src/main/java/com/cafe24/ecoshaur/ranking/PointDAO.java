package com.cafe24.ecoshaur.ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class PointDAO {
	@Autowired
	private DBOpen dbopen;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;
	ArrayList<PointDTO> pointlist = null;
	ArrayList<JoinDTO> first = null;
	ArrayList<JoinDTO> second = null;
	ArrayList<JoinDTO> others = null;
	
	
	public PointDAO() {
	}

	/*
	  포인트테이블 목록 
	 sql.append(" SELECT no, id, point, date ");
	 sql.append(" FROM point "); 
	 sql.append(" ORDER BY point DESC "); 
	 
	 멤버테이블 목록
	 sql.append(" SELECT pro_name, mem_name ");
	 sql.append(" FROM point AS p ");
	 sql.append(" JOIN member AS m ");
	 sql.append(" ON p.id = m.id ");
	 
	 MySQL Client 조인문
	 SELECT m.pro_name, m.mem_name, p.point
	 FROM point AS p 
	 JOIN member AS m 
	 ON p.id=m.id 
	 ORDER BY point DESC;
	 
	 포인트테이블, 멤버테이블 조인 
	 sql.append(" SELECT m.pro_name, m.mem_name, p.point ");
	 sql.append(" FROM point AS p ");
	 sql.append(" JOIN member AS m ");
	 sql.append(" WHERE p.id=m.id ");
	 sql.append(" ORDER BY point DESC ");  
	 
	 MySQl Client 조인문
	  포인트 별 사용자 순위 1위
 	 SELECT id, pro_name, mem_name, grade, point
	 FROM(
     	  SELECT A.*, @rownum:=@rownum+1 AS RNUM
     	  FROM(
          		SELECT m.id, m.pro_name, m.mem_name, m.grade, p.point
          		FROM point AS p 
          		JOIN member AS m ON p.id=m.id
          		JOIN(SELECT @rownum:=0) R
          	  ) AS A
      	  ORDER BY point DESC
     	 ) AS B
	 WHERE RNUM = 1;
	 포인트 별 사용자 순위 2~5위
	 SELECT id, pro_name, mem_name, grade, point
	 FROM(
     		SELECT A.*, @rownum:=@rownum+1 AS RNUM
     		FROM(
          		  SELECT m.id, m.pro_name, m.mem_name, m.grade, p.point
          		  FROM point AS p 
          		  JOIN member AS m ON p.id=m.id
          		  JOIN(SELECT @rownum:=0) R
     	  		) AS A
     		ORDER BY point DESC
     	 ) AS B
	 WHERE RNUM BETWEEN 2 AND 5;
	 포인트 별 사용자 순위 그 외
	 SELECT id, pro_name, mem_name, grade, point
	 FROM(
     		SELECT A.*, @rownum:=@rownum+1 AS RNUM
     		FROM(
          		  SELECT m.id, m.pro_name, m.mem_name, m.grade, p.point
          		  FROM point AS p 
          		  JOIN member AS m ON p.id=m.id
          		  JOIN(SELECT @rownum:=0) R
     	  		) AS A
     		ORDER BY point DESC
     	 ) AS B
	 WHERE RNUM > 5;	 
	 
	 RNUM 추가
	 sql.append(" SELECT *  ");
	 sql.append(" FROM( ");
	 sql.append(" 		SELECT A.*, @rownum:=@rownum+1 AS RNUM ");
	 sql.append(" 		FROM( ");
	 sql.append(" 				SELECT m.pro_name, m.mem_name, p.point ");
	 sql.append(" 				FROM point AS p ");
	 sql.append(" 				JOIN member AS m ON p.id=m.id ");
	 sql.append(" 				JOIN(SELECT @rownum:=0) R ");
	 sql.append(" 			) AS A ");
	 sql.append(" 		ORDER BY point DESC ");
	 sql.append(" 	  ) AS B ");
	 sql.append(" WHERE RNUM BETWEEN 1 AND 10; ");
	*/
	
	public ArrayList<JoinDTO> first() {
		try {
			JoinDTO dto = new JoinDTO();
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT id, pro_name, mem_name, grade, point ");
			sql.append(" FROM( ");
			sql.append(" 		SELECT A.*, @rownum:=@rownum+1 AS RNUM ");
			sql.append(" 		FROM( ");
			sql.append(" 				SELECT m.id, m.pro_name, m.mem_name, m.grade, p.point ");
			sql.append(" 				FROM point AS p ");
			sql.append(" 				JOIN member AS m ON p.id = m.id ");
			sql.append(" 				JOIN(SELECT @rownum:=0) R ");
			sql.append(" 			) AS A ");
			sql.append(" 		ORDER BY point DESC ");
			sql.append(" 	  ) AS B ");
			sql.append(" WHERE RNUM = 1 ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				first = new ArrayList<JoinDTO>();
				do {
					dto = new JoinDTO();
					dto.setId(rs.getString("id"));
					dto.setPro_name(rs.getString("pro_name"));
					dto.setMem_name(rs.getString("mem_name"));
					dto.setGrade(rs.getString("grade"));
					dto.setPoint(rs.getInt("point"));
					first.add(dto);
				} while (rs.next());
			} else {
				first = null;
			} // if end
		} catch (Exception e) {
			System.out.println("1순위 불러오기 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end
		return first;
	}//first end
	
	public ArrayList<JoinDTO> second() {
		try {
			JoinDTO dto = new JoinDTO();
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT id, pro_name, mem_name, grade, point ");
			sql.append(" FROM( ");
			sql.append(" 		SELECT A.*, @rownum:= @rownum+1 AS RNUM ");
			sql.append(" 		FROM( ");
			sql.append(" 				SELECT m.id, m.pro_name, m.mem_name, m.grade, p.point ");
			sql.append(" 				FROM point AS p ");
			sql.append(" 				JOIN member AS m ON p.id = m.id ");
			sql.append(" 				JOIN(SELECT @rownum:=0) R ");
			sql.append(" 			) AS A ");
			sql.append(" 		ORDER BY point DESC ");
			sql.append(" 	  ) AS B ");
			sql.append(" WHERE RNUM BETWEEN 2 AND 5");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				second = new ArrayList<JoinDTO>();
				do {
					dto = new JoinDTO();
					dto.setId(rs.getString("id"));
					dto.setPro_name(rs.getString("pro_name"));
					dto.setMem_name(rs.getString("mem_name"));
					dto.setGrade(rs.getString("grade"));
					dto.setPoint(rs.getInt("point"));
					second.add(dto);
				} while (rs.next());
			} else {
				second = null;
			} // if end
		} catch (Exception e) {
			System.out.println("2~5순위 불러오기 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end
		return second;
	}//second end
	
	public ArrayList<JoinDTO> others() {
		try {
			JoinDTO dto = new JoinDTO();
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT id, pro_name, mem_name, grade, point ");
			sql.append(" FROM( ");
			sql.append(" 		SELECT A.*, @rownum:= @rownum+1 AS RNUM ");
			sql.append(" 		FROM( ");
			sql.append(" 				SELECT m.id, m.pro_name, m.mem_name, m.grade, p.point ");
			sql.append(" 				FROM point AS p ");
			sql.append(" 				JOIN member AS m ON p.id = m.id ");
			sql.append(" 				JOIN(SELECT @rownum:=0) R ");
			sql.append(" 			) AS A ");
			sql.append(" 		ORDER BY point DESC ");
			sql.append(" 	  ) AS B ");
			sql.append(" WHERE RNUM BETWEEN 6 AND 20 ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				others = new ArrayList<JoinDTO>();
				do {
					dto = new JoinDTO();
					dto.setId(rs.getString("id"));
					dto.setPro_name(rs.getString("pro_name"));
					dto.setMem_name(rs.getString("mem_name"));
					dto.setGrade(rs.getString("grade"));
					dto.setPoint(rs.getInt("point"));
					others.add(dto);
				} while (rs.next());
			} else {
				others = null;
			} // if end
		} catch (Exception e) {
			System.out.println("6~20순위 불러오기 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end
		return others;
	}//others end

	
}
