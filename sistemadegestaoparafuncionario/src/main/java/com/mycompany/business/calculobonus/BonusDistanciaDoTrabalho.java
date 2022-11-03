/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author heflain
 */
public class BonusDistanciaDoTrabalho implements ICalculoBonus{

    @Override
    public Bonus calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data ");
        }
        
        double distancia = funcionario.getDistanciaDoTrabalho();
        double valor;
        
        if(distancia >= 30){
            valor = funcionario.getSalarioBaseAtual() * 0.1;
        } else if(distancia >= 25){
            valor = funcionario.getSalarioBaseAtual() * 0.08;
        }else if(distancia >= 20){
            valor = funcionario.getSalarioBaseAtual() * 0.06;
        }else if(distancia >= 15){
            valor = funcionario.getSalarioBaseAtual() * 0.05;
        }else{
            valor = 0;
        }
        
        if(valor != 0){
            return new Bonus("distancia do trabalho", valor,funcionario.getCargo(), data);
        }
        
        return null;
    }
    
}
