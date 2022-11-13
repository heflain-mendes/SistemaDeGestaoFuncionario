/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.interfaces;

import com.mycompany.model.Funcionario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IFuncionarioDAO {
    public Funcionario salvar (Funcionario funcionario) throws Exception, SQLException;
    public void atualizar(Funcionario funcionario) throws Exception, SQLException;
    public void remover(Funcionario funcionario) throws Exception, SQLException;
    public List<Funcionario> obterTodos() throws Exception, SQLException;
    public List<Funcionario> pesquisarPorNome (String pesquisa) throws Exception, SQLException;
    public Funcionario obterPorId(int id) throws Exception, SQLException;
    public int qtdFuncionarioCadastrado() throws Exception, SQLException;
}
