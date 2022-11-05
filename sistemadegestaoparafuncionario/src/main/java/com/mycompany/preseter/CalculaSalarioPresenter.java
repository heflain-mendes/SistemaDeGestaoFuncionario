/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.view.CalculaSalarioView;

/**
 *
 * @author heflain
 */
public class CalculaSalarioPresenter {
    private final CalculaSalarioView view;

    public  CalculaSalarioPresenter() {
        view = new CalculaSalarioView();
        view.setLocation(20, 20);
        view.setVisible(true);
    }
    
    
}
