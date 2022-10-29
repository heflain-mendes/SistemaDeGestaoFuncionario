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

    public CadastraVisualizarFuncionarioView getView() {
        return view;
    }

}
