/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.factory;

import com.mycompany.dao.interfaces.ICalculoEstatisticoDAO;
import com.mycompany.dao.interfaces.IFaltaDAO;
import com.mycompany.dao.interfaces.IFuncionarioDAO;
import com.mycompany.dao.interfaces.ISalarioDAO;
import com.mycompany.dao.sqlite.BonusProcessadoSQLiteDAO;
import com.mycompany.dao.sqlite.CalculoEstatisticoSQLiteDAO;
import com.mycompany.dao.sqlite.FaltaSQLiteDAO;
import com.mycompany.dao.sqlite.FuncionarioSQLiteDAO;
import com.mycompany.dao.sqlite.SalarioSQLiteDAO;
import java.sql.SQLException;
import com.mycompany.dao.interfaces.IBonusFuncionarioDAO;
import com.mycompany.dao.interfaces.ITipoBonusDAO;
import com.mycompany.dao.interfaces.ITipoCargoDAO;
import com.mycompany.dao.sqlite.BonusSQLiteDAO;
import com.mycompany.dao.sqlite.CargoSQLiteDAO;

/**
 *
 * @author heflain
 */
public class DAOSQLiteFactory implements IDAOFactory{

    @Override
    public IBonusFuncionarioDAO getBonusDAO() throws SQLException, Exception{
        return new BonusProcessadoSQLiteDAO();
    }

    @Override
    public ISalarioDAO getSalarioDAO() throws SQLException, Exception{
        return new SalarioSQLiteDAO();
    }

    @Override
    public IFaltaDAO getFaltaDAO() throws SQLException, Exception{
        return new FaltaSQLiteDAO();
    }

    @Override
    public IFuncionarioDAO getFuncionarioDAO() throws SQLException, Exception{
        return new FuncionarioSQLiteDAO();
    }

    @Override
    public ICalculoEstatisticoDAO getCalculoEstatisticoDAO() throws SQLException, Exception{
        return new CalculoEstatisticoSQLiteDAO();
    }

    @Override
    public ITipoBonusDAO getTipoBonusDAO() throws SQLException, Exception {
        return new BonusSQLiteDAO();
    }

    @Override
    public ITipoCargoDAO getTipoCargoDAO() throws SQLException, Exception {
        return new CargoSQLiteDAO();
    }
}
