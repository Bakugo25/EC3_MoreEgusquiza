package com.venta.EC3_MoreEgusquiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venta.EC3_MoreEgusquiza.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
