/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.TipoBonus;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ITipoBonusDAO {
    public void salvar(TipoBonus bonusCadastrado) throws Exception, SQLException;
    public List<TipoBonus> obterTodos() throws Exception, SQLException;
    public TipoBonus obter(int id) throws Exception, SQLException;
    public int obterId(String name) throws Exception, SQLException;
}
