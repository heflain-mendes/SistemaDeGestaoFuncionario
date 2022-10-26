/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testes;

import com.mycompany.DAO.SLite.SalarioSQLiteDAO;
import com.mycompany.DAO.interfaces.ISalarioDAO;
import com.mycompany.model.Salario;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heflain
 */
public class TesteSalarioSQLiteDAO {

    public static void main(String[] args) {
        ISalarioDAO salarioDAO = null;
        try {
            salarioDAO = new SalarioSQLiteDAO();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Salario salario = new Salario(200.0, 600.0, LocalDate.now());

        try {
            salarioDAO.salvar(1, salario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            salario = salarioDAO.obter(1).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        salario.setSalarioBase(500.0);

        try {
            salarioDAO.atualizar(salario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            salarioDAO.remover(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
