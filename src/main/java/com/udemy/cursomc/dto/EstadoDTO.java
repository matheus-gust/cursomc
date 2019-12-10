package com.udemy.cursomc.dto;

import java.io.Serializable;

import com.udemy.cursomc.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public EstadoDTO(Estado estado) {
		this.nome =estado.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
