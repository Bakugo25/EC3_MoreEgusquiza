package com.venta.EC3_MoreEgusquiza.repository;

import com.venta.EC3_MoreEgusquiza.model.Pedid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidReposiroty extends JpaRepository<Pedid, Integer> {
}
