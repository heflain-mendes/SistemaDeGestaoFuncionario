/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.DAO.SLite.CalculoEstatisticoSQLiteDAO;
import com.mycompany.model.CalculoEstatistico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public class RepositoryCalculoEstatisticoSQLiteDAO implements IRepositoryCalculoEstatistico{

    @Override
    public void save(CalculoEstatistico calculoEstatistico) throws Exception, SQLException {
        CalculoEstatisticoSQLiteDAO.getInstance().salvar(calculoEstatistico);
    }

    @Override
    public void update(CalculoEstatistico calculoEstatistico) throws Exception, SQLException {
        CalculoEstatisticoSQLiteDAO.getInstance().atualizar(calculoEstatistico);
    }

    @Override
    public List<CalculoEstatistico> getAll() throws Exception, SQLException {
        return CalculoEstatisticoSQLiteDAO.getInstance().obterTodos();
    }
    
}
