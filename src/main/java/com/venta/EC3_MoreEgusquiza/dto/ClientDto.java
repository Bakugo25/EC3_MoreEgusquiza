package com.venta.EC3_MoreEgusquiza.dto;

public class ClientDto implements DtoEntity{
    private String nombre_cliente;
    private String apellido_cliente;

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }
}
