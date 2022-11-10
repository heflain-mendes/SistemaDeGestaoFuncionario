/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author heflain
 */
public class Bonus {
    private int id;
    private String noma;
    private double porcentagem;

    public Bonus(int id, String noma, double porcentagem) {
        this.id = id;
        this.noma = noma;
        this.porcentagem = porcentagem;
    }

    public Bonus(String noma, double porcentagem) {
        this.noma = noma;
        this.porcentagem = porcentagem;
    }

    public int getId() {
        return id;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
