/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import application.Program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class ConexaoFactory {

    public static Connection getConexao() {
        String url = "jdbc:mysql://localhost:3306/agencia";
        String usuario = "root";
        String senha = "admin";

        try {
            return DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}