/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.preseter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.model.BonusArquivo;
import com.mycompany.model.CargoArquivo;
import com.mycompany.model.Funcionario;
import com.mycompany.preseter.states.FuncionarioInclusaoState;
import com.mycompany.preseter.states.FuncionarioState;
import com.mycompany.preseter.states.FuncionarioVisualizacaoState;
import com.mycompany.view.FuncionarioView;
import io.github.cdimascio.dotenv.Dotenv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class FuncionarioPresenter {
    
    private Funcionario funcionario;
    private FuncionarioView view;
    private FuncionarioState funcionarioState;

    public FuncionarioPresenter(Funcionario funcionario) {
        this.view = new FuncionarioView();
        this.funcionario = funcionario;
        this.iniciarCommponentes();
        if(this.funcionario == null){
            new FuncionarioInclusaoState(this);
        }else{
            new FuncionarioVisualizacaoState(this);
        }
    }
    
    public FuncionarioView getView(){
        return this.view;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
    
    public void setFuncionarioState(FuncionarioState funcionarioState){
        this.funcionarioState = funcionarioState;
    }
    
    public void iniciarCommponentes(){
        
        for(CargoArquivo c : obterListaCargos()){
            this.view.getCbxCargo().addItem(c.getCargo());
        }
        
        for(BonusArquivo b : obterListaBonus()){
            this.view.getCbBonus().addItem(b.getBonus());
        }
        
        this.view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                fechar();
            }
            
        });
        
        this.view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                salvar();
            }
            
        });
        
        this.view.getBtnExcluir().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                excluir();
            }
            
        });
        
        this.view.getBtnEditar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                editar();
            }
            
        });
    }
    
    private List<CargoArquivo> obterListaCargos(){
        Dotenv dotenv = Dotenv.load();
        Type tipoLista = new TypeToken<ArrayList<CargoArquivo>>(){}.getType();
        Gson gson = new Gson();
        
        return gson.fromJson(dotenv.get("CARGOS"), tipoLista);
    }
    
    private List<BonusArquivo> obterListaBonus(){
        Dotenv dotenv = Dotenv.load();
        Type tipoLista = new TypeToken<ArrayList<BonusArquivo>>(){}.getType();
        Gson gson = new Gson();
        
        return gson.fromJson(dotenv.get("BONUS"), tipoLista);
    }
    
    public void salvar(){
        try {
            this.funcionarioState.salvar();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void fechar() {
        view.dispose();
    }
    
    public void editar(){
        try {
            this.funcionarioState.editar();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void excluir(){
        try {
            this.funcionarioState.excluir();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void adicionarFalta(){
        
    }
}
