/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculosestatistico;

import com.mycompany.model.CalculoEstatistico;
import com.mycompany.model.Salario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public class ExecutaCalculoEstatistico {
    private ICalculoEstatistico somatorio;
    private ICalculoEstatistico media;
    private ICalculoEstatistico maiorSalario;
    private ICalculoEstatistico menorSalario;
    private ICalculoEstatistico desvioPadrao;
    private ICalculoEstatistico coeficienteVariacao;
    private ICalculoEstatistico quantidadeSalario;
    

    public ExecutaCalculoEstatistico() {
        this.somatorio = new Somatorio();
        this.media = new Media();
        this.maiorSalario = new MaiorSalario();
        this.menorSalario = new MenorSalario();
        this.desvioPadrao = new DesvioPadrao();
        this.coeficienteVariacao = new CoeficienteDeVariacao();
        this.quantidadeSalario = new QuantidadeSalario();
    }
    
    public CalculoEstatistico calcular(List<Salario> salarios, LocalDate data){
        return new CalculoEstatistico()
                .setSomatorio(this.somatorio.calcular(salarios))
                .setMedia(this.media.calcular(salarios))
                .setMaiorSalario(this.maiorSalario.calcular(salarios))
                .setMenorSalario(this.menorSalario.calcular(salarios))
                .setDesvioPadrao(this.desvioPadrao.calcular(salarios))
                .setCoeficienteVariacao(this.coeficienteVariacao.calcular(salarios))
                .setQtdSalario((int) this.quantidadeSalario.calcular(salarios))
                .setData(data);
    }
}
