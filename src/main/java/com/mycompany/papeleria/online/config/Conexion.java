package com.mycompany.papeleria.online.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory("/")         // Busca en la raíz del classpath (resources)
            .ignoreIfMalformed()    // Evita errores si el archivo tiene formato extraño
            .ignoreIfMissing()      // No detiene la app si no encuentra el archivo
            .load();
    
    // Variables de conexión desde .env o valores por defecto
    private static final String URL = dotenv.get("DB_URL", "jdbc:mysql://localhost:3306/bd_papeleria");
    private static final String USER = dotenv.get("DB_USER", "root");
    private static final String PASS = dotenv.get("DB_PASS", "tu_password");

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL no encontrado: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
            System.err.println("URL: " + URL);
            System.err.println("Usuario: " + USER);
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}