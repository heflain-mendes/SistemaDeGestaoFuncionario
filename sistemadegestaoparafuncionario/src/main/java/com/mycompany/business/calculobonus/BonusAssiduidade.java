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
public class BonusAssiduidade implements ICalculoBonus{

    @Override
    public Bonus calcular(Funcionario funcionario, LocalDate data) {
        funcionario.getFaltas();
        return null;
    }
}
