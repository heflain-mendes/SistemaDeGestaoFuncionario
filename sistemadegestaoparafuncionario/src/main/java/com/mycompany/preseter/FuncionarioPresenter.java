/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.dao.DAOUtilitarios;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Bonus;
import com.mycompany.model.Cargo;
import com.mycompany.preseter.states.FuncionarioInclusaoState;
import com.mycompany.preseter.states.FuncionarioState;
import com.mycompany.preseter.states.FuncionarioVisualizacaoState;
import com.mycompany.view.FuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class FuncionarioPresenter {
    
    private Funcionario funcionario;
    private FuncionarioView view;
    private FuncionarioState funcionarioState;
    private List<Cargo> listaCargo;
    private List<Bonus> listaBonus;

    public FuncionarioPresenter(Funcionario funcionario) {
        this.view = new FuncionarioView();
        this.funcionario = funcionario;
        listaCargo = obterListaCargos();
        listaBonus = obterListaBonus();
        this.iniciarCommponentes();
        if(this.funcionario == null){
            new FuncionarioInclusaoState(this);
        }else{
            new FuncionarioVisualizacaoState(this);
        }
        
        
    }
    
    public FuncionarioView getView(){
        return this.view;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
    
    public void setFuncionarioState(FuncionarioState funcionarioState){
        this.funcionarioState = funcionarioState;
    }
    
    public void iniciarCommponentes(){
        
        this.view.getCbBonus().removeAllItems();
        this.view.getCbxCargo().removeAllItems();
        
        for(Cargo c : listaCargo){
            this.view.getCbxCargo().addItem(c.getNome());
        }
        
        
        for(Bonus b : listaBonus){
            this.view.getCbBonus().addItem(b.getNoma());
        }
        
        this.view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }
            
        });
        
        this.view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                salvar();
            }
            
        });
        
        this.view.getBtnExcluir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                excluir();
            }
            
        });
        
        this.view.getBtnEditar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                editar();
            }
            
        });
        
        this.view.getBtnAddFaltas().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarFalta();
            }
            
        });
    }
    
    private List<Cargo> obterListaCargos(){
        try {
            return DAOUtilitarios.getInstance().getTipoCargoDAO().obterTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return null;
    }
    
    private List<Bonus> obterListaBonus(){
        try {
            return DAOUtilitarios.getInstance().getTipoBonusDAO().obterTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        } 
        return null;
    }
    
    private  void salvar(){
        try {
            this.funcionarioState.salvar();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void fechar() {
        view.dispose();
    }
    
    private void editar(){
        try {
            this.funcionarioState.editar();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void excluir(){
        try {
            this.funcionarioState.excluir();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void adicionarFalta(){
        new AdicionarFaltaPresenter(funcionario);
    }

    public List<Cargo> getListaCargo() {
        return listaCargo;
    }

    public List<Bonus> getListaBonus() {
        return listaBonus;
    }
}
