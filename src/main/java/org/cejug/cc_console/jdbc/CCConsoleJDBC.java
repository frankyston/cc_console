package org.cejug.cc_console.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.cejug.cc_console.pojo.Personagem;

/**
 * Classe que irá lidar com o acesso e manipulação dos dados no banco de dados
 * derby embarcado usando JDBC.
 * 
 * @author helio frota https://www.heliofrota.com
 * 
 */
public class CCConsoleJDBC {

    /**
     * Referência estática para a conexão com o banco.
     */
    private static Connection connection;

    /**
     * Bloco estático para inciar a conexão e criar uma única vez a tabela.
     */
    static {
        connection = obterConexao();
        criarTabela();
    }

    /**
     * Salva os dados do objeto personagem na base de dados.
     * @param personagem Personagem
     */
    public void salvarPersonagem(Personagem personagem) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into personagem (nome) values (?)");
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void listarPersonagens() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select id, nome from personagem");
            resultSet = preparedStatement.executeQuery();
            
            System.out.println("ID - PERSONAGEM");
            
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + " - " + resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void atualizarPersonagem(Personagem personagem) {

    }

    public void removerPersonagem(Personagem personagem) {

    }

    /**
     * Obtém uma conexão com o banco de dados derby embarcado.
     * 
     * @return Connection
     */
    public static Connection obterConexao() {
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
            conn = DriverManager.getConnection("jdbc:derby:cc_console_db;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Retorna a referência para a conexão com o banco.
        return conn;
    }

    /**
     * Cria a tabela PERSONAGEM no banco de dados embarcado.
     */
    public static void criarTabela() {
        // Referência para o statement.
        Statement statement = null;
        try {

            // Criação do statement.
            statement = connection.createStatement();

            // Comando sql para criar tabela personagem no banco de dados derby.
            String sql = "create table personagem (id integer not null "
                    + "generated always as identity (start with 1, increment by 1), "
                    + "nome varchar(20) not null, "
                    + "constraint primary_key primary key (id))";

            // Executando o statement sql para criação da tabela PERSONAGEM.
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
