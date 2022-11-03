/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.model.Bonus;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import java.time.LocalDate;
import java.util.List;
import com.mycompany.business.calculosalario.ICalculoSalario;
import com.mycompany.dao.DAOSingleton;
import java.sql.SQLException;

/**
 *
 * @author heflain
 */
public class CalculaSalarioService {
    private ICalculoSalario calculoSalario;

    public CalculaSalarioService(ICalculoSalario calculoSalario) {
        this.calculoSalario = calculoSalario;
    }
    
    public Salario calcular(Funcionario funcionario, List<Bonus> listaBonus, LocalDate data) throws Exception, SQLException{
        Salario salario = calculoSalario.calcular(funcionario, data, listaBonus);
        DAOSingleton.getInstance().getSalarioDAO().salvar(funcionario.getId(), salario);
        return salario;
    }
}
