/*
Before you testing, must add mariaDB connecter to Java BuildPath 
*/
package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
		 
import java.text.SimpleDateFormat;
import java.util.Date;

class DBMaria {
    String driver        = "org.mariadb.jdbc.Driver";
    String url           = "jdbc:mariadb://localhost:3306/test";
    String Id           = "dk";
    String Pwd          = "password";
    
    Connection               con;
    PreparedStatement        pstmt;
    ResultSet                rs;
    
    public DBMaria() {
         try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, Id, Pwd);
            if( con != null ){ 
            	System.out.println("데이터 베이스 접속 성공"); 
            	}
        } catch (ClassNotFoundException e) { 
        	System.out.println("드라이버 로드 실패");    
        } 
          catch (SQLException e) { 
        	  System.out.println("데이터 베이스 접속 실패"); 
        }
    }
    
    public void select(){
        String sql    = "select * from datatest";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("idx       : " + rs.getInt("ID"));
				System.out.println("writer    : " + rs.getString("Name"));
				System.out.println("title     : " + rs.getString("Date"));
				System.out.println("content   : " + rs.getString("DIV"));
				System.out.println("content   : " + rs.getString("Value"));
			}
		} catch (SQLException e) {
			System.out.println("쿼리 수행 실패");
		}
	}
}  
class SampleOfConnectMariaDB {
	public static void main(String[] args) {
		
		DBMaria MariaDB    = new DBMaria();
        MariaDB.select();
        
    }
}



