package com.vacina.zup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacina.zup.model.Usuario;
import com.vacina.zup.model.Vacinacao;

@Repository
public interface VacinaRepository extends JpaRepository<Vacinacao, Long> {}
