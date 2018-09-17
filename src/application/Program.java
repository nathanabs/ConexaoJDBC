/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Comprador;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.CompradorDB;
import service.ConexaoFactory;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inserir();
        //atualizar();
        //deletar();
        pesquisar();
    }

    public static void inserir() {
        Comprador comprador = new Comprador("245", "elisa");
        CompradorDB c = new CompradorDB();
        c.save(comprador);
    }

    public static void deletar() {
        Comprador comprador = new Comprador("245", "elisa");
        CompradorDB c = new CompradorDB();
        comprador.setId(2);
        c.delete(comprador);
    }

    public static void atualizar() {
        Comprador comprador = new Comprador("245", "Melissa");
        comprador.setId(3);
        CompradorDB c = new CompradorDB();
        c.update(comprador);
    }
    public static void pesquisar() {
        CompradorDB c = new CompradorDB();
        List<Comprador> lista = c.pesquisar("");
        for(Comprador com : lista){
            System.out.println(com.getId()+", "+com.getCpf()+", "+com.getNome());
        }
    }
}
