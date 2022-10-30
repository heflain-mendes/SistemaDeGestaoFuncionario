/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.business.calculosestatistico.ExecutaCalculoEstatistico;
import com.mycompany.model.CalculoEstatistico;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public class CalculoEstatisticoService {
    private ExecutaCalculoEstatistico calculoEstatistico;
    private CalculaSalarioService calculaSalarioService;

    public CalculoEstatisticoService(ExecutaCalculoEstatistico calculoEstatistico, CalculaSalarioService calculaSalarioService) {
        this.calculoEstatistico = calculoEstatistico;
        this.calculaSalarioService = calculaSalarioService;
    }
    
    public void calcular(List<Funcionario> funcionarios, LocalDate data){
        List<Salario> salarios = this.calculaSalarioService.calcular(funcionarios, data);
        CalculoEstatistico calculoEstatistico = this.calculoEstatistico.calcular(salarios, data);
    }
    
    
}
