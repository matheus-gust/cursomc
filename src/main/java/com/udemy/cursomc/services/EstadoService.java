package com.udemy.cursomc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.dto.EstadoDTO;
import com.udemy.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<EstadoDTO> search() {
		List<Estado> estados = estadoRepository.findAllByOrderByNome();
		List<EstadoDTO> estadosDto = estados.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		return estadosDto;
	}
}
