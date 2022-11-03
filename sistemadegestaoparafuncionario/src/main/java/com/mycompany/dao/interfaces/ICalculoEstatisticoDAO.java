/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.CalculoEstatistico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ICalculoEstatisticoDAO {
    public void salvar(CalculoEstatistico calculoEstatistico) throws Exception, SQLException;
    public void atualizar(CalculoEstatistico calculoEstatistico) throws Exception, SQLException;
    public List<CalculoEstatistico> obterTodos() throws Exception, SQLException;
}
