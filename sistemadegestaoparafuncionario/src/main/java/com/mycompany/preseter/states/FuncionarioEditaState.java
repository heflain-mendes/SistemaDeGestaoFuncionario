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
public class FuncionarioEditaState extends FuncionarioState {

    public FuncionarioEditaState(FuncionarioPresenter funcionarioPresenter) {
        super(funcionarioPresenter);
        this.configuraView();
        this.funcionarioPresenter.setFuncionarioState(this);
        this.funcionarioPresenter.getView().setVisible(true);
        this.funcionarioPresenter.getView().setVisible(true);
    }

    public void configuraView() {
        System.out.println("Entrei");
        FuncionarioView view = this.funcionarioPresenter.getView();

        view.getCbxCargo().setEnabled(true);
        view.getCbBonus().setEnabled(true);
        view.getCbFuncionarioDoMes().setEnabled(true);

        view.getTxtNome().setEditable(true);
        view.getTxtIdade().setEditable(true);
        view.getTxtAdmissao().setEditable(true);
        view.getTxtSalario().setEditable(true);
        view.getTxtDistancia().setEditable(true);

        view.getBtnExcluir().setVisible(false);
    }

    @Override
    public void editar() throws Exception, SQLException {
        FuncionarioView view = this.funcionarioPresenter.getView();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Funcionario funcionario = this.funcionarioPresenter.getFuncionario();
        funcionario.setNome(view.getTxtNome().getText());
        funcionario.setCargo(obterCargoPorNome(view.getCbxCargo().getSelectedItem().toString()));
        funcionario.setBonusHonra(obterBonusPorNome(view.getCbBonus().getSelectedItem().toString()));
        funcionario.setIdade(Integer.parseInt(view.getTxtIdade().getText()));
        funcionario.setDataInicioNaEmpresa(LocalDate.parse(view.getTxtAdmissao().getText(), formatter));
        funcionario.setSalarioBaseAtual(Double.parseDouble(view.getTxtSalario().getText()));
        funcionario.setDistanciaDoTrabalho(Double.parseDouble(view.getTxtDistancia().getText()));
        funcionario.setFuncionairoDoMes(view.getCbFuncionarioDoMes().isSelected());

        DAOSingleton.getInstance().getFuncionarioDAO().atualizar(funcionario);

        funcionarioPresenter.setFuncionarioState(new FuncionarioVisualizacaoState(funcionarioPresenter));
    }

    private int obterCargoPorNome(String nome) throws Exception {
        return DAOSingleton.getInstance().getTipoCargoDAO().obterId(nome);
    }
    
    private int obterBonusPorNome(String nome) throws Exception{
        return DAOSingleton.getInstance().getTipoBonusDAO().obterId(nome);
    }
}
