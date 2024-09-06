package com.eoi.es.proyectofinal.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.es.proyectofinal.dto.ArticuloDto;
import com.eoi.es.proyectofinal.entity.Articulo;
import com.eoi.es.proyectofinal.repository.ArticuloRepository;

@Service
public class ArticuloService {
	@Autowired
	ArticuloRepository articuloRepository;
	
	public ArticuloDto findById(int id) {
		Articulo articulo = articuloRepository.findById(id).get();
		return entityToDto(articulo);
	}
	
    public List<ArticuloDto> findByNombreParcial(String nombreparcial) {
        List<Articulo> articulos = articuloRepository.findByNombreContainingIgnoreCase(nombreparcial);
        List<ArticuloDto> dtos = new ArrayList<>();
        for (Articulo articulo : articulos) {
            dtos.add(entityToDto(articulo));
        }

        return dtos;
    }

	public void create(ArticuloDto dto) {
		Articulo entity= dtoToEntity(dto);	
		articuloRepository.save(entity);
	}
	
	public void update(ArticuloDto dto) {
		Articulo entity= dtoToEntity(dto);
		articuloRepository.save(entity);
	}
	
    private ArticuloDto entityToDto(Articulo articulo) {
        ArticuloDto dto = new ArticuloDto();
        dto.setId(articulo.getId());
        dto.setNombre(articulo.getNombre());
        dto.setPrecio(articulo.getPrecio());
        dto.setStock(articulo.getStock());
        return dto;
    }

    private Articulo dtoToEntity(ArticuloDto dto) {
        Articulo entity = new Articulo();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        return entity;
    }
}
