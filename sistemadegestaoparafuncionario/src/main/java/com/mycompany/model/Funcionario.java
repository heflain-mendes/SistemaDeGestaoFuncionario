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
    private int cargo;
    private int bonusHonra;
    private int idade;
    private LocalDate dataInicioNaEmpresa;
    private double salarioBaseAtual;
    private double distanciaDoTrabalho;
    private boolean funcionairoDoMes;

    private List<Falta> faltas;
    private List<Bonus> bonus;
    private List<Salario> salarios;

    public Funcionario(int id,String nome, int cargo, int bonus, int idade, LocalDate dataInicioNaEmpresa, double salarioBaseAtual, double distanciaDoTrabalho, boolean funcionairoDoMes) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataInicioNaEmpresa = dataInicioNaEmpresa;
        this.salarioBaseAtual = salarioBaseAtual;
        this.distanciaDoTrabalho = distanciaDoTrabalho;
        this.funcionairoDoMes = funcionairoDoMes;
        this.bonusHonra = bonus;
        this.idade = idade;
    }

    public Funcionario(String nome, int cargo, int bonus, int idade, LocalDate dataInicioNaEmpresa, double salarioBaseAtual, double distanciaDoTrabalho, boolean funcionairoDoMes) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataInicioNaEmpresa = dataInicioNaEmpresa;
        this.salarioBaseAtual = salarioBaseAtual;
        this.distanciaDoTrabalho = distanciaDoTrabalho;
        this.funcionairoDoMes = funcionairoDoMes;
        this.bonusHonra = bonus;
        this.idade = idade;
        this.id = -1;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        if(id == -1){
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCargo() {
        return cargo;
    }

    public LocalDate getDataInicioNaEmpresa() {
        return dataInicioNaEmpresa;
    }

    public double getSalarioBaseAtual() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public int getBonusHonra() {
        return bonusHonra;
    }

    public void setBonusHonra(int bonusHonra) {
        this.bonusHonra = bonusHonra;
    }
    
    public void setCargo(int cargo) {
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
    
    public Falta getfaltaPelaData(LocalDate date){
        for(Falta f : this.faltas){
            if(f.getDate().getMonth().equals(date.getMonth()) &&
               f.getDate().getYear() == date.getYear())
                return f;
        }
        
        return null;
    }

    public void setFuncionairoDoMes(boolean funcionairoDoMes) {
        this.funcionairoDoMes = funcionairoDoMes;
    }

    public void setDistanciaDoTrabalho(double distanciaDoTrabalho) {
        this.distanciaDoTrabalho = distanciaDoTrabalho;
    }
    
    
}
