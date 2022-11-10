/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import com.mycompany.dao.interfaces.ITipoCargoDAO;
import com.mycompany.model.Cargo;
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
public class CargoSQLiteDAO implements ITipoCargoDAO{

    public CargoSQLiteDAO() throws SQLException, Exception {
        String sql = "CREATE TABLE IF NOT EXISTS tipo_cargos("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " nome TEXT NOT NULL,"
                + " porcentagem_bonus REAL NOT NULL "
                + " );";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Não foi possivel criar a tabela tipo_cargos");
        }
    }
    
    

    @Override
    public void salvar(Cargo tipoCargo) throws Exception, SQLException {
        if (tipoCargo == null) {
            throw new Exception("O Metodo salvar da Classe TipoCargoSQLiteDAO"
                    + " necessita de parametros não nulos");
        }
        
        if(this.exist(tipoCargo.getNome())){
            return;
        }

        String sql = "INSERT INTO tipo_cargos (nome, porcentagem_bonus) VALUES (?, ?)";

        try (
                Connection conn = SQLiteConnection.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {

            ps.setString(1, tipoCargo.getNome());
            ps.setDouble(2, tipoCargo.getPorcentagemBonus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações do tipo de cargo");
        }
    }

    @Override
    public List<Cargo> obterTodos() throws Exception, SQLException {
         String sql = "SELECT * FROM tipo_cargos";
        List<Cargo> cargos = new ArrayList<>();

        try (
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);  
                ResultSet rs = ps.executeQuery();
            ) {

            while (rs.next()) {
                Cargo c = new Cargo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("porcentagem_bonus")
                );
                cargos.add(c);
            }

            return cargos;
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todos tipos de cargos");
        }
    }

    @Override
    public Cargo obter(int id) throws Exception, SQLException {
        String sql = "SELECT * FROM tipo_cargos WHERE id = ?";

        try ( 
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Cargo c = new Cargo(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("porcentagem_bonus")
            );
            return c;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel obter o tipo de cargos");
        }
    }
    
    private boolean exist(String nome) throws Exception{
        String sql = "SELECT * FROM tipo_cargos WHERE nome = ?";

        try ( 
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel obter o tipo de cargos");
        }
    }
    
    @Override
    public int obterId(String nome) throws Exception{
        String sql = "SELECT * FROM tipo_cargos WHERE nome = ?";

        try ( 
                Connection conn = SQLiteConnection.getConexao();  
                PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Não foi possivel obter o tipo de cargos");
        }
    }
}
