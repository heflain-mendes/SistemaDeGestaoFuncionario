/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.sqlite;

import com.mycompany.dao.interfaces.IFuncionarioDAO;
import com.mycompany.model.Funcionario;
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
public class FuncionarioSQLiteDAO implements IFuncionarioDAO {

    public FuncionarioSQLiteDAO() throws SQLException, Exception {
        String sql = "CREATE TABLE IF NOT EXISTS funcionarios("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " nome TEXT NOT NULL,"
                + " cargo INTEGER NOT NULL,"
                + " bonus_honra INTEGER NOT NULL,"
                + " idade INTEGER NOT NULL, "
                + " data_inicio TEXT NOT NULL,"
                + " salario_base REAL NOT NULL,"
                + " distancia_trabalho REAL NOT NULL,"
                + " funcionario_mes INTEGER NOT NULL"
                + ")";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            throw new SQLException("Não foi possivel criar a tabela funcionarios");
        } catch (Exception ex) {
            throw new Exception("Não foi possivel fazer conexao com o bando de dados SQLite");
        }

    }

    @Override
    public Funcionario salvar(Funcionario funcionario) throws Exception, SQLException {

        if (funcionario == null) {
            throw new Exception("O Metodo salvar da Classe FuncionarioSQLiteDAO necessita que funcionario tenha valores validos");
        }

        String sql = "INSERT INTO funcionarios (nome, cargo, bonus_honra, idade, data_inicio, salario_base, distancia_trabalho, funcionario_mes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getBonusHonra());
            ps.setInt(4, funcionario.getIdade());
            ps.setString(5, funcionario.getDataInicioNaEmpresa().toString());
            ps.setDouble(6, funcionario.getSalarioBaseAtual());
            ps.setDouble(7, funcionario.getDistanciaDoTrabalho());
            ps.setBoolean(8, funcionario.IsFuncionairoDoMes());
            ps.executeUpdate();

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações do funcionario: " + funcionario.getNome() + " na tabela funcionario");
        }

        return obterUltimoFuncionarioInserido();
    }

    private Funcionario obterUltimoFuncionarioInserido() throws SQLException, Exception {
        String sql = "SELECT * FROM funcionarios ORDER BY id DESC LIMIT 1";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            rs.next();

            Funcionario f = new Funcionario(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("cargo"),
                    rs.getInt("bonus_honra"),
                    rs.getInt("idade"),
                    LocalDate.parse(rs.getString("data_inicio")),
                    rs.getDouble("salario_base"),
                    rs.getDouble("distancia_trabalho"),
                    rs.getBoolean("funcionario_mes")
            );

            return f;

        } catch (SQLException ex) {
            ex.printStackTrace();
            new SQLException("Não foi possivel resgatar o ultimo funcionario inserido");

        }

        return null;
    }

    @Override
    public void atualizar(Funcionario funcionario) throws Exception {
        if (funcionario == null) {
            throw new Exception("O Metodo atualizar da Classe FuncionarioSQLiteDAO necessita que funcionario tenha valores validos");
        }

        String sql = "UPDATE funcionarios SET nome = ? , cargo = ? , bonus_honra = ?, idade = ?, data_inicio = ? , salario_base = ? , distancia_trabalho = ? , funcionario_mes = ? WHERE id = ?";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo());
            ps.setInt(3, funcionario.getBonusHonra());
            ps.setInt(4, funcionario.getIdade());
            ps.setString(5, funcionario.getDataInicioNaEmpresa().toString());
            ps.setDouble(6, funcionario.getSalarioBaseAtual());
            ps.setDouble(7, funcionario.getDistanciaDoTrabalho());
            ps.setBoolean(8, funcionario.IsFuncionairoDoMes());
            ps.setInt(9, funcionario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel atualizar informações do funcionario: " + funcionario.getNome() + " na tabela funcionario");
        }
    }

    @Override
    public void remover(Funcionario funcionario) throws Exception {
        if (funcionario == null) {
            throw new Exception("O Metodo delete da Classe FuncionarioSQLiteDAO necessita que funcionario tenha valores validos");
        }

        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, funcionario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel deletar funcionario: " + funcionario.getNome() + " na tabela funcionario");
        }
    }

    @Override
    public List<Funcionario> obterTodos() throws Exception {
        String sql = "SELECT * FROM funcionarios";
        List<Funcionario> funcionarios = new ArrayList<>();
        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("cargo"),
                        rs.getInt("bonus_honra"),
                        rs.getInt("idade"),
                        LocalDate.parse(rs.getString("data_inicio")),
                        rs.getDouble("salario_base"),
                        rs.getDouble("distancia_trabalho"),
                        rs.getBoolean("funcionario_mes")
                );
                funcionarios.add(f);
            }
            return funcionarios;
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel obter todos funcionarios na tabela funcionario");
        }
    }
}
