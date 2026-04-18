<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Papelería Online - Inicio</title>
        <style>
            body { font-family: Arial; text-align: center; margin-top: 50px; }
            .mensaje { color: green; font-weight: bold; }
        </style>
    </head>
    <body>
        <h1>Bienvenido a la Papelería Online</h1>
        
        <%-- Esta parte muestra el mensaje de éxito cuando regresas del Servlet --%>
        <% if(request.getAttribute("mensaje") != null) { %>
            <p class="mensaje"><%= request.getAttribute("mensaje") %></p>
        <% } %>

        <a href="ProductoServlet">Ir al formulario de productos</a>
    </body>
</html>