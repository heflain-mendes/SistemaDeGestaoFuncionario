/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.dao.factory.IDAOFactory;
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
public class DAOUtilitarios {
    private static DAOUtilitarios daoSingleton;
    
    private IBonusFuncionarioDAO bonusDAO;
    private ICalculoEstatisticoDAO calculoEstatisticoDAO;
    private IFaltaDAO faltaDAO;
    private IFuncionarioDAO funcionarioDAO;
    private ISalarioDAO salarioDAO;
    private ITipoBonusDAO tipoBonusDAO;
    private ITipoCargoDAO tipoCargoDAO;
    
    private DAOUtilitarios() throws SQLException, Exception{
    }
    
    private void configurar(IDAOFactory daoFactory) throws SQLException, Exception{
        this.bonusDAO = daoFactory.getBonusDAO();
        this.salarioDAO = daoFactory.getSalarioDAO();
        this.faltaDAO = daoFactory.getFaltaDAO();
        this.funcionarioDAO = daoFactory.getFuncionarioDAO();
        this.calculoEstatisticoDAO = daoFactory.getCalculoEstatisticoDAO();
        this.tipoCargoDAO = daoFactory.getTipoCargoDAO();
        this.tipoBonusDAO = daoFactory.getTipoBonusDAO();
    }
    
    public static void configureInstance(IDAOFactory daoFactory) throws Exception{
        if(daoSingleton == null){
            daoSingleton = new DAOUtilitarios();
        }
        
        daoSingleton.configurar(daoFactory);
    }
    
    public static DAOUtilitarios getInstance(){
        return daoSingleton;
    }

    public IBonusFuncionarioDAO getBonusDAO() {
        return bonusDAO;
    }

    public ICalculoEstatisticoDAO getCalculoEstatisticoDAO() {
        return calculoEstatisticoDAO;
    }

    public IFaltaDAO getFaltaDAO() {
        return faltaDAO;
    }

    public IFuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public ISalarioDAO getSalarioDAO() {
        return salarioDAO;
    }

    public ITipoBonusDAO getTipoBonusDAO() {
        return tipoBonusDAO;
    }

    public ITipoCargoDAO getTipoCargoDAO() {
        return tipoCargoDAO;
    }
}
