/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.Bonus;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ITipoBonusDAO {
    public void salvar(Bonus bonusCadastrado) throws Exception, SQLException;
    public List<Bonus> obterTodos() throws Exception, SQLException;
    public Bonus obter(int id) throws Exception, SQLException;
    public int obterId(String name) throws Exception, SQLException;
}
