/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.DAO.interfaces;

import com.mycompany.model.Falta;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IFaltaDAO {
    public void salvar(int idFuncionario, Falta falta) throws Exception, SQLException;
    public void atualizar(Falta falta) throws Exception, SQLException;
    public void remover(int idFuncionario) throws Exception, SQLException;
    public List<Falta> obterPorFuncionario(int idFuncionario) throws Exception, SQLException;
}
