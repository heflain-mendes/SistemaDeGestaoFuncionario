/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter.states;

import com.mycompany.model.Funcionario;
import com.mycompany.model.TipoBonus;
import com.mycompany.model.TipoCargo;
import com.mycompany.preseter.ExcluirFuncionarioPresenter;
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
        view.getCbBonus().setSelectedIndex(obterIndexBonus(funcionario.getBonusHonra()));
        view.getCbxCargo().setSelectedIndex(obterIndexCargo(funcionario.getCargo()));
        view.getTxtAdmissao().setText(funcionario.getDataInicioNaEmpresa().format(formatter));
        view.getTxtDistancia().setText(String.valueOf(funcionario.getDistanciaDoTrabalho()));
        view.getTxtSalario().setText(String.valueOf(funcionario.getSalarioBaseAtual()));
        view.getTxtIdade().setText(String.valueOf(funcionario.getIdade()));
        view.getCbFuncionarioDoMes().setSelected(funcionario.IsFuncionairoDoMes());
        
        view.getBtnEditar().setVisible(true);
        view.getBtnExcluir().setVisible(true);
        view.getBtnAddFaltas().setVisible(true);
    }

    @Override
    public void excluir() throws Exception, SQLException {
        Funcionario funcionario = this.funcionarioPresenter.getFuncionario();
        new ExcluirFuncionarioPresenter(funcionario);
        funcionarioPresenter.fechar();
    }

    @Override
    public void editar() throws Exception, SQLException {
        this.funcionarioPresenter.setFuncionarioState(new FuncionarioEditaState(this.funcionarioPresenter));
    }
    
    private int obterIndexBonus(int id){
        for(TipoBonus b : this.funcionarioPresenter.getListaBonus()){
            if(b.getId() == id){
                return funcionarioPresenter.getListaBonus().indexOf(b);
            }
        }
        
        return -1;
    }
    
    private int obterIndexCargo(int id){
        for(TipoCargo c : this.funcionarioPresenter.getListaCargo()){
            if(c.getId() == id){
                return funcionarioPresenter.getListaCargo().indexOf(c);
            }
        }
        
        System.out.println("Chegou aki");
        return -1;
    }
}
