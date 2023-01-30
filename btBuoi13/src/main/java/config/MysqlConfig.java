package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {
    private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/crm_app";
    private static String USER_NAME = "root";
    private static String PASSWORD = "02042003";

    public static Connection getConnection ()
    {
        Connection connection = null;
        try
        {
            Class.forName(DRIVER_NAME);
            connection =DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch (Exception e )
        {

            System.out.println("Error in connection "+e.getMessage());
        }
        return connection;
    }

}
