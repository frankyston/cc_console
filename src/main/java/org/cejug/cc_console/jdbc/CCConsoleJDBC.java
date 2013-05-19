package org.cejug.cc_console.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que irá lidar com o acesso e manipulação dos dados
 * no banco de dados derby embarcado usando JDBC. 
 * 
 * @author helio frota https://www.heliofrota.com
 * 
 */
public class CCConsoleJDBC {

    /**
     * Obtém uma conexão com o banco de dados derby embarcado.
     * 
     * @return Connection
     */
    public Connection getConnection() {
        // Referência para java.sql.Connection.
        Connection conn = null;
        // Tenta carregar o driver do derby embarcado, caso contrário
        // imprime uma exceção.
        try {
            // Carrega o driver do derby embarcado.
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // tenta obter a conexão com o banco de dados derby embarcado,
        // caso contrário imprime uma exceção.
        try {
            // Conecta no banco sem usuario e senha.
            conn = DriverManager
                    .getConnection("jdbc:derby:cc_console_db;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Retorna a referência para a conexão com o banco.
        return conn;
    }

}
