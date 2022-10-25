/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO.interfaces;

import com.mycompany.model.Salario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface ISalarioDAO {
    public void salvar(int idFuncionario, Salario salario) throws Exception, SQLException;
    public List<Salario> obter(int idFuncionario) throws Exception, SQLException;
    public void atualizar(Salario salario) throws Exception, SQLException;
    public void remover (int idFuncionario) throws Exception, SQLException;
}
