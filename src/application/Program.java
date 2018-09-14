/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Comprador;
import java.sql.Connection;
import java.sql.SQLException;
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
        Comprador comprador = new Comprador("245", "elisa");
        CompradorDB c = new CompradorDB();
        c.save(comprador);
    }

}
