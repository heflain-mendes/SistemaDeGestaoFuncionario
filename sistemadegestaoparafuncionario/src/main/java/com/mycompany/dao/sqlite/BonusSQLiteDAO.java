/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import com.mycompany.dao.interfaces.IBonusDAO;
import com.mycompany.model.Bonus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class BonusSQLiteDAO implements IBonusDAO {

    public BonusSQLiteDAO() throws SQLException, Exception {
        String sql = "CREATE TABLE IF NOT EXISTS bonus("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " id_funcionario INTEGER NOT NULL,"
                + " tipo TEXT NOT NULL,"
                + " data_bonus TEXT NOT NULL,"
                + " valor REAL NOT NULL,"
                + " cargo INTEGER NOT NULL, "
                + " FOREIGN KEY (id_funcionario) REFERENCES funcionairos (id)"
                + " );";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException("Não foi possivel criar a tabela bonus");
        }
    }

    @Override
    public void salvar(int idFuncionario, Bonus bonus) throws Exception, SQLException {
        if (bonus == null) {
            throw new Exception("O Metodo salvar da Classe BonusSQLiteDAO necessita que bonus tenha valores validos");
        }

        String sql = "INSERT INTO bonus (id_funcionario, tipo, data_bonus, valor, cargo) VALUES (?, ?, ?, ?, ?)";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idFuncionario);
            ps.setString(2, bonus.getTipo());
            ps.setString(3, bonus.getData().toString());
            ps.setDouble(4, bonus.getValor());
            ps.setInt(5, bonus.getCargo());

            ps.executeUpdate();

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações do bonus");
        }
    }

    @Override
    public List<Bonus> obter(int idFuncionario) throws Exception, SQLException {
        String sql = "SELECT * FROM bonus WHERE id_funcionario = ?";
        List<Bonus> bonus = new ArrayList<>();

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bonus b = new Bonus(rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getDouble("valor"),
                        rs.getInt("cargo"),
                        LocalDate.parse(rs.getString("data_bonus")));
                bonus.add(b);
            }

            rs.close();

            return bonus;
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todos bonus");
        }
    }

    @Override
    public void remover(int idFuncionario, LocalDate data) throws Exception, SQLException {
        String sql = "DELETE FROM bonus WHERE id_funcionario = ? AND data_bonus = ?";
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.setString(2, data.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel deletar salario");
        }
    }

    @Override
    public void removerTodos(int idFuncionario) throws Exception, SQLException {
        String sql = "DELETE FROM bonus WHERE id_funcionario = ?";
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel deletar salarios");
        }
    }
}
