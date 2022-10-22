/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.model.Funcionario;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IFuncionarioDAO {
    public void salvar(Funcionario funcionario);
    public void atualizar(Funcionario funcionario);
    public void remover(long idFuncionario);
    public List<Funcionario> obterTodos();
}
