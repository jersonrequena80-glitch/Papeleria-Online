package com.mycompany.papeleria.online.servlet;

import com.mycompany.papeleria.online.model.Producto;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        
        // 1. Capturar datos del formulario
        String nombre = request.getParameter("txtNombre");
        String precioStr = request.getParameter("txtPrecio");
        String stockStr = request.getParameter("txtStock");

        // 2. Validar y convertir datos
        double precio = Double.parseDouble(precioStr);
        int stock = Integer.parseInt(stockStr);

        // 3. Crear objeto (Simulación de lógica de negocio)
        Producto nuevoProd = new Producto(0, nombre, precio, stock);

        // 4. Enviar mensaje de éxito a la vista
        request.setAttribute("mensaje", "Producto '" + nuevoProd.getNombre() + "' registrado correctamente.");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}