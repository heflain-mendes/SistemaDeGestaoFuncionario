/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author heflain
 */
public class BonusAleatorio implements ICalculoBonus {

    @Override
    public Bonus calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data ");
        }
        double valor = new Random().nextDouble() * funcionario.getSalarioBaseAtual();
        return new Bonus("Aleatorio",  valor,funcionario.getCargo(), data);
    }
}
