package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class conectar_bd {
    private static String db_ = "manu";
    private static String login_ = "manu";
    private static String password_ = "Fat/3232";
    private static String url_ = "jdbc:mysql://localhost/" + db_;
    private static Connection connection_;
    private static Statement st_ = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);
        } catch (Exception e) {
            System.out.println("error1");
            System.out.println(e.getMessage());

        }

        if (connection_ == null) {
            System.out.println("error");
        } else {
            try {
                st_ = connection_.createStatement();
                System.out.println("Conexiona la base de datos: " + db_ + " correcta.");
            } catch (Exception e) {
            }

        }
    }

    public static void Select() {
        try {
            ResultSet rs = st_.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

        } catch (Exception e) {
        }

    }

}