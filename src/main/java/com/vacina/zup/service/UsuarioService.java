package com.vacina.zup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacina.zup.model.Usuario;
import com.vacina.zup.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		
		Optional<Usuario> usuarioExiste = repository.findAllByEmailContainingIgnoreCase(usuario.getEmail());
		
		if(usuarioExiste.isPresent()) return null;
			
		return repository.save(usuario);
	}
}
