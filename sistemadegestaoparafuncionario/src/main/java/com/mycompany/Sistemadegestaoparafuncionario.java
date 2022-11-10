/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany;

import com.mycompany.dao.DAOUtilitarios;
import com.mycompany.dao.factory.DAOSQLiteFactory;
import com.mycompany.preseter.PrincipalPresenter;
import io.github.cdimascio.dotenv.Dotenv;
import javax.swing.JOptionPane;

/**
 *
 * @author heflain
 */
public class Sistemadegestaoparafuncionario {

    public static void main(String[] args) {
        try {
            configuracaoInicial();
            new PrincipalPresenter();
            //testeBonusDAO();
            //testeCargoDAO();
            //cadastraCargos();
            //System.out.println("Acabou 1");
            //cadastraBonus();
            //System.out.println("Acabou 2");
            //cadastraFuncionario();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void configuracaoInicial() {
        Dotenv dotenv = Dotenv.load();

        String bancoDados = dotenv.get("BANCO_DE_DADOS");
        if ("SQLite".equals(bancoDados)) {
            try {
                DAOUtilitarios.configureInstance(new DAOSQLiteFactory());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Erro no banco de dados",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("não foi configurado");
        }
    }

    /*
    private static void testeBonusDAO() {
        try {
            TipoBonus bonus = new TipoBonus("teste", 2.6);
            TipoBonusSQLiteDAO tb = new TipoBonusSQLiteDAO();
            tb.salvar(bonus);
            bonus = tb.obter(1);
            System.out.println(bonus.getId() + " " + bonus.getNoma() + " " + bonus.getPorcentagem());
            tb.obterTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void testeCargoDAO() {
        try {
            TipoCargo cargo = new TipoCargo("testador", 50.6);
            TipoCargoSQLiteDAO cb = new TipoCargoSQLiteDAO();
            cb.salvar(cargo);
            cargo = cb.obter(1);
            System.out.println(cargo.getId() + " " + cargo.getNome() + " " + cargo.getPorcentagemBonus());
            cb.obterTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<String[]> readAllLines(Path filePath) throws Exception {
        try ( Reader reader = Files.newBufferedReader(filePath)) {
            try ( CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    public static List<String[]> readAllExample() throws Exception {
        Path path = Paths.get(
                "funcionarios.csv"
        );
        return readAllLines(path);
    }

    public static void cadastraCargos() throws Exception {
        List<String[]> lista = readAllExample();
        TipoCargoSQLiteDAO tc = new TipoCargoSQLiteDAO();
        for (String[] x : lista) {
            tc.salvar(new TipoCargo(x[2], Math.random() * 0.1));
        }
    }

    public static void cadastraBonus() throws Exception {
        TipoBonus t1 = new TipoBonus("comum", 0.02);
        TipoBonus t2 = new TipoBonus("generoso", 0.05);

        TipoBonusSQLiteDAO tb = new TipoBonusSQLiteDAO();
        tb.salvar(t1);
        tb.salvar(t2);
    }

    public static void cadastraFuncionario() throws Exception {
        List<String[]> lista = readAllExample();
        TipoCargoSQLiteDAO tc = new TipoCargoSQLiteDAO();
        FuncionarioSQLiteDAO funDAO = new FuncionarioSQLiteDAO();
        for (String[] x : lista) {
            Funcionario f = new Funcionario(
                    x[1],
                    tc.obterId(x[2]),
                    1,
                    (int)(Math.random() * 20 + 18),
                    LocalDate.parse(x[6]),
                    Double.parseDouble(x[3]),
                    Double.parseDouble(x[4]),
                    false
            );
            
            funDAO.salvar(f);
        }
    }*/
}
