package com.eoi.es.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eoi.es.proyectofinal.entity.PedidoArticulo;

@Repository
public interface PedidoArticuloRepository extends JpaRepository<PedidoArticulo, Integer>{	
	
}
	