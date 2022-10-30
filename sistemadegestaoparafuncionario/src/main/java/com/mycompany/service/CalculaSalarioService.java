/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.business.calculosalario.ICalculoSalario;

/**
 *
 * @author heflain
 */
public class CalculaSalarioService {
    private ICalculoSalario calculoSalario;
    private CalculaBonusService calculaBonusService;

    public CalculaSalarioService(ICalculoSalario calculoSalario, CalculaBonusService calculaBonusService) {
        this.calculoSalario = calculoSalario;
        this.calculaBonusService = calculaBonusService;
    }
    
    public List<Salario> calcular(List<Funcionario> funcionarios, LocalDate data){
        List<Bonus> listaBonus;
        List<Salario> salarios = new ArrayList<>();
        for(Funcionario funcionario : funcionarios){
            listaBonus = calculaBonusService.calcular(funcionario, data);
            
            salarios.add(calculoSalario.calcular(funcionario, data, listaBonus));
        }
        
        return salarios;
    }
}
