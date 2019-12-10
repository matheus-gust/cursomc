package com.udemy.cursomc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.dto.CidadeDTO;
import com.udemy.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<CidadeDTO> search(Integer estadoId) {
		List<Cidade> cidades = cidadeRepository.findByEstadoId(estadoId);
		List<CidadeDTO> cidadesDto = cidades.parallelStream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return cidadesDto;
	}
}
