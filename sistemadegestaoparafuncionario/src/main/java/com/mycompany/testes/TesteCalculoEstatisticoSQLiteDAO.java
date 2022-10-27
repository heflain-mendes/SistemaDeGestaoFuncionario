/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testes;

import com.mycompany.DAO.SLite.CalculoEstatisticoSQLiteDAO;
import com.mycompany.model.CalculoEstatistico;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heflain
 */
public class TesteCalculoEstatisticoSQLiteDAO {

    public static void main(String[] args) {
        CalculoEstatisticoSQLiteDAO ceDAO = null;
        try {
            ceDAO = new CalculoEstatisticoSQLiteDAO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        CalculoEstatistico ce = new CalculoEstatistico(LocalDate.now(), 6.0, 5.6, 9.3, 9.0, 10.7, 0.5, 50);

        try {
            ceDAO.salvar(1, ce);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            ce = ceDAO.obterPorIdFuncionario().get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ce.setData(LocalDate.of(2000, 8, 9));
        ce.setSomatorio(10);
        System.out.println(ce.getData().toString());

        try {
            System.out.println(ce.toString());
            ceDAO.atualizar(ce);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
