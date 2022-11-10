/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author heflain
 */
public class TipoCargo {
    private int id;
    private String nome;
    private double porcentagemBonus;

    public TipoCargo(int id, String nome, double porcentagemBonus) {
        this.id = id;
        this.nome = nome;
        this.porcentagemBonus = porcentagemBonus;
    }

    public TipoCargo(String nome, double porcentagemBonus) {
        this.nome = nome;
        this.porcentagemBonus = porcentagemBonus;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPorcentagemBonus() {
        return porcentagemBonus;
    }

    public void setPorcentagemBonus(double porcentagemBonus) {
        this.porcentagemBonus = porcentagemBonus;
    }
}

