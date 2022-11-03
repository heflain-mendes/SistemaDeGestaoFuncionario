/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.business.calculosalario;

import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ICalculoSalario {
    public Salario calcular(Funcionario funcionario, LocalDate data, List<Bonus> listaBonus);
}
