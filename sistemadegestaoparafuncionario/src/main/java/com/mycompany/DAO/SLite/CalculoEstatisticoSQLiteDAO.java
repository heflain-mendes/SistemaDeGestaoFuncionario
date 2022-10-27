    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO.SLite;

import com.mycompany.DAO.interfaces.ICalculoEstatisticoDAO;
import com.mycompany.model.CalculoEstatistico;
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
public class CalculoEstatisticoSQLiteDAO implements ICalculoEstatisticoDAO {

    private static CalculoEstatisticoSQLiteDAO calculoEstatisticoSQLitDAO;
    
    public static CalculoEstatisticoSQLiteDAO getInstance() throws Exception{
        if(calculoEstatisticoSQLitDAO == null){
            calculoEstatisticoSQLitDAO = new CalculoEstatisticoSQLiteDAO();
        }
        
        return calculoEstatisticoSQLitDAO;
    }
    
    private CalculoEstatisticoSQLiteDAO() throws SQLException, Exception {
        String sql = "CREATE TABLE IF NOT EXISTS calculos_estatisticos("
                + " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                + " data_calculo TEXT NOT NULL,"
                + " somatorio REAL NOT NULL,"
                + " media REAL NOT NULL,"
                + " desvio_padrao REAL NOT NULL,"
                + " maior_salario REAL NOT NULL,"
                + " menor_salario REAL NOT NULL,"
                + " qtd_salario INTEGER NOT NULL,"
                + " coeficiente_variacao "
                + ");";

        try ( Statement st = SQLiteConnection.getConexao().createStatement()) {
            st.execute(sql);
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            throw new SQLException("Não foi possivel criar a tabela calculo_estatistico");
        }

    }

    @Override
    public void salvar(CalculoEstatistico calculoEstatistico) throws Exception, SQLException {
        if (calculoEstatistico == null) {
            throw new Exception("O Metodo salvar da Classe CalculoEstatisticoSQLitDAO necessita que calculoEstatistico seja não nulo");
        }

        String sql = "INSERT INTO calculos_estatisticos ("
                + " data_calculo,"
                + " somatorio,"
                + " media,"
                + " desvio_padrao,"
                + " maior_salario,"
                + " menor_salario,"
                + " coeficiente_variacao,"
                + " qtd_salario)"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, calculoEstatistico.getData().toString());
            ps.setDouble(2, calculoEstatistico.getSomatorio());
            ps.setDouble(3, calculoEstatistico.getMedia());
            ps.setDouble(4, calculoEstatistico.getDesvioPadrao());
            ps.setDouble(5, calculoEstatistico.getMaiorSalario());
            ps.setDouble(6, calculoEstatistico.getMenorSalario());
            ps.setDouble(7, calculoEstatistico.getCoeficienteVariacao());
            ps.setInt(8, calculoEstatistico.getQttSalario());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new SQLException("Não foi possivel salvar informações sobre calculos estatistico");
        }
    }

    @Override
    public void atualizar(CalculoEstatistico calculoEstatistico) throws Exception, SQLException {
        System.out.println(calculoEstatistico.toString());
        if (calculoEstatistico == null) {
            throw new Exception("O Metodo atualizar da Classe CalculoEstatisticoSQLitDAO necessita que calculoEstatistico não seja null");
        }

            String sql = "UPDATE calculos_estatisticos"
                + " SET "
                + " data_calculo = ? ,"
                + " somatorio = ? ,"
                + " media = ? ,"
                + " desvio_padrao = ? ,"
                + " maior_salario = ? ,"
                + " menor_salario = ? ,"
                + " coeficiente_variacao = ? ,"
                + " qtd_salario = ?"
                + " WHERE id = ?";

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, calculoEstatistico.getData().toString());
            ps.setDouble(2, calculoEstatistico.getSomatorio());
            ps.setDouble(3, calculoEstatistico.getMedia());
            ps.setDouble(4, calculoEstatistico.getDesvioPadrao());
            ps.setDouble(5, calculoEstatistico.getMaiorSalario());
            ps.setDouble(6, calculoEstatistico.getMenorSalario());
            ps.setDouble(7, calculoEstatistico.getCoeficienteVariacao());
            ps.setInt(8, calculoEstatistico.getQttSalario());
            ps.setInt(9, calculoEstatistico.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Não foi possivel atualizar informações da calculo estatistico");
        }
    }

    @Override
    public List<CalculoEstatistico> obterTodos() throws Exception, SQLException {
        String sql = "SELECT * FROM calculos_estatisticos";

        List<CalculoEstatistico> calculosEstatistico = new ArrayList<>();

        try ( Connection conn = SQLiteConnection.getConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CalculoEstatistico ce = new CalculoEstatistico(
                        rs.getInt("id"),
                        LocalDate.parse(rs.getString("data_calculo")),
                        rs.getDouble("somatorio"),
                        rs.getDouble("media"),
                        rs.getDouble("menor_salario"),
                        rs.getDouble("maior_salario"),
                        rs.getDouble("desvio_padrao"),
                        rs.getDouble("coeficiente_variacao"),
                        rs.getInt("qtd_salario"));
                calculosEstatistico.add(ce);
            }

            return calculosEstatistico;

        }catch (SQLException e) {
            throw new SQLException("Não foi possivel obter calculos estátistico completo");
        }
    }

}
