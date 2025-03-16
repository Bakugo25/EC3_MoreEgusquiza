package com.venta.EC3_MoreEgusquiza.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product product;

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
