package org.cejug.cc_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CCConsole {

    public static void main(String[] args) {

        System.out.println("=======");
        System.out.println(getConnection());

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Carrega o driver do derby embarcado.
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Conecta no banco sem usuario e senha.
            conn = DriverManager.getConnection("jdbc:derby:cc_console_db;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }

}
