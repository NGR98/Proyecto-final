package com.eoi.es.proyectofinal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class PedidoArticuloDto {
	
    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "cantidad")
    private int cantidad;
	
}
	