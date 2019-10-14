package Postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author rbhavsar
 * Created on 8/4/19.
 */
public class c3p0ConnectionPool {

  private static ComboPooledDataSource comboPooledDataSource;
  private static final String url = "jdbc:postgresql://localhost:5432/postgres";
  private static final String user = "postgres";
  private static final String password = "birst@123";
  private static final String driverClass = "org.postgresql.jdbc3.Jdbc3ConnectionPool";

  public static void main(String[] args) {
    try {
      comboPooledDataSource = new ComboPooledDataSource();
      comboPooledDataSource.setDriverClass(driverClass);
      comboPooledDataSource.setJdbcUrl(url);
      comboPooledDataSource.setUser(user);
      comboPooledDataSource.setPassword(password);
      comboPooledDataSource.setMaxPoolSize(100);
      comboPooledDataSource.setMaxPoolSize(1000);
      comboPooledDataSource.setAcquireIncrement(5);

      try(Connection connection = comboPooledDataSource.getConnection();
      Statement statement = connection.createStatement();){
        String sql = "INSERT INTO public.auditlog(" +
            "tm, username, spaceid, MODE, name, dashboard, dashboardguid, elapsedtime, sessionid, hostname, apiname, spacename)" +
            " VALUES ('2016-07-01 00:03:57.96', 'accountadmin@birst.com', 'aac8f9f1-f93e-4bb2-96ac-61b496e72963', " +
            "'Dashboard', 'Quantity by Year.viz.dashlet', 'Column Selectors', 'df5152ee-868b-42b9-8c67-dd7031e8e348', 52, '65440085716B30A933566DB2DB02A94E',\n" +
            "'BA-V521-W2012', 'saveQuery', ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,"अंतरिक्ष1199");
        pstmt.executeUpdate();
      }catch (Exception e){
        System.out.println("Exception :"+e.getMessage());
      }

    }catch (Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}
