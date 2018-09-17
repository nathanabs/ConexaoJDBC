/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Comprador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class CompradorDB {

    public void save(Comprador c) {
        String sql = "insert into agencia.comprador (cpf, nome) values('" + c.getCpf() + "','" + c.getNome() + "')";
        Connection con = ConexaoFactory.getConexao();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            ConexaoFactory.fecharConexao(con, st);
            System.out.println("Inserido com sucesso.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Comprador c) {
        if (c == null || c.getId() == null) {
            throw new IllegalArgumentException("Identificação do comprador com erro.");
        }
        String sql = "Delete from comprador where id = " + c.getId();
        Connection con = ConexaoFactory.getConexao();
        try {
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate(sql));
            ConexaoFactory.fecharConexao(con, st);
            System.out.println("Excluido com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Comprador c) {
        if (c == null || c.getId() == null) {
            throw new IllegalArgumentException("Identificação do comprador com erro.");
        }
        String sql = "update agencia.comprador set nome = '" + c.getNome() + "', cpf = '" + c.getCpf() + "' where (id = " + c.getId() + ")";
        Connection con = ConexaoFactory.getConexao();
        try {
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate(sql));
            ConexaoFactory.fecharConexao(con, st);
            System.out.println("atualizado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Comprador> pesquisar() {

        String sql = "Select id, nome, cpf from comprador";
        Connection con = ConexaoFactory.getConexao();
        try {
            List<Comprador> lista = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.fecharConexao(con, st, rs);
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Comprador> pesquisar(String pesquisa) {

        String sql = "Select id, nome, cpf from comprador where nome like '%"+pesquisa+"%'";
        Connection con = ConexaoFactory.getConexao();
        try {
            List<Comprador> lista = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.fecharConexao(con, st, rs);
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
