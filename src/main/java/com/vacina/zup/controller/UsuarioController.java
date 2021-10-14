package com.vacina.zup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacina.zup.model.Usuario;
import com.vacina.zup.repository.UsuarioRepository;
import com.vacina.zup.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	
	// ResponseEntity representa toda a resposta HTTP: código de status, cabeçalhos e corpo . Como resultado, podemos usá-lo para configurar totalmente a resposta HTTP.
	// Se quisermos usá-lo, temos que devolvê-lo do ponto de extremidade; A primavera cuida do resto.
	// ResponseEntity é um tipo genérico. Consequentemente, podemos usar qualquer tipo como corpo de resposta:
	
	@GetMapping("/api/{email}")
	public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
		return repository.findAllByEmailContainingIgnoreCase(email)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@Valid @RequestBody Usuario usuario) {
		
		Usuario usuarioParaCadastrar = usuarioService.CadastrarUsuario(usuario);
		
		if(usuarioParaCadastrar == null) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioParaCadastrar);
	}
}
