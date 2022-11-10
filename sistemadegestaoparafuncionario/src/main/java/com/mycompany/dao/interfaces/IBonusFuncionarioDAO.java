/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.BonusProcessado;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IBonusFuncionarioDAO {
    public void salvar(int idFuncionario, BonusProcessado bonus) throws Exception, SQLException;
    public List<BonusProcessado> obter(int idFuncionario) throws Exception, SQLException;
    public void remover(int idFuncionario, LocalDate data) throws Exception, SQLException;
    public void removerTodos(int idFuncionario) throws Exception, SQLException;
}
