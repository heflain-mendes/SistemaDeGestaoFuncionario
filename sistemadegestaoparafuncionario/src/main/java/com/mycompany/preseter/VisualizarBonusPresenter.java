/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import com.mycompany.view.VisualizarBonusView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.dao.interfaces.IBonusFuncionarioDAO;
import com.mycompany.model.TipoCargo;

/**
 *
 * @author heflain
 */
public class VisualizarBonusPresenter {

    private VisualizarBonusView view;
    private Funcionario funcionario;

    public VisualizarBonusPresenter(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.view = new VisualizarBonusView(null, true);
        carregarComponentes();
    }

    private void carregarComponentes() {
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }
        });

        carregarTabela();
        
        view.getLblNome().setText(funcionario.getNome());
        
        view.setVisible(true);
    }

    private void carregarTabela() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Data calculo");
        modelo.addColumn("cargo");
        modelo.addColumn("tipo bonus");
        modelo.addColumn("Valor Bonus");

        IBonusFuncionarioDAO bonusDAO = DAOSingleton.getInstance().getBonusDAO();
        try {
            for (Bonus b : bonusDAO.obter(funcionario.getId())) {
                modelo.addRow(new Object[]{
                    b.getData().format(formatter),
                    obterCargoPorId(b.getCargo()).getNome(),
                    b.getTipo(),
                    b.getValor()
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

        view.getTblBonus().setModel(modelo);
    }

    private void fechar() {
        view.dispose();
    }
    
    private TipoCargo obterCargoPorId(int id){
        try {
            return DAOSingleton.getInstance().getTipoCargoDAO().obter(id);
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
}
