package com.cafe24.ecoshaur.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.home.HomeDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class HomeDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<HomeDTO> list = null;

    public HomeDAO() {
      System.out.println("---HomeDAO() 객체 생성됨---");
    }

    public HomeDTO read() {
      HomeDTO dto = new HomeDTO();
      try {
        con = dbopen.getConnection();
        sql = new StringBuilder();
        sql.append(" SELECT id, mem_name");
        sql.append(" FROM member ");
        sql.append(" WHERE id='TEST02' ");

        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        if (rs.next()) {
          dto.setId(rs.getString("id"));
          dto.setMem_name(rs.getString("mem_name"));
        }
      } catch (Exception e) {
        System.out.println("db 실패: " + e);
      } finally {
        dbclose.close(con, pstmt, rs);
      }
      return dto;
    }// read() end
}
