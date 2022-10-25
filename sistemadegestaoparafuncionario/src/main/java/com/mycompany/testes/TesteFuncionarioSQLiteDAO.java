/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testes;

import com.mycompany.DAO.SLite.FuncionarioSQLiteDAO;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author heflain
 */

public class TesteFuncionarioSQLiteDAO {
    public static void main(String[] args) {
        FuncionarioSQLiteDAO fsd = null;
        try {
            fsd = new FuncionarioSQLiteDAO();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        Funcionario f = new Funcionario("Heflain", "Programador", LocalDate.now(), 2000.0, 6, false );
        
        try {
            fsd.salvar(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            f = fsd.obterTodos().get(0);
            System.out.println(f.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        f.setNome("Abel");
        
        try {
            fsd.atualizar(f);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            f = fsd.obterTodos().get(3);
            System.out.println(f.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(f.getNome() + " " + f.getId());
    }
}

