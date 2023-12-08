/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LAB_ETESC
 */
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


