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
public class Falta {
    private int id;
    private LocalDate date;
    private int quantidade;

    public Falta(int id, LocalDate date, int quantidade) {
        this.id = id;
        this.date = date;
        this.quantidade = quantidade;
    }

    public Falta(LocalDate date, int quantidade) {
        this.date = date;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
