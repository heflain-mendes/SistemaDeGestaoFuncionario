/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import com.mycompany.dao.interfaces.ITipoBonusDAO;
import com.mycompany.model.TipoBonus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class TipoBonusSQLiteDAO implements ITipoBonusDAO {

    public TipoBonusSQLiteDAO() throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS tipo_bonus("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " nome TEXT NOT NULL,"
                + " porcentagem REAL NOT NULL "
                + " );";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Não foi possivel criar a tabela tipo_bonus");
        }
    }

    @Override
    public void salvar(TipoBonus bonusCadastrado) throws Exception, SQLException {
        if (bonusCadastrado == null) {
            throw new Exception("O Metodo salvar da Classe TipoBonusSQLiteDAO"
                    + " necessita de parametros não nulos");
        }

        String sql = "INSERT INTO tipo_bonus (nome, porcentagem) VALUES (?, ?)";

        try (
                Connection conn = SQLiteConnection.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {

            ps.setString(1, bonusCadastrado.getNoma());
            ps.setDouble(2, bonusCadastrado.getPorcentagem());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações do tipo de bonus");
        }
    }

    @Override
    public List<TipoBonus> obterTodos() throws Exception, SQLException {
        String sql = "SELECT * FROM tipo_bonus";
        List<TipoBonus> bonus = new ArrayList<>();

        try (
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);  
                ResultSet rs = ps.executeQuery();
            ) {

            while (rs.next()) {
                TipoBonus b = new TipoBonus(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("porcentagem")
                );
                bonus.add(b);
            }

            return bonus;
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todos tipos bonus");
        }
    }

    @Override
    public TipoBonus obter(int id) throws Exception, SQLException {
        String sql = "SELECT * FROM tipo_bonus WHERE id = ?";

        try ( 
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            TipoBonus b = new TipoBonus(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("porcentagem")
            );
            return b;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel obter o tipo de bonus");
        }
    }
    
    @Override
    public int obterId(String name) throws Exception, SQLException {
        String sql = "SELECT * FROM tipo_bonus WHERE nome = ?";

        try ( 
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            rs.next();
            TipoBonus b = new TipoBonus(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("porcentagem")
            );
            return b.getId();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel obter o tipo de bonus");
        }
    }
    
}
