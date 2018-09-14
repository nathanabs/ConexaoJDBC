/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class ConexaoFactory {
    public Connection getConexao(){
        String url = "jdbc:mysql://localhost:3306/agencia";
        String usuario = "root";
        String senha = "admin";
        
        try {
            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
