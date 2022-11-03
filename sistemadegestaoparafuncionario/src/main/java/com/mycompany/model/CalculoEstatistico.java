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

    public CalculoEstatistico(int id,
            LocalDate data,
            double somatorio,
            double media,
            double menorSalario,
            double maiorSalario,
            double desvioPadrao,
            double coeficienteVariacao,
            int qtdSalario) {
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

    public CalculoEstatistico() {
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

    public CalculoEstatistico setData(LocalDate data) {
        this.data = data;
        return this;
    }

    public CalculoEstatistico setSomatorio(double somatorio) {
        this.somatorio = somatorio;
        return this;
    }

    public CalculoEstatistico setMedia(double media) {
        this.media = media;
        return this;
    }

    public CalculoEstatistico setMenorSalario(double menorSalario) {
        this.menorSalario = menorSalario;
        return this;
    }

    public CalculoEstatistico setMaiorSalario(double maiorSalario) {
        this.maiorSalario = maiorSalario;
        return this;
    }

    public CalculoEstatistico setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
        return this;
    }

    public CalculoEstatistico setCoeficienteVariacao(double coeficienteVariacao) {
        this.coeficienteVariacao = coeficienteVariacao;
        return this;
    }

    public CalculoEstatistico setQtdSalario(int qtdSalario) {
        this.qtdSalario = qtdSalario;
        return this;
    }

    @Override
    public String toString() {
        return "CalculoEstatistico{" + "id=" + id + ", data=" + data + ", somatorio=" + somatorio + ", media=" + media + ", menorSalario=" + menorSalario + ", maiorSalario=" + maiorSalario + ", desvioPadrao=" + desvioPadrao + ", coeficienteVariacao=" + coeficienteVariacao + ", qtdSalario=" + qtdSalario + '}';
    }
}
