/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculosestatistico;

import com.mycompany.model.Salario;
import java.util.List;

/**
 *
 * @author heflain
 */
public class MenorSalario implements ICalculoEstatistico {

    @Override
    public double calcular(List<Salario> salarios) {
        double menor = 0;
        if (salarios.size() >= 1) {
            menor = salarios.get(0).getSalarioTotal();
        }

        for (Salario salarioTotal : salarios) {
            if (menor > salarioTotal.getSalarioTotal()) {
                menor = salarioTotal.getSalarioTotal();
            }
        }

        return menor;
    }

}
