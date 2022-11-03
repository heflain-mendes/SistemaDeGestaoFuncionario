/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IFuncionarioDAO {
    public void salvar (Funcionario funcionario) throws Exception, SQLException;
    public void atualizar(Funcionario funcionario) throws Exception, SQLException;
    public void remover(Funcionario funcionario) throws Exception, SQLException;
    public List<Funcionario> obterTodos() throws Exception, SQLException;
}
