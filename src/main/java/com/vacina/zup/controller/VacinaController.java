package com.vacina.zup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacina.zup.model.Vacinacao;
import com.vacina.zup.service.VacinaService;

@RestController
@RequestMapping("/vacina")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VacinaController {
	
	@Autowired
	private VacinaService vacinaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Vacinacao> Post(@Valid @RequestBody Vacinacao vacinacao) {
		System.out.println(vacinacao.getNome());
		Vacinacao vacinacaoParaCadastrar = vacinaService.CadastrarVacina(vacinacao);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(vacinacaoParaCadastrar);
	}
}
