package com.cafe24.ecoshaur.ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.ranking.RatingDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class RatingDAO {
    @Autowired
    static private DBOpen dbopen;
    @Autowired
    static private DBClose dbclose;

    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    static StringBuilder sql = null;
    
    public RatingDAO() { }


}
