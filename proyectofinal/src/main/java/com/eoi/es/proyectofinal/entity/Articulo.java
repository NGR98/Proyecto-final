package com.eoi.es.proyectofinal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@ToString
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private double precio;
	
	@Column
	private int stock;
	
	@OneToMany(mappedBy = "articulo")
	private List<PedidoArticulo> pedidoArticulos;
}
