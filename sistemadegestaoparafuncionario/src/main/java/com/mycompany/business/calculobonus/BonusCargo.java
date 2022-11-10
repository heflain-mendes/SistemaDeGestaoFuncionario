/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.dao.DAOSingleton;
import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import com.mycompany.model.TipoCargo;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class BonusCargo implements ICalculoBonus{

    @Override
    public Bonus calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data invalidos");
        }
        
        TipoCargo cargo = obterCargo(funcionario.getId());
        return new Bonus(
                "bonus por cargo", 
                funcionario.getSalarioBaseAtual() * cargo.getPorcentagemBonus(),
                funcionario.getCargo(),
                data
        );
    }
    
    private TipoCargo obterCargo(int id){
        try {
            return DAOSingleton.getInstance().getTipoCargoDAO().obter(id);
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
