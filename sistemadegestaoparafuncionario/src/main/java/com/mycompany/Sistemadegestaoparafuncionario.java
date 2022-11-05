/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.dao.factory.DAOSQLiteFactory;
import com.mycompany.preseter.PrincipalPresenter;
import io.github.cdimascio.dotenv.Dotenv;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class Sistemadegestaoparafuncionario {

    public static void main(String[] args) {
        try {
            configuracaoInicial();
            new PrincipalPresenter();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    private static void configuracaoInicial(){
        Dotenv dotenv = Dotenv.load();

        String bancoDados = dotenv.get("BANCO_DE_DADOS");
        if("SQLite".equals(bancoDados)){
            try {
                DAOSingleton.configureInstance(new DAOSQLiteFactory());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, 
                    ex.getMessage(), 
                "Erro no banco de dados",
                JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.out.println("não foi configurado");
        }
    }
}
