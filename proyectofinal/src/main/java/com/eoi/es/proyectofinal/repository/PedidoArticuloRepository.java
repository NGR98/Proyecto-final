package com.eoi.es.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eoi.es.proyectofinal.entity.PedidoArticulo;

@Repository
public interface PedidoArticuloRepository extends JpaRepository<PedidoArticulo, Integer>{	
	@Modifying
    @Query("UPDATE PedidoArticulo pa SET pa.cantidad = ?2 WHERE pa.id = ?1")
    void updateCantidad(int id, int cantidad);
}
	