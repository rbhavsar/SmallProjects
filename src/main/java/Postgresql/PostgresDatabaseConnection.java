package Postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rbhavsar
 * Created on 7/20/19.
 */
public class PostgresDatabaseConnection {

  private static final String url = "jdbc:postgresql://localhost:5432/postgres";
  private static final String user = "postgres";
  private static final String password = "birst@123";

  public static void main(String[] args) {

    Connection conn;

    try{
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(url,
          user,
          password);
     System.out.println("Connected to the PostgreSQL server successfully.");

      Statement stmnt = null;
      stmnt = conn.createStatement();
      String sql = "INSERT INTO public.auditlog(" +
          "tm, username, spaceid, MODE, name, dashboard, dashboardguid, elapsedtime, sessionid, hostname, apiname, spacename)" +
          " VALUES ('2016-07-01 00:03:57.96', 'accountadmin@birst.com', 'aac8f9f1-f93e-4bb2-96ac-61b496e72963', " +
          "'Dashboard', 'Quantity by Year.viz.dashlet', 'Column Selectors', 'df5152ee-868b-42b9-8c67-dd7031e8e348', 52, '65440085716B30A933566DB2DB02A94E',\n" +
          "'BA-V521-W2012', 'saveQuery', ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,"अंतरिक्ष11");
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
