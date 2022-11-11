/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import com.mycompany.dao.interfaces.ISalarioDAO;
import com.mycompany.model.Funcionario;
import com.mycompany.model.Salario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class SalarioSQLiteDAO implements ISalarioDAO {

    public SalarioSQLiteDAO() throws SQLException, Exception {
        String sql = "CREATE TABLE IF NOT EXISTS salarios("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " funcionario INTEGER NOT NULL,"
                + " salario_base REAL NOT NULL,"
                + " salario_total REAL NOT NULL,"
                + " data_salario TEXT NOT NULL,"
                + " FOREIGN KEY (funcionario) REFERENCES funcionarios (id)"
                + ");";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            throw new SQLException("Não foi possivel criar a tabela salario");
        }
    }

    public void salvar(int idFuncionario, Salario salario) throws Exception, SQLException {
        if (salario == null) {
            throw new Exception("O Metodo salvar da Classe SalarioSQLiteDAO necessita que bonus tenha valores validos");
        }

        String sql = "INSERT INTO salarios (funcionario, salario_base, salario_total, data_salario) VALUES ( ?, ?, ?, ?)";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idFuncionario);
            ps.setDouble(2, salario.getSalarioBase());
            ps.setDouble(3, salario.getSalarioTotal());
            ps.setString(4, salario.getData().toString());
            ps.executeUpdate();

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações do salario");
        }
    }

    @Override
    public List<Salario> obter(int idFuncionario) throws Exception, SQLException {
        String sql = "SELECT * FROM salarios WHERE funcionario = ?";

        List<Salario> salarios = new ArrayList<>();

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Salario s = new Salario(rs.getInt("id"),
                        rs.getDouble("salario_base"),
                        rs.getDouble("salario_total"),
                        LocalDate.parse(rs.getString("data_salario")));
                salarios.add(s);
            }

            return salarios;

        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todos bonus");
        }
    }

    @Override
    public void atualizar(Salario salario) throws Exception, SQLException {
        if (salario == null) {
            throw new Exception("O Metodo atualizar da Classe FuncionarioSQLiteDAO necessita que funcionario tenha valores validos");
        }

        String sql = "UPDATE salarios SET salario_base = ? , salario_total = ? , data_salario = ? WHERE id = ?";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, salario.getSalarioBase());
            ps.setDouble(2, salario.getSalarioTotal());
            ps.setString(3, salario.getData().toString());
            ps.setInt(4, salario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel atualizar informações do salario");
        }
    }

    @Override
    public void remover(int idFuncionario) throws Exception, SQLException {
        String sql = "DELETE FROM salarios WHERE funcionario = ?";
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new SQLException("Não foi possivel deletar salarios");
        }
    }

    @Override
    public List<Salario> obterPorData(int idFuncionario, LocalDate data) throws Exception, SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sql = "SELECT * FROM salarios WHERE funcionario = ?";

        List<Salario> salarios = new ArrayList<>();

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();

            LocalDate dataObtidaDoSQLite;
            while (rs.next()) {
                dataObtidaDoSQLite = LocalDate.parse(rs.getString("data_salario"));
                if (dataObtidaDoSQLite.equals(data)) {
                    Salario s = new Salario(rs.getInt("id"),
                            rs.getDouble("salario_base"),
                            rs.getDouble("salario_total"),
                            LocalDate.parse(rs.getString("data_salario")));
                    salarios.add(s);
                }
            }

            return salarios;

        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todos bonus");
        }
    }
}
