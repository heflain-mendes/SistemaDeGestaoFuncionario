/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author heflain
 */
public class SQLiteConnection {
    private static String url;
    
    public static Connection getConexao() throws Exception {
        Dotenv dotenv = Dotenv.load();
        url = dotenv.get("CAMINHO_BANCO_DADOS");
        if(url == null){
            url = ("CAMINHO_BANCO_DADOS");
        }
        
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new Exception("Problema ao abrir banco de dados SQLite");
        }
    } 
}
