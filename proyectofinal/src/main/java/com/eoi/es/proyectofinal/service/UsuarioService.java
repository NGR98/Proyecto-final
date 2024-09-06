package com.eoi.es.proyectofinal.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.es.proyectofinal.dto.UsuarioDto;
import com.eoi.es.proyectofinal.entity.Usuario;
import com.eoi.es.proyectofinal.repository.UsuarioRepository;


@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioDto findById(int id) {
		
		Usuario usuario = usuarioRepository.findById(id).get();		
		UsuarioDto dto= new UsuarioDto();
		dto.setId(usuario.getId());
		dto.setNombre(usuario.getNombre());
		dto.setPassword(usuario.getPassword());
				
		return dto;
	}
	
	public List<UsuarioDto> findAll() {		
		List<Usuario> usuarios = usuarioRepository.findAll();			
		List<UsuarioDto> dtos = new ArrayList<UsuarioDto>();
		
		for (Usuario usuario : usuarios) {			
			UsuarioDto dto= new UsuarioDto();
			dto.setId(usuario.getId());
			dto.setNombre(usuario.getNombre());
			dto.setPassword(usuario.getPassword());			
			dtos.add(dto);
		}

		return dtos;
	}

	public void create(UsuarioDto dto) {
		Usuario entity= new Usuario();

		entity.setNombre(dto.getNombre());
		entity.setPassword(dto.getPassword());		
	
		usuarioRepository.save(entity);
	}
	
	public void update(UsuarioDto dto) {
		Usuario entity= new Usuario();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setPassword(dto.getPassword());

	    usuarioRepository.save(entity);
	}
	
	public UsuarioDto loguin(String username, String password) {

        Usuario usuario = usuarioRepository.findByNombre(username).get();
        if (usuario.getPassword().equals(password)) {
            UsuarioDto dto = new UsuarioDto();
            dto.setId(usuario.getId());
            dto.setNombre(usuario.getNombre());
            dto.setPassword(usuario.getPassword());
            return dto;
        } else {
    		return null;
        } 
    }
}
