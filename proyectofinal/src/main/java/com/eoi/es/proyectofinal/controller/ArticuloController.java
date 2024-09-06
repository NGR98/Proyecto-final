package com.eoi.es.proyectofinal.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.proyectofinal.dto.ArticuloDto;
import com.eoi.es.proyectofinal.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	@Autowired
	ArticuloService articuloService;

	@GetMapping("/{nombreparcial}/nombre")
    public ResponseEntity<List<ArticuloDto>> findByNombreParcial(@PathVariable String nombreparcial) {
        List<ArticuloDto> articulos = articuloService.findByNombreParcial(nombreparcial);
        return new ResponseEntity<>(articulos, HttpStatus.OK);
    }

	@GetMapping(value = "/{id}")
	public ResponseEntity<ArticuloDto> findById(@PathVariable int id) {
		return new ResponseEntity<ArticuloDto>(articuloService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody @Valid ArticuloDto articulo) {
		articuloService.create(articulo);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid ArticuloDto articulo, @PathVariable int id, BindingResult result) {
		if (id != articulo.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		articuloService.update(articulo);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
