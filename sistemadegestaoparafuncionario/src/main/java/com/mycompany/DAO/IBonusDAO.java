/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.model.Bonus;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author heflain
 */
public interface IBonusDAO {
    public void salvar(long idFuncionario, Bonus... bonus);
    public List<Bonus> obter(long idFuncionario);
    public void remover(long idFuncionario, LocalDate data);
}
