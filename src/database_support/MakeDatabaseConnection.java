package database_support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by AURANGO SABBIR on 11/18/2014.
 */
public class MakeDatabaseConnection {

    public static Connection getConnection() {
        Connection con = null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found : " + ex.toString());
        }
        String connect_string = "jdbc:mysql://localhost/?" + "user=root&password=1234";
        try {
            con = (Connection) DriverManager.getConnection(connect_string);
            statement=con.createStatement();
            statement.executeUpdate("CREATE  DATABASE IF NOT EXISTS `guitar_shop`;");
            statement.executeUpdate("USE `guitar_shop`;");
            System.out.println("databse connected");
        } catch (SQLException ex) {
            System.out.println("Connection Problem : " + ex.toString());
        }
        return con;
    }
}
