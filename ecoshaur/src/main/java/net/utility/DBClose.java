package net.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class DBClose {
  
  public DBClose() {
    System.out.println("---DBClose()객체 생성됨...");
    }
  
  public static void close(Connection con) {
    try{
      if(con != null){ con.close(); con=null; }
    }catch(Exception e){}
  }//close end
  

  public static void close(Connection con, PreparedStatement pstmt) {
    try{
      if(pstmt != null){ pstmt.close(); pstmt=null; }
    }catch(Exception e){}
    
    try{
      if(con != null){ con.close(); con=null; }
    }catch(Exception e){}
  }//close end
  

  public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
    try{
      if(rs != null){ rs.close(); rs=null; }
    }catch(Exception e){}
    
    try{
      if(pstmt != null){ pstmt.close(); pstmt=null; }
    }catch(Exception e){}
    
    try{
      if(con != null){ con.close(); con=null; }
    }catch(Exception e){}
  }//close end
  
}//class end








