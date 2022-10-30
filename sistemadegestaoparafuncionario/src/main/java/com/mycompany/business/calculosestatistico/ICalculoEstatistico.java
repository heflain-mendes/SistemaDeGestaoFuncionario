/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.business.calculosestatistico;

import com.mycompany.model.Salario;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ICalculoEstatistico {
    public double calcular(List<Salario> salarios);
}
