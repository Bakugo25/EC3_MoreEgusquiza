package com.venta.EC3_MoreEgusquiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venta.EC3_MoreEgusquiza.model.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}
