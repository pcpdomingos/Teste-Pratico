package br.org.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.nttdata.model.ModelCliente;


@Repository
public interface ClienteRepository extends JpaRepository<ModelCliente, Long>{
	
	ModelCliente findByEmail(String email);
}
