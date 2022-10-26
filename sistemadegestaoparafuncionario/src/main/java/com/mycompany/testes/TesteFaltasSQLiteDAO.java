/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testes;

import com.mycompany.DAO.SLite.FaltaSQLiteDAO;
import com.mycompany.DAO.SLite.SalarioSQLiteDAO;
import com.mycompany.model.Falta;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heflain
 */
public class TesteFaltasSQLiteDAO {

    public static void main(String[] args) {
        FaltaSQLiteDAO faltaDAO = null;
        try {
            faltaDAO = new FaltaSQLiteDAO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Falta f = new Falta(LocalDate.now(), 5);

        try {
            faltaDAO.salvar(1, f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            f = faltaDAO.obterPorFuncionario(1).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(f.getId());

        f.setQuantidade(10);
        try {
            faltaDAO.atualizar(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            faltaDAO.remover(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
