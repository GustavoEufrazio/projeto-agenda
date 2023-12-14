
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CriaConexao {
    
    public static Connection getconexao() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectando ao Banco");
            return DriverManager.getConnection("jdbc:postgresql:amigos","postgres","admin");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
            
}


