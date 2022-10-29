/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private LocalDate dataInicioNaEmpresa;
    private double salarioBaseAtual;
    private double distanciaDoTrabalho;
    private boolean funcionairoDoMes;

    private List<Falta> faltas;
    private List<Bonus> bonus;
    private List<Salario> salarios;

    public Funcionario(int id,String nome, String cargo, LocalDate dataInicioNaEmpresa, double salarioBaseAtual, double distanciaDoTrabalho, boolean funcionairoDoMes) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataInicioNaEmpresa = dataInicioNaEmpresa;
        this.salarioBaseAtual = salarioBaseAtual;
        this.distanciaDoTrabalho = distanciaDoTrabalho;
        this.funcionairoDoMes = funcionairoDoMes;
    }

    public Funcionario(String nome, String cargo, LocalDate dataInicioNaEmpresa, double salarioBaseAtual, double distanciaDoTrabalho, boolean funcionairoDoMes) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataInicioNaEmpresa = dataInicioNaEmpresa;
        this.salarioBaseAtual = salarioBaseAtual;
        this.distanciaDoTrabalho = distanciaDoTrabalho;
        this.funcionairoDoMes = funcionairoDoMes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public LocalDate getDataInicioNaEmpresa() {
        return dataInicioNaEmpresa;
    }

    public Double getSalarioBaseAtual() {
        return salarioBaseAtual;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public List<Bonus> getBonus() {
        return bonus;
    }

    public List<Salario> getSalarios() {
        return salarios;
    }
    
    public double getDistanciaDoTrabalho(){
        return distanciaDoTrabalho;
    }

    public boolean IsFuncionairoDoMes() {
        return funcionairoDoMes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDataInicioNaEmpresa(LocalDate dataInicioNaEmpresa) {
        this.dataInicioNaEmpresa = dataInicioNaEmpresa;
    }

    public void setSalarioBaseAtual(Double salarioBaseAtual) {
        this.salarioBaseAtual = salarioBaseAtual;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    public void setBonus(List<Bonus> bonus) {
        this.bonus = bonus;
    }

    public void setSalarios(List<Salario> salarios) {
        this.salarios = salarios;
    }
    
    public void getfaltaPelaData(LocalDate date){
        for(Falta f : this.faltas){
            if(f.getDate().equals(f))
                return f;
        }
    }
}
