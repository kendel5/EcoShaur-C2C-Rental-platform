package com.cafe24.ecoshaur.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafe24.ecoshaur.payment.OrderHistoryDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class OrderHistoryDAO {
    @Autowired
    private DBOpen dbopen;
    @Autowired
    private DBClose dbclose;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = null;
    ArrayList<OrderHistoryDTO> list = null;

    public OrderHistoryDAO() { }

    
}
