/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.Bonus;
import com.mycompany.model.Falta;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IRepositoryFuncionario{
    public List<Funcionario> getAllFuncionario() throws Exception, SQLException;
    public void save(Funcionario funcionario) throws Exception, SQLException;
    public void save(int idFuncionario, Salario salario) throws Exception, SQLException;
    public void save(int idFuncionario, Falta falta) throws Exception, SQLException;
    public void save(int idFuncionario, List<Bonus> bonus) throws Exception, SQLException;
    public void update(Funcionario funcionario) throws Exception, SQLException;
    public void update(Salario salario) throws Exception, SQLException;
    public void update(Falta falta) throws Exception, SQLException;
    public void deleteFuncionarioAll(Funcionario funcionario) throws Exception, SQLException;
    public void delete(int idFuncionairo, LocalDate data) throws Exception, SQLException;
}
