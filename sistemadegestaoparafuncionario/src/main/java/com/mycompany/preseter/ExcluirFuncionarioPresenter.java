/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.model.Funcionario;
import com.mycompany.view.ExcluirFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class ExcluirFuncionarioPresenter {
    private ExcluirFuncionarioView view;
    private Funcionario funcionario;

    public ExcluirFuncionarioPresenter(Funcionario funcionario) {
        this.view = new ExcluirFuncionarioView(null, true);
        this.funcionario = funcionario;
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }
        
        });
        
        view.getBtnExcluir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    excluir();
                } catch (Exception ex) {
                    ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "erro ao excluir funcionario",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        
        });
        
        view.setTitle("Mensagem de exclusao");
        
        view.getTxtMensagem().setText("Deseja realmente excluir o funcionario ?");
        view.getTxtMensagem().setEditable(false);
        
        view.setVisible(true);
    }
    
    private void excluir() throws Exception, SQLException{
        DAOSingleton instance = DAOSingleton.getInstance();
        instance.getFuncionarioDAO().remover(funcionario);
        instance.getBonusDAO().removerTodos(funcionario.getId());
        instance.getFaltaDAO().remover(funcionario.getId());
        fechar();
    }
    
    private void fechar(){
        view.dispose();
    }
    
    
            
}
