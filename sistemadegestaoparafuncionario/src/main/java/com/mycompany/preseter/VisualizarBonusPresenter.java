/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.dao.DAOSingleton;
import com.mycompany.dao.interfaces.IBonusDAO;
import com.mycompany.model.Bonus;
import com.mycompany.model.CargoArquivo;
import com.mycompany.model.Funcionario;
import com.mycompany.view.VisualizarBonusView;
import io.github.cdimascio.dotenv.Dotenv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

        IBonusDAO bonusDAO = DAOSingleton.getInstance().getBonusDAO();
        List<CargoArquivo> cargos = this.obterListaCargos();
        try {
            for (Bonus b : bonusDAO.obter(funcionario.getId())) {
                modelo.addRow(new Object[]{
                    b.getData().format(formatter),
                    cargos.get(b.getCargo()),
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
    
    private List<CargoArquivo> obterListaCargos() {
        Dotenv dotenv = Dotenv.load();
        Type tipoLista = new TypeToken<ArrayList<CargoArquivo>>() {
        }.getType();
        Gson gson = new Gson();

        return gson.fromJson(dotenv.get("CARGOS"), tipoLista);
    }
}
