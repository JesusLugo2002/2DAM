package com.docencia.rest.domain;

import java.math.BigDecimal;
import java.util.Objects;

import com.docencia.rest.domain.ProductDetail;

public class Product {

    private int id;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private ProductDetail detail;

    /**
     * Constructor vacio
     */
    public Product() {
    }

    /**
     * Constructor con asignacion de id para busquedas
     * 
     * @param id - Identificador unico del producto
     */
    public Product(int id) {
        this.id = id;
    }

    /**
     * Constructor con asignacion de todos los campos
     * 
     * @param nombre - Nombre del producto
     * @param precio - Precio del producto
     * @param stock  - Stock del producto
     */
    public Product(String nombre, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
    }

}