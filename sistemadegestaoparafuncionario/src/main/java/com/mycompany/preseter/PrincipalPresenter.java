/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.dao.DAOUtilitarios;
import com.mycompany.view.PrincipalView;
import io.github.cdimascio.dotenv.Dotenv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
        Dotenv dotenv = Dotenv.load();
        view.getTxtVersaoBiulder().setText("1.0-SNAPSHOT");
        
        try {
            view.getTxtQtdFuncionarios().setText(
                    "" +
                            DAOUtilitarios.getInstance().getFuncionarioDAO().qtdFuncionarioCadastrado() +
                            " funcionarios"
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "erro a o carregar pagina inicial", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        view.getTxtPersistencia().setText(dotenv.get("BANCO_DE_DADOS"));

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
