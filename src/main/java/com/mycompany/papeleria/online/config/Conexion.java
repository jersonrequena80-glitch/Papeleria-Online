package com.mycompany.papeleria.online.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    // REEMPLAZA TU CARGA ANTERIOR POR ESTA:
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("/")         // Indica que busque en la raíz del classpath (resources)
            .ignoreIfMalformed()    // Evita errores si el archivo tiene un formato extraño
            .ignoreIfMissing()      // Evita que la app se detenga si no encuentra el archivo
            .load();
    
    // El resto sigue igual, usando las variables del .env
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