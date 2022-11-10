/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.factory;

import com.mycompany.dao.interfaces.ICalculoEstatisticoDAO;
import com.mycompany.dao.interfaces.IFaltaDAO;
import com.mycompany.dao.interfaces.IFuncionarioDAO;
import com.mycompany.dao.interfaces.ISalarioDAO;
import java.sql.SQLException;
import com.mycompany.dao.interfaces.IBonusFuncionarioDAO;
import com.mycompany.dao.interfaces.ITipoBonusDAO;
import com.mycompany.dao.interfaces.ITipoCargoDAO;

/**
 *
 * @author heflain
 */
public interface IDAOFactory {
    public IBonusFuncionarioDAO getBonusDAO() throws SQLException, Exception;
    public ISalarioDAO getSalarioDAO() throws SQLException, Exception;
    public IFaltaDAO getFaltaDAO() throws SQLException, Exception;
    public IFuncionarioDAO getFuncionarioDAO() throws SQLException, Exception;
    public ICalculoEstatisticoDAO getCalculoEstatisticoDAO() throws SQLException, Exception;
    public ITipoBonusDAO getTipoBonusDAO() throws SQLException, Exception;
    public ITipoCargoDAO getTipoCargoDAO() throws SQLException, Exception;
}
