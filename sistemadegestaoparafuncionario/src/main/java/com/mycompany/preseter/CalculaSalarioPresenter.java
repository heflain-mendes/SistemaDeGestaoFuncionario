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
    
     public static CalculaSalarioPresenter instance = null;
    private final CalculaSalarioView view;

    private CalculaSalarioPresenter() {
        view = new CalculaSalarioView();
        view.setLocation(20, 20);
        view.setVisible(true);
    }

    public static CalculaSalarioPresenter getInstance(){
        if(instance == null){
            instance = new CalculaSalarioPresenter();
        }
        
        return instance;
    }
    
     public CalculaSalarioView getView() {
        return view;
    }
    
    
}
