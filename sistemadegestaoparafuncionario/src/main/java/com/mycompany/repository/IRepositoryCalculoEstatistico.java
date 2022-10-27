/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.CalculoEstatistico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IRepositoryCalculoEstatistico {
    public void save(CalculoEstatistico calculoEstatistico) throws Exception, SQLException;
    public void update(CalculoEstatistico calculoEstatistico) throws Exception, SQLException;
    public List<CalculoEstatistico> getAll() throws Exception, SQLException;
}
