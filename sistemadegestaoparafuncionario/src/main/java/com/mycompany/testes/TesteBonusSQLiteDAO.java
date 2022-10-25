/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testes;

import com.mycompany.DAO.SLite.BonusSQLiteDAO;
import com.mycompany.model.Bonus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        Bonus b = new Bonus("Teste", 200, LocalDate.now());
        List<Bonus> lb = new ArrayList<>();
        try {
            bsqlite.salvar(1, lb);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
