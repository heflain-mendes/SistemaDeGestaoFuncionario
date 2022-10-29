/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import com.mycompany.preseter.PrincipalPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class Sistemadegestaoparafuncionario {

    public static void main(String[] args) {
        try {
            PrincipalPresenter.getInstance();
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
