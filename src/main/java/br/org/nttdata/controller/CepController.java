package br.org.nttdata.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.nttdata.service.CepService.CepService;

@RestController("/cep")
public class CepController {
	
	@Autowired
	CepService cepService;
	
	@GetMapping(path = "/{cep}")
	public String buscarCep(@PathVariable (name="cep") String cep) throws IOException {
		return cepService.consultarAPI(cep);
	}
	
	@RequestMapping("/save")
	public void salvarEnderecp(@RequestParam (name = "cep") String cep,
							   @RequestParam (name = "email") String email )
	{
		
		cepService.cadastrarEndereco(cep, email);
	}

}
