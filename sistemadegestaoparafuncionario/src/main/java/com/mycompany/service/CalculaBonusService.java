/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.business.calculobonus.ExecutaCalculoBonus;
import com.mycompany.dao.DAOSingleton;
import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import com.mycompany.dao.interfaces.IBonusFuncionarioDAO;

/**
 *
 * @author heflain
 */
public class CalculaBonusService{
    private ExecutaCalculoBonus calculoBonus;
    
    public CalculaBonusService(ExecutaCalculoBonus executaCalculoBonus){
        if(executaCalculoBonus == null){
            return;
        }
        this.calculoBonus = executaCalculoBonus;
    }
    
    public List<Bonus> calcular(Funcionario funcionario, LocalDate data) throws Exception, SQLException{
        List<Bonus> listBonus = calculoBonus.calcular(funcionario, data);
        IBonusFuncionarioDAO daoS = DAOSingleton.getInstance().getBonusDAO();
        
        for(Bonus bonus : listBonus){
            daoS.salvar(funcionario.getId(), bonus);
        }
        
        return listBonus;
    }
}
