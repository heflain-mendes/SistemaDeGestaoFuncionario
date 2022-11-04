/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.model.Funcionario;
import com.mycompany.preseter.states.FuncionarioState;
import com.mycompany.view.PrincipalView;

/**
 *
 * @author heflain
 */
public class PrincipalPresenter {
    private PrincipalView view;
    private FuncionarioState funcionarioState;
    private Funcionario funcionario;
    
    
    public PrincipalPresenter(Funcionario funcionairo) {
        this.view = new PrincipalView();
        
    }

    
    /*
    private void initListeners() {
        try {

            view.getMiCadastrarFuncionario().addActionListener((var e) -> {
                try {
                    cadastraFuncionarioPresenter = FuncionarioPresenter.getInstance();
                    cadastraFuncionarioPresenter.setState(funcionarioList);
                    view.add(cadastraFuncionarioPresenter.getView());

                } catch (Exception ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            view.getMiBuscarFuncionario().addActionListener((ActionEvent e) -> {
                try {
                    buscaFuncionarioPresenter = BuscaFuncionarioPresenter.getInstance();
                    view.add(cadastraFuncionarioPresenter.getView());
                } catch (Exception ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            view.getMiCalcularSalario().addActionListener((var e) -> {
                try {
                  calculaSalarioPresenter = CalculaSalarioPresenter.getInstance();
                  view.add(calculaSalarioPresenter.getView());
                } catch (Exception ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (Exception e) {
            Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }*/
}
