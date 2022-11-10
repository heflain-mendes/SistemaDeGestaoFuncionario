/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.dao.DAOUtilitarios;
import com.mycompany.model.BonusProcessado;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Bonus;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class BonusHonra implements ICalculoBonus{

    @Override
    public BonusProcessado calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data invalidos");
        }
        
        Bonus bonus = obterBonus(funcionario.getBonusHonra());
        return new BonusProcessado(
                bonus.getNoma(), 
                funcionario.getSalarioBaseAtual() * bonus.getPorcentagem(),
                funcionario.getCargo(),
                data
        );
    }
    
    
    private Bonus obterBonus(int id){
        try {
            return DAOUtilitarios.getInstance().getTipoBonusDAO().obter(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro no sistema", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return null;
    }
}
