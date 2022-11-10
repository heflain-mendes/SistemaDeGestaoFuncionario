/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.model.BonusProcessado;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author heflain
 */
public class BonusTempoServico implements ICalculoBonus{

    @Override
    public BonusProcessado calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data ");
        }
        
        double tempo = funcionario.getDistanciaDoTrabalho();
        double valor;
        
        if(tempo >= 20){
            valor = funcionario.getSalarioBaseAtual() * 0.15;
        }else if(tempo >= 16){
            valor = funcionario.getSalarioBaseAtual() * 0.10;
        }else if(tempo >= 11){
            valor = funcionario.getSalarioBaseAtual() * 0.8;
        }else if(tempo >= 6){
            valor = funcionario.getSalarioBaseAtual() * 0.3;
        }else if(tempo >= 1){
            valor = funcionario.getSalarioBaseAtual() * 0.2;
        }else{
            valor = 0;
        }
        
        return new BonusProcessado("tempo de serviço", valor,funcionario.getCargo(), data);
    }
}
