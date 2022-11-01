package br.org.nttdata.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.nttdata.model.ModelCliente;
import br.org.nttdata.repository.ClienteRepository;

@RestController("/usuario")
public class UsuarioController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping(path = "/usuario")
	public ResponseEntity<Object> cadastraUsuario(@RequestBody ModelCliente modelCliente) throws IOException {
		return ResponseEntity.ok(clienteRepository.save(modelCliente));
	
	}

}
