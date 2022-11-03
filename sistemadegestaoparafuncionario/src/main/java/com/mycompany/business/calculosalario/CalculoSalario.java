/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CalculoSalario implements ICalculoSalario{
    @Override
    public Salario calcular(Funcionario funcionario, LocalDate data, List<Bonus> listaBonus) {
        double somaValorBonus = 0;
        
        for(Bonus bonus : listaBonus){
            somaValorBonus += bonus.getValor();
        }
        
        return new Salario(funcionario.getSalarioBaseAtual(),
                funcionario.getSalarioBaseAtual() + somaValorBonus,
                data);
    }
}
