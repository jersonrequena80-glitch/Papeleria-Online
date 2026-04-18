<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Papelería Online - Registro</title>
        <style>
            body { font-family: Arial; background-color: #F8F9FA; }
            .btn-primary { background-color: #007BFF; color: white; border: none; padding: 10px; }
            .container { width: 50%; margin: auto; padding: 20px; }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Registrar Nuevo Producto</h2>
            <form action="ProductoServlet" method="POST">
                <label>Nombre del Producto:</label><br>
                <input type="text" name="txtNombre" required><br><br>
                
                <label>Precio:</label><br>
                <input type="number" step="0.01" name="txtPrecio" required><br><br>
                
                <label>Stock Inicial:</label><br>
                <input type="number" name="txtStock" required><br><br>
                
                <input type="submit" class="btn-primary" value="Guardar en Inventario">
            </form>
            <br>
            <a href="index.jsp">Volver al Inicio</a>
        </div>
    </body>
</html>
