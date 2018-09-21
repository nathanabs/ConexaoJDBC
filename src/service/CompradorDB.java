/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Comprador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        
        try (Connection con = ConexaoFactory.getConexao()){
            Statement st = con.createStatement();
            st.executeUpdate(sql);
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
        
        try (Connection con = ConexaoFactory.getConexao()) {
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate(sql));
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
        
        try (Connection con = ConexaoFactory.getConexao()){
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate(sql));
            System.out.println("atualizado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Comprador> pesquisar() {

        String sql = "Select id, nome, cpf from comprador";
        
        try (Connection con = ConexaoFactory.getConexao()){
            List<Comprador> lista = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Comprador> pesquisar(String pesquisa) {

        String sql = "Select id, nome, cpf from comprador where nome like '%"+pesquisa+"%'";
        
        try (Connection con = ConexaoFactory.getConexao()) {
            List<Comprador> lista = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void metaDados(){
        String sql = "Select * from comprador";
        
        try (Connection con = ConexaoFactory.getConexao()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsMetaDados = rs.getMetaData();
            rs.next();
            
            int qtdColunas = rsMetaDados.getColumnCount();
            System.out.println("Nome tabela: " + rsMetaDados.getTableName(1));
            for (int i = 1; i <= qtdColunas; i++) {
                
                System.out.println("Nome Coluna: " + rsMetaDados.getColumnName(i));
                System.out.println("Tamanho coluna: " + rsMetaDados.getColumnDisplaySize(i));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompradorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
