/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.TipoCargo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ITipoCargoDAO {
    public void salvar(TipoCargo tipoCargo) throws Exception, SQLException;
    public List<TipoCargo> obterTodos() throws Exception, SQLException;
    public TipoCargo obter(int id) throws Exception, SQLException;
    public int obterId(String nome) throws Exception;
}
