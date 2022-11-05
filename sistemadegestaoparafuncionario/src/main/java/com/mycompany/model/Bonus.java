/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.time.LocalDate;

/**
 *
 * @author heflain
 */
public class Bonus {
    private int id;
    private String tipo;
    private double valor;
    private int cargo;
    private LocalDate data;

    public Bonus(int id, String tipo, double valor, int cargo, LocalDate data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.cargo = cargo;
    }

    public Bonus(String tipo, double valor, int cargo, LocalDate data) {
        this.tipo = tipo;
        this.valor = valor;
        this.cargo = cargo;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public int getCargo() {
        return cargo;
    }
    
    
}
