package com.eoi.es.proyectofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pedidoarticulo")
@Getter
@Setter
@ToString
public class PedidoArticulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "idPedido", referencedColumnName = "id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "idArticulo", referencedColumnName = "id")
	private Articulo articulo;

	@Column
	private int cantidad;

}
