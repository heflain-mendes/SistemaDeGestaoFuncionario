/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.model.Funcionario;
import com.mycompany.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class PrincipalPresenter {

    private static PrincipalPresenter instance = null;
    private final PrincipalView view;
    private CadastraFuncionarioPresenter cadastraFuncionarioPresenter;
    private BuscaFuncionarioPresenter buscaFuncionarioPresenter;
    private CalculaSalarioPresenter calculaSalarioPresenter;
    private final ArrayList<Funcionario> funcionarioList;

    private PrincipalPresenter() {
        view = new PrincipalView();
        view.setVisible(true);
        funcionarioList = new ArrayList();

        initListeners();
    }

    public static PrincipalPresenter getInstance() {
        if (instance == null) {
            instance = new PrincipalPresenter();
        }
        return instance;
    }

    private void initListeners() {
        try {

            view.getMiCadastrarFuncionario().addActionListener((var e) -> {
                try {
                    cadastraFuncionarioPresenter = CadastraFuncionarioPresenter.getInstance();
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

    }

}
