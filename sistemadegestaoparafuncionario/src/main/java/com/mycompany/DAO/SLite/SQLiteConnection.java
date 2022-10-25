/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO.SLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author heflain
 */
public class SQLiteConnection {
    public static Connection getConexao() throws Exception {
        String url = "jdbc:sqlite:database_funcionario.db";
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new Exception("Problema ao abrir banco de dados SQLite");
        }
    } 
}
