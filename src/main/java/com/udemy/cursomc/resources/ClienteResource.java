 package com.udemy.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Cliente> categorias = clienteService.listar();
		return ResponseEntity.ok().body(categorias);
	}
	
	@GetMapping
	@RequestMapping(value="/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = clienteService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
