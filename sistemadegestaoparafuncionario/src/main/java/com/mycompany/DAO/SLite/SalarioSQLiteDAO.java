/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO.SLite;

import com.mycompany.DAO.interfaces.ISalarioDAO;
import com.mycompany.model.Salario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class SalarioSQLiteDAO implements ISalarioDAO {

    @Override
    public void salvar(int idFuncionario, Salario salario) throws Exception, SQLException {
        if (salario == null) {
            throw new Exception("O Metodo salvar da Classe SalarioSQLiteDAO necessita que bonus tenha valores validos");
        }

        String sql = "INSERT INTO salarios (id_funcionario, salario_base, salario_total, data_salario) VALUES ( ?, ?, ?, ?)";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idFuncionario);
            ps.setDouble(2, salario.getId());
            ps.setDouble(3, salario.getSalarioBase());
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
        String sql = "SELECT * FROM salarios WHERE id_funcionario = ?";

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
    public void remover(int idFuncionario) throws Exception, SQLException{
        String sql = "DELETE FROM salarios WHERE id_funcionario = ? ?";
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.executeUpdate();
        }catch (Exception ex) {
           throw new SQLException("Não foi possivel deletar salarios");
        }
    }
}
