/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heflain
 */
public class PrincipalPresenter {

    private static PrincipalPresenter instance = null;
    private final PrincipalView view;
    private CadastraFuncionarioPresenter cadastraFuncionarioPresenter;

    private PrincipalPresenter() {
        view = new PrincipalView();
        view.setVisible(true);
        
        initListeners();
    }

    public static PrincipalPresenter getInstance() {
        if (instance == null) {
            instance = new PrincipalPresenter();
        }
        return instance;
    }
    
    
    private void initListeners(){
        try {
            
            view.getMiCadastraFuncionario().addActionListener((ActionEvent e) -> {
                try {
                    cadastraFuncionarioPresenter = CadastraFuncionarioPresenter.getInstance();
                    
                    
                } catch (Exception e) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, e);
                }
            });
            
              
            
        } catch (Exception e) {
        }
            
    }

}
