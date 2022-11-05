/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter.states;

import com.mycompany.preseter.FuncionarioPresenter;
import java.sql.SQLException;

/**
 *
 * @author heflain
 */
public class FuncionarioState {
    FuncionarioPresenter funcionarioPresenter;

    public FuncionarioState(FuncionarioPresenter funcionarioPresenter) {
        this.funcionarioPresenter = funcionarioPresenter;
    }
    
    public void salvar() throws Exception, SQLException{
        throw new Exception("Botão salvar não pode ser acionado");
    }
    
    public void visualizar() throws Exception, SQLException{
        throw new Exception("Botão visualizar não pode ser acionado");
    }
    
    public void editar() throws Exception, SQLException{
        throw new Exception("Botão editar não pode ser acionado");
    }
    
    public void excluir() throws Exception, SQLException{
        throw new Exception("Botão excluir não pode ser acionado");
    }
    
    public void removerConfiguracoesAnterior(){
        this.funcionarioPresenter.getView().getCbxCargo().setEnabled(false);
        this.funcionarioPresenter.getView().getCbBonus().setEnabled(false);
        this.funcionarioPresenter.getView().getCbFuncionarioDoMes().setEnabled(false);
        
        this.funcionarioPresenter.getView().getTxtNome().setEditable(false);
        this.funcionarioPresenter.getView().getTxtIdade().setEditable(false);
        this.funcionarioPresenter.getView().getTxtAdmissao().setEditable(false);
        this.funcionarioPresenter.getView().getTxtSalario().setEditable(false);
        this.funcionarioPresenter.getView().getTxtDistancia().setEditable(false);

        this.funcionarioPresenter.getView().getBtnSalvar().setVisible(false);
        this.funcionarioPresenter.getView().getBtnExcluir().setVisible(false);
        this.funcionarioPresenter.getView().getBtnAddFaltas().setVisible(false);
        this.funcionarioPresenter.getView().getBtnEditar().setVisible(false);
    }
}
