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
public class CoeficienteDeVariacao implements ICalculoEstatistico{

    @Override
    public double calcular(List<Salario> salarios) {
        return new DesvioPadrao().calcular(salarios) / new Media().calcular(salarios);
    }
    
}
