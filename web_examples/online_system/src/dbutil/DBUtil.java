package dbutil;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

 
public class DBUtil
{
	private static final String driver="com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://127.0.0.1:3306/onlinetest";
  private static final String UNAME = "root";
  private static final String PWD = "root";
 
  private static Connection conn = null;
// 
//  static
//  {
//    try
//    {
//      // 1.������������
//      Class.forName(driver);
//      // 2.������ݿ������
//      conn =  (Connection) DriverManager.getConnection(URL, UNAME, PWD);
//    }
//    catch (ClassNotFoundException e)
//    {
//      e.printStackTrace();
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//    }
//  }
 
  public static Connection getConnection()
  {
	  try
	    {
	      // 1.������������
	      Class.forName(driver);
	      // 2.������ݿ������
	      conn =  (Connection) DriverManager.getConnection(URL, UNAME, PWD);
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
    return conn;
  }
}
