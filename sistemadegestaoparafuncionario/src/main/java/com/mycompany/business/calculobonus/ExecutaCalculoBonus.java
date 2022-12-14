/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.model.BonusProcessado;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class ExecutaCalculoBonus {
    private List<ICalculoBonus> calculosBonus;

    public ExecutaCalculoBonus(List<ICalculoBonus> calculosBonus) {
        if(calculosBonus == null){
            return;
        }
        this.calculosBonus = calculosBonus;
    }
    
    public List<BonusProcessado> calcular(Funcionario funcionario, LocalDate data) throws Exception{
        List<BonusProcessado> listBonus = new ArrayList();
        
        for(ICalculoBonus calculoBonus : calculosBonus){
           BonusProcessado bonus = calculoBonus.calcular(funcionario, data);
           
           if(bonus != null){
               listBonus.add(bonus);
           }
           
        }
        
        return listBonus;
    }
}
