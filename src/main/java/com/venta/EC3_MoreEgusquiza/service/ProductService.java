package com.venta.EC3_MoreEgusquiza.service;

import org.springframework.stereotype.Service;
import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;
import com.venta.EC3_MoreEgusquiza.dto.ProductDto;
import com.venta.EC3_MoreEgusquiza.model.Product;
import com.venta.EC3_MoreEgusquiza.repository.ProductRepository;
import com.venta.EC3_MoreEgusquiza.util.ConvertDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ConvertDto convertDto;

    public ProductService(ProductRepository productRepository, ConvertDto convertDto) {
        this.productRepository = productRepository;
        this.convertDto = convertDto;
    }

    public List<DtoEntity> listarProductos(){
        List<DtoEntity> productDtoList = new ArrayList<>();
        productDtoList = productRepository.findAll().stream().map(p -> convertDto.convertirADto(p, new ProductDto())).collect(Collectors.toList());
        return productDtoList;
    }

    public Product guardarProducto(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> obtenerProductoXid(Integer productid){
        return productRepository.findById(productid);
    }

}
