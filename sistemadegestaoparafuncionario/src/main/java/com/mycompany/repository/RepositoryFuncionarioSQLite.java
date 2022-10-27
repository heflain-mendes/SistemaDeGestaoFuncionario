/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.DAO.SLite.BonusSQLiteDAO;
import com.mycompany.DAO.SLite.FaltaSQLiteDAO;
import com.mycompany.DAO.SLite.FuncionarioSQLiteDAO;
import com.mycompany.DAO.SLite.SalarioSQLiteDAO;
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
public class RepositoryFuncionarioSQLite implements IRepositoryFuncionario {
    
    @Override
    public List<Funcionario> getAllFuncionario() throws Exception, SQLException {
        List<Funcionario> funcionarios = FuncionarioSQLiteDAO.getInstance().obterTodos();
        
        for (Funcionario f : funcionarios) {
            f.setBonus(BonusSQLiteDAO.getInstance().obter(f.getId()));
            f.setSalarios(SalarioSQLiteDAO.getInstance().obter(f.getId()));
            f.setFaltas(FaltaSQLiteDAO.getInstance().obterPorFuncionario(f.getId()));
        }
        return funcionarios;
    }
    
    @Override
    public void save(Funcionario funcionario) throws Exception, SQLException {
        FuncionarioSQLiteDAO.getInstance().salvar(funcionario);
    }
    
    @Override
    public void save(int idFuncionario, Salario salario) throws Exception, SQLException {
       SalarioSQLiteDAO.getInstance().salvar(idFuncionario, salario);
    }
    
    @Override
    public void save(int idFuncionario, Falta falta) throws Exception, SQLException {
        FaltaSQLiteDAO.getInstance().salvar(idFuncionario, falta);
    }
    
    @Override
    public void save(int idFuncionario, List<Bonus> bonus) throws Exception, SQLException {
        BonusSQLiteDAO.getInstance().salvar(idFuncionario, bonus);
    }
    
    @Override
    public void update(Funcionario funcionario) throws Exception, SQLException {
        FuncionarioSQLiteDAO.getInstance().atualizar(funcionario);
    }
    
    @Override
    public void update(Salario salario) throws Exception, SQLException {
        SalarioSQLiteDAO.getInstance().atualizar(salario);
    }
    
    @Override
    public void update(Falta falta) throws Exception, SQLException {
        FaltaSQLiteDAO.getInstance().atualizar(falta);
    }
    
    @Override
    public void deleteFuncionarioAll(Funcionario funcionario) throws Exception, SQLException {
        FaltaSQLiteDAO.getInstance().remover(funcionario.getId());
        SalarioSQLiteDAO.getInstance().remover(funcionario.getId());
        BonusSQLiteDAO.getInstance().removerTodos(funcionario.getId());
        FuncionarioSQLiteDAO.getInstance().remover(funcionario);
    }
    
    @Override
    public void delete(int idFuncionairo, LocalDate datas) throws Exception, SQLException {
        BonusSQLiteDAO.getInstance().remover(idFuncionairo, datas);
    }
}
