package com.mycompany.papeleria.online.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_papeleria";
    private static final String USER = "root"; // Tu usuario de MySQL
    private static final String PASS = "tu_password"; // Tu contraseña de MySQL

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            System.err.println("Detalle: " + e.getMessage());
            return null;
        }
    }
    
}
