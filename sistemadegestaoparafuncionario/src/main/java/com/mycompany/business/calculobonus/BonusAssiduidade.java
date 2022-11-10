/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.mycompany.dao.DAOUtilitarios;
import com.mycompany.model.BonusProcessado;
import com.mycompany.model.Falta;
import com.mycompany.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author heflain
 */
public class BonusAssiduidade implements ICalculoBonus{

    @Override
    public BonusProcessado calcular(Funcionario funcionario, LocalDate data) throws Exception{
        
        
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data não são validos");
        }
        Falta falta = DAOUtilitarios.getInstance()
                .getFaltaDAO()
                .obterPorFuncionarioData(funcionario.getId(), data);
        
        if(falta == null){
            return null;
        }
        
        int qtdFalta = falta.getQuantidade();
        double valor;
        
        if(qtdFalta == 0){
            valor = funcionario.getSalarioBaseAtual() * 0.05;
        }else if(qtdFalta <= 3){
            valor = funcionario.getSalarioBaseAtual() * 0.03;
        }else if(qtdFalta <= 5){
            valor = funcionario.getSalarioBaseAtual() * 0.01;
        }else{
            valor = 0;
        }
        
        if(valor != 0){
            return new BonusProcessado("distancia do trabalho", valor,funcionario.getCargo(), data);
        }
        
        return null;
    }
    
}
