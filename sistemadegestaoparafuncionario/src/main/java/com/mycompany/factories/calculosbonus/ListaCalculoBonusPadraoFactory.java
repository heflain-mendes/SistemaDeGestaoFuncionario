/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factories.calculosbonus;

import com.mycompany.business.calculobonus.BonusAleatorio;
import com.mycompany.business.calculobonus.BonusAssiduidade;
import com.mycompany.business.calculobonus.BonusDistanciaDoTrabalho;
import com.mycompany.business.calculobonus.BonusTempoServico;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.business.calculobonus.ICalculoBonus;

/**
 *
 * @author heflain
 */
public class ListaCalculoBonusPadraoFactory implements IListaCalculoBonusFactory{

    @Override
    public List<ICalculoBonus> obterLista() {
        List<ICalculoBonus> listaCalculosBonus = new ArrayList<>();
        listaCalculosBonus.add(new BonusAssiduidade());
        listaCalculosBonus.add(new BonusTempoServico());
        listaCalculosBonus.add(new BonusDistanciaDoTrabalho());
        listaCalculosBonus.add(new BonusAleatorio());
        
        return listaCalculosBonus;
    }
}
