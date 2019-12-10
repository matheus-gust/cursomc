package com.udemy.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursomc.dto.CidadeDTO;
import com.udemy.cursomc.dto.EstadoDTO;
import com.udemy.cursomc.services.CidadeService;
import com.udemy.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	EstadoService estadoService;
	
	@Autowired
	CidadeService cidadeService;

	@GetMapping
	public ResponseEntity<List<EstadoDTO>> search() {
		List<EstadoDTO> obj = estadoService.search();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{estadoId}/cidades")
	public ResponseEntity<List<CidadeDTO>> search(@PathVariable Integer estadoId) {
		List<CidadeDTO> cidades = cidadeService.search(estadoId);
		return ResponseEntity.ok().body(cidades);
	}
}
