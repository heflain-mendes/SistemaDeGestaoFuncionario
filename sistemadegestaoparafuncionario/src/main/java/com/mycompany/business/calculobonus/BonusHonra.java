/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.model.Bonus;
import com.mycompany.model.BonusArquivo;
import com.mycompany.model.Funcionario;
import io.github.cdimascio.dotenv.Dotenv;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class BonusHonra implements ICalculoBonus{

    @Override
    public Bonus calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data invalidos");
        }
        
        BonusArquivo bonusArquivo = obterListaBonus().get(funcionario.getBonusHonra());
        return new Bonus(
                bonusArquivo.getBonus(), 
                funcionario.getSalarioBaseAtual() * bonusArquivo.getPorcentagem(),
                funcionario.getCargo(),
                data
        );
    }
    
    private List<BonusArquivo> obterListaBonus(){
        Dotenv dotenv = Dotenv.load();
        Type tipoLista = new TypeToken<ArrayList<BonusArquivo>>(){}.getType();
        Gson gson = new Gson();
        
        return gson.fromJson(dotenv.get("BONUS"), tipoLista);
    }
}
