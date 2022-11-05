/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.business.calculobonus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.model.Bonus;
import com.mycompany.model.CargoArquivo;
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
public class BonusCargo implements ICalculoBonus{

    @Override
    public Bonus calcular(Funcionario funcionario, LocalDate data) {
        if(funcionario == null || data == null){
            throw new NullPointerException("funcionario ou data invalidos");
        }
        
        CargoArquivo cargoArquivo = obterListaCargos().get(funcionario.getCargo());
        return new Bonus(
                "bonus por cargo", 
                funcionario.getSalarioBaseAtual() * cargoArquivo.getPorcentagem(),
                funcionario.getCargo(),
                data
        );
    }
    
    private List<CargoArquivo> obterListaCargos(){
        Dotenv dotenv = Dotenv.load();
        Type tipoLista = new TypeToken<ArrayList<CargoArquivo>>(){}.getType();
        Gson gson = new Gson();
        
        return gson.fromJson(dotenv.get("CARGOS"), tipoLista);
    }
}
