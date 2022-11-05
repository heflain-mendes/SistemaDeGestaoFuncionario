/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.business.calculobonus.ExecutaCalculoBonus;
import com.mycompany.business.calculobonus.calculosbonusfactories.ListaCalculoBonusComumFactory;
import com.mycompany.business.calculosalario.CalculoSalario;
import com.mycompany.business.calculosestatistico.ExecutaCalculoEstatistico;
import com.mycompany.dao.DAOSingleton;
import com.mycompany.dao.interfaces.IFuncionarioDAO;
import com.mycompany.dao.interfaces.ISalarioDAO;
import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import com.mycompany.service.CalculaBonusService;
import com.mycompany.service.CalculaSalarioService;
import com.mycompany.service.CalculoEstatisticoService;
import com.mycompany.view.CalculaSalarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heflain
 */
public class CalculaSalarioPresenter {

    private final CalculaSalarioView view;

    public CalculaSalarioPresenter() {
        view = new CalculaSalarioView();
        iniciarComponenetes();
    }

    private void iniciarComponenetes() {
        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buscarPorData();
            }

        });

        view.getBtnListarTodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                carregarTabela();
            }

        });

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }

        });

        view.getBtnCalcular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calcular();
            }

        });

        carregarTabela();
        view.getTbSalarioFuncionario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        view.setVisible(true);
    }

    private void carregarTabela() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("data");
        modelo.addColumn("Salário Base(R$)");
        modelo.addColumn("Salario(R$)");
        modelo.addColumn("Bonus(R$)");

        modelo.setRowCount(0);

        IFuncionarioDAO ifdao = DAOSingleton.getInstance().getFuncionarioDAO();
        ISalarioDAO isdao = DAOSingleton.getInstance().getSalarioDAO();

        try {
            for (Funcionario f : ifdao.obterTodos()) {
                for (Salario s : isdao.obter(f.getId())) {

                    modelo.addRow(
                            new Object[]{
                                f.getNome(),
                                s.getData().format(formatter),
                                s.getSalarioBase(),
                                s.getSalarioTotal(),
                                s.getSalarioTotal() - s.getSalarioBase()
                            });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro ao carregar tabela",
                    JOptionPane.ERROR_MESSAGE);
        }

        view.getTbSalarioFuncionario().setModel(modelo);
    }

    private void buscarPorData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(view.getTxtData().getText(), formatter);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("data");
        modelo.addColumn("Salário Base(R$)");
        modelo.addColumn("Salario(R$)");
        modelo.addColumn("Bonus(R$)");

        modelo.setRowCount(0);

        IFuncionarioDAO ifdao = DAOSingleton.getInstance().getFuncionarioDAO();
        ISalarioDAO isdao = DAOSingleton.getInstance().getSalarioDAO();

        try {
            for (Funcionario f : ifdao.obterTodos()) {
                for (Salario s : isdao.obterPorData(f.getId(), data)) {

                    modelo.addRow(
                            new Object[]{
                                f.getNome(),
                                s.getData().format(formatter),
                                s.getSalarioBase(),
                                s.getSalarioTotal(),
                                s.getSalarioTotal() - s.getSalarioBase()
                            });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro ao carregar tabela",
                    JOptionPane.ERROR_MESSAGE);
        }

        view.getTbSalarioFuncionario().setModel(modelo);
    }

    private void fechar() {
        view.dispose();
    }

    private void calcular() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(view.getTxtDataCalculo().getText(), formatter);

        CalculaBonusService bonusService = new CalculaBonusService(
                new ExecutaCalculoBonus(
                        new ListaCalculoBonusComumFactory().obterLista()
                )
        );

        CalculaSalarioService salarioService = new CalculaSalarioService(
                new CalculoSalario()
        );

        CalculoEstatisticoService calculoEstatisticoService
                = new CalculoEstatisticoService(
                       new ExecutaCalculoEstatistico()
                );

        List<Salario> lSalario = new ArrayList<>();

        IFuncionarioDAO ifdao = DAOSingleton.getInstance().getFuncionarioDAO();

        try {
            for (Funcionario f : ifdao.obterTodos()) {
                List<Bonus> lBonus = bonusService.calcular(f, data);
                lSalario.add(salarioService.calcular(f, lBonus, data));
            }

            calculoEstatisticoService.calcular(lSalario, data);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro ao calcular bonus",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        carregarTabela();
    }
}
