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

import com.eoi.es.proyectofinal.dto.UsuarioDto;
import com.eoi.es.proyectofinal.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() {
		return new ResponseEntity<List<UsuarioDto>>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable int id) {
		return new ResponseEntity<UsuarioDto>(usuarioService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody @Valid UsuarioDto usuario) {
		usuarioService.create(usuario);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid UsuarioDto usuario, @PathVariable int id, BindingResult result) {
		if (id != usuario.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		usuarioService.update(usuario);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/{nombre}/{password}")
	public ResponseEntity<UsuarioDto> loguin(@PathVariable String nombre, @PathVariable String password) {
		return new ResponseEntity<UsuarioDto>(usuarioService.loguin(nombre, password), HttpStatus.OK);
	}

}
