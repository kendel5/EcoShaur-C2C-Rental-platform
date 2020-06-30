package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

//스프링컨테이너(웹서버)가 자동으로 객체 생성함
@Component
public class DBOpen {
  
  public DBOpen() {
    System.out.println("---DBOpen()객체 생성됨..."); 
  }  
  //데이터베이스 연결 메소드  
  public Connection getConnection() {
    String url      = "jdbc:mysql://localhost:3306/Rental_service?serverTimezone=UTC";
    String user     = "root";
    String password = "1234";
    String driver   = "org.mariadb.jdbc.Driver";

    Connection con=null;
   
    try {
      
      Class.forName(driver);  
      con=DriverManager.getConnection(url, user, password);

    }catch(Exception e){
      System.out.println("DB실패:" + e);
    }//try end
    
    return con;
    
  }//getConnection() end
  
}//class end
