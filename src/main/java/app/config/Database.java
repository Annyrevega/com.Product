package app.config;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootroot";
    private static Connection connection = null;
    Driver DRIVER;

    {
        try {
            DRIVER = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(DRIVER);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public static Connection getConnection(){
        if(connection!=null)
        try {

            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  connection;
    }
}
