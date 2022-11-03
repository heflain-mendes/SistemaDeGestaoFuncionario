/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.dao.factory.IDAOFactory;
import com.mycompany.dao.interfaces.IBonusDAO;
import com.mycompany.dao.interfaces.ICalculoEstatisticoDAO;
import com.mycompany.dao.interfaces.IFaltaDAO;
import com.mycompany.dao.interfaces.IFuncionarioDAO;
import com.mycompany.dao.interfaces.ISalarioDAO;
import java.sql.SQLException;

/**
 *
 * @author heflain
 */
public class DAOSingleton {
    private static DAOSingleton daoSingleton;
    
    private IBonusDAO bonusDAO;
    private ICalculoEstatisticoDAO calculoEstatisticoDAO;
    private IFaltaDAO faltaDAO;
    private IFuncionarioDAO funcionarioDAO;
    private ISalarioDAO salarioDAO;
    
    private DAOSingleton() throws SQLException, Exception{
    }
    
    private void configurar(IDAOFactory daoFactory) throws SQLException, Exception{
        this.bonusDAO = daoFactory.getBonusDAO();
        this.salarioDAO = daoFactory.getSalarioDAO();
        this.faltaDAO = daoFactory.getFaltaDAO();
        this.funcionarioDAO = daoFactory.getFuncionarioDAO();
        this.calculoEstatisticoDAO = daoFactory.getCalculoEstatisticoDAO();
    }
    
    public static void configureInstance(IDAOFactory daoFactory) throws Exception{
        if(daoSingleton == null){
            daoSingleton = new DAOSingleton();
        }
        
        daoSingleton.configurar(daoFactory);
    }
    
    public static DAOSingleton getInstance(){
        return daoSingleton;
    }

    public IBonusDAO getBonusDAO() {
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
}
