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
public class DesvioPadrao implements ICalculoEstatistico{

    @Override
    public double calcular(List<Salario> salarios) {
        double media = new Media().calcular(salarios);
        double total = 0;
        
        for(Salario salario : salarios){
            total += Math.pow(salario.getSalarioTotal() - media, 2);
        }
        
        total /= salarios.size();
        
        return Math.sqrt(total);
    }
    

   
}
