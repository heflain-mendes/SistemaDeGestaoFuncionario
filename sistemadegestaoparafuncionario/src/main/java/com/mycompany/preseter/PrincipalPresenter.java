/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author heflain
 */
public class PrincipalPresenter {

    private PrincipalView view;

    public PrincipalPresenter() {
        this.view = new PrincipalView();
        this.initListeners();
    }

    private void initListeners() {

        view.getMiCadastrarFuncionario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cadastraFuncionario();
            }
        });

        view.getMiBuscarFuncionario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buscarFuncionario();
            }
        });

        view.getMiCalcularSalario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calcularSalario();
            }
        });
        
        view.getMiCalculosEstatistico().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calculoEstatistico();
            }
        });
        
        view.setVisible(true);
    }

    private void cadastraFuncionario() {
        new FuncionarioPresenter(null);
    }

    private void buscarFuncionario() {
        new BuscaFuncionarioPresenter();
    }

    private void calcularSalario() {
        new CalculaSalarioPresenter();
    }
    
    private void calculoEstatistico(){
        new CalculoEstatisticoPresenter();
    }
}
