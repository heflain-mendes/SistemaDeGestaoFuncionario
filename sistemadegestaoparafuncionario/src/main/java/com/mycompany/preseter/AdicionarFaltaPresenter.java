/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.dao.interfaces.IFaltaDAO;
import com.mycompany.model.Falta;
import com.mycompany.model.Funcionario;
import com.mycompany.view.AdicionaFaltaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class AdicionarFaltaPresenter {

    private Funcionario funcionario;
    private final AdicionaFaltaView view;

    public AdicionarFaltaPresenter(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.view = new AdicionaFaltaView();
        iniciarComponente();
    }

    private void iniciarComponente() {
        this.view.getTxtNome().setText(funcionario.getNome());
        this.view.getTxtNome().setEditable(false);

        this.view.getBtnFechar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }

        });

        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                salvar();
            }
        });
        
        view.setVisible(true);
    }

    private void fechar() {
        view.dispose();
    }
    
    private void salvar(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        IFaltaDAO faltaDAO = DAOSingleton.getInstance().getFaltaDAO();
        Falta falta = new Falta(
                LocalDate.parse(view.getTxtData().getText(), formatter),
                Integer.parseInt(view.getTxtFaltas().getText()));
        try {
            faltaDAO.salvar(funcionario.getId(), falta);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "erro a o salvar faltas", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        JOptionPane.showMessageDialog(
                    null,
                    "Faltas adicionadas com sucesso",
                    "sucesso", 
                    JOptionPane.INFORMATION_MESSAGE
            );
        
        fechar();
    }
}
