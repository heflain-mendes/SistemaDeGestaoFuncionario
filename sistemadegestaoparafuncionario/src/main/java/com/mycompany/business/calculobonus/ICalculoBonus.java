/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;

/**
 *
 * @author heflain
 */
public interface ICalculoBonus {
    public Bonus calcular(Funcionario funcionario, LocaDate data);
}
