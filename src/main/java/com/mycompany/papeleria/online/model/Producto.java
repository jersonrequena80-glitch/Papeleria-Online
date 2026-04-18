package com.mycompany.papeleria.online.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor vacío (es una buena práctica en Java Web)
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // --- GETTERS Y SETTERS ---
    // (Son necesarios para que los JSP puedan leer los datos)

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
