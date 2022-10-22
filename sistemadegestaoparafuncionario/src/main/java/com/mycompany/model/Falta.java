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
    private long id;
    private LocalDate date;
    private int quantidade;
    private boolean funcionarioDoMes;

    public Falta(long id, LocalDate date, int quantidade, boolean funcionarioDoMes) {
        this.id = id;
        this.date = date;
        this.quantidade = quantidade;
        this.funcionarioDoMes = funcionarioDoMes;
    }

    public Falta(LocalDate date, int quantidade, boolean funcionarioDoMes) {
        this.date = date;
        this.quantidade = quantidade;
        this.funcionarioDoMes = funcionarioDoMes;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setFuncionarioDoMes(boolean funcionarioDoMes) {
        this.funcionarioDoMes = funcionarioDoMes;
    }
    
    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isFuncionarioDoMes() {
        return funcionarioDoMes;
    }
}
