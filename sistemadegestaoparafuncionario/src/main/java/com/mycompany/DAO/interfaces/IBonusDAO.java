/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.DAO.interfaces;

import com.mycompany.model.Bonus;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IBonusDAO {
    public void salvar(int idFuncionario, List<Bonus> bonus) throws Exception, SQLException;
    public List<Bonus> obter(int idFuncionario) throws Exception, SQLException;
    public void remover(int idFuncionario, LocalDate data) throws Exception, SQLException;
}
