package com.eoi.es.proyectofinal.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {
	private Integer id;	
	private Date fecha;		
	private String nombre;
	private List<PedidoArticuloDto> articulos;
}
