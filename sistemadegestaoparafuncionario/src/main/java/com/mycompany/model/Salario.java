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
public class Salario {
    private final long id;
    private Double salarioBase;
    private Double salarioTotal;
    private LocalDate data;

    public Salario(long id, Double salarioBase, Double salarioTotal, LocalDate data) {
        this.id = id;
        this.salarioBase = salarioBase;
        this.salarioTotal = salarioTotal;
        this.data = data;
    }

    public Salario(Double salarioBase, Double salarioTotal, LocalDate data) {
        this.salarioBase = salarioBase;
        this.salarioTotal = salarioTotal;
        this.data = data;
        this.id = -1;
    }
    
    
}
