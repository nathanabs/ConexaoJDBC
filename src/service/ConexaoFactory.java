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

    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection con, Statement st) {
        fecharConexao(con);
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void fecharConexao(Connection con, Statement st, ResultSet rs) {
        fecharConexao(con, st);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
