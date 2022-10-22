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
    private Long id;
    private String nome;
    private String cargo;
    private LocalDate dataInicioNaEmpresa;
    private Double salarioBaseAtual;

    private List<Falta> faltas;
    private List<Bonus> bonus;
    private List<Salario> salarios;

    public Funcionario(String nome, String cargo, LocalDate dataInicioNaEmpresa, Double salarioBaseAtual) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataInicioNaEmpresa = dataInicioNaEmpresa;
        this.salarioBaseAtual = salarioBaseAtual;
    }

    public long getId() {
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

    public void setId(Long id) {
        this.id = id;
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
}
