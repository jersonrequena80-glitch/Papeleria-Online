package com.mycompany.papeleria.online.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

// Esta anotación permite que el navegador encuentre el código en /ProductoServlet
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige al formulario JSP
        request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nombre = request.getParameter("txtNombre");
            String precioStr = request.getParameter("txtPrecio");
            String stockStr = request.getParameter("txtStock");
            
            // Validar que los parámetros no sean nulos
            if (nombre == null || nombre.trim().isEmpty() || precioStr == null || stockStr == null) {
                request.setAttribute("mensaje", "Error: Todos los campos son obligatorios.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            
            double precio = Double.parseDouble(precioStr);
            int stock = Integer.parseInt(stockStr);
            
            try (java.sql.Connection con = com.mycompany.papeleria.online.config.Conexion.getConnection();
                 java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)")) {
                
                ps.setString(1, nombre);
                ps.setDouble(2, precio);
                ps.setInt(3, stock);
                ps.executeUpdate();
                
                request.setAttribute("mensaje", "Producto '" + nombre + "' guardado en base de datos.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "Error: Precio y Stock deben ser números válidos.");
        } catch (ServletException | IOException | SQLException e) {
            request.setAttribute("mensaje", "Error al guardar: " + e.getMessage());
        }
Connection con = com.mycompany.papeleria.online.config.Conexion.getConnection();
if (con == null) {
    request.setAttribute("mensaje", "Error: No se pudo conectar a la base de datos. Revisa la consola.");
    request.getRequestDispatcher("index.jsp").forward(request, response);
    return; // Detiene la ejecución para que no salga el error de "con is null"
}        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
