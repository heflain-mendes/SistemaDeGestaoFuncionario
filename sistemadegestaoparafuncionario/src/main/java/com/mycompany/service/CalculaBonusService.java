/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.business.calculobonus.ExecutaCalculoBonus;
import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public class CalculaBonusService{
    private ExecutaCalculoBonus calculosBonus;
    
    public CalculaBonusService(ExecutaCalculoBonus calculoBonus){
        if(calculosBonus == null){
            throw new NullPointerException("passe uma parametro não nulo para  CalculaBonusService");
        }
        this.calculosBonus = calculosBonus;
    }
    
    public List<Bonus> calcular(Funcionario funcionario, LocalDate data){
        return calculosBonus.calcular(funcionario, data);
    }
}
