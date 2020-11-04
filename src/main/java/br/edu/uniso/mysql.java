package br.edu.uniso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysql {

    public static void enfiandoNoBanco(String nome, int idade, String cpf){
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luislocal",
                    "root","");

            PreparedStatement ps = c.prepareStatement("insert into VENDEDORES(nome, idade, cpf) values " +
                    "(?,?,?)");

            ps.setString(1,nome);
            ps.setString(2, String.valueOf(idade));
            ps.setInt(3, Integer.parseInt(cpf));

            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
