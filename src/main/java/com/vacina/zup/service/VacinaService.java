package com.vacina.zup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacina.zup.model.Usuario;
import com.vacina.zup.model.Vacinacao;
import com.vacina.zup.repository.VacinaRepository;

@Service
public class VacinaService {
	
	@Autowired
	private VacinaRepository repository;
	
	public Vacinacao CadastrarVacina(Vacinacao vacina) {
		return repository.save(vacina);
	}
	
}
