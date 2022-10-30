/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.builder;

import com.mycompany.business.calculobonus.BonusAleatorio;
import com.mycompany.business.calculobonus.BonusAssiduidade;
import com.mycompany.business.calculobonus.BonusDistanciaDoTrabalho;
import com.mycompany.business.calculobonus.BonusTempoServico;
import com.mycompany.business.calculobonus.ExecutaCalculoBonus;
import com.mycompany.business.calculobonus.ICalculoBonus;
import com.mycompany.business.calculosalario.CalculoSalario;
import com.mycompany.business.calculosestatistico.ExecutaCalculoEstatistico;
import com.mycompany.service.CalculaBonusService;
import com.mycompany.service.CalculaSalarioService;
import com.mycompany.service.CalculoEstatisticoService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class CalculoEstatisticoServiceBuilder implements ICalculoEstatisticoServiceBuilder{
    @Override
    public CalculoEstatisticoService obter(){
        return new CalculoEstatisticoService(new ExecutaCalculoEstatistico(), 
                obterCalculaSalarioService());
    }
    
    private CalculaSalarioService obterCalculaSalarioService(){
        return new CalculaSalarioService( new CalculoSalario(),
                obterCalculoBonusService());
    }
    
    private CalculaBonusService obterCalculoBonusService(){
        return new CalculaBonusService(obterExecutaCalculoBonus());
    }
    
    private ExecutaCalculoBonus obterExecutaCalculoBonus(){
        List<ICalculoBonus> listaCalculoBonus = new ArrayList<>();
        listaCalculoBonus.add(new BonusAleatorio());
        listaCalculoBonus.add(new BonusAssiduidade());
        listaCalculoBonus.add(new BonusDistanciaDoTrabalho());
        listaCalculoBonus.add(new BonusTempoServico());

        return new ExecutaCalculoBonus(listaCalculoBonus);
    }
}
