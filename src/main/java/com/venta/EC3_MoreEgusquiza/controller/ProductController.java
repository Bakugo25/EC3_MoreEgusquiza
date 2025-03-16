package com.venta.EC3_MoreEgusquiza.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;
import com.venta.EC3_MoreEgusquiza.dto.GenericResponseDto;
import com.venta.EC3_MoreEgusquiza.exception.ResourceNotFoundException;
import com.venta.EC3_MoreEgusquiza.model.Product;
import com.venta.EC3_MoreEgusquiza.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<DtoEntity>>> listarProductos(){
        List<DtoEntity> productList = productService
                .listarProductos();
        if(productList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        GenericResponseDto<List<DtoEntity>> responseDto = new GenericResponseDto<>();
        responseDto.setRespuesta(productList);
        responseDto.setStatusCode(200);
        return new ResponseEntity<>(responseDto,
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> registarProducto
            (@RequestBody Product product){
        return new ResponseEntity<>(
                productService.guardarProducto(product),
                HttpStatus.CREATED);
    }

    @GetMapping("/{productid}")
    public ResponseEntity<Product> obtenerProductoXid(@PathVariable Integer productid){
        Product product = productService.obtenerProductoXid(productid).orElseThrow(()->new ResourceNotFoundException("El producto buscado no existe"));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{productid}")
    public ResponseEntity<Product> actualizarProducto(@PathVariable Integer productid, @RequestBody Product product){
        Product currentProduct = productService.obtenerProductoXid(productid).orElseThrow(()->new ResourceNotFoundException("El producto buscado no existe"));
        currentProduct.setNombre_producto(product.getNombre_producto());
        currentProduct.setPrecio(product.getPrecio());
        return new ResponseEntity<>(productService.guardarProducto(currentProduct),HttpStatus.OK);
    }
}
