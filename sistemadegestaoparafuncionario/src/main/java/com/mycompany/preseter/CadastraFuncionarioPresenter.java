/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

/**
 *
 * @author heflain
 */
public class CadastraFuncionarioPresenter {
    
    private static CadastraFuncionarioPresenter instance = null;
    
    private CadastraFuncionarioPresenter() {
    }
    
    private CadastraFuncionarioPresenter getInstance(){
        if(instance == null){
            instance = new CadastraFuncionarioPresenter();
        }
        
        return instance
    }

  
    
}
