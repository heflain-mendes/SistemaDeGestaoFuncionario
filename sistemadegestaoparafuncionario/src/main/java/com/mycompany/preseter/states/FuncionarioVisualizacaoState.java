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
import java.time.format.DateTimeFormatter;

/**
 *
 * @author heflain
 */
public class FuncionarioVisualizacaoState extends FuncionarioState{
    
    public FuncionarioVisualizacaoState(FuncionarioPresenter funcionarioPresenter) {
        super(funcionarioPresenter);
        this.removerConfiguracoesAnterior();
        this.configuraView();
        this.funcionarioPresenter.setFuncionarioState(this);
        this.funcionarioPresenter.getView().setVisible(true);
    }
    
    private void configuraView(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        FuncionarioView view = this.funcionarioPresenter.getView();
        Funcionario funcionario = this.funcionarioPresenter.getFuncionario();
        
        view.getTxtNome().setText(funcionario.getNome());
        view.getCbBonus().setSelectedIndex(funcionario.getBonusHonra());
        view.getCbxCargo().setSelectedIndex(funcionario.getCargo());
        view.getTxtAdmissao().setText(funcionario.getDataInicioNaEmpresa().format(formatter));
        view.getTxtDistancia().setText(String.valueOf(funcionario.getDistanciaDoTrabalho()));
        view.getTxtSalario().setText(String.valueOf(funcionario.getSalarioBaseAtual()));
        view.getTxtIdade().setText(String.valueOf(funcionario.getIdade()));
        view.getCbFuncionarioDoMes().setSelected(funcionario.IsFuncionairoDoMes());
        
        view.getBtnEditar().setVisible(true);
        view.getBtnExcluir().setVisible(true);
    }

    @Override
    public void excluir() throws Exception, SQLException {
        Funcionario funcionario = this.funcionarioPresenter.getFuncionario();
        DAOSingleton instance = DAOSingleton.getInstance();
        instance.getFuncionarioDAO().remover(funcionario);
        instance.getBonusDAO().removerTodos(funcionario.getId());
        instance.getFaltaDAO().remover(funcionario.getId());
        funcionarioPresenter.fechar();
    }

    @Override
    public void editar() throws Exception, SQLException {
        this.funcionarioPresenter.setFuncionarioState(new FuncionarioEditaState(this.funcionarioPresenter));
    }
}
