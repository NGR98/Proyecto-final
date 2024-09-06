package com.eoi.es.proyectofinal.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.eoi.es.proyectofinal.dto.PedidoArticuloDto;
import com.eoi.es.proyectofinal.dto.PedidoDto;
import com.eoi.es.proyectofinal.entity.Articulo;
import com.eoi.es.proyectofinal.entity.Pedido;
import com.eoi.es.proyectofinal.entity.PedidoArticulo;
import com.eoi.es.proyectofinal.repository.ArticuloRepository;
import com.eoi.es.proyectofinal.repository.PedidoArticuloRepository;
import com.eoi.es.proyectofinal.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PedidoArticuloRepository pedidoArticuloRepository;
	
	@Autowired
	ArticuloRepository articuloRepository;

	public PedidoDto findById(int id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		List<PedidoArticuloDto> articuloDtos = new ArrayList<>();
		
	    for (PedidoArticulo pedidoArticulo : pedido.getPedidoArticulos()) {
	        PedidoArticuloDto articuloDto = new PedidoArticuloDto();
	        articuloDto.setId(pedidoArticulo.getArticulo().getId());
	        articuloDto.setCantidad(pedidoArticulo.getCantidad());
	        articuloDtos.add(articuloDto);
	    }
		
		PedidoDto pedidoDto = new PedidoDto();
		pedidoDto.setId(pedido.getId());
		pedidoDto.setNombre(pedido.getNombre());
		pedidoDto.setFecha(pedido.getFecha());
		pedidoDto.setArticulos(articuloDtos);

		return pedidoDto;
	}

	public List<PedidoDto> findByNombreParcial(String nombreparcial) {
	    List<Pedido> pedidos = pedidoRepository.findByNombreContainingIgnoreCase(nombreparcial);
	    List<PedidoDto> dtos = new ArrayList<>();
	    for (Pedido pedido : pedidos) {
	        List<PedidoArticuloDto> articuloDtos = new ArrayList<>();
	        for (PedidoArticulo pedidoArticulo : pedido.getPedidoArticulos()) {
	            PedidoArticuloDto articuloDto = new PedidoArticuloDto();
	            articuloDto.setId(pedidoArticulo.getArticulo().getId());
	            articuloDto.setCantidad(pedidoArticulo.getCantidad());
	            articuloDtos.add(articuloDto);
	        }
	        
	        PedidoDto dto = new PedidoDto();
	        dto.setId(pedido.getId());
	        dto.setNombre(pedido.getNombre());
	        dto.setFecha(pedido.getFecha());
	        dto.setArticulos(articuloDtos);

	        dtos.add(dto);
	    }

	    return dtos;
	}

	public void create(PedidoDto dto) {
	    Pedido pedido = new Pedido();
	    pedido.setNombre(dto.getNombre());
	    pedido.setFecha(dto.getFecha());

	    if (dto.getArticulos() != null) {
	        List<PedidoArticulo> pedidoArticulos = new ArrayList<>();
	        for (PedidoArticuloDto articuloDto : dto.getArticulos()) {
	            PedidoArticulo pedidoArticulo = new PedidoArticulo();
	            pedidoArticulo.setCantidad(articuloDto.getCantidad());	            
	            Articulo articulo = articuloRepository.findById(articuloDto.getId()).get();
	            pedidoArticulo.setArticulo(articulo);
	            pedidoArticulo.setPedido(pedido);
	            pedidoArticulos.add(pedidoArticulo);
	        }
	        pedido.setPedidoArticulos(pedidoArticulos);
	    }
	    pedidoRepository.save(pedido);
	}

	public void update(PedidoDto dto) {
		Pedido entity = new Pedido();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setFecha(dto.getFecha());

		pedidoRepository.save(entity);
	}

	public void deleteById(int id) {
		pedidoRepository.deleteById(id);
	}

}
