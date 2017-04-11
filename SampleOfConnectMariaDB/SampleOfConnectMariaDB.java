/*
Though this example, you can see that how to control execution sequence of Thread.  
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
            	System.out.println("������ ���̽� ���� ����"); 
            	}
        } catch (ClassNotFoundException e) { 
        	System.out.println("����̹� �ε� ����");    
        } 
          catch (SQLException e) { 
        	  System.out.println("������ ���̽� ���� ����"); 
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
			System.out.println("���� ���� ����");
		}
	}
}  
class SampleOfConnectMariaDB {
	public static void main(String[] args) {
		
		DBMaria MariaDB    = new DBMaria();
        MariaDB.select();
        
    }
}



