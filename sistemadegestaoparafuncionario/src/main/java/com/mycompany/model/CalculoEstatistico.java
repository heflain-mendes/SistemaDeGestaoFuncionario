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
public class CalculoEstatistico {
    private int id;
    private LocalDate data;
    private double somatorio;
    private double media;
    private double menorSalario;
    private double maiorSalario;
    private double desvioPadrao;
    private double coeficienteVariacao;
    private int qtdSalario;

    public CalculoEstatistico(int id, LocalDate data, double somatorio, double media, double menorSalario, double maiorSalario, double desvioPadrao, double coeficienteVariacao, int qtdSalario) {
        this.id = id;
        this.data = data;
        this.somatorio = somatorio;
        this.media = media;
        this.menorSalario = menorSalario;
        this.maiorSalario = maiorSalario;
        this.desvioPadrao = desvioPadrao;
        this.coeficienteVariacao = coeficienteVariacao;
        this.qtdSalario = qtdSalario;
    }

    public CalculoEstatistico(LocalDate data, double somatorio, double media, double menorSalario, double maiorSalario, double desvioPadrao, double coeficienteVariacao, int qtdSalario) {
        this.data = data;
        this.somatorio = somatorio;
        this.media = media;
        this.menorSalario = menorSalario;
        this.maiorSalario = maiorSalario;
        this.desvioPadrao = desvioPadrao;
        this.coeficienteVariacao = coeficienteVariacao;
        this.qtdSalario = qtdSalario;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public double getSomatorio() {
        return somatorio;
    }

    public double getMedia() {
        return media;
    }

    public double getMenorSalario() {
        return menorSalario;
    }

    public double getMaiorSalario() {
        return maiorSalario;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public double getCoeficienteVariacao() {
        return coeficienteVariacao;
    }

    public int getQttSalario() {
        return qtdSalario;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setSomatorio(double somatorio) {
        this.somatorio = somatorio;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setMenorSalario(double menorSalario) {
        this.menorSalario = menorSalario;
    }

    public void setMaiorSalario(double maiorSalario) {
        this.maiorSalario = maiorSalario;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public void setCoeficienteVariacao(double coeficienteVariacao) {
        this.coeficienteVariacao = coeficienteVariacao;
    }

    public void setQtdSalario(int qtdSalario) {
        this.qtdSalario = qtdSalario;
    }

    
}
