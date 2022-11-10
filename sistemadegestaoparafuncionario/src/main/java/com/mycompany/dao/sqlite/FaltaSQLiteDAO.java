/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import com.mycompany.dao.interfaces.IFaltaDAO;
import com.mycompany.model.Falta;
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
public class FaltaSQLiteDAO implements IFaltaDAO {

    public FaltaSQLiteDAO() throws SQLException, Exception {
        String sql = "CREATE TABLE IF NOT EXISTS faltas("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " id_funcionario INTEGER NOT NULL,"
                + " qtd INTEGER NOT NULL,"
                + " data_falta TEXT NOT NULL,"
                + " FOREIGN KEY (id_funcionario) REFERENCES funcionairos (id) "
                + ");)";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            throw new SQLException("Não foi possivel criar a tabela faltas");
        }
    }

    @Override
    public void salvar(int idFuncionario, Falta falta) throws Exception, SQLException {
        if (falta == null) {
            throw new Exception("O Metodo salvar da Classe FaltasSQLiteDAO necessita que bonus tenha valores validos");
        }

        String sql = "INSERT INTO faltas (id_funcionario, qtd, data_falta) VALUES ( ?, ?, ?)";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idFuncionario);
            ps.setInt(2, falta.getQuantidade());
            ps.setString(3, falta.getDate().toString());

            ps.executeUpdate();

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações da falta");
        }
    }

    @Override
    public void atualizar(Falta falta) throws Exception, SQLException {
        if (falta == null) {
            throw new Exception("O Metodo atualizar da Classe FaltasSQLiteDAO necessita que funcionario tenha valores validos");
        }

        String sql = "UPDATE faltas SET qtd = ? , data_falta = ? WHERE id = ?";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, falta.getQuantidade());
            ps.setString(2, falta.getDate().toString());
            ps.setInt(3, falta.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel atualizar informações da falta");
        }
    }

    @Override
    public void remover(int idFuncionario) throws Exception, SQLException {
        String sql = "DELETE FROM faltas WHERE id_funcionario = ?";
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new SQLException("Não foi possivel deletar faltas");
        }
    }

    @Override
    public List<Falta> obterPorFuncionario(int idFuncionario) throws Exception, SQLException {
        String sql = "SELECT * FROM faltas WHERE id_funcionario = ?";

        List<Falta> faltas = new ArrayList<>();

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Falta f = new Falta(rs.getInt("id"),
                        LocalDate.parse(rs.getString("data_falta")),
                        rs.getInt("qtd")
                );
                faltas.add(f);
            }

            return faltas;

        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todas as faltas");
        }
    }

    @Override
    public Falta obterPorFuncionarioData(int idFuncionario, LocalDate data) throws Exception {
        for (Falta f : obterPorFuncionario(idFuncionario)) {
            if(f.getDate().getMonthValue() == data.getMonthValue() &&
                    f.getDate().getYear() == data.getYear()){
                return f;
            }
        }
        return null;
    }
}
