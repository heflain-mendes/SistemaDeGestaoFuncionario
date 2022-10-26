/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testes;

import com.mycompany.DAO.SLite.BonusSQLiteDAO;
import com.mycompany.model.Bonus;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heflain
 */
public class TesteBonusSQLiteDAO {

    public static void main(String[] args) {
        BonusSQLiteDAO bsqlite = null;
        try {
            bsqlite = new BonusSQLiteDAO();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Bonus b = new Bonus("Teste", 200, LocalDate.of(2000, Month.MARCH, 3));
        List<Bonus> lb = new ArrayList<>();
        lb.add(b);
        
        
        try {
            bsqlite.salvar(2, lb);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            lb = bsqlite.obter(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        if(lb == null){
            System.out.println("Retorno vazio");
        }
        
        for(Bonus bn : lb){
            System.out.println(bn.getData());
        }
        
        b = lb.get(0);
        
        try {
            bsqlite.remover(1, b.getData());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
