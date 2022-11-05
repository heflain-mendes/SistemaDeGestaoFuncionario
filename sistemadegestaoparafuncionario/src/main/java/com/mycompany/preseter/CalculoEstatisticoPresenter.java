/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.dao.interfaces.ICalculoEstatisticoDAO;
import com.mycompany.model.CalculoEstatistico;
import com.mycompany.view.CalculoEstatisticoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heflain
 */
public class CalculoEstatisticoPresenter {

    private CalculoEstatisticoView view;

    public CalculoEstatisticoPresenter() {
        this.view = new CalculoEstatisticoView(null, true);
        carregarTabela();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }

        });

        view.setVisible(true);
    }

    private void carregarTabela() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Resultado");
        modelo.addColumn("Somatorio");
        modelo.addColumn("Média");
        modelo.addColumn("Desvio Padrão");
        modelo.addColumn("Maior salario");
        modelo.addColumn("Menor Salario");
        modelo.addColumn("qtd salarios");
        modelo.addColumn("coeficiente variação");

        ICalculoEstatisticoDAO calculoEstatisticoDAO
                = DAOSingleton.getInstance().getCalculoEstatisticoDAO();

        try {
            for (CalculoEstatistico ce : calculoEstatisticoDAO.obterTodos()) {
                modelo.addRow(new Object[]{
                    ce.getData().format(formatter),
                    ce.getSomatorio(),
                    ce.getMedia(),
                    ce.getDesvioPadrao(),
                    ce.getMaiorSalario(),
                    ce.getMenorSalario(),
                    ce.getQttSalario(),
                    ce.getCoeficienteVariacao()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    view,
                    ex.getMessage(),
                    "Erro ao carregar tabela",
                    JOptionPane.ERROR_MESSAGE);
        }

        view.getTblResultados().setModel(modelo);
    }

    private void fechar(){
        view.dispose();
    }
}
