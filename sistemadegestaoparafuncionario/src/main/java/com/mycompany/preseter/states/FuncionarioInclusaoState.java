/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter.states;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.model.Funcionario;
import com.mycompany.preseter.FuncionarioPresenter;
import com.mycompany.view.FuncionarioView;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author heflain
 */
public class FuncionarioInclusaoState extends FuncionarioState{
    
    public FuncionarioInclusaoState(FuncionarioPresenter funcionarioPresenter) {
        super(funcionarioPresenter);
        this.removerConfiguracoesAnterior();
        this.configuraView();
        this.funcionarioPresenter.setFuncionarioState(this);
        this.funcionarioPresenter.getView().setVisible(true);
    }
    
    private void configuraView(){
        FuncionarioView view = this.funcionarioPresenter.getView();
        
        view.getCbxCargo().setEnabled(true);
        view.getCbBonus().setEnabled(true);
        view.getCbFuncionarioDoMes().setEnabled(true);
        
        view.getTxtNome().setEditable(true);
        view.getTxtIdade().setEditable(true);
        view.getTxtAdmissao().setEditable(true);
        view.getTxtSalario().setEditable(true);
        view.getTxtDistancia().setEditable(true);
        
        view.getBtnSalvar().setVisible(true);
        view.getBtnAddFaltas().setVisible(false);
        view.getBtnExcluir().setVisible(false);
        view.getBtnEditar().setVisible(false);
    }

    @Override
    public void salvar() throws Exception, SQLException {
        FuncionarioView view = this.funcionarioPresenter.getView();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Funcionario funcionario = new Funcionario(
                view.getTxtNome().getText(),
                view.getCbxCargo().getSelectedIndex(),
                view.getCbBonus().getSelectedIndex(),
                Integer.parseInt(view.getTxtIdade().getText()),
                LocalDate.parse(view.getTxtAdmissao().getText(), formatter),
                Double.parseDouble(view.getTxtSalario().getText()),
                Double.parseDouble(view.getTxtDistancia().getText()),
                view.getCbFuncionarioDoMes().isSelected()
        );
        
        funcionario = DAOSingleton.getInstance().getFuncionarioDAO().salvar(funcionario);
        
        this.funcionarioPresenter.setFuncionario(funcionario);
        
        funcionarioPresenter.setFuncionarioState(
                new FuncionarioVisualizacaoState(
                        this.funcionarioPresenter
                )
        );
    }
}
