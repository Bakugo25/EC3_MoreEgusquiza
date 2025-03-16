package com.venta.EC3_MoreEgusquiza.dto;


public class PedidDto implements DtoEntity{
    private ClientDto client;
    private ProductDto product;

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
