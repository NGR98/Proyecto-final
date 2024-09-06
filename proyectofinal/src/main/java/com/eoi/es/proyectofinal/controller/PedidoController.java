package com.eoi.es.proyectofinal.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.proyectofinal.dto.PedidoDto;
import com.eoi.es.proyectofinal.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;

	@GetMapping("/{nombreparcial}/nombre")
    public ResponseEntity<List<PedidoDto>> findByNombreParcial(@PathVariable String nombreparcial) {
        List<PedidoDto> articulos = pedidoService.findByNombreParcial(nombreparcial);
        return new ResponseEntity<>(articulos, HttpStatus.OK);
    }

	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoDto> findById(@PathVariable int id) {
		return new ResponseEntity<PedidoDto>(pedidoService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody @Valid PedidoDto pedido) {
		pedidoService.create(pedido);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid PedidoDto pedido, @PathVariable int id, BindingResult result) {
		if (id != pedido.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		pedidoService.update(pedido);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public void delete(@RequestParam int id) {
		pedidoService.deleteById(id);
	}
}
