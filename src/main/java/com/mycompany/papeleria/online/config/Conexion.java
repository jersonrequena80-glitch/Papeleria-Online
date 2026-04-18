package com.mycompany.papeleria.online.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    // Cargamos el archivo .env
    private static final Dotenv dotenv = Dotenv.load();
    
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}