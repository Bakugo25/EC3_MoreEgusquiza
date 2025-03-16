package com.venta.EC3_MoreEgusquiza.dto;

public class ProductDto implements DtoEntity{
    private String nombre_producto;
    private Double precio;

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
