/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author J.Jabr
 */
public class DBConnecter {
   
    private static final String URL = "jdbc:mysql://localhost:3306/LegoHus";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "cimber123";

    private static Connection singleton;

    public static void setConnection( Connection connection ) {
        singleton = connection;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
}
