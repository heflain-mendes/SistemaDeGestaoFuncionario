/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.model.BonusProcessado;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author heflain
 */
public interface ICalculoBonus {
    public BonusProcessado calcular(Funcionario funcionario, LocalDate data) throws Exception;
}
