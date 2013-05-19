package org.cejug.cc_console.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CCConsoleJDBC {

    
    public static void main(String[] args) {
        
        try {
            System.out.println(getConnection().getCatalog());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:derby:firstdb;create=true");
    }

}
