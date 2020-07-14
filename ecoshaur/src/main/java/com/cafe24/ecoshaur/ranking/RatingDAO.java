package com.cafe24.ecoshaur.ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.category.RentalDTO;
import com.cafe24.ecoshaur.member.MemberDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class RatingDAO {
	@Autowired
	private DBOpen dbopen;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;
	ArrayList<RentalDTO> productlist = null;
	ArrayList<RatingDTO> ratinglist = null;
	ArrayList<JoinDTO> list = null;
	
	public RatingDAO() {
	}

	/*
	  렌탈리스트테이블 목록
	 sql.append(" SELECT thmb_name, product_name, (price_daily + deposit) AS price ");
	 sql.append(" FROM rental_list as r "); 
	 sql.append(" JOIN member as m "); 
	 sql.append(" ON r.id = m.id ");
	 
	 
	 MySQL Client 조인문
	 렌탈리스트 목록 출력
	 select thmb_name, product_name, price_daily + deposit
	 from rental_list as r
	 join member as m
	 on r.id = m.id;
	 레이팅테이블 좋아요 수 출력
	 select count(no)
	 from rating
	 where evaluation='Good'
	 group by no;
	 렌탈리스트테이블, 멤버테이블, 레이팅테이블 조인
	 select thmb_name, product_name, price_daily, deposit, no, count(no)
	 from rental_list as rent
	 join member as mem
	 on rent.id = mem.id
	 join rating
	 on rent.product_no = rating.no
	 where evaluation = 'Good'
	 group by no
	 order by count(no) desc;
	 사용자 아이디 별 좋아요 수 랭킹
	 select id_receive, pro_name, mem_name, grade, evaluation, count(evaluation)
	 from rating as r
	 join member as m
	 on m.id = r.id_receive
	 where evaluation = 'Good'
	 group by id_receive
	 order by count(evaluation) desc;
	*/
	
	public ArrayList<JoinDTO> list() {
		try {
			JoinDTO dto = new JoinDTO();
			
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT id_receive, pro_name, mem_name, grade, evaluation, COUNT(r.evaluation) AS cnt ");
			sql.append(" FROM rating AS r ");
			sql.append(" JOIN member AS m ");
			sql.append(" ON m.id = r.id_receive ");
			sql.append(" WHERE evaluation = 'Good'");
			sql.append(" GROUP BY r.id_receive ");
			sql.append(" ORDER BY cnt desc; ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<JoinDTO>();
				do {
					dto = new JoinDTO();
					dto.setId_receive(rs.getString("id_receive").trim());
					dto.setPro_name(rs.getString("pro_name").trim());
					dto.setMem_name(rs.getString("mem_name").trim());
					dto.setGrade(rs.getString("grade").trim());
					dto.setEvaluation(rs.getString("evaluation").trim());
					dto.setCount(rs.getInt("cnt"));
					list.add(dto);
				} while (rs.next());
			} else {
				list = null;
			} // if end
		} catch (Exception e) {
			System.out.println("목록 불러오기 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // try end
		return list;
	}//list end
	

}
