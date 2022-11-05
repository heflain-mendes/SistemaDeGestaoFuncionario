/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.dao.DAOSingleton;
import com.mycompany.dao.interfaces.IFuncionarioDAO;
import com.mycompany.model.CargoArquivo;
import com.mycompany.model.Funcionario;
import com.mycompany.view.BuscaFuncionarioView;
import io.github.cdimascio.dotenv.Dotenv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heflain
 */
public class BuscaFuncionarioPresenter {

    private final BuscaFuncionarioView view;
    private DefaultTableModel modelo;

    public BuscaFuncionarioPresenter() {
        view = new BuscaFuncionarioView();
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        carregarTabela();

        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buscar();
            }
        });

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }
        });

        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                criarNovoFuncionario();
            }
        });

        view.getBtnRecarregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                carregarTabela();
            }
        });

        view.getBtnVerBonus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                verBonus();
            }
        });

        view.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                visualizar();
            }
        });

        view.setVisible(true);
    }

    private void carregarTabela() {
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Idade");
        modelo.addColumn("Cargo");
        modelo.addColumn("Salário Base(R$)");

        modelo.setRowCount(0);

        IFuncionarioDAO ifdao = DAOSingleton.getInstance().getFuncionarioDAO();

        List<CargoArquivo> cargos = this.obterListaCargos();

        try {
            for (Funcionario f : ifdao.obterTodos()) {
                modelo.addRow(
                        new Object[]{
                            f.getId(),
                            f.getNome(),
                            f.getIdade(),
                            cargos.get(f.getCargo()).getCargo(),
                            f.getSalarioBaseAtual()
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

        view.getTbListaFuncionario().setModel(modelo);
        view.getTbListaFuncionario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void verBonus() {
        Funcionario f = obterFuncionario();
        if (f != null) {
            new VisualizarBonusPresenter(f);
        }
    }

    private List<CargoArquivo> obterListaCargos() {
        Dotenv dotenv = Dotenv.load();
        Type tipoLista = new TypeToken<ArrayList<CargoArquivo>>() {
        }.getType();
        Gson gson = new Gson();

        return gson.fromJson(dotenv.get("CARGOS"), tipoLista);
    }

    private void buscar() {
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Idade");
        modelo.addColumn("Cargo");
        modelo.addColumn("Salário Base(R$)");

        modelo.setRowCount(0);

        IFuncionarioDAO ifdao = DAOSingleton.getInstance().getFuncionarioDAO();

        List<CargoArquivo> cargos = this.obterListaCargos();
        String pesquisa = view.getTxtNome().getText();

        try {
            for (Funcionario f : ifdao.pesquisarPorNome(pesquisa)) {
                modelo.addRow(
                        new Object[]{
                            f.getId(),
                            f.getNome(),
                            f.getIdade(),
                            cargos.get(f.getCargo()).getCargo(),
                            f.getSalarioBaseAtual()
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

        view.getTbListaFuncionario().setModel(modelo);
    }

    private void fechar() {
        view.dispose();
    }

    private void criarNovoFuncionario() {
        new FuncionarioPresenter(null);
    }

    private void visualizar() {
        Funcionario funcionario = obterFuncionario();

        if (funcionario != null) {
            new FuncionarioPresenter(funcionario);
        } else {
            JOptionPane.showMessageDialog(
                    view,
                    "Funcionario removido do banco de dados",
                    "Erro ao obter usuario",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private Funcionario obterFuncionario() {
        if (view.getTbListaFuncionario().getSelectedRowCount() > 0) {
            IFuncionarioDAO ifdao = DAOSingleton.getInstance().getFuncionarioDAO();
            Integer id = (Integer) modelo.getValueAt(
                    view.getTbListaFuncionario().getSelectedRow(),
                    0
            );
            Funcionario funcionario = null;
            try {
                funcionario = ifdao.obterPorId(id.intValue());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        view,
                        ex,
                        "Erro ao obter usuario",
                        JOptionPane.ERROR_MESSAGE);
            }

            return funcionario;
        }
        return null;
    }
}
