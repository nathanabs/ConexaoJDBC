/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Comprador;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class CompradorDB {

    public void save(Comprador c) {
        String sql = "insert into agencia.comprador (cpf, nome) values('"+c.getCpf()+"','"+c.getNome()+"')";
        Connection con = ConexaoFactory.getConexao();
        try {
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate(sql));
            ConexaoFactory.fecharConexao(con, st);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
