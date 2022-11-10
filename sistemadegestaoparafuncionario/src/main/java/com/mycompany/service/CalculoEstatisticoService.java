/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.business.calculosestatistico.ExecutaCalculoEstatistico;
import com.mycompany.dao.DAOUtilitarios;
import com.mycompany.model.CalculoEstatistico;
import com.mycompany.model.Salario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public class CalculoEstatisticoService {
    private ExecutaCalculoEstatistico calculoEstatistico;

    public CalculoEstatisticoService(ExecutaCalculoEstatistico executaCalculoEstatistico) {
        this.calculoEstatistico = executaCalculoEstatistico;
    }
    
    public void calcular(List<Salario> salarios, LocalDate data) throws Exception, SQLException{
        CalculoEstatistico calculoEstatistico = this.calculoEstatistico.calcular(salarios, data);
        DAOUtilitarios.getInstance().getCalculoEstatisticoDAO().salvar(calculoEstatistico);
    }
}
