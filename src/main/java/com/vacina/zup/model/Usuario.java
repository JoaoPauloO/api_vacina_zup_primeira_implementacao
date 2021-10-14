package com.vacina.zup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

@Table(uniqueConstraints = {
	    @UniqueConstraint(columnNames = "email", name = "email_uk"),
	    @UniqueConstraint(columnNames = "cpf", name = "cpf_uk") }
	)

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_usuario")
	private Long id;
	
	@NotBlank @NotNull
	@Column(name = "nome_usuario")
	private String nome;
	
	@Email
	@NotBlank @NotNull
	private String email;
	
	@Size(min = 11, max = 11)
	@NotBlank @NotNull
	private String cpf;
	
	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
