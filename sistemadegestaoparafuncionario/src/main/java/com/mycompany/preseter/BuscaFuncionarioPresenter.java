/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.view.BuscaFuncionarioView;

/**
 *
 * @author heflain
 */
public class BuscaFuncionarioPresenter {

    public static BuscaFuncionarioPresenter instance = null;
    private final BuscaFuncionarioView view;

    private BuscaFuncionarioPresenter() {
        view = new BuscaFuncionarioView();
        view.setLocation(20, 20);
        view.setVisible(true);
    }

    public static BuscaFuncionarioPresenter getInstance(){
        if(instance == null){
            instance = new BuscaFuncionarioPresenter();
        }
        
        return instance;
    }
    
     public BuscaFuncionarioView getView() {
        return view;
    }
}
