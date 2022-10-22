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
    private long id;
    private String tipo;
    private double valor;
    private LocalDate data;

    public Bonus(long id, String tipo, double valor, LocalDate data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public Bonus(String tipo, double valor, LocalDate data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public long getId() {
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
}
