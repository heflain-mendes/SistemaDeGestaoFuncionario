/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.model.Funcionario;
import com.mycompany.view.CadastraVisualizarFuncionarioView;
import java.util.List;

/**
 *
 * @author heflain
 */
public class CadastraFuncionarioPresenter {

    private static CadastraFuncionarioPresenter instance = null;
    private final CadastraVisualizarFuncionarioView view;

    private List<Funcionario> state;
    private final Funcionario funcionario;

    private CadastraFuncionarioPresenter() {
        this.funcionario = null;

        view = new CadastraVisualizarFuncionarioView();
        view.setLocation(20, 20);
        view.setVisible(true);
    }

    public static CadastraFuncionarioPresenter getInstance() {
        if (instance == null) {
            instance = new CadastraFuncionarioPresenter();
        }

        return instance;
    }

    public void setState(List<Funcionario> state) {
        this.state = state;
    }

    public void limparCampos() {
        getView().getTxtNome().setText("");
        getView().getTxtIdade().setText("");
        getView().getTxtSalario().setText("");
        getView().getTxtAdmissao().setText("");
        getView().getCbBonus().setSelectedIndex(-1);
        getView().getCbCargo().setSelectedIndex(-1);
        getView().getCbFuncionarioDoMes().setSelected(false);
    }

    private boolean camposEstaoVazios() {
        return view.getTxtNome().getText().equals("")
                || view.getTxtSalario().getText().equals("")
                || view.getTxtIdade().getText().equals("")
                || view.getTxtAdmissao().getText().equals("")
                || view.getCbCargo().getSelectedIndex() == -1;
    }

    private void setFuncionario() {

        String cargo = String.valueOf(view.getCbCargo().getSelectedItem());
        Double salarioBaseAtual = Double.valueOf(view.getTxtSalario().getText());
//        if (cargo.equalsIgnoreCase("outro")) {
//            cargo = view.getTfdOutro().getText();
//        }

        funcionario.setCargo(cargo);
        funcionario.setNome(view.getTxtNome().getText());     
//        funcionario.setDataInicioNaEmpresa(view.getTxtAdmissao().getText());
        funcionario.setSalarioBaseAtual(salarioBaseAtual);
        

    }

    public CadastraVisualizarFuncionarioView getView() {
        return view;
    }

}
